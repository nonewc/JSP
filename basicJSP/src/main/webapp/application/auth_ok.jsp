<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String code = request.getParameter("code");
	String auth = (String)session.getAttribute("auth");
	
	if(code.equals(auth)){
		response.sendRedirect("reserve.jsp");
	} else {
		response.sendRedirect("auth.jsp");
	}


%>