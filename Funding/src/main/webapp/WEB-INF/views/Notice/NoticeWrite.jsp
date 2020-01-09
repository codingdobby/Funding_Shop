<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/notice.css"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

</head>

<body>


<div class="writeForm">

<div class="logo">
<a href="main.do"><img src="resources/image/Logo.png"></a>
</div>
	<h1>게시판</h1>



<form name='iform' action="noticeOK.do" method="post">
		<table border='1' >
			<tr>
				<td>글제목</td>
				<td><input type="text" name="nTitle"></td>
			</tr>
			
			<tr>
				<td>내용</td>
				<td><textarea name="nContent" ></textarea></td>
			
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="등록"><input type="reset" value="취소"></td>
			</tr>

		</table>
		<%
String name = (String) session.getAttribute("name");
%>
	<input type="hidden" name="nWrtier" value="<%=name%>">
	</form>
</div>


</body>
</html>