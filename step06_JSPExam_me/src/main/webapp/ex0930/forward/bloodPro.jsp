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
//post방식으로 전송되는 한글데이터의 인코딩처리 필요
request.setCharacterEncoding("UTF-8");

//전송된 데이터 받기
String name=request.getParameter("name");
String blood=request.getParameter("blood");

%>
<jsp:forward page="<%=blood+".jsp" %>">
</jsp:forward>
</body>
</html>