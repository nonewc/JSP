package com.zerock.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;

//@Componenet	// 잘됨
//@Componenet("scoreService")	//잘됨, 해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
//@Repository	//잘됨


@Service
public class ScoreServiceImpl implements ScoreService {

	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
	
	
	@Override
	public void scoreRegist(ScoreVO dao) {
		
		System.out.println("------- ���� ���� -------");
		System.out.println(dao.getName());
		System.out.println(dao.getKor());
		System.out.println(dao.getEng());
		System.out.println(dao.getMath());
		
		list.add(dao);
		
		System.out.println(list.toString());
		
	}

	@Override
	public ArrayList<ScoreVO> scoreResult() {
		return list;
	}

	@Override
	public void scoreDelete(String number) {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(number);
		list.remove(num);

	}

}
