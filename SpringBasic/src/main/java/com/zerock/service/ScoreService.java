package com.zerock.service;

import java.util.ArrayList;

import com.zerock.command.ScoreVO;

public interface ScoreService {

	
	public void scoreRegist(ScoreVO dao);	//�������
	
	public ArrayList<ScoreVO> scoreResult(); //���� ���
	
	public void scoreDelete(String num);	//���� ����
	
	
	
}
