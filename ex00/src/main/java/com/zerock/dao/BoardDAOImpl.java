package com.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zerock.command.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	//DB로 가정할 ArrayList 처리
	ArrayList<BoardVO> DB = new ArrayList<>();
	
	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String user = "myjsp";
	private String password = "myjsp";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	
	@Override
	public void boardInsert(String name, String title, String content) {
		
		String sql = "INSERT INTO board01(name,title,content) VALUES(?,?,?)";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

	@Override
	public ArrayList<BoardVO> boardSelect() {
		
		String sql = "SELECT * FROM board01 OREDR BY num ASC";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
					
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
			}
			
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		return DB;
	}

	@Override
	public void boardDelete(String num) {
		
		String sql = "DELETE FROM board01 WHERE num =?";
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
					
			pstmt.executeUpdate();
								
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}

}
