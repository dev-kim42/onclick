//211027 jhr �۾�
package com.onclick.app.service;

import java.util.HashMap;

import com.onclick.app.domain.S_taskDTO;

public interface S_taskService {

	//���� ����
	public int s_taskInsert(HashMap<String,Object> hm);
	
	//������ ���� ���뺸��
	public S_taskDTO s_taskSelectOne(int tuidx, int sidx);
	
	//���� ����
	public int s_taskUpdate(HashMap<String,Object> hm);
	
}
