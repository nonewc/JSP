package com.zerock.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.ScoreVO;
import com.zerock.dao.ScoreDAO;
import com.zerock.dao.ScoreDAOImpl;

//@Componenet	// 잘됨
//@Componenet("scoreService")	//잘됨, 해당 클래스를 컨테이너에 빈으로 생성하겠다는 어노테이션
//@Repository	//잘됨


@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

//	ArrayList<ScoreVO> list = new ArrayList<ScoreVO>();
//	
//	
//	@Override
//	public void scoreRegist(ScoreVO dao) {
//		
//		System.out.println("------- 서비스 계층 -------");
//		System.out.println(dao.getName());
//		System.out.println(dao.getKor());
//		System.out.println(dao.getEng());
//		System.out.println(dao.getMath());
//		
//		list.add(dao);
//		
//		System.out.println(list.toString());
//		
//	}
//
//	@Override
//	public ArrayList<ScoreVO> scoreResult() {
//		return list;
//	}
//
//	@Override
//	public void scoreDelete(String number) {
//		// TODO Auto-generated method stub
//		
//		int num = Integer.parseInt(number);
//		list.remove(num);
//
//	}
	
	//--------------DAO들어가기-----------------------
	
//	//1st
//	ScoreDAO scoreDAO = new ScoreDAOImpl();
	
	//2nd : DispatcherServlet을 이용 - Servlet-Context.xml 설정에 bean 등록
//	@Resource(name="scoreDAO")
//	ScoreDAO scoreDAO;
	
	//3nd : 자동 의존성 주입을 어노테이션을 이용하여
	@Autowired
	ScoreDAO scoreDAO;
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		System.out.println("------- 서비스 계층 -------");
		System.out.println(vo.getName());
		System.out.println(vo.getKor());
		System.out.println(vo.getEng());
		System.out.println(vo.getMath());
		
		scoreDAO.scoreInsert(vo);	//점수 입력 메서드 호출
		
	}
	
	@Override
	public ArrayList<ScoreVO> scoreResult() {

		ArrayList<ScoreVO> DB = scoreDAO.scoreSelect();	//점수 결과 메서드 호출
		return DB;
		
	}
	
	
	@Override
	public void scoreDelete(String num) {
		
		scoreDAO.scoreDelete(num); 	//점수 삭제 메서드 호출
		
	}
	

}
