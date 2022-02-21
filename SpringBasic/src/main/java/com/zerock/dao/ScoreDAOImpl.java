package com.zerock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zerock.command.BoardVO;
import com.zerock.command.ScoreVO;

//DAO의 객체 주입은 일반적으로  Component나, Repository 어노테이션을 사용한다.
//component-scan에 꼭 추가해준다.


//@Componenet
@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {

//	//DB를 대신할 저장소
//	ArrayList<ScoreVO> DB = new ArrayList<>();
//	
//	@Override
//	public void scoreInsert(ScoreVO vo) {
//		
//		System.out.println("------- DAO 계층 -------");
//		System.out.println(vo.getName());
//		System.out.println(vo.getKor());
//		System.out.println(vo.getEng());
//		System.out.println(vo.getMath());
//		
//		DB.add(vo);
//		System.out.println("현재 게시물 수 : " + DB.size());
//	}
//
//	@Override
//	public ArrayList<ScoreVO> scoreSelect() {
//		
//		return DB;
//		
//	}
//
//	@Override
//	public void scoreDelete(String num) {
//		
//		int index = Integer.parseInt(num);
//		DB.remove(index);	// DB 삭제
//		
//	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void scoreInsert(ScoreVO vo) {
		System.out.println(jdbcTemplate); // 검증
		
		
		String sql = "insert into score01(name, kor, eng, math) values(?,?,?,?)";
		
		
		//update() 메서드의 파라미터 값으로 (sql문, ?에 바인딩할 값)
		int result = jdbcTemplate.update(sql, new Object[] {vo.getName(),vo.getKor(),vo.getEng(),vo.getMath()});
		System.out.println(result);
		
		
	}
	
	@Override
	public ArrayList<ScoreVO> scoreSelect() {
		
				
		String sql = "SELECT * FROM score01";
		
		List<ScoreVO> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<ScoreVO>() {
				
				@Override
				public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					ScoreVO vo = new ScoreVO();
					vo.setNum(rs.getInt("num"));
					vo.setName(rs.getString("name"));
					vo.setKor(rs.getString("kor"));
					vo.setEng(rs.getString("eng"));
					vo.setMath(rs.getString("math"));
					return vo;
				
					
				}
				
		});
	
		
		return (ArrayList<ScoreVO>)list;
	}
	
	@Override
	public void scoreDelete(String num) {
		
		String sql = "DELETE FROM score01 WHERE num = ?";
		
		
		//update() 메서드의 파라미터 값으로 (sql문, ?에 바인딩할 값)
		int result = jdbcTemplate.update(sql, new Object[] {num});
		System.out.println(result);
		
		
	}

}
