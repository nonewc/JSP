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

	<!--  다음 화면과 같은 내용으로 처리되도록 -->
	<h2>게시글 목록</h2>
	
	
	<table>
	
		<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>내용</td>
		<td>비고</td>		
		</tr>
		
		<c:forEach var="board" items="${boardList }" varStatus="num">
		<tr>
		<td>${board.num}</td>
		<td>${board.name}</td>
		<td>${board.title }</td>
		<td>${board.content }</td>
		<td><input type="button" value="삭제" onclick="location.href='boardDelete?num=${board.num}'"><td>
		</tr>
	</c:forEach>
				
		
	
	
	</table>
	
	<a href="boardRegister">게시글 작성</a>



</body>
</html>