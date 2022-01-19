<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  	request.setCharacterEncoding("utf-8");
 	String name = request.getParameter("name");
 	float height = Float.parseFloat(request.getParameter("height"));
 	float weight = Float.parseFloat(request.getParameter("weight"));
    
   	float BMI = (weight/((height/100)*(height/100)));
   	
   	String check = "";
   	
   	if(BMI >= 25){
   		check = "과체중";
   	}else if(BMI >= 18){
   		check = "저체중";
   	} else {check = "정상";}
 	
 	%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <%=name %> <br>
	키 : <%=height %> cm <br>
	몸무게 : <%=weight %> kg <br>
	BMI : <%=BMI %> <br>
	<br>	
	당신은 <%=check %>입니다.



</body>
</html>