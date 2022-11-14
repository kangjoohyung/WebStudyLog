<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>forward결과 - forwardResult.jsp 문서입니다</h2>
<h3>연산결과 : <%=request.getParameter("total") %>
메시지 : <%=request.getParameter("Message") %></h3>
</body>
</html>