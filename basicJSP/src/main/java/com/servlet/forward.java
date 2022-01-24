package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward")
public class forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public forward() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		
		//request에 1회성으로 사용하기 위해서 값을 강제저장
		//request.setAttribute("변수명", 값)
		request.setAttribute("name", "홍길동");
		//response.sendRedirect("actionTag/forward_ex04.jsp"); 리스폰스로 넘기면 값이 유지가 안됨
		RequestDispatcher dp = request.getRequestDispatcher("actionTag/forward_ex04.jsp");
		dp.forward(request, response);
		
	}

}
