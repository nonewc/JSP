<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
<body>
	<h2>로그인 연습</h2>
	<form action="login_ok" method="post">
		<table>
			<caption>로그인</caption>
			<tr>
				<td>ID:</td>
				<td><input type="text" size="10" name="id" placeholder="아이디"></td>
			</tr>
			<tr>
				<td>PW:</td>
				<td><input type="password" size="10" name="pw" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td colspan=2 align="right"><input type="submit" value="로그인">
			</td>
		</table>
	</form>
</body>
</html>