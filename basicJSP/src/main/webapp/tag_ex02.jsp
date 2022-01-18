<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%!
 	Random rand = new Random();
 	
 	int count = 0;
 
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

페이지 누적 요청 : <% out.print(++count); %> <br>
매 10번째 방문자에게는 기프티콘을 드립니다.<br>
랜덤값 : <%= rand.nextInt(10) %> <br>
<%
	if(count%10 == 0){
		out.println("당첨되었습니다.");
	}
%>




</body>
</html>