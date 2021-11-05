//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;

public interface StudentService {

	//학생 아이디 중복체크
	public int studentIdChcek(String sidx);
	
	//학생회원가입
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail);
	
	//학생로그인
	public StudentVO studentLogin(int id, String pwd);
	
	//학생과목
	public ArrayList<EnrollDTO> stuLecSelectAll(int sidx);
	
	//학생과제
	public List<Map<String,Object>> stuTaskSelectAll(int sidx);
	
	//강의홈가기
	public LecVO stuLecHome(int lidx);
	
	//대시보드에서 과제 내용보기로 이동
	public TaskVO stuTaskContent(String tuname);
}
