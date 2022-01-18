<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	/*
 		1. 페이지를 접속할 때마다 랜덤으로 생성된 값을 출력 :
 		출력 양식 => 오늘의 숫자 : 랜덤 숫자
 		2. 페이지 누적 요청 숫자를 계산하여 출력
 		출력 양식 => 페이지 누적 요청 : 누적 요청수
 		3. 요청한 페이지 개별요청 숫자를 표시
 		출력 양식 => 페이지 개별요청 : 개별 요청수
 	*/
 		
%>
<%! 
	//선언자와 스크립틀릿의 차이 => 멤버변수는 전역변수의 성질을 가지면서
	//전체 어플에 영향을 준다.
	Random rand = new Random();

	public int RandInt(int i){
	
	return rand.nextInt(i);
	}
	
 	int count = 0;

%>
<%
	//페이지가 실행될 때 마다 발생하는 코드를 작성
	int each = 0;

	count++;
	
	each++;
	
	int rn = RandInt(46); // 0~45 사이에 있는 랜덤값 출력
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p> 
		오늘의 숫자 : <%=rn %> <br>
		페이지 누적요청 : <%= count%>
		페이지 개별요청 : <%= each%>
	</p>



</body>
</html>