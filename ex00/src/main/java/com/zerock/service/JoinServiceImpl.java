package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.JoinVO;

@Service("joinService")
public class JoinServiceImpl implements JoinService {

	ArrayList<JoinVO> JoinList = new ArrayList<>();
	
	@Override
	public int insertMember(JoinVO vo) {
		
		int joincheck = 0;
		
		for (JoinVO dbVO : JoinList) {
			
			if (dbVO.getId().equals(vo.getId())) {
				joincheck = 1;
				break;
			}
			
		}
		
		
		if (joincheck == 0) {
		JoinList.add(vo);
		}
		
		
		return joincheck;
		
		
	}

	

}
