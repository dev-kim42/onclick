//211027 jhr �۾�
package com.onclick.app.controller;

import java.io.File;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value="/taskSubmit.do")
	public String taskWrite(@RequestParam("tuidx") int tuidx, HttpSession session) {
		//�л� �����ۼ� ȭ��
		TaskVO tv = ts.taskContent(tuidx);
		session.setAttribute("tv", tv);
		session.setAttribute("tuidx", tuidx);
		
		return "lecture/stuTaskWrite";
	}
	

	@RequestMapping(value="/taskWriteAction.do")
	public String taskWriteAction(@RequestParam("s_taskSubject") String tsubject,
								@RequestParam("s_taskFile") MultipartFile tfile,
								@RequestParam("s_taskContents") String tcontents,
								HttpSession session, Model model) throws Exception{
		//÷������ ����
		//���ϸ�
		String originalFileName = tfile.getOriginalFilename();
		System.out.println(originalFileName);
		//���ϸ� �� Ȯ���ڸ� ����
		String orignalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
		//���ϰ��
		String route = uploadPath;
		//���� ����
		if(!tfile.getOriginalFilename().isEmpty()) {
			tfile.transferTo(new File(uploadPath, originalFileName));
		} else {
			model.addAttribute("msg", "���� ���ε带 �Ϸ����� ���߽��ϴ�.");
		}
		
		//�л� �����ۼ� ����
		int sidx = (Integer)session.getAttribute("sidx");
		int tuidx = (Integer)session.getAttribute("tuidx");
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("tsubject", tsubject);
		hm.put("tcontents", tcontents);
		hm.put("tfile", originalFileName);
		hm.put("sidx", sidx);
		hm.put("tuidx", tuidx);
		
		int value = sts.s_taskInsert(hm);
		
		return "lecture/stuTaskSubmit";
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
