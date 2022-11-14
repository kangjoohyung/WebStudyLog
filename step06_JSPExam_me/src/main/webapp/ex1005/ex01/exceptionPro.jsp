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
//두 수를 받아서 합계를 구한다.
int num1=Integer(request.getParameter("num1"));
int num2=Integer(request.getParameter("num2"));

%>
<h3>
<%=num1 %>
</h3>
</body>
</html>