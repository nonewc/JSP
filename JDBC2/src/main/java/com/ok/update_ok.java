package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update_ok")
public class update_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public update_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Form 데이터 처리
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(email);
		System.out.println(gender);
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE testusers SET pw= ? ,name= ? , phone1 = ? , "
				+ "phone2 = ? , email = ? , gender = ? WHERE id = ?";
		
		try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, pw);
		pstmt.setString(2, name);
		pstmt.setString(3, phone1);
		pstmt.setString(4, phone2);
		pstmt.setString(5, email);
		pstmt.setString(6, gender);
		pstmt.setString(7, id);
		
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			System.out.println("수정 성공");
			response.sendRedirect("update_success.jsp");
		} else {
			System.out.println("수정 실패");
			response.sendRedirect("update_fail.jsp");
		}
		
		} catch(ClassNotFoundException cnfe) {
			System.out.println("드라이버 연결 오류 : " +cnfe.toString());
		} catch(SQLException sqle) {
			System.out.println("DB연결 오류 or SQL 구문 오류 :" +sqle.toString());
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e2) {
				
			}
			
		}
		
	}

}
