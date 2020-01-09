<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Jua|Nanum+Gothic&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css?after"
	type="text/css">
<meta charset="UTF-8">


<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// disabled 처리
		$("#txtBox").attr("readonly", true);
	});
</script>
<!-- 유효성 검사 -->
<script>
	//빈칸 확인

	function check() {

		var name = document.getElementById('name');

		if (name.value == '' || name.value == null) {
			alert('이름이 빈칸입니다!');
			return false;
			iform.name.focus();
		}

		var str = document.getElementById('pwd');

		if (str.value == '' || str.value == null) {
			alert('비밀번호를 입력해주세요');
			return false;
			iform.pwd.focus();
		}

		var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

		if (special_pattern.test(str.value) == true) {
			alert('특수문자는 사용할 수 없습니다.');
			return false;
		}
		var str2 = document.getElementById('pwd1');
		if (str.value != str2.value) {
			alert('값이 일치하지 않습니다.');
			return false;

		}

		var tel = document.getElementById('tel');

		if (tel.value == '' || tel.value == null) {
			alert('전화번호가 빈칸입니다.');
			return false;
			iform.tel.focus();
		}

		var addr = document.getElementById('address');

		if (addr.value == '' || addr.value == null) {
			alert('주소가 빈칸입니다!');
			return false;
			iform.addr.focus();
		}

		alert('수정완료');
		iform.action = "mypageUpdate";
		iform.method = "post";
		iform.submit(); //서버에 파일로 전송(servlet, jsp)
	}
</script>



<title>마이페이지</title>
</head>
<body>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/mymenu.jsp"></jsp:include>


	<%
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
	%>

	<form name="iform" method="post">
		<div class="mypage_content">

			<table border="1">
				<tr>
					<td>이름</td>
				</tr>
				<tr>

					<td><input type="text" placeholder="사용하실 닉네임을 입력하세요" id="name"
						name="nickname" value="<%=name%>"></td>

				</tr>
				<tr>
					<td>아이디</td>

				</tr>

				<tr>
					<td colspan="2"><input type="text" name="id" value="<%=id%>"
						id="txtBox"></td>

				</tr>


				<tr>
					<td>비밀번호</td>
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd" id="pwd"
						placeholder="비밀번호를 입력하세요">
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd1" id="pwd1"
						placeholder="비밀번호를 입력하세요"></td>
				</tr>


				<tr>
					<td>전화번호</td>
				</tr>

				<tr>
					<td colspan="2"><input type="text" name="phone" id="tel"
						value="<%=phone%>" maxlength="15">
				</tr>

				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="address" id="address"
						value="<%=address%>"></td>
				</tr>
			</table>
		</div>
		<div>

			<input type="submit" value="수정하기" onclick="check()">

		</div>
	</form>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>

</body>
</html>