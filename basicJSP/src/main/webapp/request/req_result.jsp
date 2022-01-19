<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
   	
   		request.setCharacterEncoding("utf-8"); // post는 필수
   		String name = request.getParameter("id");
   		String number = request.getParameter("ps");
   	
   %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	전달받은 값 <br>
	이름 : <%=name %> <br>
	번호 : <%=number %> <br>



</body>
</html>