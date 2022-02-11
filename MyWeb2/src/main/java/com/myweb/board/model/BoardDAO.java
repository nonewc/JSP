package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.Criteria;
import com.myweb.util.JdbcUtil;

public class BoardDAO {
	
	//1. 스스로 객체를 멤버변수로 선언하고 1개 제한 - 싱글톤
	private static BoardDAO instance = new BoardDAO();

	//2. 외부에서 객체를 생성할 수 없도록 private설정함. 
	private BoardDAO() {
		// 커넥션풀을 꺼내는 작업
		try {
			InitialContext ctx = new InitialContext();  // Context.xml값에 저장된 설정을 저장하기 위해서
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			System.out.println("커넥션 풀링 에러 발생");
		}
	}
	
	//3. 외부에서 객체를 요구할 때에 getter메서드만 써서 반환
	public static BoardDAO getIntance() {
		return instance;
	}
	
	//--------------- 중복되는 코드를 멤버변수로 선언 ------------------
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//--------------- 메서드 구현 ---------------------------------
	
	
	//게시글 등록 메서드 구현
	public void regist(String writer,String title,String content) {

		
		String sql = "insert into board (writer, title, content) values (?,?,?)";
		
		try {
			conn =ds.getConnection();  //커넥션 객체 생성
			pstmt = conn.prepareStatement(sql);  //PreparedStatement객체 생성
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			//SQL실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		

		
	}
	
		
	/*
	//게시물 목록 조회 메서드
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<>();
		
		String sql = "select * from board order by num desc";   //게시글 번호 내림차순
		
		try {
			conn = ds.getConnection(); //커넥션 객체
			pstmt = conn.prepareStatement(sql);  //PreparedStatement 객체생성
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//rs.getString(컬럼명), rs.getInt(), rs.getTimeStamp()
				//데이터를 vo에 담고, 이 데이터를 lst에 저장할 코드를 작성
				/*
				 *  BoardVO vo = new BoardVO();
				 *  vo.setNum(rs.getInt("num");
				 *  vo.setWriter(rs.getString("writer");
				 *  vo.setTitle(rs.getString("title");
				 *  vo.setContent(rs.getString("content");
				 *  vo.setRegdate(rs.getTimeStamp("regdate");
				 *  vo.setHit(rs.getInt("hit");
				 *  
				 *//*
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
				
				//생성된 vo를 리스트에 추가 
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	*/
	
	public ArrayList<BoardVO> getList(Criteria cri) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "SELECT * FROM (SELECT rownum AS rnum, B.* from board B where rownum <= ? "
				+ "order by num desc) where ? <= rnum";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getCount_oracle()); // 몇 개의 데이터 조회 (끝)
			pstmt.setInt(2, cri.getPageStart()); // 시작번호
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
				
				//생성된 vo를 리스트에 추가 
				list.add(vo);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("여기");
			
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	// 총 게사물 수를 반환하는 메서드
	public int getTotal() {
		int result = 0;
		
		String sql = "SELECT count(*) as total from board";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("total");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("여기2");
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
	
	
	
	
	//num 을 이용한 게시글 넘기는 getContent()
	public BoardVO getContent(String num) {
		BoardVO vo = new BoardVO();
		
		String sql = "SELECT * FROM board where num = ?";
		
		try {
			// 커넥션
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			//sql 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
					vo.setNum(rs.getInt("num"));
					vo.setWriter(rs.getString("writer"));
					vo.setContent(rs.getString("content"));
					vo.setTitle(rs.getString("title"));
					vo.setRegdate(rs.getTimestamp("regdate"));
					vo.setHit(rs.getInt("hit"));
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
			
		}
		
		return vo;
	}
	
	//업데이트
	public void update(String num,String title,String content) {
		
		String sql = "UPDATE board set title = ? , content = ? WHERE num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(num));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	
	//딜리트
	public void delete(String num) {
		String sql = "DELETE from board WHERE num = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
	
	//조회수 업데이트
	public void upHit(String num) {
	
		String sql = "UPDATE board SET hit = hit+1 WHERE num = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
	
}
