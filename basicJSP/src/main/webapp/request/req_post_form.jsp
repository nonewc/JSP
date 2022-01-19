<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>req_get_form</title>
</head>
<body>
	<!--  form 안에 작성된 데이터를 서버로 보낼때, 처리할 경로는 action,
	전송방식을 지정할 떄는 method에서 지정. 단, method 설정하지 않으면 GET방식 -->
	<form action="req_post_parameter.jsp" method="post">
	
		아이디 : <input type="text" size="10" name="id"><br>
		비밀번호 : <input type="password" size="10" name="pw"><br>
		
		관심분야 :
		<input type="checkbox" name="intro" value="자바">자바 
		<input type="checkbox" name="intro" value="JSP">JSP 
		<input type="checkbox" name="intro" value="DATABASE">DATABASE
		<br>
		전공 : 
		<input type="radio" name="major" value="컴공"> 컴공
		<input type="radio" name="major" value="디자인"> 디자인
		<input type="radio" name="major" value="경영"> 경영
		<br>
		통신사 : 
		<select name="phone">
			<option>SKT</option>
			<option>KT</option>
			<option>LGT</option>
		</select>
		<br>
		이름 : <input type="text" size="10" name="name"><br>
		주소 : <input type="text" size="50" name="address"><br>
		<input type="submit" value="전달">
	
	
	</form>


</body>
</html>