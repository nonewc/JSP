<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// request에는 브라우저에 대한 정보, 사용자가 전달하고자 하는 많은 정보를
	// 자동으로 저장함.
	
	StringBuffer url = request.getRequestURL();
	String uri = request.getRequestURI();
	String path = request.getContextPath();
	String query = request.getQueryString();
	String addr = request.getRemoteAddr();
	
	String method = request.getMethod();
	String sn = request.getServerName();
	int sp = request.getServerPort();
	String protocol = request.getProtocol();
	
	String id = request.getParameter("id");
	String[] check = request.getParameterValues("check");
	
	
	System.out.println("접속주소 : "+addr);


%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	url 주소 : <%=url %><br>
	uri 주소 : <%=uri %><br>
	컨텍스트 주소 : <%=path %> <br>
	쿼리값 : <%=query %><br>
	접속 경로 : <%=addr %><br>
	<br>
	메서드 : <%=method %><br>
	서버이름 : <%=sn %><br>
	서버포트 : <%=sp %><br>
	프로토콜 : <%=protocol %><br>
	<br>
	아이디 : <%=id %><br>
	체크 : <% out.println(Arrays.toString(check)); %><br>
	




</body>
</html>