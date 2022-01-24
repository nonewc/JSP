<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = request.getParameter("name");
    	String avgScore = request.getParameter("avg");
    
    	Double re = Double.parseDouble(avgScore);
    	re = (double)Math.round(re*100)/100;
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=name %>님 평균 <%=avgScore %>점 합격입니다.

</body>
</html>