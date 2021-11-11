//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onclick.app.domain.ClassVo;
import com.onclick.app.service.ClassService;

@Controller
public class ClassController {
	
	@Autowired
	ClassService cs;
	
	@RequestMapping(value="/lecUpload.do")
	public String classWrite() {
		//���¾��ε� ȭ��
		return "lecture/lecUpload";
	}
	
	@RequestMapping(value="/lecUploadAction.do")
	public String classWriteAction(ClassVo cv) {
		//���¾��ε� ����
		int result = cs.classInsert(cv);
		return "lecture/classList";
	}
	
	/*
	@RequestMapping(value="/.do")
	public String classContents() {
		//���³��뺸��? ������?
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classList() {
		//���¸���Ʈ ����
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdate() {
		//���³��� ����ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classUpdateAction() {
		//���³��� ���� ����
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDelete() {
		//���³��� ����ȭ��
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String classDeleteAction() {
		//���³��� ���� ����
		return null;
	}
*/	
	
}
