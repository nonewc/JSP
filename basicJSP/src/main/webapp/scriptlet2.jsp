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
	//out.println(), while, break 사용해서 구구단 4단을 출력.
	
	int i = 1;
	int j = 1;
	
	while(i<5){
		
		i++;
		j=1;
		if(i == 5){break;}
		
	while (j <= i){		
				
		%>
		<%= i + "x" + j + "=" + (i*j)%>
		<%
		
		j++;
	}
	out.println("<br>");
	}
	
	
	%>
	<hr> 1. 체크박스 20개를 for문을 이용하여 가로로 생성 <br>
	<%
	for (int k = 0; k < 20; k++){
		
		%>
		<input type="checkbox" name="check">
		<%
			
		
	}
	
	
	%>

</body>
</html>