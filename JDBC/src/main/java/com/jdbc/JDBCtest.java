package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {

	public static void main(String[] args) {
		
		//Oracle 설정
		String driver_oracle = "oracle.jdbc.driver.OracleDriver";
		String url_oracle = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		
		//DB 접속 계정 정보
		String user = "myjsp";
		String password = "myjsp";
		
		
		//연결을 위한 객체 생성
		Connection conn = null;
		
		//connection 값을 판별하는 boolean값
		Boolean connect = false;
		
		try {
			//1. Driver 로딩
			Class.forName(driver_oracle);
			
			//2. DB 연결
			DriverManager.getConnection(url_oracle, user, password);
			connect = true;
			
		} catch (ClassNotFoundException cnfe) {
			//드라이버 로딩 실패시 예외
			connect = false;
			System.out.println("DB드라이버 로딩 실패: "+cnfe.toString());
		} catch (SQLException sqle){
			// Connection 실패시 에러(SQLExcpetion)
			connect = false;
			System.out.println("DB접속 실패: "+sqle.toString());
		} catch (Exception e) {
			// Unknown 에러
			connect = false;
			System.out.println("Unknown Error");
			e.printStackTrace();
		}
		
		if (connect) {
			System.out.println("연결 성공");
		} else {
			System.out.println("연결 실패");
		}
		
		
	}
	
}
