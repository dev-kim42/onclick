package com.onclick.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.LecService;
import com.onclick.app.service.TaskService;

@Controller
public class TaskController { //���� ���� ��Ʈ�ѷ�

		@Autowired
		TaskService ts;
		
		@Autowired
		LecService ls;

		@RequestMapping(value="/student/taskContent.do")
		public String taskContent(@RequestParam("tuidx") int tuidx, 
								@RequestParam("lidx") int lidx, Model model, HttpSession session) {
			
			//��ú��� ���� ��Ͽ��� ���� ���뺸��� �Ѿ��
			TaskVO tv = ts.taskContent(tuidx);
			model.addAttribute("tv", tv);
			//�ش� ���� ���� ��������
			LecVO lv = ls.lecSelectOne(lidx);
			session.setAttribute("lv", lv);
			
			return "/student/taskContent";
		}

		@RequestMapping(value="/taskList.do")
		public String taskList(@RequestParam("lidx") int lidx, Model model) {
			//���� ���� ���
			ArrayList<TaskVO> tlist = ts.taskSelectAll(lidx);
			model.addAttribute("tlist", tlist);
			
			return "student/taskList";
		}
		
/*
	@RequestMapping(value="*.do")
	public String taskWrite() {
		//���� ���� �ۼ� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskWriteAction() {
		//���� ���� �ۼ� �Ϸ�
		return "";
	}
		
	@RequestMapping(value="*.do")
	public String taskContents() {
		//���� ���뺸��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModify() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskModifyAction() {
		//���� ���� ���� �Ϸ�
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskDelete() {
		//���� ���� ���� ȭ��
		return "";
	}
	
	@RequestMapping(value="*.do")
	public String taskSubmitList() {
		//�л� ���� ���� ���
		return "";
	}
	*/
}
