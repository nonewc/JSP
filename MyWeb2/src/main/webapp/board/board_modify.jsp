<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <%@ include file="../include/_header.jsp" %>
  <section>
  	<div align="center">
	<form name="regform" action="update.board" method="post">
		<table border="1" width ="500">
			<tr>
				<td width="20%"> 글번호 </td>
				<td width="30%"> <input type="text" name="num" value="${vo.num }" readonly> </td> <!-- DB로부터 전달 받을 부분 -->
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.writer}" readonly></td> <!-- DB로부터 전달 받을 부분 -->
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${vo.title }"></td> <!-- DB로부터 전달 받을 부분 -->
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="120">
				<textarea name="content" rows="10" style="width:100%;">
				${vo.content }
				</textarea>
				</td> <!-- DB로부터 전달 받을 부분 -->
			</tr>
			<tr>
				<td colspan="4" align="center">
					<input type="button" value="수정하기" onclick="modifyCheck()">
					<input type="button" value="목록" onclick="location.href='list.board'">
					<input type="button" value="삭제하기" onclick="deleteCheck()">
			</tr>
				
		</table>	
	</form>  
	</div>
  </section>
<%@ include file="../include/_footer.jsp" %>
<script type="text/javascript">
	function modifyCheck() {
		//작성자, 글제목에 공백을 확인하고, 공백이 아니라면 submit() 처리
		if (document.regform.title.value == "" ){
			alert("제목을 입력하세요!!");
			return;
		} else if (confirm("게시글을 수정하시겠습니까?")) {
			document.regform.submit();
		}
	}
	
	function deleteCheck() {
		if (confirm("게시글을 삭제하시겠습니까?")){
			location.href='delete.board?num=${vo.num}'
		}
		
	}
</script>
</body>
</html>