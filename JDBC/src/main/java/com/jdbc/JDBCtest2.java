package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCtest2 {

	
	public static void main(String[] args) {
		
	// 입력값을 받는 코드
		
		Scanner scan = new Scanner(System.in);
		System.out.println("id>");
		String id = scan.next();
		System.out.println("pw>");
		String pw = scan.next();
		System.out.println("name>");
		String name = scan.next();
		System.out.println("email>");
		String email = scan.next();
		
		//System.out.println("입력 아이디 : "+id+"\n입력 암호 : "+pw+"\n입력 이름 : "
		//		+ name +"\n입력 이메일 : "+email);
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; //oracle URL
		String uid = "myjsp";
		String upw = "myjsp";
				
		Connection conn = null;
		Statement stmt = null;
		//ResultSet 객체는 선언 안함 why? select문에서만 사용하기 때문
		
		//SQL 구문 : INSERT INTO member values ('id', 'pw', 'name', 'email');
		String sql = "INSERT INTO member values ('"+id+"', '"+pw+"', '"+name+"', '"+email+"')";
		
		try {
			// 1. JDBC 드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2.커넥션
			conn = DriverManager.getConnection(url, uid, upw);
			
			//3. sql문을 전달할 객체 생성
			stmt = conn.createStatement();
			
			//4. 실행(성공시 1을 반환, 실패시 0을 반환)
			int result = stmt.executeUpdate(sql);
			
			if(result==1) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			
			
		} catch(ClassNotFoundException cnfe) {
			System.out.println("드라이버를 로드하지 못함 : "+cnfe.toString());
			
		} catch(SQLException sqle) {
			System.out.println("DB연결 또는 SQL구문 에러 : "+sqle.toString());
			
		} catch(Exception e) {
			System.out.println("Unknown ERROR");
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
			} catch (Exception e2) {
				
			}
			
		}
		
		
	}
}
