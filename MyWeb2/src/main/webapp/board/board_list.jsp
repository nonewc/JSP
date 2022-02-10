<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <%@ include file="../include/_header.jsp" %>

  <div class="container">
    <h3>MyWeb 게시판</h3>
    
    <table class="table table-bordered">
      <!-- 게시글...  -->
      <thead>
        <tr>
          <th>글 번호</th>
          <th>작성자</th>
          <th>제목</th>
          <th>날짜</th>
          <th>조회수</th>
        </tr>
      </thead>
      <!-- DB로부터 게시글 정보를 알아서 동작 -->
      <!-- EL과 JSTL을 사용하여 처리 -->
      <c:forEach var="vo" items="${list }">
        <tbody>
          <tr>
            <td>${vo.num }</td>
            <td>${vo.writer }</td>
            <td><a href="content.board?num=${vo.num }">${vo.title }</a></td>
            <td>${vo.regdate }</td>
            <td>${vo.hit }</td>
          </tr>
        </tbody>
 	  </c:forEach>
	
	    <!-- 작성글 검색 및 글작성하기 메뉴 -->
	    <tbody>
	      <tr>
	        <td colspan="5" align="right">
	          <form action="" class="form-inline">
	            <div class="form-group">
	              <input type="text" name="search" placeholder="제목검색" class="form-control">
	              <input type="submit" value="검색" class="btn btn-default">
	              <input type="button" value="글 작성" class="btn btn-primary" onclick="location.href='/MyWeb2/board/write.board'">
	            </div>
	          </form>
	        </td>
	      </tr>
	    </tbody>	
    </table>
    
    <!-- 페이지 작업하는 공간 -->
    <div align="center">
      <ul class="pagination pagination-sm">
        <li><a href="#">이전</a></li>
        <li><a href="#">1</a>  </li>
        <li><a href="#">다음</a> </li>
      </ul>
    </div>  
  
  </div>

  <%@ include file="../include/_footer.jsp" %>
</body>
</html>