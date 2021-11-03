package com.onclick.app.persistence;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;

public interface StudentService_Mapper {

	//�л� ȸ������
	public int studentJoin(HashMap<String,Object> hm);
	
	//�л� ���̵� �ߺ� üũ
	public int studentIdChcek(HashMap<String,String> hm);
	
	//�л��α���
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	//�л�����
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	//����Ȩ
	public LecVO stuLecHome(int lidx);
	
}
