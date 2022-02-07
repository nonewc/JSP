<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");


	UserDAO dao = UserDAO.getInstance();
	
	int result = dao.login(id, pw);
	
	if(result == 0) {
%>

		<script>
			alert("아이디 또는 비밀번호가 잘못되었습니다.");
			history.go(-1);
		</script>
<%
		
	} else {
		// 로그인 성공시 회원정보를 얻어오는 작업 진행
		UserVO vo = dao.getUserInfo(id);
		String name = vo.getName();
		
		//아이디와 이름을 세션에 저장
		session.setAttribute("user_id", id);
		session.setAttribute("user_name", name);
		
		response.sendRedirect("user_mypage.jsp");
		
		
	}
			


%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>