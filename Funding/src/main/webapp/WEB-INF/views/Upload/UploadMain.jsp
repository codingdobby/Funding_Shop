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
	function doDisplay() {
		var con = document.getElementById("test");
		if (con.style.display == 'none') {
			con.style.display = 'block';
		} else {
			con.style.display = 'none';
		}
	}
</script>

<script type="text/javascript">
	var bDisplay = true;
	function doDisplay1() {
		var con = document.getElementById("test1");
		if (con.style.display == 'none') {
			con.style.display = 'block';
		} else {
			con.style.display = 'none';
		}
	}
</script>

<script
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
<script>
	CKEDITOR.replace('editor1');
</script>
<script type="text/javascript">
	$(document).ready(function() {
		// disabled 처리
		$("#writerRead").attr("readonly", true);
	});
	</script>

<title>프로젝트 업로드</title>
</head>
<body>
	
		<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<%
		String name = (String) session.getAttribute("name");
		String id = (String) session.getAttribute("id");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
	%>
	<form action="insertProd" method="post" id="insertBoardFrm"
		enctype="multipart/form-data">
	
		<div class="Upload_name">
			<h1>프로젝트 업로드</h1>
		</div>

		<!-- 여기서 부터 내용입력 -->
		<div class="Upload_back">
			<br>
			<div class="content_show">
				<a href="javascript:doDisplay();">프로젝트 진행 정보 입력</a>
			</div>

			<div class="Upload_content" id="test">
				<fieldset>

					<table border="1">
						<tr>
							<td>프로젝트 제목</td>
							<td><input type="text" name="ptitle"></td>
						</tr>

						<tr>
							<td>프로젝트 이미지</td>
							<td><input type="file" name="ppic1"></td>
						</tr>
						<tr>
							<td>프로젝트 내용</td>
							<td><textarea name="pcontent" id="editor1" class="ckeditor" row="100" cols="100"
									style="width: 100%; height: 400px;"></textarea></td>

						</tr>
						<tr>
							<td>마감일</td>
							<td><input type="date" name="pdate"></td>

						</tr>


						<tr>
							<td>창작자 이름</td>
							<td><input type="text" name="pwriter"  value=<%=name %> id="writerRead"></td>
						</tr>


						<tr>
							<td>목표액수</td>
							<td><input type="text" name="totMoney"></td>
						</tr>
					</table>
				</fieldset>
			</div>
		

			<br> <input type="submit" value="다음" /> 



		</div>

	</form>
</body>
</html>