<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  form 태그를 사용하여 ID, PW입력 받고 처리하는 JSP -->
	<form action="forward_ex02.jsp" method="post">
	
		ID:<input type="text" name="id">
		PW:<input type="password" name="pw">
		<input type="submit" value="login">
		
	</form>


</body>
</html>