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
import javax.servlet.http.HttpSession;

@WebServlet("/delete_ok")
public class delete_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		System.out.println(id);
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "myjsp";
		String password = "myjsp";
		
		String sql = "DELETE FROM testusers WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			System.out.println("삭제 완료");
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("삭제 실패");
			response.sendRedirect("mypage.jsp");
		}
		
		} catch (ClassNotFoundException cnfe) {
			
			System.out.println("드라이버 연결 오류 : "+cnfe.toString());
			
		} catch (SQLException sqle) {
			
			System.out.println("DB연결 오류 or SQL 구문 오류 : "+sqle.toString());
			
		} catch (Exception e) {
			
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
