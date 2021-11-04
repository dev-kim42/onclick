//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		rttr.addFlashAttribute("joinOk", "ȸ�����Կ� �����Ͽ����ϴ�");
		
		return "redirect:/";
	}

	
	@RequestMapping(value="/student/stuLogin.do")
	public String studentLogin( @RequestParam("stuId") int sidx,
								@RequestParam("stuPwd") String spwd,
								Model model) {
		//�л� �α��� �� ��ú��� �̵�
		String str = "";
		StudentVO sv = ss.studentLogin(sidx, spwd);
		System.out.println("login id is !! " + sv.getSidx());
		
		if(sv != null) { 
			//�α��� ���� ��
			//���� �̸� ��������(��ú���-���Ǹ��)
			ArrayList<EnrollDTO> alist = ss.stuLecSelectAll(sidx);
			model.addAttribute("alist", alist);
			str = "redirect:/student/stuDashBoard.do";	
		} else {
			//�α��� ���� �� 
			//rttr.addFlashAttribute("loginNok", "�α��ο� �����Ͽ����ϴ�.");
			str = "redirect:/";
		}
		
		return str;
	}
	
	@RequestMapping(value="/student/stuDashBoard.do")
	public String studentLecHome() {
		//�л� ��ú��� �̵� 
		return "/student/stuDashBoard";
	}
/*	
	//�л�  ���� Ȩ �̵�
	@RequestMapping(value="/student/lecHome.do")
	public String studentLecHome(@RequestParam("lidx") int lidx,
								 Model model) {
		
		//�л��� ������ ������ ���� Ȩ���� �̵�
		LecVO lv = ss.stuLecHome(lidx);
		model.addAttribute("lv", lv);
		
		return "/lecture/home";
	}
*/
	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentpwdCheck() {
		//�л� �������� - ��й�ȣ Ȯ�� ������
		return "/student/pwdCheck";
	}
	
	@ResponseBody
	@RequestMapping(value="/student/pwdCheckAction.do")
	public int studentpwdCheckAction(@RequestParam("pwd") String spwd) {
		//�л� �������� - ��й�ȣ Ȯ�� ���� 
		int cnt = ss.studentPwdCheck(spwd);
		System.out.println("��й�ȣ Ȯ�� �޼ҵ� ~ " + cnt );
		return cnt;
	}
	
	@RequestMapping(value="/student/stuModify.do")
	public String studentModify(HttpServletRequest request) {
		//�л� ���� ����ȭ�� 
		System.out.println("ȸ�� ���� ���� �޼ҵ� in ~~~ ");
		HttpSession session = request.getSession();
		int sidx = (Integer)request.getAttribute("sidx");
		System.out.println("sidx ===== " + sidx);
		return "/student/stuModify";
	}

	@RequestMapping(value="/student/stuModifyAction.do")
	public String studentModifyAction() {
		//�л� ���� ��������
		
		return "redirect:/student/pwdCheck.do";
	}

/*	
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
