<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 
 	String num = request.getParameter("num");
 	Integer sel = Integer.parseInt(num);
 
 
 
 %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (num == null){
	%> 잘못된 접근입니다.
	<%
	} else if (sel==1) {
	%>
	<div align="center">
		<h2>시스코 네트워크</h2>
		<p> 1. vtp 예제 </p>
		<hr>
		<iframe width="711" height="480" src="https://www.youtube.com/embed/7jApbSAFMMI" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
	<%} else if(sel==2) { %>
	<div align="center">
		<h2>시스코 네트워크</h2>
		<p> 1. stp 예제 </p>
		<hr>
		<iframe width="711" height="480" src="https://www.youtube.com/embed/B15XxoGOBks" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	</div>
	<%}%>
	


</body>
</html>