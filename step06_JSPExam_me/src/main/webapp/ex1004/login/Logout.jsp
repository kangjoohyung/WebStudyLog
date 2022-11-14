<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();//모든 세션정보 삭제
response.sendRedirect("LoginForm.jsp");//폼으로 이동
%>

</body>
</html>