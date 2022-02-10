package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class GetListServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 1. BoardDAO 객체 생성
		 *    BoardDAO dao = BoardDAO.getInstance(); 
		 * 2. 목록 조회 메서드(getList()) 생성 후 결과를 List형태 받음.  
		 * 3. 다음으로 전달하기 위해서 request객체에 강제로 저장. 
		 */
		BoardDAO dao = BoardDAO.getIntance();
		ArrayList<BoardVO> list = dao.getList(); //목록 조회 메서드로 반환값은 List<BoardVO> 형태로 저장
		
		request.setAttribute("list", list);

	}

}
