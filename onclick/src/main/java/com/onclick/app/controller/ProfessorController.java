package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.service.ProfessorService;

@Controller
public class ProfessorController { 

	@Autowired
	ProfessorService ps;
	
	@ResponseBody
	@RequestMapping(value="/professor/idCheck.do")
	public int professorIdCheck(@RequestParam("pidx") String pidx) {
		//���� ��� �ߺ�üũ - ajax �̿�
		int cnt = ps.professorIdCheck(pidx);

		return cnt;
	}
	
	@RequestMapping(value="/professor/joinAction.do")
	public String professorJoinAction(@RequestParam("pidx") int pidx,
									@RequestParam("pname") String pname,
									@RequestParam("ppwd") String ppwd,
									@RequestParam("pphone") int pphone,
									@RequestParam("pemail") String pemail) {
		//���� ȸ������ �Ϸ�
		int cnt = ps.professorJoin(pidx, pname, ppwd, pphone, pemail);
		
		return "mypage";
	}
/*	
	@RequestMapping(value="*.do")
	public String professorLogin() {
		//���� �α���
		return "";
	}
		
	@RequestMapping(value="*.do")
	public String professorModify() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorModifyAction() {
		//���� ���� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLogout() {
		//���� �α׾ƿ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecList() {
		//���� ���� ���
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorLecPlan() {
		//���ǰ�ȹ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorIdCheck() {
		//��� üũ
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwd() {
		//���� ��й�ȣ ã�� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorFindPwdAction() {
		//���� ��й�ȣ ã�� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String professorContents() {
		//���� ���� ����
		return "";
	}
	*/
}
