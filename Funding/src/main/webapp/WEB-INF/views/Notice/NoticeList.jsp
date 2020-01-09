<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css?after"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<title>공지 게시판</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include> 

	<h1>공지 게시판</h1>
	<div class="notice_table"> 
	<table border="1" cellspacing="0">
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>

		<c:forEach var='vo' items='${boardList}'>
			<tr>
			
				<td>${vo.getNotice_num()}</td>
				<td><a href="listContent.do?no=${vo.getNotice_num()}">${vo.getnTitle()}</a></td>
				<td>${vo.getnWriter()}</td>
				<td>${vo.getnRegdate()}</td>
				<td>${vo.getNhits()}</td>
				
			
			</tr>
		</c:forEach>

	</table>
	
	</div>
	<div>
	<form action="go_noticeWrite.do">
	<input type="submit" value="글쓰기">
	</form>
	</div>
	 
<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>

</html>