package com.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


	//spring-test 라이브러리가 추가되어 있어야 함.
	//Run As -> JUnitTest (@Test 어노테이션으로 JUnit 사용이 가능)
	
	@RunWith(SpringJUnit4ClassRunner.class) 
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml") 
	public class JdbcTemplateTest { 
		
		@Autowired 
		DataSource datasource;
		

		@Autowired
		JdbcTemplate jdbcTemplate;
	
	@Test 
	public void testTemplate() { 
		
		try { 
			
			Connection conn = datasource.getConnection(); 
			System.out.println(">>>>>>>>>>>>>>connection 출력 :" + conn);
			System.out.println(">>>>>>>>>>>>>> 템플릿객체생성 :" + jdbcTemplate);
	
		} catch (Exception e) { 
			e.printStackTrace();
	
		}
		
	}
	}
	




