package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/modify_ok")
public class modify_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public modify_ok() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 정보 수정을 위한 페이지 이동시 DB정보를 얻기 위한 작업
		
		// DB에서 가져올 정보는 Session에서 "아이디" 값을 얻어옴(user_id)
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "myjsp";
		String password = "myjsp";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM testusers WHERE id = ?";
		
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			/*
			 *  rs.next()를 이용하여 다음 레코드 정보를 조회, 
			 *  rs.getString()... pw,name,phone,phone2,email,gender...
			 *	request를 이용하여 강제로 저장한 후에 forward로 update.jsp로 이동	  
			 *
			 */
			
			
			if (rs.next()) {
				
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				
				//request 객체에 강제 저장
				
				request.setAttribute("user_pw", pw);
				request.setAttribute("user_name", name);
				request.setAttribute("user_phone1", phone1);
				request.setAttribute("user_phone2", phone2);
				request.setAttribute("user_email", email);
				request.setAttribute("user_gender", gender);
				
				System.out.println(id);
				System.out.println(pw);
				System.out.println(name);
				System.out.println(phone1);
				System.out.println(phone2);
				System.out.println(email);
				System.out.println(gender);
				
				// forward
				RequestDispatcher dp = request.getRequestDispatcher("update.jsp");
				dp.forward(request, response);				
				
			}
			
		
		} catch (ClassNotFoundException cnfe) {
			System.out.println("드라이버 연결 오류 : "+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB연결 오류 or SQL 구문 오류"+sqle.toString());
		} catch (Exception e) {
			System.out.println("알 수 없는 오류");
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				
			}
			
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post는 주로 form 태그로 받을 때만
		
		
	}

}
