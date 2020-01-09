<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색완료</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div class="search_result">


		<table border="1" style="width: 1000px;">
			<c:forEach var='vo' items='${search}'>
				<tr>
					<th rowspan="4"><img
						src="resources/photoUpload/${vo.getPpic1()}"></th>
					<td>글 제목 : <a href="fundDetail.do?pnum=${vo.getProject_num()}">${vo.getPtitle()}</a>
					
				</tr>

				<tr>
					<td>마감기간 :${vo.getPdate()}</td>

				</tr>
				<tr>
					<td>목표금액 : ${vo.getTotMoney()}</td>

				</tr>

			</c:forEach>
		</table>



	</div>
	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>