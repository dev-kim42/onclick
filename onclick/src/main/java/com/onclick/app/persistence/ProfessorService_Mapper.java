package com.onclick.app.persistence;

import java.util.HashMap;

public interface ProfessorService_Mapper {

	//���� ���̵� �ߺ� üũ
	public int professorIdCheck(HashMap<String,String> hm);
	
	//���� ȸ������
	public int professorJoin(HashMap<String,Object> hm);
}
