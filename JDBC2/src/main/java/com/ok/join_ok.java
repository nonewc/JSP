package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join_ok")
public class join_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public join_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 1. 입력값 처리 (form)
			
		
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String phone1 = request.getParameter("phone1");
			String phone2 = request.getParameter("phone2");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			
		
		// 2. DB 연동 (변수 선언.. 객체 생성..)
			
			String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String uid = "myjsp";
			String upw = "myjsp";
			
			//String sql = "INSERT INTO testusers VALUES ('"+id+"','"+pw+"','"+name+"','"+phone1+"','"+phone2+"','"+email+"','"+gender+"')";
			String sql = "INSERT INTO testusers VALUES (?,?,?,?,?,?,?)";
			
			Connection conn = null;
			//Statement stmt = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,uid,upw);
				//stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, phone1);
				pstmt.setString(5, phone2);
				pstmt.setString(6, email);
				pstmt.setString(7, gender);
				
				
				//int result = stmt.executeUpdate(sql);
				int result = pstmt.executeUpdate();
				
				if (result == 1) {
					System.out.println("등록 성공");
					response.sendRedirect("join_success.jsp");
				} else {
					System.out.println("등록 실패");
					response.sendRedirect("join_fail.jsp");
				}
			} catch(ClassNotFoundException cnfe) {
				System.out.println("드라이버 연결 실패 : "+cnfe.toString());
				
			} catch(SQLException sqle) {
				System.out.println("DB연결 실패 or SQL 구문 오류"+sqle.toString());
				
			} catch(Exception e) {
				System.out.println("알 수 없는 오류");
				e.printStackTrace();
			} finally {
				try {
				if (conn != null) conn.close();
				//if (stmt != null) stmt.close();
				if (pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
			}
		
		/* 3. 처리 결과에 따른 뷰 (view)
		 *  성공 : Success -> 성공 메세지를 출력하는 페이지 연결
		 *  실패 : Fail -> 실패 메세지 전송하고 다시 회원가입 페이지
		 */
		
		
	}

}
