<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
footer {
	width: 1000px;
	height: 310px;
	margin: 20px auto 0;
	overflow: hidden;
}

footer div {
	float: left;
	height: 250px;
	border: 1px solid #cccccc;
	box-sizing: border-box;
}

footer div:first-child {
	width: 500px;
}

footer div:nth-child(2) {
	width: 500px;
}


footer div:last-child {
	width: 1000px;
	height: 50px;
	margin: 10px auto 0;
	background-color: #FF6F61;
	color: #000000;
	text-align: center;
	line-height: 50px;
	clear: both;
	border: 0;
}
.office_logo img{
width:500px;
height:250px;
}

.office_adress img {
width:500px;
height:250px;
}

</style>

<meta charset="UTF-8">

</head>
<body>
    <footer>
        <div class="office_logo"><img src="resources/image/offical_logo.png"></div>
        <div class="office_adress"><img src="resources/image/map.png"></div>
        <!-- <div class="shopping_info">shopping_info</div> -->
        <div class="copyright">copyright@1712124</div>
    </footer>

</body>
</html>