<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지 (화면 URL요청 : 컨패스/service/member_ex03 )</h2>
	
	<form action="login" method="post">
		ID : <input type="text" name="id"><br>
		pw : <input type="password" name="pw"><br>
	    <input type="submit" value="login">
	    <input type="button" value="회원 가입" onclick="location.href='member_ex00'">
	</form>
	
	결과 : ${msg }

</body>
</html>