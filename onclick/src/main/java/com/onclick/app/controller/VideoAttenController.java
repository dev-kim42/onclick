//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoAttenController {
/*
	@RequestMapping(value="/.do")
	public String videoContents() {
		//��û��� ��ư ������ ���
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoLevelUpdate() {
		//������ ��û�� ���ǳ��̵� �ۼ�
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoEnd() {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		return null;
	}
	
	@RequestMapping(value="/.do")
	public String videoStart() {
		//��û���� ��ư ���� ���
		return null;
	}
 */	
	
	@RequestMapping(value="/lecContent.do")
	public String lecContent() {
		//�л� ������ �⼮ ȭ��
		return "lecture/lecContent_p";
	}
	
/*	
	@RequestMapping(value="/.do")
	public String videoProAtten() {
		//���� ������ �⼮ ȭ��
		return null;
	}
*/	
}
