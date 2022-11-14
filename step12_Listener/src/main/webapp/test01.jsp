<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<h3> 나라정보 - ServletContextListener TEST</h3>
<fieldset>
	<legend>나라선택</legend>
		<c:forEach items="${applicationScope.nationMap}" var="nation">
		<input type="radio" name="nation" value="${nation.key }">${nation.value }<br>
		</c:forEach>
</fieldset>
<hr>
<h4>[접속자 수 : ${applicationScope.count}명]</h4>
</body>
</html>