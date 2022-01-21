<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!char seatCol = ' ';
	String seatNo = "";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
th, td {
	width: 10px;
	height: 10px;
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

		<table>
			<tr>
				<td></td>
				<%
				for (int i = 1; i < 27; i++) {
					seatCol = (char)(i+64);
				%>
				<td><%=seatCol%></td>
				<%} %>
			</tr>

			<%
			for (int j = 1; j < 7; j++) {
				if (j == 4) {
			%>
			<tr>
				<%
				for (int x = 0; x < 27; x++) {
				%>
				<td></td>
				<%}	%>
			</tr>
			<%}	%>
			<tr>
				<td><%=j%></td>
				<%
				for (int k = 1; k < 27; k++) {
				%><td><%=seatNo %><input type="checkbox" name="seat" value="y"></td>
				<%}	%>
			</tr>
			<%}	%>
		</table>
	</div>





</body>
</html>