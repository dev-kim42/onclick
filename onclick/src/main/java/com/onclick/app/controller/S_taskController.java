//211027 jhr �۾�
package com.onclick.app.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/stuTaskWrite.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session) {
		//�л� �����ۼ� ȭ��
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "lecture/stuTaskWrite";
	}
	

	@RequestMapping(value="/stuTaskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") String tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session) throws Exception{
		//�л� �����ۼ� ����
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", tfile);
		hm.put("sidx", sidx);
		hm.put("tuidx", tuidx);
		
		String str ="";
		int value = sts.s_taskInsert(hm);
		
		if(value == 0) {
			str = "redirect:/stuTaskWrite.do?tuidx="+tuidx;
		} else {
			
			str ="redirect:/stuTaskContent.do?tuidx="+tuidx+"&sidx="+sidx;
		}
		return str;
	}
	
	
	@RequestMapping(value="/stuTaskContent.do")
	public String taskContents(@RequestParam("tuidx") int tuidx,
							@RequestParam("sidx") int sidx,
							HttpSession session) {
		//�л� ������ �������� ����
		S_taskDTO std = sts.s_taskSelectOne(tuidx, sidx);
		session.setAttribute("std", std);
		//���� ���� ��������
		TaskVO tv = ts.taskSelectOne(tuidx);
		session.setAttribute("tv", tv);
		
		return "lecture/stuTaskContent";
	}
	
	
	@RequestMapping(value="/stuTaskModify.do")
	public String taskUpdate() {
		//�л� �������� ȭ��
		
		return "lecture/stuTaskModify";
	}
	
	
	@RequestMapping(value="/stuTaskModifyAction.do")
	public String taskUpdateAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") String tfile,
								@RequestParam("s_taskContents") String tcontents,
								@RequestParam("tidx") int tidx,
								HttpSession session) {
		//�л� ��������  ����
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", tfile);
		hm.put("tidx", tidx);
		
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		String str = null;
		int value = sts.s_taskUpdate(hm);
		
		if(value == 0) {
			str="redirect:/stuTaskModify.do";
		} else {
			str="redirect:/stuTaskContent.do?tuidx="+tuidx+"&sidx="+sidx;
		}
		
		return str;
	}
	
	
		/*
	@RequestMapping(value="/.do")
	public String taskDelete() {
		//�л� ��������
		return null;
	}
	
	
	
	@RequestMapping(value="/.do")
	public String taskList() {
		//�л� ���� ����Ʈ����
		return null;
	}
	*/
}
