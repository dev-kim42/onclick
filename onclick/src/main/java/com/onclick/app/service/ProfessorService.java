package com.onclick.app.service;

public interface ProfessorService {

	//���� ���̵� �ߺ� üũ 
	public int professorIdCheck(String pidx);
	
	//���� ȸ������
	public int professorJoin(int pidx,String pname,String ppwd, int pphone,String pemail);
}
