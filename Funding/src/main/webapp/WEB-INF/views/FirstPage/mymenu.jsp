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

.nav1 ul {
	margin: 0 auto;
	list-style: none;
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
	list-style: none;
	text-align: center;
	background-color: #FFABA3;
	padding: 10px;
	width: 1000px;
}

.nav1 ul li {
	display: inline;
	padding: 20px;
	font-size: 20pt;
	font-family: 'Do Hyeon', sans-serif;
}

.nav1 ul li a {
	text-decoration: none;
	color: black;
}

.fixed1 {
	width: 100%;
	min-width: 1000px;
}
</style>

</head>
<body>


	<div class="fixed1">
		<div class="nav1">
			<ul>
				<li><a href="mypage">회원 정보 수정</a></li>
				<li><a href="upload">진행중인 프로젝트</a></li>
				<li><a href="mycart">장바구니</a></li>
			</ul>
		</div>
	</div>




</body>
</html>