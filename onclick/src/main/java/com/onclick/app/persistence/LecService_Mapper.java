package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.LecVO;

public interface LecService_Mapper {

	//���� ����Ʈ �������� 
	public ArrayList<LecVO> lecSelectAll(int pidx);
	
	//����Ȩ
	public LecVO lecHome(int lidx);
	
	//�ش� ���� ���� ��������
	public LecVO lecSelectOne(int lidx);
}
