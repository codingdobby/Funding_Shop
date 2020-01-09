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
	href="${pageContext.request.contextPath}/resources/css/pwd.css"
	type="text/css">
<style type="text/css">

input[type="password"] {
	width: 100%;
}

input[type="text"] {
	width: 100%;
	height:100%;
}

input[type="submit"] {
	width: 100%;
	display: block;
	box-sizing: border-box;
	background-color: #FF6F61;
	padding: 10px;
	border: 1px solid #eeeeee;
	border-radius: 3px;
	font-family: 'Do Hyeon', sans-serif;
	font-size: 100%;
	outline: none;
	color: #FFFFFF;
}

input[type="submit"]:hover, /*foucs는 탭으로 갔을때*/ input[type="submit"]:focus
	{
	border: 2px solid black;
	box-shadow: inset 2px 2px 2px rgba(0, 0, 0, .13)
}


* {
	font-family: font-family : 'Do Hyeon', sans-serif;
}
</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>


</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>

	<form action="update_pwd" method="post" name="iform">
		<div class="findPWD">
			<table border="1">

				<tr>
					<th colspan="2">비밀번호 설정</th>
				</tr>

				<tr>
					<td>비밀번호 입력</td>
					
					<td><input type="text" name="pwd"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="text" name="pwd2"></td>
				</tr>
				
				<tr>

					<td colspan="2"><input type="submit" value="확인"></td>



				</tr>

			</table>

		</div>

	</form>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>