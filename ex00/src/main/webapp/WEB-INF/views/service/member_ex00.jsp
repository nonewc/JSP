<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입 (화면 URL 요청 : 컨패스/service/member_tx01)</h2>
	
	<form action="join" method="post">
	 ID : <input type="text" name="id"><br>
	 PW : <input type="password" name="pw"><br>
	 name : <input type="text" name="name"><br>
		<input type="submit" value="회원가입">
	</form>


</body>
</html>