package com.onclick.app.persistence;

import java.util.ArrayList;

import com.onclick.app.domain.TaskVO;

public interface TaskService_Mapper {

	//���� ���뺸��
	public TaskVO taskContent(int tuidx);

	//���� ���
	public ArrayList<TaskVO> taskSelectAll(int lidx);
}
