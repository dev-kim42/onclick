package com.onclick.app.persistence;

import java.util.HashMap;

import com.onclick.app.domain.ProfessorVO;

public interface ProfessorService_Mapper {

	//교수 아이디 중복 체크
	public int professorIdCheck(HashMap<String,String> hm);
	
	//교수 회원가입
	public int professorJoin(HashMap<String,Object> hm);
	
	//교수 로그인 
	public ProfessorVO professorLogin(HashMap<String,Object> hm);
	
}
