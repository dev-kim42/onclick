package com.onclick.app.service;

import java.util.ArrayList;

import com.onclick.app.domain.TaskVO;

public interface TaskService {
	
	//���� ���뺸��
	public TaskVO taskContent(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(int lidx);
}
