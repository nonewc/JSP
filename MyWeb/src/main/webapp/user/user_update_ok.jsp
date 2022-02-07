<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*
		진행 흐름 :
			1. 폼 값을 받기
			2. DAO연동을 통해서 update() 메서드를 호출해서 회원 정보를 수정
			3. 매개값을 VO로 전달
			4. 수정 성공시 "회원 정보가 수정되었습니다." 출력후 마이페이지로 이동
			   수정 실패시 "회원 정보 수정에 실패했습니다." 출력 후 마이페이지로 이동
	*/
	
		//URL 강제 접속 차단
		if (session.getAttribute("user_id")==null){
			response.sendRedirect("user_login.jsp");
		}
		String id = (String)session.getAttribute("user_id");
		request.setCharacterEncoding("utf-8");
			
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(address);
		

		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO(id, null, name, email, address, null);
		
			int result = dao.update(vo);
			System.out.println(result);
			
			if (result == 1){
				out.println("<script>alert('회원 정보가 수정되었습니다.'); location.href='user_mypage.jsp';</script>");
			} else {
				%>
				
				<script>
				alert('회원 정보 수정에 실패했습니다.'); 
				history.go(-1)';
				</script>
				
				<%
				
			}
			
			
		


%>