package com.myweb.user.model;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class UserDAO {
	
	/*
	 *  DAO는 단수 DB연동을 담당하는 클래스 
	 *  여러개 생성하도록 일반 클래스로 만들면, 메모리 과부하가 올 수 있다. 
	 *  싱글톤 패턴을 적용해서 객체를 1개로 제한. 
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
		} catch (Exception e) {
			System.out.println("Connection Pool 에러");
		}
	}
	
	//3. 외부에서 객체를 요구할 때에 getter메서드를 사용하여 반환
	public static UserDAO getInstance() {
		return instance;
	}
	
	
	// ------ 중복되는 코드를 맴버변수로 선언 --------
	//DB연동에 필요한 변수 및 객체 선언
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
			
	//ID확인 메서드
	public int IdConfirm(String id) {
		int result = 0;
		
		String sql = "select * from users where id = ?";
		
		try {
			//커넥션
			conn = ds.getConnection();
			
			//PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//sql실행
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return result;
	}
	
	
	//회원 가입 메서드
	public int join(UserVO vo) {
		int result = 0;
		
		String sql = "insert into users (id, pw, name, email, address) "
				+ "values(?,?,?,?,?)";
		try {
			//커넥션
			conn = ds.getConnection();
			
			//PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			
			//SQL실행
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
				
		
		return result;
	}
	
	//로그인 메서드
	public int login(String id, String pw) {
		int result = 0;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setNString(2, pw);
			
			//SQL실행
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			} catch (Exception e2) {
				// TODO: handle exception
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
				//DB에서 getString(컬럼명), getTimeStamp(컬럼명) 메서드를 이용
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
	
	//패스워드 변경 메소드
	public int changePassword(String id, String newpw) {
		int result = 0;
		
		String sql = "update users set pw = ? where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newpw);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//회원정보 업데이트 메서드 
	public int update(UserVO vo) {
		int result = 0;
		
		String sql = "update users set name = ? , email = ? , address = ? where id = ?";
		
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
	
	//회원 삭제 메소드
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from users where id = ?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}

}
