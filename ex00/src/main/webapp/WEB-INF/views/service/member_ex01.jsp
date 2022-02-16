<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<h3>전통적인 방법</h3>
	
	<h2>
	회원 정보 처리
	</h2>
	<form action="memlogin" method="post">
	 ID : <input type="text" name="memid">
	 PW : <input type="password" name="mempw">
		<input type="submit" value="login">
	</form>
	
	<hr>
	
	<h3> 어노테이션을 이용한 방법</h3>
	
	<h2>
	회원 정보 처리
	</h2>
	<form action="memlogin2" method="post">
	 ID : <input type="text" name="memid">
	 PW : <input type="password" name="mempw">
		<input type="submit" value="login">
	</form>
	
	<hr>
	
	<h3>커맨드를 이용한 방식</h3>
	
	<h2>
	회원 정보 처리
	</h2>
	
	<form action="memlogin3" method="post">
	 ID : <input type="text" name="id">
	 PW : <input type="password" name="pw">
		<input type="submit" value="login">
	</form>
	
</body>
</html>