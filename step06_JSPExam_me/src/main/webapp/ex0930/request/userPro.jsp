<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>가입 정보</h3>
<%
//폼으로 전송된 모든 name 정보 가져오기
request.setCharacterEncoding("UTF-8");
Enumeration<String> e=request.getParameterNames();
while(e.hasMoreElements()){ //요소가 존재한다면 true 아니면 false (아마도?)
	String name=e.nextElement();//요소를 꺼낸다
	String value=request.getParameter(name);
	out.println(name+"="+value+"<br>");
}
%>

<hr>
request.getContextPath()=<%=request.getContextPath() %><p>
request.getRequestURL()=<%=request.getRequestURL() %><p>

</body>
</html>