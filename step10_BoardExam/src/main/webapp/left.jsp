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
<script type="text/javascript" src="{pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<c:choose>
<c:when test="${not empty sessionScope.sessionId }">
${sessionId }님 로그인 중<br>
[접속시간 : ${creationTime}]<p>
<a href="${pageContext.request.contextPath }/logout">로그아웃</a>
</c:when>
<c:otherwise>

<form method="post" action="${pageContext.request.contextPath }/login"><!-- servlet의 url-pattern이 /login -->
  ID : <input type="text" name="userId" size="10" /><br/>
  PWD : <input type="password" name="userPwd" size="10"/></br/>
  <input type="submit" value="로그인" />
  <input type="reset" value="취소" />
</form>
</c:otherwise>
</c:choose>
</body>
</html>