<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>액션태그-forward</h2>
<%
	int sum=0;
	for(int i=0; i<=10; i++){
		out.println(i);
		out.print(i);
		out.println(i+"<br>");
		sum+=i;
	}
%>
<jsp:forward page="forwardResult.jsp"/>
	<jsp:param value="<%=sum %>" name="total" />
	<jsp:param value="즐거운주말" name="message" />
</jsp:forward>
</body>
</html>