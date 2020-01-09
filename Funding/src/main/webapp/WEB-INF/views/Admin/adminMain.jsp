<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Do+Hyeon|Jua|Nanum+Gothic&display=swap"
	rel="stylesheet">


<meta charset="UTF-8">
<title>관리자페이지</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
		

	<h1>관리자페이지</h1>
<jsp:include page="/WEB-INF/views/FirstPage/AdminMenu.jsp"></jsp:include>
	
	<div class="admin-content">

		<div class="memberList">
			<table border="1">
				<tr>
					<th>닉네임</th>
					<th>아이디</th>
					<th>번호</th>
					<th>주소</th>
					<th>회원 삭제</th>

				</tr>

				<c:forEach var='vo' items='${MemberList}'>
					<tr>

						<td>${vo.getNickname()}</td>
						<td>${vo.getId()}</td>
						<td>${vo.getPhone()}</td>
						<td>${vo.getAddress()}</td>
						<td><input type="button"
							onclick="location.href='delete?id=${vo.getId()}'" value="삭제"></td>


					</tr>
				</c:forEach>
			</table>



		</div>
	</div>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>