<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>���� �Է� (ȭ�� URL ��û : /service/1scoreRegister)</h2>
	
	<h2>score �Է�</h2>
	<form action="scoreForm" method="post">
	
		�̸� : <input type="text" name="name"><br>
		���� : <input type="text" name="kor"><br>
		���� : <input type="text" name="eng"><br>
		���� : <input type="text" name="math"><br>
	
	<input type="submit" value="����">
	<input type="button" value="���" onclick="location.href='3scoreList'">
	
	</form>
	
	

</body>
</html>