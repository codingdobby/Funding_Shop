<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mypage.css?after"
	type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/mymenu.jsp"></jsp:include>
	<div class="cart_table">
		<table border="1">
			<tr>
				<th>제품이름</th>
				<th>프로젝트 이름</th>
				<th>개수</th>
				<th>가격</th>
			</tr>

			<c:forEach var='vo' items='${cartList}'>
				<tr>

					<td><a href="#">${vo.getProdName()}</a></td>
					<td><a href="#">${vo.getPtitle()}</a></td>
					<td>${vo.getAmount()}</td>
					<td><fmt:formatNumber value="${vo.getPrice()}" 	pattern="###,###,###" /></td>



				</tr>
			</c:forEach>


		</table>

	</div>



	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>