package com.myweb.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	/*
	 *  DAO는 단수 DB연동을 담당하는 클래스
	 *  여러 개 생성하도록 일반 클래스로 만들면, 메모리 과부하가 올 수 있다.
	 *  싱글톤 패턴을 적용해서 객체를 1개로 제한.
	 * 
	 * 
	 */
	
	
	//1. 스스로의 객체를 멤버변수로 선언하고 1개로 제한
	private static UserDAO instance = new UserDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private를 처리
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			
			System.out.println("드라이버 호출시 에러 발생 : "+cnfe.toString());
			
		}
	}
	
	
	//3. 외부에서 객체를 요구할 때에 getter 메서드를 사용하여 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	// ------- 중복되는 코드를 멤버변수로 선언 --------
	// DB 연동에 필요한 변수 및 객체 선언
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String user = "myjsp";
	private String password = "myjsp";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	// ID 확인 메서드
	public int IdConfirm(String id) {
		int result = 0;
		
		String sql = "SELECT * FROM users WHERE id = ?";
		
		try {
			
			//커넥션
			conn = DriverManager.getConnection(url, user, password);
			
			//PrepareStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			//sql 실행
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				result = 1;
				
			} 
			
		} catch (SQLException sqle) {
			
			System.out.println("DB연동 오류 or SQL 구문 오류 : "+sqle.toString());
			
		} finally {
			
			try {
				
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
				
			} catch (Exception e) {
				
			}
			
			
		}
			
		
		
		return result;
	}
	
	
	
	
	// 회원가입 메서드
	
	public int join(UserVO vo) {
		int result = 0;
		String sql = "INSERT INTO users (id, pw, name, email, address) VALUES (?,?,?,?,?)";
		
		
		try {
			
			
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPw());
		pstmt.setString(3, vo.getName());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getAddress());
		//pstmt.setTimestamp(6, vo.getRegdate());
		
		result = pstmt.executeUpdate();
		
		
		} catch (SQLException sqle) {
			System.out.println("DB연결 오류 or SQL 구문 오류 : "+ sqle.toString());
		} finally {
			
			try {
				
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				
			} catch (Exception e) {
			}
			
			
		}
		
		return result;
	}
	
	
	
}
