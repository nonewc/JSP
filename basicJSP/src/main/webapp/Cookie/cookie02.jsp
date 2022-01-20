<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<%


	Cookie[] arr = request.getCookies(); 
	String test = "";

	if (arr != null) { 
		//for(int i = 0; i < arr.length ; i++){
			test = arr[0].getValue();
		//}
	} else {
			test = "쿠키가 없습니다.";
	}




%>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= test%>
</body>
</html>