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
<h3>파일 첨부 결과</h3>
<h4>
이름 : ${requestScope.name }<br>
subject : ${requestScope.subject }<br>
fileSystemName:${requestScope.fileSystemName}<br>
originalName:${originalName }<br>
fileSize:<fmt:formatNumber value="${fileSize }"/>byte<br>
saveDir:${saveDir }<br>
</h4>

</body>
</html>