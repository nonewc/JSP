package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.MemberVO;



@Service("memberService")
public class MemberServiceImpl implements MemberService {

	ArrayList<MemberVO> memberList = new ArrayList<>();
	
	
	@Override
	public void insertMember(MemberVO vo) {

		memberList.add(vo);
		
	}

	@Override
	public int memberCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
