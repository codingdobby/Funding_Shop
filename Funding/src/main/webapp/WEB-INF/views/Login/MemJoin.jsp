<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="https://fonts.googleapis.com/css?family=Do Hyeon"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/test.css"
	type="text/css">


<script type="text/javascript">
	function ok() {
		alert("회원가입 완료");

	}
</script>

<script>
	window.onload = function() {
		document.getElementById("send").onclick = chkData;

	}
	function chkData() {
		if (document.iform.id.value === "" || isNaN(iform.id.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.id.focus(); //request는 생략 가능(java)
			alert("아아디를 입력하세요");
			return;
		}

		
		if (document.iform.pwd.value === "" || isNaN(iform.pwd.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.pwd.focus(); //request는 생략 가능(java)
			alert("비밀번호를 입력하세요");
			return;
		}
/* 
		if (document.iform.pwd2.value === "" || isNaN(iform.pwd2.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.pwd2.focus(); //request는 생략 가능(java)
			alert("비밀번호 확인을 입력하세요");
			return;
		}

		if (document.iform.address.value === "" || isNaN(iform.address.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.id.focus(); //request는 생략 가능(java)
			alert("주소를 입력하세요");
			return;
		}

		if (document.iform.phone.value === "" || isNaN(iform.phone.value) === false) { //isNaN에 의해서 숫자는 처리 불가
			iform.phone.focus(); //request는 생략 가능(java)
			alert("전화번호를 입력하세요");
			return;
		}
 */
		
		
		
		
		//정규 표현식으로 입력자료 검사
		var aa = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
		// a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
		if (!iform.id.value.match(aa)) {
			alert("이메일 형식으로 입력하세요!");
			iform.id.focus();
			return;
		}

		if (iform.pwd.value.length > 12) {
			alert("비밀번호는 4~12자 이내로 입력 가능합니다!");

			iform.pwd.select();//입력한 문자를 선택 상태로 만듬.
			return;
		}

		iform.action = "loginInsert.do";
		iform.method = "post";
		iform.submit(); //서버에 파일로 전송(servlet, jsp)

	}
</script>




</head>
<body>

	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>

	<div id="put" align="center">
		<form name="iform" method="post">

			<table id="test" border="1">
				<tr>
					<td>이름</td>
				</tr>
				<tr>

					<td><input type="text" placeholder="사용하실 닉네임을 입력하세요"
						name="nickname" id="userId"></td>

				</tr>
				<tr>
					<td>아이디</td>

				</tr>

				<tr>
					<td colspan="2"><input type="text" placeholder="이메일을 입력하세요"
						name="id"></td>

				</tr>

				<tr>
					<td>비밀번호</td>
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd"
						placeholder="비밀번호를 입력하세요">
				</tr>


				<tr>
					<td colspan="2"><input type="password" name="pwd1"
						placeholder="비밀번호를 입력하세요"></td>
				</tr>


				<tr>
					<td colspan="2"><input type="text" name="phone"
						placeholder="폰번호를 입력하세요" maxlength="15">
				</tr>


				<tr>
					<td colspan="2"><input type="text" name="address"
						placeholder="주소를 입력하세요"></td>
				</tr>




				<tr>
					<td colspan="2">
					<input type="submit" id="send" value="다음"></td>
				</tr>


			</table>

		</form>
	</div>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>