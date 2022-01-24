<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    request.setCharacterEncoding("UTF-8");
    
    int korScore = Integer.parseInt(request.getParameter("korean").trim());
    int engScore = Integer.parseInt(request.getParameter("english").trim());
    int mathScore = Integer.parseInt(request.getParameter("math").trim());
    double avgScore = (korScore+engScore+mathScore)/3;
    
/*     String path = "";
    
    		if (avgScore >= 60) {
    			path = "score_quiz03.jsp";
    		} else {
    			path = "score_quiz04.jsp";
    		}
     */
    
    if (avgScore >= 60){ %>
    <jsp:forward page="score_quiz03.jsp">
    	<jsp:param value="<%=avgScore %>" name="avg"/>
	</jsp:forward>
	<% } else { %>
    <jsp:forward page="score_quiz04.jsp">
    	<jsp:param value="<%=avgScore %>" name="avg"/>
	</jsp:forward>
	<%}	%> 
	