<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    
    로그인 성공시 cookie를 통해서 로그인 정보를 추가
    로그인 정보를 유지하는 내용
    
     --%>

<%
	/*
		1. idcheck 쿠키를 찾아서, idcheck쿠기가 있다면,
			해당 값을 얻어서 아이디 안에 미리 값을 갖게 코드를 작성!!
			(input태그의 value속성)
		
	
	*/
	Cookie[] idcheck = request.getCookies();
	String id = "";
	
	if (idcheck != null){
		for (int i = 0; i < idcheck.length; i++){
			if (idcheck[i].getName().equals("idCheck")){
				id = idcheck[i].getValue();
			}
		}
	}




%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cookie_login_ok.jsp">
		<table>
			<tr>
				<td><input type=text name="id" placeholder="아이디" value="<%=id %>"></td>
				<td rowspan=2><input type=submit></td>
			</tr>
			<tr>
				<td><input type=password name="pw" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td><input type="checkbox" name="idCheck" value="y">아이디 기억하기</td>
			</tr>
		
		</table>
	</form>
</body>
</html>