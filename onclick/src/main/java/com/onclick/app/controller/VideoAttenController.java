//211027 jhr �۾�
package com.onclick.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		 */

	@ResponseBody
	@RequestMapping(value="/videoEnd.do")
	public int videoEnd(@RequestParam("videoFulltime") String vfull, 
							@RequestParam("startTime") String vstart,
							@RequestParam("endTime") String vend,
							@RequestParam("sidx") int sidx) {
		//��û�� ������(â�� ���� ���, �α׾ƿ��� ���, ������ư�� �������)
		//��ü�ð�,���۽ð�,����ð� �޾ƿ�
		
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
