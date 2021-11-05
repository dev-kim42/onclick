//211027 jhr 작업
package com.onclick.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.EnrollDTO;
import com.onclick.app.domain.LecVO;
import com.onclick.app.domain.StudentVO;
import com.onclick.app.domain.TaskVO;
import com.onclick.app.persistence.StudentService_Mapper;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int studentJoin(int sidx, String spwd,String sname,int sphone,String semail) {
		//학생 가입
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("sidx", sidx);
		hm.put("spwd", spwd);
		hm.put("sname", sname);
		hm.put("sphone", sphone);
		hm.put("semail", semail);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentJoin(hm);

		return cnt;
	}

	@Override
	public int studentIdChcek(String sidx) {
		//학생 아이디 중복 체크
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("sidx", sidx);
	
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		int cnt = ssm.studentIdChcek(hm);
		
		return cnt;
	}

	@Override
	public StudentVO studentLogin(int id, String pwd) {
		//학생 로그인
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("id", id);
		hm.put("pwd", pwd);
		
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		StudentVO sv = ssm.studentLogin(hm);
		
		return sv;
	}

	@Override
	public ArrayList<EnrollDTO> stuLecSelectAll(int sidx) {
		//학생 과목(대시보드)
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		ArrayList<EnrollDTO> alist = ssm.stuLecSelectAll(sidx);
		
		return alist;
	}

	
	@Override
	public List<Map<String,Object>> stuTaskSelectAll(int sidx) {
		//학생 과제(대시보드)
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		List<Map<String,Object>> list = ssm.stuTaskSelectAll(sidx);
		
		return list;
	}


	@Override
	public LecVO stuLecHome(int lidx) {
		//강의홈가기
		StudentService_Mapper ssm = sqlSession.getMapper(StudentService_Mapper.class);
		LecVO lv = ssm.stuLecHome(lidx);
		
		return lv;
	}

	@Override
	public TaskVO stuTaskContent(String tuname) {
		// 대시보드에서 과제 내용보기로 이동
		
		return null;
	}


}
