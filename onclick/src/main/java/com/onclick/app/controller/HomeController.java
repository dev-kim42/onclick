package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecVO;
import com.onclick.app.service.LecService;

@Controller
public class HomeController {

	@Autowired
	LecService ls;
	
	@RequestMapping(value="/")
	public String main() {
		//Main ������ ��ȯ
		return "index";
	}
	
	@RequestMapping(value="/join.do")
	public String join() {
		//�л�,���� ȸ�� ���� ȭ��
		return "join";
	}
	
	@RequestMapping(value="/lecHome.do")
	public String LecHome(@RequestParam("lidx") int lidx, Model model) {
		
		//��ú��� ���� ��Ͽ��� ���� ���� Ȩ���� �Ѿ��
		LecVO lv = ls.lecHome(lidx);
		model.addAttribute("lv", lv);
		
		return "lecture/home";
	}
	
	

}
