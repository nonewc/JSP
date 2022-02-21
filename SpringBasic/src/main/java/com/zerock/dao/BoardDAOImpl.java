package com.zerock.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zerock.command.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

//	//DB로 가정할 ArrayList 처리
//	ArrayList<BoardVO> DB = new ArrayList<>();
//	
//	private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String user = "myjsp";
//	private String password = "myjsp";
//	
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
//	
//	
//	
//	@Override
//	public void boardInsert(String name, String title, String content) {
//		
//		String sql = "INSERT INTO board01(name,title,content) VALUES(?,?,?)";
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, name);
//			pstmt.setString(2, title);
//			pstmt.setString(3, content);
//			
//			pstmt.executeUpdate();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if (conn != null) conn.close();
//				if (pstmt != null) pstmt.close();
//				if (rs != null) pstmt.close();
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		
//	}
//
//	@Override
//	public ArrayList<BoardVO> boardSelect() {
//		
//		String sql = "SELECT * FROM board01 OREDR BY num ASC";
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//					
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				int num = rs.getInt("num");
//				String name = rs.getString("name");
//				String title = rs.getString("title");
//				String content = rs.getString("content");
//			}
//			
//		
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if (conn != null) conn.close();
//				if (pstmt != null) pstmt.close();
//				if (rs != null) pstmt.close();
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		
//		
//		return DB;
//	}
//
//	@Override
//	public void boardDelete(String num) {
//		
//		String sql = "DELETE FROM board01 WHERE num =?";
//		
//		try {
//			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, num);
//					
//			pstmt.executeUpdate();
//								
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				
//				if (conn != null) conn.close();
//				if (pstmt != null) pstmt.close();
//				if (rs != null) pstmt.close();
//				
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		
//		
//	}

	// root-context.xml에서 설정 후 주입
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
//	//bean 설정이 없는 경우 (root-context.xml에 설정하지 않은 경우)
//	private HikariConfig hikariConfig;
//	private HikariDataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
//	
//	public BoardDAOImpl() {
//		hikariConfig = new HikariConfig();
//		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
//		hikariConfig.setUsername("myjsp");
//		hikariConfig.setPassword("myjsp");
//		
//		dataSource = new HikariDataSource(hikariConfig);
//		jdbcTemplate = new JdbcTemplate();
//		jdbcTemplate.setDataSource(dataSource); 
//	}
	
	
	
	@Override
	public void boardInsert(String name, String title, String content) {
		System.out.println(jdbcTemplate); // 검증
		
		
		//1st
		
		String sql = "insert into board01(name, title, content) values(?,?,?)";
		
		/*
		int result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, name);
				ps.setString(2, title);
				ps.setString(3, content);
				
			}
		});
		
		System.out.println("결과 조회(성공 : 1, 실패 : 0) :"+result);
		*/
		
		//2nd
		//update() 메서드의 파라미터 값으로 (sql문, ?에 바인딩할 값)
		int result = jdbcTemplate.update(sql, new Object[] {name,title,content});
		System.out.println(result);
		
		
	}
	
	@Override
	public ArrayList<BoardVO> boardSelect() {
		
		/*
		 * 	query()의 파라미터 의미
		 *  - sql : sql 쿼리, ?를 사용하는 preparedStatement용 쿼리를 사용
		 *  - new Object[] {값1, 값2,..args} : sql 물음표에 셋팅할 값을 저장함(바인딩)
		 *  - new RowMapper<Type> () : 조회 결과를 ResultSet으로부터 데이터를 읽어와서 type 데이터 생성
		 * 		-> 익명클래스로 사용합니다
		 * 		-> mapRow() 메서드는 ResultSet에서 읽어온 값을 처리한 후 리턴한다.
		 */
		
		String sql = "SELECT * FROM board01";
		
		List<BoardVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<BoardVO>() {
				
				@Override
				public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					BoardVO vo = new BoardVO();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
					return vo;
				
					
				}
				
		});
	
		
		return (ArrayList<BoardVO>)list;
	}
	
	@Override
	public void boardDelete(String num) {
		
	}

}
