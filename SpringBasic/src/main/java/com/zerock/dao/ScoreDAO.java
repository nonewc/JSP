package com.zerock.dao;

import java.util.ArrayList;

import com.zerock.command.ScoreVO;

public interface ScoreDAO {

	public void scoreInsert(ScoreVO vo); //점수 입력 메서드
	public ArrayList<ScoreVO> scoreSelect(); // 점수 저장 결과 보기 메서드
	public void scoreDelete(String num); //점수 삭제 메서드
	
}
