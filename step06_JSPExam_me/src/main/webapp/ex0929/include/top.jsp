<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메뉴입니다 - top.jsp</h1>
<H3>오늘은<%= new Date().toLocaleString() %></H3> 
</body>
</html>