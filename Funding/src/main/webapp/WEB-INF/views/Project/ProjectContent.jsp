<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/project.css"
	type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Nanum+Myeongjo&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>프로젝트 후원 메인</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div class="fund_detail">

		<div class="product_title">${vo.getPtitle()}</div>

		<div class="fund_content">
			<!-- 개별 내용 -->
			<div class="fund_each_detail">
				<!-- 개별 이미지 -->
				<div class="detail_img">
					<img src="resources/photoUpload/${vo.getPpic1()}">
				</div>
				<!-- 개별 이미지 end -->


			</div>



			<!-- 개별 내용 -->
			<div class="fund_each_detail2">
				<table border="1">
					<tr>
						<th>프로젝트 진행자</th>

					</tr>
					<tr>
						<td>${vo.getName()}</td>

					</tr>
					<tr>
						<th>목표금액</th>

					</tr>
					<tr>
						<td><fmt:formatNumber value="${vo.getPmoney()}"
								pattern="###,###,###" />/<fmt:formatNumber
								value="${vo.getTotMoney()}" pattern="###,###,###" /></td>

					</tr>

					<tr>
						<th>마감일</th>

					</tr>
					<tr>

						<td>${vo.getPdate()}</td>
					</tr>
					<tr>
						<td>남은 수량 : ${count.getProdCount()}</td>
					</tr>

				</table>

				<!-- 개별 내용 end -->
				<div class="addcart">
					<form action="addCart?pnum=${vo.getProject_num()}" method="post">
						<input type="hidden" name="prodNum_fk"
							value="${count.getProdNum()}"> <input type="hidden"
							name="project_num_fk" value="${vo.getProject_num()}"> <input
							type="submit" value="장바구니 담기">
					</form>
				</div>

			</div>

		</div>
		<!-- 개별 타이틀 end-->

		<div class="prod_info">${vo.getPdate()}${vo.getPcontent()}</div>
	</div>

	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>