package com.zerock.service;

import com.zerock.command.MemberVO;

public interface MemberService {

	public void insertMember(MemberVO vo);	//회원 가입 처리
	
	public int memberCheck(MemberVO vo);	//회원 확인
	
	
}
