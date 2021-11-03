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
	
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	public LecVO stuLecHome(int lidx);
	
}
