<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection conn = null;
	String driver = "oracle.jdbc.driver.OracleDriver"; // DB드라이버
	String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1"; // DB connection 작업 중 url 값
	
	/*
		=driver=
		MySQL(6이후) : com.mysql.cj.jdbc.Driver
		MySQL(6이전) : com.mysql.jdbc.Driver
		MariaDB : org.mariadb.jdbc.Driver
		
		=URL설정=
		오라클 : jdbc:oracle:thin:@[서버주소(IP 또는 도메인)]:[서비스포트(1521)]/[세션]
		MySQL(6이후) : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/[DB이름]?serverTimezone=UTC
		MySQL(6이전) : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/[DB이름]
		서울의 UTC : Asia/Seoul
		MariaDB : jdbc:mysql://[서버주소(IP 또는 도메인)]:[서비스포트(3306)]/[DB이름]

	*/
	
	String user = "hr";
	String pw = "hr";
	
	Boolean connect = false;
	
	try {
		//1.Driver 로딩
		Class.forName(driver);
		
		//2.DB 연결 (connection)
		conn=DriverManager.getConnection(url, user, pw);
		connect = true;
		
	} catch(ClassNotFoundException cnfe){
		//Driver 로딩 실패
		connect = false;
		System.out.println("DB드라이버 로딩 실패" + cnfe.toString());
	} catch(SQLException sqle){
		//DB 연결 실패
		connect = false;
		System.out.println("DB연결 실패" + sqle.toString());
	} catch(Exception e){
		// Unknown Error
		connect = false;
		System.out.println("Unknown ERROR");
		e.printStackTrace();
	}
	
	if (connect){%>
		
		<h2>DB연동 성공</h2>
		
	<% } else { %>
	
		<h2>DB연동 실패</h2>
		
	<%} %>
	










</body>
</html>