<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.myweb.user.model.UserVO"%>
<%@page import="com.myweb.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*
		진행 흐름 :
			1. 전달받은 값을 처리
			2. 회원 가입 여부를 확인
			3. 가입된 경우 실패 (뒤로 가기) | 가입 안된 경우 -> 가입 진행 ("join()")
			4. 회원가입 축하 및 로그인 페이지로 이동 | 실패시 재가입 페이지로 이동
	*/

		request.setCharacterEncoding("utf-8");
			
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		//Timestamp regdate = new Timestamp(System.currentTimeMillis());
		

		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO(id, pw, name, email, address, null);
		
		if (dao.IdConfirm(id) == 0) {
			
			int result = dao.join(vo);
			
			if (result == 1){
				out.println("<script>alert('회원가입을 축하합니다.'); location.href='user_login.jsp';</script>");
			} else {
				out.println("<script>alert('회원가입을 실패했습니다.'); history.go(-1)';</script>");
				
			}
			
			
		} else {
			
			out.println("<script>alert('아이디가 중복됩니다.'); history.go(-1);</script>");
			
		}


%>