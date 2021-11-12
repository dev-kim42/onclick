//211027 jhr 작업
package com.onclick.app.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onclick.app.domain.VideoAttenDto;
import com.onclick.app.persistence.VideoAttenService_Mapper;

@Service("VideoAttenServiceImpl")
public class VideoAttenServiceImpl implements VideoAttenService{

	@Autowired
	SqlSession sqlSession;

	@Override
	public int videoUpdate(VideoAttenDto vd) {
		//영상 시청시 시청기록 업데이트
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("sidx", vd.getSidx());
		hm.put("cidx", vd.getCidx());
		hm.put("vfull", vd.getVfull());
		hm.put("vstart", vd.getVstart());
		hm.put("vend", vd.getVend());
		hm.put("vpercent", vd.getVend()-vd.getVstart());
		
		System.out.println(vd.getVend()-vd.getVstart());
		
		VideoAttenService_Mapper vsm = sqlSession.getMapper(VideoAttenService_Mapper.class);
		int result = vsm.videoUpdate(hm);
		System.out.println("result value : " + result);
		return result;
	}
	
	
}
