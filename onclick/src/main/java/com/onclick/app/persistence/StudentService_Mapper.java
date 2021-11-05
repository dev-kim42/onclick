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
	public int studentIdChcek(int sidx);
	
	//�л��α���
	public StudentVO studentLogin(HashMap<String,Object> hm);
	
	//�л�����
	public ArrayList<EnrollDTO> stuLecSelectAll(int id);
	
	//����Ȩ
	public LecVO stuLecHome(int lidx);
	
	//�л� ��й�ȣ Ȯ��
	public int studentPwdCheck(HashMap<String,String> hm);
	
	//�л� ���� ���� 
	public int studentModifyAction(HashMap<String,Object> hm);
	
	//�л� ���� ��������
	public StudentVO studentSelectOne(int sidx);
}
