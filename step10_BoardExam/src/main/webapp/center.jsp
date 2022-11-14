<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3>Board LIST</h3>
<table>
<tr>
<th>순서</th>
<th>글번호</th>
<th>제목</th>
<th>내용</th>
</tr>

<c:forEach items="${applicationScope.boardList}" var="board" varStatus="state">
<tr>
<td>${state.count }</td>
<td>${board.no }</td>
<td>${board.subject }</td>
<td>${board.content }</td>
</tr>
</c:forEach>

</table>
<hr>
<c:if test="${not empty sessionId }">
<form action="${pageContext.request.contextPath }/board" method="post">
글번호 : <input type="text" name="no" /><br>
제목 : <input type="text" name="subject" /><br>
내용 : <textarea rows="5" cols="20" name="context" /><br>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>
</c:if>
</body>
</html>