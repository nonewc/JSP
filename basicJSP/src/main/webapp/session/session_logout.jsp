<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 처리(세션 정보 삭제)
	//1번 - 일부 세션 정보를 제거 ... user_id
	session.removeAttribute("user_id");
	response.sendRedirect("session_login.jsp");

%>