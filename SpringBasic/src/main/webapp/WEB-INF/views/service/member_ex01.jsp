<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 처리</h2>
	
	<hr>
	<h3>전통적인 방법</h3>
	<form action="/service/memlogin" method="post">
		ID : <input type="text" name="memid"><br>
		pw : <input type="password" name="mempw"><br>
	    <input type="submit" value="login">		
	</form>
	<hr>
	<h3>어노테이션을 이용한 방법</h3>
	<form action="/service/memlogin2" method="post">
		ID : <input type="text" name="memid"><br>
		pw : <input type="password" name="mempw"><br>
	    <input type="submit" value="login">		
	</form>
	<hr>
	<h3>커맨트를 이용한 방식</h3>
	<form action="/service/memlogin3" method="post">
			pw : <input type="password" name="pw"><br>
			ID : <input type="text" name="id"><br>

	    <input type="submit" value="login">		
	</form>
	
	
	
</body>
</html>