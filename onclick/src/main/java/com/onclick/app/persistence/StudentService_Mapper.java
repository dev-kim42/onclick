package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;

public interface StudentService_Mapper {

	//�л� ȸ������
	public int studentJoin(HashMap<String,Object> hm);
	
	//�л� ���̵� �ߺ� üũ
	public int studentIdChcek(HashMap<String,String> hm);
	
	//�л��α���
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	//�л�����
	public ArrayList<EnrollDTO> stuLecSelectAll(int sidx);
	
	//�л�����
	public List<Map<String,Object>> stuTaskSelectAll(int sidx);
	
	//����Ȩ
	public LecVO stuLecHome(int lidx);
	
	//��ú��忡�� ���� ���뺸��� �̵�
	public TaskVO stuTaskContent(String tuname);
}
