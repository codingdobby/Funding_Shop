<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
	alert("로그아웃 되었습니다.");
</script>
</head>
<body>
	<%
		session.invalidate();
		response.sendRedirect("main.do");
	%>
</body>


</html>

