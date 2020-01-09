<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.header {
	width: 1000px;
	min-width: 1000px;
	margin: 0 auto;
}

.test {
	display: inline-block;
}

.header ul {
	margin-top: 20px;
	margin-bottom: 20px;
	list-style: none;
	text-align: center;
}

.header ul li {
	display: inline;
	padding: 10px;
	font-size: 20pt;
	font-family: 'Do Hyeon', sans-serif;
}

.header ul li a {
	text-decoration: none;
	color: black;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/search.css"
	type="text/css">
<meta charset="UTF-8">
<%
	if (session.getAttribute("name") == null)
%>
</head>
<body>
	<%
		String name = (String) session.getAttribute("name");

		if (name != null) {
	%>

	<!-- 로그인 성공 -->

	<div class="header">
		<ul>
			<li><a href="main.do"><img src="resources/image/logoTest.png"></a></li>
			<li>
				<form class="test" action="searchPage?ptitle=?">
					<div class="box">
						<div class="container-3">
							<span class="icon"><i class="fa fa-search"></i></span> <input
								type="search" id="search" placeholder="Search..." name="search" />
						</div>
					</div>
				</form>
			</li>


			<li><a href="#"><img src="resources/image/people.png"
					style="width: 50px; height: 50px">&nbsp;<%=name%>님</a></li>
			<li><a href="logout.do">로그아웃</a></li>

		</ul>
	</div>
	<%
		}

		//로그인 성공하기 전 메인 화면
		else {
	%>
	<div class="header">
		<ul>

			<li><a href="main.do"><img src="resources/image/logoTest.png"></a></li>
			<li>
				<form class="test" action="searchPage">
					<div class="box">
						<div class="container-3">
							<span class="icon"><i class="fa fa-search"></i></span> <input
								type="search" id="search" name="search" placeholder="Search..." />
						</div>
					</div>
				</form>
			</li>

			<li><a href="go_login.do">로그인</a></li>
			<li><a href="agree.do">회원가입</a></li>

		</ul>
	</div>
	<%
		}
	%>

</body>
</html>