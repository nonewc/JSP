<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/_header.jsp" %>
</div>
</div>
	<!--  회원 가입을 위한 form 태그 작성 -->
	<body>
	<section>
		<div align = "center">
		
			<form name= "regform" action = "user_join_ok.jsp" method = "post">
				<h2>회원가입 페이지</h2>
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" placeholder="4글자 이상 8글자 이하"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pw"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="pw_check"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
	c					<td>이메일</td>
						<td><input type="email" name="email"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="button" value="회원가입" class="btn btn-primary" onclick="check()">
				<input type="button" value="로그인" class="btn btn-info">
			</form>
		</div>
	</section>



<%@ include file = "../include/_footer.jsp" %>
	<script>
		function check() {
			//form은 docunment.태그이름.태그이름으로 하위 태그에 접근이 가능
			//console.log (document.regform.id.value); 을 이용하여 접근 확인 가능...
			if (document.regform.id.value == '') {
				alert("아이디는 필수 사항입니다.");
				return;
			} else if (document.regform.id.value.length < 4 || document.regform.id.value.length > 8){
				alert("아이디는 4글자 이상 8글자 이하로 입력하세요.");
				return;
			} else if (document.regform.pw.value == '') {
				alert("비밀번호는 필수 사항입니다.");
				return;
			} else if (document.regform.pw.value != document.regform.pw_check.value){
				alert("비밀번호가 일치하지 않습니다.");
				return;
			} else if (document.regform.name.value == ''){
				alert("이름은 필수 사항입니다.");
				return;
			} else if (confirm("회원 가입을 하시겠습니까?")) {
				//confirm() 확인창에 "예" 클릭하면 true를 반환, "아니오" 클릭시 false를 반환
				document.regform.submit(); // 자바스크립트를 이용한 submit() 기능
			}
			
			
		}
	</script>

