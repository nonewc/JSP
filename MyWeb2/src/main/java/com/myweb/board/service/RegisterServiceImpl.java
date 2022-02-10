package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class RegisterServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//폼에서 전달된 값을 처리
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//DAO객체 생성
		//regist메서드 호출
		BoardDAO dao = BoardDAO.getIntance();
		dao.regist(writer,title,content);   //BoardDAO에 regist()메소드 구현. 		
		
	}

}
