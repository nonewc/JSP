<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	
    	Cookie[] arr = request.getCookies();
    	String id = "";
    	int age = 0;
    	
    	if(arr != null){
    		
    		for(Cookie c : arr){
    			if (c.getName().equals("user_id")){
    				id = c.getValue();
    			}
    		}
    		
    	/* for(int i = 0; i < arr.length ; i++){
    		if (arr[i].getName().equals("user_id")){
    		id = arr[i].getValue();
    		
    		}
    	} */
    	}
    
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2><%=id %>님 환영합니다.</h2>
	<%=arr[0].getName() %> : <%= arr[0].getValue()%><br><br>
	<%=arr[1].getName() %> : <%= arr[1].getValue()%><br><br>
	<%=arr[2].getName() %> : <%= arr[2].getValue()%><br><br>
	<%=arr[3].getName() %> : <%= arr[3].getValue()%><br><br>
	
	<a href="cookie_login.jsp">로그인으로</a>

</body>
</html>