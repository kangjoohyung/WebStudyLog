<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{width:800px; height:600px; border:1px solidgray; border-collapse: collapse;}
td{border:1px gray solid; text-align: center;}
table tr:first-child{height:100px}
table tr:last-child{height:70px}
iframe{width:100%; height:430px; border:none}

table tr:nth-child(2) > td:nth-child(1){width:200px;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
</head>
<body>
<table>
<tr><td colspan="2"><jsp:include page="top.jsp" /></td></tr>
<tr><td><iframe src="left.jsp" name="left"></iframe></td>
<td><iframe src="center.jsp" name="center"></iframe></td></tr>
<tr><td colspan="2"><jsp:include page="footer.jsp" /></td></tr>
</table>
</body>
</html>