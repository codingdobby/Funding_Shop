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
<style type="text/css">
#agree {
	border-radius: 10px;
	width: 30%;
	height: 80%;
	text-align: center;
}

#test td {
	padding: 10px;
}

input[type="password"] {
	width: 100%;
}

input[type="text"] {
	width: 100%;
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

#put table {
	justify-content: center;
	width: 1000px;
	min-width: 1000px;
}

* {
	font-family: font-family : 'Do Hyeon', sans-serif;
}
</style>

<script src="https://code.jquery.com/jquery-latest.js"></script>
<script>
	function check() { // 체크박스 한번에 모두 선택가능하게 만드는 소스
		var f = document.forms[0];
		if (f.chkAll.checked) { // chkAll에 체크가 되면 chk배열의 총길이만큼 모두 체크하여준다.(모두 체크)
			for (var n = 0; n < f.chk.length; n++)
				f.chk[n].checked = true;
		} else { // chkAll에 체크가 해제되면 chk배열의 총길이만큼 모두 해제하여준다.(모두 체크 해제)
			for (var n = 0; n < f.chk.length; n++)
				f.chk[n].checked = false;
		}
	}
</script>







</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>



	<form action="go_insert.do" method="post" name="iform">
		<div id="put" align="center">
			<table border='1' id="agree">
				<tr>
					<th>아래의 약관에 동의</th>

				</tr>
				<tr>
					<td>원할한 서비스를 위해 아래의 약관에 동의해주세요</td>
				</tr>
				
				<tr>
					<td><input type="checkbox" name="chkAll" onclick="check();">전체
						동의</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="chk" value="1">동의1</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="chk" value="2">동의2</td>
				</tr>

				<tr>
					<td><input type="checkbox" name="chk" value="3">선택.마켓팅</td>

				</tr>
				<tr>
					<td colspan="2" id="send"><input type="submit" 
						value="완료"></td>
				</tr>


			</table>
		</div>
	</form>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>