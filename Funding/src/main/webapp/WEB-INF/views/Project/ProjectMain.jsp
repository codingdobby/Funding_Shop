<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/project.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo&display=swap"
	rel="stylesheet">
<title>프로젝트 후원 메인</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<!-- 본문 내용 -->
 <div align="center">

	<div class="fund_content">

		<!-- 개별 내용 -->

		<div class="fund_each">
			<c:forEach var='vo' items='${projectBotari}'>
				<table border="1">

					<tr>
						<th><a href="fundDetail?pnum=${vo.getProject_num()}"><img
								src="${pageContext.request.contextPath}/resources/photoUpload/${vo.getPpic1()}"></a></th>

					</tr>

					<tr>
						<td>${vo.getProject_num()}</td>
					</tr>
					<tr>
						<td><a href="fundDetail?pnum=${vo.getProject_num()}">${vo.getPtitle()}</a></td>

					</tr>
					<tr>
						<td>글쓴이 : ${vo.getName()}</td>

					</tr>
					<tr>
						<td>목표일 : ${vo.getPdate()}</td>

					</tr>
					<tr>
						<td>목표 금액 : <fmt:formatNumber value="${vo.getTotMoney()}"
								pattern="###,###,###" /></td>

					</tr>
				</table>
			</c:forEach>
		</div>
		<!-- 개별 타이틀 end-->




		<!-- 개별 내용 end -->
	</div>
</div> 




	<%-- <jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include> --%>
</body>
</html>