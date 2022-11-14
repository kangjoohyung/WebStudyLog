<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>include 지시자 TEST</h1>

<%@ include file="top.jsp" %>
<h3>여기는 main.jsp영역입니다</h3>
<hr color="blue">
<%@ include file="footer.jsp" %>

</body>
</html>