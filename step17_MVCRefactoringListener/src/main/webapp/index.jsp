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
<h2>MVC Refactoring TEST</h2>
<h4>
\${path }=${path }<p><!-- 복붙해와서 step16으로 뜸, 키값도 16찾아가는듯? -->
<a href="${path }/front?key=select">검색하기</a>
<a href="${path }/front?key=update">수정하기</a>
<a href="${path }/front?key=delete">삭제하기</a>
<a href="${path }/front?key=insert">등록하기</a>
</h4>

</body>
</html>