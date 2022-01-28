<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //로그아웃 처리는 세션을 삭제
    session.invalidate();
    response.sendRedirect("login.jsp");
    %>
    
   <!--  <script>
		alert("로그아웃 되었습니다.");
		location("login.jsp");    
    </script> -->
