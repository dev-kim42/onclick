//211027 jhr �۾�
package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.S_taskDTO;
import com.onclick.app.persistence.S_taskService_Mapper;

@Service("s_taskServiceImpl")
public class S_taskServiceImpl implements S_taskService{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int s_taskInsert(HashMap<String,Object> hm) {
		//���� ����
		S_taskService_Mapper stsm = sqlSession.getMapper(S_taskService_Mapper.class);
		int value = stsm.s_taskInsert(hm);
		
		return value;
	}

}
