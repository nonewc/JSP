package com.zerock.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.BoardVO;

public interface BoardMapper {

	
	public void insert(BoardVO vo);
	public void insert2(Map<String, String> map);
	public ArrayList<BoardVO> select();
	public void delete(String num);
	
}
