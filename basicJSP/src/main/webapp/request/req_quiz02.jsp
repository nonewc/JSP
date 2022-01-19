<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- a태그를 클릭했을 경우 req_quiz02_ko.jsp에 학생번호를 출력 -->
	<H2>req_quiz02.jsp</H2>
	<p> 다음을 구현하고 a태그 클릭시 req_quiz02_ok.jsp에 학생번호를 클릭하세요.<br>
	<%
		for (int i=1; i <= 30; i++){
			%>
			<a href="req_quiz02_ok.jsp?data=<%=i%>번 학생 번호 출력"><%= i%>번 학생</a><br>
			<% 			
		}
	%>

</body>
</html>