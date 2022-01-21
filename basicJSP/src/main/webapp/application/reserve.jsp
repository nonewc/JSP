<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!char seatCol = ' ';
	String seatNo = "";

%>

<%

	//예약 현황이 있다면, 예약 좌석을 꺼내서 처리
	List<String> list = new ArrayList<>();
	if (application.getAttribute("seats") != null) {
		list = (List<String>)application.getAttribute("seats");
	}
		
		

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
th, td {
	width: 20px;
	height: 15px;
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<h2>콘서트 예약</h2>
		<h3>예약할 좌석을 선택하세요</h3>
		<hr>
		<h4>좌석 배치도</h4>
		<form action="reserve_ok.jsp" method="post">
		<table>
		
			<tr>
			
			<%for (int j = 0; j < 7; j++) { //열 설정
				
				if (j == 4) { // 3~4열 사이 줄간격 (CSS로 대체가능)
				%><tr><%
					for (int x = 0; x < 27; x++) { %>
					<td></td>
					<%}	%>
				</tr>
				<%} %>
				
			<tr>
			
				<%if (j != 0){ // 행 번호 출력, 0인경우 공백 %> 
					<td><%=j%></td>
				<%} else {%>
					<td></td>
				<%} %>
				
					<% for (int i = 1; i < 27; i++) { // 열 작업
						seatCol = (char)(i+64); // 열 문자 ASKII 
						seatNo = Character.toString(seatCol)+j;%>
							<% if (j==0){ // 열 문자 출력%>
								<td><%=seatCol%></td>
							<%} else if (list.contains(seatNo)) {  //체크박스 생성, 예약목록 있으면 dsiable
								 %>
								<td><input type="checkbox" 
										   name="seat" 
										   value="<%=seatNo%>"
										   disabled>
								</td>
							<%} else {  //체크박스 생성
								 %>
								<td><input type="checkbox" 
										   name="seat" 
										   value="<%=seatNo%>"
										   >
								</td>
							<%} %>
					<%} %>
				
			</tr>

			<%} %>
			
		</table>
		<br>		
		<input type="submit" value="예약">
		<input type="reset" value="취소">
		</form>
	</div>





</body>
</html>