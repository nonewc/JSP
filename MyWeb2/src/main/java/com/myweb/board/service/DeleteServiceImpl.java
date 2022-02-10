package com.myweb.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;

public class DeleteServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String num = request.getParameter("num");
				
				//DAO객체 생성
				//regist메서드 호출
				BoardDAO dao = BoardDAO.getIntance();
				dao.delete(num);   	
		
	}

}
