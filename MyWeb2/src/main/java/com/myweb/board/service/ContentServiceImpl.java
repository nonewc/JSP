package com.myweb.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class ContentServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//String num = request.getParameter("num");
		//System.out.println(num);
		/*
		 *  1. dao에 getContent(num) 메서드를 생성하고, 호출
		 *  2. getContent()메서드에서는 num을 가지고, 게시글에 대한 정보를 vo객체에 담는 코드를 작성
		 *  3. 메서드 리턴타입 BoardVO
		 *  4. 화면전송을 위한 리턴값을 vo라는 이름으로 강제 저장 처리합니다.
		 * 
		 */
		
		String num = request.getParameter("num");
		
		//DAO 객체 생성
		BoardDAO dao = BoardDAO.getIntance();
		
		//쿠키 생성 : 
		Cookie[] arr = request.getCookies();
		boolean bool = true;
		for (Cookie c : arr) {
			if (c.getName().equals("hitNum"+num)) { //쿠키 이름이 계시글번호의 쿠키인지 확인
				bool = false; //읽었으면 히트 안오름
				break;
			}
		}
		
		if (bool) { // bool이 true면 클릭한 적이 없다
			dao.upHit(num);  // hitNum값을 +1해서 업데이트 하는 메서드
		}
		
		
		BoardVO vo = dao.getContent(num); //결과 값을 받아오는 메서드 반환값이 BoardVO
		
		request.setAttribute("vo", vo); //request에 강제 저장
		
		// 중복 증가를 방지하기 위한 쿠키 생성
		Cookie hitcoo= new Cookie("hitNum"+num, num);
		hitcoo.setMaxAge(60);
		response.addCookie(hitcoo);
	}

}
