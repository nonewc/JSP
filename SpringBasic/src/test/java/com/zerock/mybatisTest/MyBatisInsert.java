package com.zerock.mybatisTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisInsert {
	
	@Autowired
	TestMapper mapper;
	
	@Test
	public void insert() {
		try {
		//VO 넣기
		ScoreVO vo = new ScoreVO();
		vo.setName("홍길동");
		vo.setKor("90");
		vo.setEng("100");
		vo.setMath("80");
		
		boolean result = mapper.insert(vo);
		
		System.out.println("성공? :"+result);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void insert2() {
		
		try {
		//맵 넣기
		Map<String, String> map = new HashMap<>();
		map.put("p1", "홍길자");
		map.put("p2", "80");
		map.put("p3", "80");
		map.put("p4", "80");
		
		boolean result = mapper.insert2(map);
		System.out.println("map을 이용한 mybatis 성공? : "+ result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
