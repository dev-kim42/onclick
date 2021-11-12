//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.service.VideoAttenService;

@Controller
public class VideoAttenController {
	
	@Autowired
	VideoAttenService vs;
	
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
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(VideoAttenDto vd) {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		//��ü�ð�,���۽ð�,����ð� �޾ƿ�
		int vpercent = vd.getVend()-vd.getVstart();
		System.out.println(vpercent + "," + vd.getCidx());

		
		int result=vs.videoUpdate(vd);
		System.out.println("controller : " + result);
		
		return 1;
	}
	
	/*
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
