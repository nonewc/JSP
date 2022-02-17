package com.zerock.service;

import java.util.ArrayList;

import com.zerock.command.ScoreVO;

public interface ScoreService {

	
	public void scoreRegist(ScoreVO dao);	//점수등록
	
	public ArrayList<ScoreVO> scoreResult(); //점수 결과
	
	public void scoreDelete(String num);	//점수 제거
	
	
	
}
