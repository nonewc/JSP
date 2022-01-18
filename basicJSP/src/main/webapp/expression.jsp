<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String name = "홍길동";
	int age = 20;
	
%>

<%
	String email = "abc@naver.com";
	String address = "서울시 서대문구";
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.println("이름 : <strong>"+name+"</strong><br>");	
		out.println("나이 : <strong>"+age+"</strong><br>");	
		out.println("이메일 : <strong>"+email+"</strong><br>");	
		out.println("주소 : <strong>"+address+"</strong>");	
	%>
	<hr>
	이름 : <strong><%=name %></strong> <br>
	나이 : <strong><%=age %></strong> <br>
	이메일 :<strong><%=email %></strong> <br>
	주소 : <strong><%=address %></strong>
	
</body>
</html>