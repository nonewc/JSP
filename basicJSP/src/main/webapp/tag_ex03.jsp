<%@page import="java.util.Collections"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
ArrayList<Integer> lotto = new ArrayList<>();
Random rand = new Random();

for (int i = 0; i < 6; i++) {

	while (true) {
		int x = rand.nextInt(45) + 1;
		if (lotto.contains(x)) {
		continue;
		}

		lotto.add(i, x);
		break;
	}
}

Collections.sort(lotto);

/*
	ArrayList<Integer> list = new ArrayList<>();
	Random ran = new Random();
	while (list.size()<6) {
		int num = ran.nextInt(45)+1;
		if(!list.contains(num)){
		list.add(num);
		}
	}
	
	Collections.sort(list);




*/
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	로또 번호 :
	<%=lotto.toString()%>


</body>
</html>