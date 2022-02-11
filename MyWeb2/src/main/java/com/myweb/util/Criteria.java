package com.myweb.util;

public class Criteria {

	// mysql, mariadb : SELECT * FROM board BY num desc limit ?, ?
	// oracle : SELECT *
	//			FROM (SELECT ROWNUM rnum, num,writer FROM board)
	//			WHERE rnum BETWEEN ? AND ?
	//			ORDER BY rnum desc;
	//				
	//			SELECT * FROM (SELECT rownum as rnum,num,writer from board
	//			wher ? >= rownum order by num desc) where rnum >=? ;
	
	private int pageNum; // 페이지 번호
	private int count; // 몇 개의 데이터를 게시판에 출력할지 결정
	
	public Criteria() {
		//최초 게시판에 진입할 때 기본값 1번 페이지, 10개 데이터 세팅
		
		this.pageNum = 1;
		this.count = 10;
		
	}
	
	public Criteria(int pageNum, int count) {
		//전달받은 매개변수를 이용한 페이지 값 출력
		super();
		this.pageNum = pageNum;
		this.count = count;
		
	}
	
	// mysql,mariadb limit x, count 구문의 x값을 구하는 메서드
	public int getPageStart() {
		// return (pageNum - 1) * count;  -> mysql, mariadb 인 경우
		return ((pageNum - 1) * count) + 1; // rownum은 1부터 시작하기 때문
		
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public int getCount_oracle() {
		return (pageNum * count);
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	// 게터 세터 생성
	
	
	
	
	
	
}
