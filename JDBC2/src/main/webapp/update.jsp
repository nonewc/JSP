<%@page import="com.ok.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	
		// 아이디는 세션을 통해서 얻고, 회원 정보는 request 객체를 통해서 얻음.
		
		String id = (String)session.getAttribute("user_id");
		
		/*
		String pw = (String)request.getAttribute("user_pw");
		String name = (String)request.getAttribute("user_name");
		String phone1 = (String)request.getAttribute("user_phone1");
		String phone2 = (String)request.getAttribute("user_phone2");
		String email = (String)request.getAttribute("user_email");
		String gender = (String)request.getAttribute("user_gender");
		*/
		
		//VO를 이용한 값 받기
		MemberVO vo = (MemberVO)request.getAttribute("vo");
		System.out.println("vo.getId");
		System.out.println("vo.getPw");
		System.out.println("vo.getName");
		System.out.println("vo.getPhone1");
		System.out.println("vo.getPhone2");
		System.out.println("vo.getEmail");
		System.out.println("vo.getGender");

		String pw = vo.getPw();
		String name = vo.getName();
		String phone1 = vo.getPhone1();
		String phone2 = vo.getPhone2();
		String email = vo.getEmail();
		String gender = vo.getGender();
		
		
		
	%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 페이지</title>
</head>
<body>
		<!-- 
			
			input 태그의 읽기만 허용하는 속성은 readonly (disabled는 값도 사라짐)
			select 태그의 옵션 중 미리 선택(default)값은 "selected"
			radion 버튼이나, checkbox 미리 선택하는 기능은 "checked"
			radion 버튼이나, checkbox 선택할 수 없게 하는 기능은 "disabled"
			
		 -->



	<form action="update_ok" method="post">
		<table align="center">
			<caption><h3>회원정보 수정</h3></caption>
			<tr>
				<td>아이디</td>
				<td><input type="text" size="10" name="id" value="<%=id%>" readonly></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" size="10" name="pw"
					value="<%=pw%>" readonly></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" size="10" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
				<select name="phone1">
						<option <%=phone1.equals("010")? "selected" : "" %>>010</option>
						<option <%=phone1.equals("011")? "selected" : "" %>>011</option>
						<option <%=phone1.equals("018")? "selected" : "" %>>018</option>
				</select> 
				-&nbsp;<input type="text" size="6" name="phone2" value="<%=phone2%>"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" size="15" name="email"
					value="<%=email%>"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
				<%if (gender == null || gender.equals("m")) {%>
				<input type="radio" name="gender" id="m" value="m" checked>남자
				<input type="radio" name="gender" id="f" value="f">여자
				<%} else { %>
				<input type="radio" name="gender" id="m" value="m">남자
				<input type="radio" name="gender" id="f" value="f" checked>여자
				<%} %>
				</td>
			</tr>
			<tr align="center">
				<td colspan=2 height="30px"><input type="reset" value="리셋">
					<input type="submit" value="수정"></td>
			</tr>

		</table>
	</form>

</body>
</html>