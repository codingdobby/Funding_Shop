<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 승인</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Jua|Nanum+Gothic&display=swap"
	rel="stylesheet">

</head>

<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div>


		<h1>프로젝트 관리 페이지</h1>
		<jsp:include page="/WEB-INF/views/FirstPage/AdminMenu.jsp"></jsp:include>

		<div class="admin_project">
			<table border="1" cellspacing="0">
				<tr>
					<th>글 번호</th>
					<th>글 제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>승인여부</th>
					<th>승인</th>
				</tr>

				<c:forEach var='vo' items='${ProjectList}'>
					<tr>
						<td>${vo.getProject_num()}</td>
						<td><a href="fundDetail?pnum=${vo.getProject_num()}">${vo.getPtitle()}</a></td>
						<td>${vo.getName()}</td>
						<td>${vo.getRegdate()}</td>
						<td>${vo.getpVerify()}</td>
						<td><input type="button" value="승인"
							onclick="location.href='admit?pnum=${vo.getProject_num()}'"></td>
					</tr>
				</c:forEach>

			</table>

		</div>


	</div>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>