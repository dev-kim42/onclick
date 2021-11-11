//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.service.S_taskService;
import com.onclick.app.service.TaskService;

@Controller
public class S_taskController {
	
	@Autowired
	TaskService ts;
	
	@Autowired
	S_taskService sts;
	
	@RequestMapping(value="/taskSubmit.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session) {
		//�л� �����ۼ� ȭ��
		TaskVO tv = ts.taskContent(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "student/taskWrite";
	}
	

	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") String tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session) {
		//�л� �����ۼ� ����
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", tfile);
		hm.put("sidx", sidx);
		hm.put("tuidx", tuidx);
		
		int value = sts.s_taskInsert(hm);
		
		return "";
	}
	
		/*
	@RequestMapping(value="/.do")
	public String taskDelete() {
		//�л� ��������
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String task() {
		//�л� �����ۼ� ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdate() {
		//�л� �������� ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskUpdateAction() {
		//�л� ��������  ����
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskContents() {
		//�л� �������� ����
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String taskList() {
		//�л� ���� ����Ʈ����
		return null;
	}
	*/
}
