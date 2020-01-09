<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Jua|Nanum+Gothic&display=swap" rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css?after"
	type="text/css">
<meta charset="UTF-8">
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




</body>
</html>