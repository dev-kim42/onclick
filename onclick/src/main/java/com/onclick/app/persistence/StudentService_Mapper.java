package com.onclick.app.persistence;

import java.util.HashMap;

public interface StudentService_Mapper {

	//�л� ȸ������
	public int studentJoin(HashMap<String,Object> hm);
	
	//�л� ���̵� �ߺ� üũ
	public int studentIdChcek(HashMap<String,String> hm);
}
