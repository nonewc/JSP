<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>�α��� ������ (ȭ�� URL ��û : ���佺/service/memeber_ex03")</h2>

	<form action="login" method="post">
	 ID : <input type="text" name="id">
	 PW : <input type="password" name="pw">
		<input type="submit" value="login">
		<input type="button" value="ȸ�� ����" onclick="location.href='member_ex00'">
	</form>
	
	��� : ${msg }
	
</body>
</html>