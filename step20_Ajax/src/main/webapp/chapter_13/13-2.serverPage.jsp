<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h3>
이름 : ${param.name }님 메세지는 ${param.message }입니다  <!-- //$는 jquery가 아닌 jstl - el이니 주의 -->
접속시간 : <%=new Date().toLocaleString() %>
</h3>
</body>
</html>