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
 <h1> HttpServletRequest - request관련 메소드 </h1>

 <%
     Enumeration<String> e = request.getHeaderNames();//request의 header 정보에 대한 name들
     while(e.hasMoreElements()){
    	 String name = e.nextElement();
    	 String value = request.getHeader(name);
    	 
    	 out.println(name+" = "+ value +"<br>");
     }
 
      //request.getHeader(name)
 
 %>
 
 <hr>
 request.getContextPath() = <%=request.getContextPath() %> <p>
 request.getRequestURL() = <%=request.getRequestURL() %> <p>
 

</body>
</html>
















