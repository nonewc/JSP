<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	GET 방식은 반드시 폼태그를 사용할 필요가 없음.
	주소를 통해서 강제로 파라미터를 전달할 수 있음.
	
	?변수명=값 => 웹어플리케이션 ex) login.jsp?id=test
	여러가지 변수 값을 전달하는 경우에는 "&"를 사용하여 전달
	
	** 브라우저에서 url 인코딩을 하지 않으면 오류가 발생할 수 있음.
	http://localhost:8080/basicJSP/request/req_result.jsp?name=%ED%99%8D%EA%B8%B8%EB%8F%99&number=1234
	 -->
	 
	 <a href="req_result.jsp?id=홍길동&ps=1234">get방식 확인</a>



</body>
</html>