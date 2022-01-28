<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "join_ok" method="post">
	<table align = "center">
		<caption><h3>회원가입</h3></caption>
		<tr>
			<td>아이디</td>
			<td><input type="text" size = "10" name="id" placeholder="아이디"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" size = "10" name="pw" placeholder="비밀번호"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" size = "10" name="name" placeholder="이름"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><select name = "phone1">
					<option>010</option>
					<option>011</option>
					<option>018</option>
				</select>
				-&nbsp;<input type="text" size = "6" name="phone2" placeholder="전화번호"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" size = "15" name="email" placeholder="이메일"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" id="m" value="m">남자<input type="radio" name="gender" id="f" value="f">여자</td>
		</tr>
		<tr align = "center">
			<td colspan=2 height="30px"> 
			<input type="reset" value="리셋">
			<input type="submit" value="가입"></td>
		</tr>
	
	</table>
</form>



</body>
</html>