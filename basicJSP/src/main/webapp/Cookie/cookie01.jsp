<%@page import="java.net.URLEncoder"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
		/*
    		cookie01.jsp는 웹 페이지에 접근한 시간을 xxxx년 xx월 xx일 형태로 쿠키를 생성
    		날짜 형식을 문자열 형태로 show라는 이름의 쿠키로 생성
    		
    		cookie02.jsp는 cookie01.jsp에서 생성된 쿠키를 확인하는 페이지
    		show 쿠키가 잇다면, 쿠키를 가지고 있는 값을 화면에 출력
    		만약 없다면, "쿠키가 없습니다." 출력
    		
    	*/
    	

    	
    	LocalDate now = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
	    String formatedNow = now.format(formatter);

    
    
     	Cookie dateCoo = new Cookie("show", formatedNow);
         	
     	dateCoo.setMaxAge(60);
     	
     	response.addCookie(dateCoo);
        	
    	
    	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="cookie02.jsp">쿠키 확인하기</a>

</body>
</html>