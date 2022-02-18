package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.BoardVO;
import com.zerock.service.BoardService;
import com.zerock.service.BoardServiceImpl;

@Controller
@RequestMapping("/service")
public class BoardServiceController {

	//1st (new로 연결하기)	--	BoardService 객체를 생성시
	BoardService boardService = new BoardServiceImpl();
	
	
	//화면처리 - 게시판 등록
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		
		return "service/boardRegister";
		
	}
	
	//게시글 등록 요청 처리
	@RequestMapping("/boardForm")
	public String boardForm(
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("content") String content
			) {
		
		boardService.register(name, title, content);
		
		return "service/boardResult";
	}
		
	//게시글 리스트 보기 요청 처리
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> DB = boardService.getList();
		
		// 전달 받은 DB를 boardList 이름으로 전달
		model.addAttribute("boardList", DB);
		
		return "service/boardList";
	
	}
	
	//게시글 삭제
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") String num) {
		
		boardService.delete(num);
		
		return "redirect:/service/boardList";
	}
	
	
	
	
	
}
