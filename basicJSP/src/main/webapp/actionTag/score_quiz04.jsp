<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = request.getParameter("name");
    	String avgScore = request.getParameter("avg");
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=name %>님 평균 <%=avgScore %>점 불합격입니다.

</body>
</html>