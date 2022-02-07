package com.myweb.user.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class UserDAO {

	/*
	 *  DAO는 단수 DB연동을 담당하는 클래스
	 *  여러 개 생성하도록 일반 클래스로 만들면, 메모리 과부하가 올 수 있다.
	 *  싱글톤 패턴을 적용해서 객체를 1개로 제한.
	 * 
	 * 
	 */
	
	private DataSource ds;
	private Context ct;
	
	
	
	
	
	//1. 스스로의 객체를 멤버변수로 선언하고 1개로 제한
	private static UserDAO instance = new UserDAO();
	
	//2. 외부에서 객체를 생성할 수 없도록 생성자에 private를 처리
	private UserDAO() {
		try {
			ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle");
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			
			//System.out.println("드라이버 호출시 에러 발생 : "+cnfe.toString());
			System.out.println("Connection Pool 에러");
			
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
			//conn = DriverManager.getConnection(url, user, password);
			conn = ds.getConnection();
			
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
			
			
		//conn = DriverManager.getConnection(url, user, password);
		conn = ds.getConnection();
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
	
	//로그인 메서드
	public int login(String id, String pw) {
		int result = 0;
		
		String sql = "SELECT * FROM users WHERE id = ? and pw = ?";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch(Exception e2) {
				
			}
		}
		
		return result;
	}
	
	
	//회원 정보 얻어오는 메서드
	public UserVO getUserInfo(String id1) {
		UserVO vo = null;
		
		String sql = "select * from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id1);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// DB에서 getString(컬럼명), getTimeStamp(컬럼명) 메서드를 이용
				//rs의 데이터를 vo에 저장.
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new UserVO(id, null, name, email, address, regdate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			
			JdbcUtil.close(conn, pstmt, rs);
			
		}
		
		
		
		return vo;
	}
	
	
	// 비밀번호 변경
	public int changePassword(String id, String new_pw) {
		int result = 0;
		
		String sql = "UPDATE users SET pw = ? WHERE id = ?";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pw);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			JdbcUtil.close(conn, pstmt, rs);
			
		}
		
		return result;
	}
	
	//회원정보 수정
	public int update(UserVO vo) {
		int result = 0;
		String sql = "UPDATE users SET name = ?, email = ?, address = ? WHERE id = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
	
	
}
