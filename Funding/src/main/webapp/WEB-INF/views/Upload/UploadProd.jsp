<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/upload.css?after"
	type="text/css">
<style>
* {
	font-family: 'Do Hyeon', sans-serif;
}
</style>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="./resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>



<script type="text/javascript">
	var bDisplay = true;
	function doDisplay1() {
		var con = document.getElementById("test");
		if (con.style.display == 'none') {
			con.style.display = 'block';
		} else {
			con.style.display = 'none';
		}
	}
</script>


<title>프로젝트 업로드</title>
</head>
<body>


	<%
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
	%>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div class="Upload_name">
		<h1>프로젝트 업로드</h1>
	</div>
	<div class="content_show">
		<a href="javascript:doDisplay1();">상품 정보 </a>
	</div>


	<form action="insert_OK" method="post">
		<div class="Upload_creater" id="test">
			<fieldset>
				<table border="1">

					<tr>
						<td>상품이름</td>
						<td><input type="text" name="prodName"></td>
					</tr>
					<tr>
						<td>상품가격</td>
						<td><input type="text" name="prodPrice"></td>
					</tr>
					<tr>
						<td>수량</td>
						<td><input type="text" name="prodCount"></td>
					</tr>

				

				</table>
			</fieldset>
		</div>
		<br> <input type="submit" value="등록" />


	</form>


</body>
</html>