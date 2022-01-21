<%@page import="java.util.Arrays"%>
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	//인증정보를 생성, 전달하는 JSP
    	//자바 uuid 중복되지 않는 16bit값을 생성
    	UUID uuid = UUID.randomUUID();
    
    	String struuid = uuid.toString();
    	//System.out.println(struuid);
    	
    	String[] arr = struuid.split("-");
    	//System.out.println(Arrays.toString(arr));
    	
    	session.setAttribute("auth", arr[1]);
    
    %>
    
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<div align="center">
		<h2>인증 페이지</h2>
		<hr>
		<form action="auth_ok.jsp" method="post">
			<h3>인증문자 : <del><%=arr[1] %></del></h3> <!-- <del>:사선 --> 
			인증 문자를 입력하세요 : <input type="text" name="code" size="8">
			<input type="submit" value="인증">
		</form>
	</div>
	</body>
</html>