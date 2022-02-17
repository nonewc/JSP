<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	
	<form action="join" method="post">
	 ID : <input type="text" name="id"><br>
	 PW : <input type="password" name="pw"><br>
	 name : <input type="text" name="name"><br>
		<input type="submit" value="회원가입">
	</form>

	${msg }
	
	
</body>
</html>