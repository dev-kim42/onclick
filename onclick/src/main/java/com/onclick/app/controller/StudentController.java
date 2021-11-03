//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
									@RequestParam("semail") String semail) {
		//�л� ȸ�� ���� 
		int cnt = ss.studentJoin(sidx, spwd, sname, sphone, semail);

		return "redirect:/";
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
			//���� �̸� ��������(��ú���-���Ǹ��)
			System.out.println("�α��� ����");
			ArrayList<EnrollDTO> alist = ss.stuLecSelectAll(sidx);
			model.addAttribute("alist", alist);
			str = "/student/stuDashBoard";	
		} else {
			//�α��� ���� �� 
			str = "redirect:/";
		}
		
		return str;
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

	
	@RequestMapping(value="/student/pwdCheck.do")
	public String studentModify() {
		//�л� ���� ����ȭ��
		return "/student/pwdCheck";
	}
*/	
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
