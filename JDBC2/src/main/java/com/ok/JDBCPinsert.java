package com.ok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCPinsert {

	public static void main(String[] args) {
		
		// 입력값 받는 처리(member)
		
		Scanner scan = new Scanner(System.in);
		System.out.println("id>");
		String id = scan.next();
		System.out.println("pw>");
		String pw = scan.next();
		System.out.println("name>");
		String name = scan.next();
		System.out.println("email>");
		String email = scan.next();
		
		// 연결에 필요한 변수 설정
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver ="oracle.jdbc.driver.OracleDriver";
		String user = "myjsp";
		String password = "myjsp";
		
		// 객체생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO member VALUES(?,?,?,?)";
		
		try {
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, user, password);

			pstmt = conn.prepareStatement(sql);
			// pstmt 객체에 값을 설정시 setString, setInt, setDouble...
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			//pstmt 실행 (성공시 1, 실패시 0을 반환)
			int result = pstmt.executeUpdate(); // 주의 : SQL구문을 인자로 전달하지 않아요
			
			if (result == 1) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			
		} catch(ClassNotFoundException cnfe) {
			System.out.println("드라이버 연결 오류 : "+cnfe.toString());
		} catch(SQLException sqle) {
			System.out.println("DB연결 오류 or SQL 구문 오류 : "+sqle.toString());
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (scan != null) scan.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
