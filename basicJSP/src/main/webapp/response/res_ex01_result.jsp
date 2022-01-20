<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
	  String age = request.getParameter("age");
  	  int result = Integer.parseInt(age);
  	  
  	  if(result >= 20) {
  		  //응답할 페이지를 지정
  		  response.sendRedirect("res_ex01_ok.jsp");
  	  } else {
  		  response.sendRedirect("res_ex01_no.jsp");
  	  }
  
  
  
  
  %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>