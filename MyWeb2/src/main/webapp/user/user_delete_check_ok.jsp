<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	/*
	1. user_delete_check.jsp로 받은 폼데이터 값을 처리
	2. login(id,pw) 메서드를 재사용하여, 비밀번호를 확인
	3. login메서드가 0을 반환하면, "비밀번호를 확인하세요"라고 출력
	   login메서드가 1을 반환하면, delete()를 실행
	4. 삭제 성공시 "회원 탈퇴처리가 되었습니다." 출력. 세션을 전부 삭제후 /MyWeb으로 이동
	      삭제 실패시 "회원 탈퇴에 실패했습니다." 출력. 마이페이지로 이동
	      sql = "delete from users where id = ?"
	*/

	if (session.getAttribute("user_id")==null){
		response.sendRedirect("user_login.jsp");
	}
	
	request.setCharacterEncoding("utf-8");

	String id = (String)session.getAttribute("user_id");
	String pw = request.getParameter("pw");
	
	UserDAO dao = UserDAO.getInstance();
	int result = dao.login(id, pw);
	
	if (result == 0) {  //비밀번호가 틀린 경우  %>
		<script>
			alert("비밀번호를 확인하세요.");
			location.href="user_mypage.jsp";
		</script>
<%	}else { //성공    
		int result2 = dao.delete(id);
		if (result2 == 0) { //삭제 실패시 %> 
			<script>
				alert("회원 탈퇴에 실패했습니다.");
				location.href="user_mypage.jsp";
			</script>
<%  	}else {  //삭제 성공시  
			session.invalidate();   //세션 삭제  %>
			<script>
				alert("회원 탈퇴처리가 되었습니다.");
				location.href="/MyWeb2"
			</script>			
<% 		}
	} 
%>
