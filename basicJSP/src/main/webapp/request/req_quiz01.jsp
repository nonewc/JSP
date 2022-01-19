<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BMI 측정 프로그램</title>
</head>
<body>

	<%--
	1. form 태그를 이용하여 post 형식으로 이름, 키와 몸무게를 입력 받음.
	2. req_quiz_result.jsp로 입력값을 전달
	3. 전달된 페이지(req_quiz_result.jsp)에서는 넘어간 값을 처리
		BMI지수를 처리함.
	4. BMI 공식 = kg / (cm/100 * cm/100)
		-> String형식의 값으로 전달됨. 때문에 Integer.parseInt(값) 사용
			또는 Double.parseDouble(값) 사용.
		화면에 이름, 키, 몸무게, BMI지수를 출력
		if를 통해서 BMI지수가 25이상 과체중, 18이하라면 저체중, 나머지는 정상으로 출력	
	 --%>

	<form action="req_quiz_result.jsp" method="post">
		<table>
		<tr>
			<td>이름</td> 
			<td><input type="text" size = "10" name="name"> </td>
		</tr>
		<tr>
			<td>키</td>
			<td> <input type="text" size = "5" name="height"> cm </td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td> <input type="text" size = "5" name="weight"> kg </td>
		<tr>
			<td><input type="submit" value="제출"></td>
		</tr>
		</table>	
	
	
	
	</form>

</body>
</html>