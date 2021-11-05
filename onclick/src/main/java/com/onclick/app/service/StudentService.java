//211027 jhr �۾�
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;

public interface StudentService {

	//�л� ���̵� �ߺ�üũ
	public int studentIdChcek(String sidx);
	
	//�л�ȸ������
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail);
	
	//�л��α���
	public StudentVO studentLogin(int id, String pwd);
	
	//�л�����
	public ArrayList<EnrollDTO> stuLecSelectAll(int sidx);
	
	//�л�����
	public List<Map<String,Object>> stuTaskSelectAll(int sidx);
	
	//����Ȩ����
	public LecVO stuLecHome(int lidx);
	
	//��ú��忡�� ���� ���뺸��� �̵�
	public TaskVO stuTaskContent(String tuname);
}
