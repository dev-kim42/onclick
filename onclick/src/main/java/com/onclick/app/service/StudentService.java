//211027 jhr �۾�
package com.onclick.app.service;

import java.util.HashMap;

public interface StudentService {

	//�л� ���̵� �ߺ�üũ
	public int studentIdChcek(String sidx);
	//�л�ȸ������
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail);
	
}
