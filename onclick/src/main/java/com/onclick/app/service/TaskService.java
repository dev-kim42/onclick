package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.onclick.app.domain.TaskVO;

public interface TaskService {
	
	//���� ���뺸��
	public TaskVO taskSelectOne(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(int lidx);
	
	//���� ���ε�
	public int taskInsert(HashMap<String,Object> hm);
}
