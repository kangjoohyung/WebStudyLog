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
//request.setCharacterEncoding("UTF-8");
String userName=request.getParameter("userName");
out.println(userName+"님 로그인 성공");
%>
</body>
</html>