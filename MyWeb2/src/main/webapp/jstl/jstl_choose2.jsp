<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	choose절을 이용하여 90이상은 A, 80이상은 B, 70이상은 C, 나머지는 F로 출력하세요
	 -->
	 <c:choose>
	 	<c:when test="${param.point >= 90 }">
	 		A 입니다.
	 	</c:when>
	 	<c:when test="${param.point >= 80 }">
	 		B 입니다.
	 	</c:when>
	 	<c:when test="${param.point >= 70 }">
	 		C 입니다.
	 	</c:when>
	 	<c:otherwise>
	 		F 입니다.
	 	</c:otherwise>

	 
	 </c:choose>
	 
	 
</body>
</html>