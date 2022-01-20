<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1번 페이지에서 넘어온 ID,PW 값을 받아서 처리
		ID가 abc123이고, 비밀번호가 asd123이면, 로그인 성공이라고 간주하고,
		login_welcome페이지로 리다이렉트
		
		id가 틀린 경우 login_id_fail페이지로 리다이렉트
		pw가 틀린 경우 login_pw_fail페이지로 리다이렉트
		
	*/
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if (id.equals("abc123") && pw.equals("asd123")){
		
		response.sendRedirect("login_welcome.jsp");
		
	} else if (!id.equals("abc123")){
		
		response.sendRedirect("login_id_fail.jsp");
		
	} else {
		
		response.sendRedirect("login_pw_fail.jsp");
		
	}
	
	
	
	
	
	
%>