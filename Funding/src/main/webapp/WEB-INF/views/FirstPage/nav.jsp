<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<style>
* {
	padding: 0px;
	margin: 0px;
}

.nav ul {
	margin: 0 auto;
	margin-top: 20px;
	margin-bottom: 20px;
	list-style: none;
	text-align: center;
	background-color: #FF6F61;
	margin-top: 20px;
	margin-bottom: 20px;
	list-style: none;
	text-align: center;
	background-color: #FF6F61;
	padding: 10px;
	width: 1000px;
}

.nav ul li {
	display: inline;
	padding: 20px;
	font-size: 20pt;
	font-family: 'Do Hyeon', sans-serif;
}

.nav ul li a {
	text-decoration: none;
	color: black;
}

.fixed {
	width: 100%;
	min-width: 1200px;
}
</style>

</head>
<body>


	<div class="fixed">
		<div class="nav">
			<ul>
				<li><a href="project">프로젝트 후원</a></li>
				<li><a href="upload">프로젝트 올리기</a></li>

				
				<%-- 	<c:if test="${param.verify==9}">
						<li><a href="Admin">관리자페이지</a></li>
					</c:if> --%>
				

			<li><a href="Admin">관리자페이지</a></li>

				<li><a href="notice">공지사항</a></li>
				<li><a href="mypage">마이페이지</a></li>
			</ul>
		</div>
	</div>




</body>
</html>