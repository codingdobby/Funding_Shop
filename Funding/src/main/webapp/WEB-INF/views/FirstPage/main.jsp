<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funding_Main</title>


<script src="https://code.jquery.com/jquery-latest.js"></script>
<!--bxslider  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<link rel="images" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/bxslider-4-4.2.12/src/images/controls.png" />
<script>
	$(document).ready(function() {
		$('.slider').bxSlider({
			mode : 'horizontal',
			speed : 500,
			auto : true,
			pager : false,
			controls : true,
			autoHover : true

		});

	});
</script>

<!-- 요소 디자인 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main_css.css"
	type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/FirstPage/header.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/FirstPage/nav.jsp"></jsp:include>
	<div id="content">
	<h2>신규 프로젝트</h2>
		<div class="section1">
			<div class="slide_banner">
				<ul class="slider">
					<c:forEach var='vo' items='${newBotari}'>
						<li><a href="fundDetail?pnum=${vo.getProject_num()}"><img
								src="resources/photoUpload/${vo.getPpic1()}"></a></li>
					</c:forEach>
				</ul>

			</div>
			<!-- <div class="side_banner">
				<ul class="sideSlider">
					<li><img src="resources/image/test.png" /></li>
					<li><img src="resources/image/size.png" /></li>
					<li><img src="resources/image/test.png" /></li>
					<li><img src="resources/image/size.png" /></li>
				</ul>


			</div> -->
		</div>
		<br>
		<h2>최다 조회수 상품</h2>
		<div class="section2">
			<div class="hit_product">

				<ul>
					<c:forEach var='vo' items='${hitBotari}'>
						<li><a href="fundDetail?pnum=${vo.getProject_num()}"><img
								src="resources/photoUpload/${vo.getPpic1()}"></a></li>
					</c:forEach>
				</ul>
			</div>
			<!-- <div class="md_product">
				<ul>
					<li><a href="#" alt="">md_product1</a></li>
					<li><a href="#" alt="">md_product2</a></li>
					<li><a href="#" alt="">md_product3</a></li>
					<li><a href="#" alt="">md_product4</a></li>
				</ul>
			</div> -->
		</div>
	</div>



	<jsp:include page="/WEB-INF/views/FirstPage/footer.jsp"></jsp:include>
</body>
</html>