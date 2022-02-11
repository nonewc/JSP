package com.myweb.board.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;
import com.myweb.util.Criteria;
import com.myweb.util.PageVO;

public class GetListServiceImpl implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 1. BoardDAO 객체 생성
		 *    BoardDAO dao = BoardDAO.getInstance(); 
		 * 2. 목록 조회 메서드(getList()) 생성 후 결과를 List형태 받음.  
		 * 3. 다음으로 전달하기 위해서 request객체에 강제로 저장. 
		 */
		
		//페이징 작업
		
		
		BoardDAO dao = BoardDAO.getIntance();
		
		//기준값 객체 생성
		Criteria cri = new Criteria();
		
		if (request.getParameter("pageNum") != null) {
			//전달 받은 페이지값을 처리
			String pageNum = request.getParameter("pageNum");
			
			cri.setPageNum(Integer.parseInt(pageNum));
			
			
		}
		
		ArrayList<BoardVO> list = dao.getList(cri); //목록 조회 메서드로 반환값은 List<BoardVO> 형태로 저장
		
		request.setAttribute("list", list);
		
		// 화면에 보여질 페이지 버튼을 계산 처리
		// 1. 총 게시글 수
		int total = dao.getTotal();
		
		// 2. PageVO 객체를 생성
		PageVO vo = new PageVO(total, cri);
		
		request.setAttribute("PageVO", vo);
		// 
		

	}

}
