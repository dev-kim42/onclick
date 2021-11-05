//211027 jhr 작업
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService ss;
	
	@ResponseBody
	@RequestMapping(value="/student/idCheck.do")
	public int studentIdCheck(@RequestParam("sidx") String sidx) {
		//학생 학번 중복체크 - ajax 이용
		int cnt = ss.studentIdChcek(sidx);
		
		return cnt;
	}
	
	@RequestMapping(value="/student/joinAction.do")
	public String studentJoinAction(@RequestParam("sidx") int sidx, 
									@RequestParam("spwd") String spwd,
									@RequestParam("sname") String sname,
									@RequestParam("sphone") int sphone,
									@RequestParam("semail") String semail,
									RedirectAttributes rttr ) {
		//학생 회원 가입 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);
		rttr.addFlashAttribute("msg", "회원가입에 성공하였습니다");
		System.out.println("msggg ");
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentModify() {
		//학생 정보 수정화면
		return "/student/pwdCheck";
	}
	
	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								Model model) {
		//학생 로그인 후 대시보드 이동
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		
		if(sv != null) { 
			//로그인 성공 시
			//대시보드-강의목록
			System.out.println("로그인 성공");
			ArrayList<EnrollDTO> alist = ss.stuLecSelectAll(sidx);
			model.addAttribute("alist", alist);
			
			//대시보드-과제목록
			List<Map<String,Object>> list = ss.stuTaskSelectAll(sidx);
//			System.out.println(list.get(1).get("LIDX").toString());
			List<String> tunameList = new ArrayList<String>();
			for(Map<String,Object> data : list) {
				tunameList.add(data.get("TUNAME").toString());
			}
//			System.out.println(tnameList);
			model.addAttribute("list", list);
			model.addAttribute("tunameList", tunameList);
			
//			System.out.println(alist);
//			rttr.addAttribute("alist", alist);

			str = "student/stuDashBoard";	
		} else {
			//로그인 실패 시 
//			rttr.addFlashAttribute("msg3", "로그인 실패");
			str = "redirect:/";
		}
		
		return str;
	}
	
//	@RequestMapping(value="/student/stuDashBoard.do")
//	public String studentLoginSuc() {
//		return "student/stuDashBoard";
//	}

	
	@RequestMapping(value="/student/lecHome.do")
	public String studentLecHome(@RequestParam("lidx") int lidx,
								 Model model) {
		
		//대시보드 강의 목록에서 강의 메인 홈으로 넘어가기
		LecVO lv = ss.stuLecHome(lidx);
		model.addAttribute("lv", lv);
		
		return "lecture/home";
	}

	
	@RequestMapping(value="/student/taskContent.do")
	public String studentTaskContent(@RequestParam("tuname") String tuname,
									 Model model) {
		//대시보드 과제 목록에서 과제 내용보기로 넘어가기
		
		return "";
	}

	/*
	@RequestMapijping(value="/.do")
	public String studentModifyAction() {
		//학생 정보 수정실행
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentLogout() {
		//학생 로그아웃
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentIdCheck() {
		//학생 회원가입시 학번확인
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentFindPwd() {
		//학생 비밀번호 찾기
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeList() {
		//학생  알림화면
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeNonCheck() {
		//학생  알림 읽음 체크
		return null;
	}
	*/
	@RequestMapping(value="/lecture/stuList.do")
	public String enrollList() {
		//학생 수강신청 목록
		return "lecture/stuList";
	}
	
}
