<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    	String path = "include_ex02.jsp";
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>여기는 1번 페이지</h2>
	<%@ include file="include_ex02.jsp" %>
	<jsp:include page="<%=path %>"/>


</body>
</html>