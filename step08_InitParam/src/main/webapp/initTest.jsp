<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Context-param 가져오기 </h3>
<h4>
  메시지 :<%=application.getInitParameter("message") %><p>
  driverName :<%=application.getInitParameter("driverName") %> 
</h4>





</body>
</html>