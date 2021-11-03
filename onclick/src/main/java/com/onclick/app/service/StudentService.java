//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;

public interface StudentService {

	//�л� ���̵� �ߺ�üũ
	public int studentIdChcek(String sidx);
	
	//�л�ȸ������
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail);
	
	//�л��α���
	public StudentVO studentLogin(int id, String pwd);
	
	//�л�����
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	//����Ȩ����
	public LecVO stuLecHome(int lidx);
}
