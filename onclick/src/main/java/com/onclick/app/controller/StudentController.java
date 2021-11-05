//211027 jhr �۾�
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
		//�л� �й� �ߺ�üũ - ajax �̿�
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
		//�л� ȸ�� ���� 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);
		rttr.addFlashAttribute("msg", "ȸ�����Կ� �����Ͽ����ϴ�");
		System.out.println("msggg ");
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentModify() {
		//�л� ���� ����ȭ��
		return "/student/pwdCheck";
	}
	
	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								Model model) {
		//�л� �α��� �� ��ú��� �̵�
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		
		if(sv != null) { 
			//�α��� ���� ��
			//��ú���-���Ǹ��
			System.out.println("�α��� ����");
			ArrayList<EnrollDTO> alist = ss.stuLecSelectAll(sidx);
			model.addAttribute("alist", alist);
			
			//��ú���-�������
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
			//�α��� ���� �� 
//			rttr.addFlashAttribute("msg3", "�α��� ����");
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
		
		//��ú��� ���� ��Ͽ��� ���� ���� Ȩ���� �Ѿ��
		LecVO lv = ss.stuLecHome(lidx);
		model.addAttribute("lv", lv);
		
		return "lecture/home";
	}

	
	@RequestMapping(value="/student/taskContent.do")
	public String studentTaskContent(@RequestParam("tuname") String tuname,
									 Model model) {
		//��ú��� ���� ��Ͽ��� ���� ���뺸��� �Ѿ��
		
		return "";
	}

	/*
	@RequestMapijping(value="/.do")
	public String studentModifyAction() {
		//�л� ���� ��������
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentLogout() {
		//�л� �α׾ƿ�
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentIdCheck() {
		//�л� ȸ�����Խ� �й�Ȯ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String studentFindPwd() {
		//�л� ��й�ȣ ã��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeList() {
		//�л�  �˸�ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String noticeNonCheck() {
		//�л�  �˸� ���� üũ
		return null;
	}
	*/
	@RequestMapping(value="/lecture/stuList.do")
	public String enrollList() {
		//�л� ������û ���
		return "lecture/stuList";
	}
	
}
