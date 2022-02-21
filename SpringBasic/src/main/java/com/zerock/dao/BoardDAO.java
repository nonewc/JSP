package com.zerock.dao;

import java.util.ArrayList;

import com.zerock.command.BoardVO;

public interface BoardDAO {

	
	public void boardInsert(String name, String title, String content);
	
	public ArrayList<BoardVO> boardSelect();
	
	public void boardDelete(String num);
	
}
