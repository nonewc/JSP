package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login_ok")
public class login_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login_ok() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 form으로 받은 정보 전달 받음
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	

		// DB연동을 위한 변수 및 객체 생성

		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String user = "myjsp";
		String password = "myjsp";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM testusers WHERE id = ? AND pw = ?";

		try {
			// 1. 드라이버 로드
			Class.forName(driver);
			// 2. 커넥션 객체 생성
			conn = DriverManager.getConnection(url, user, password);
			// 3. preparedStatemnet 객체 생성 및 sql 작성
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			// 4. 쿼리 실행
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 아이디 패스워드 일치, 로그인 성공
				
				// Session은 tomcat의 내장객체라 다른곳에서 쓰려면 객체 직접 찍어야함
				HttpSession session = request.getSession();
				
				session.setAttribute("user_id", id); // 이렇게도 되고
				session.setAttribute("user_name", rs.getString("name")); //이렇게도 돼
				
				response.sendRedirect("mypage.jsp");
			} else {
				// 로그인 실패시 - 아이디 혹은 비밀번호가 틀린 경우
				response.sendRedirect("login_fail.jsp");
			}

		} catch (ClassNotFoundException cnfe) {

			System.out.println("드라이버 연결 오류 : " + cnfe.toString());

		} catch (SQLException sqle) {

			System.out.println("DB 연결 오류 or SQL 구문 오류 : " + sqle.toString());

		} catch (Exception e) {

			System.out.println("알 수 없는 오류");
			e.printStackTrace();

		} finally {

			try {

				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();

			} catch (Exception e2) {

			}
		}

	}

}
