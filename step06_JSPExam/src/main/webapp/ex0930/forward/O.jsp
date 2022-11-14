<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>
<%=request.getParameter("name") %>님 혈액형은 
<%=request.getParameter("blood") %>형
</h1>

<h3>성격이 가장 좋다</h3>
</body>
</html>