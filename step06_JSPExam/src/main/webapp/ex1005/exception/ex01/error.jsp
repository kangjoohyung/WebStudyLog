<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"%>
    
 <%
    response.setStatus(200);//정상
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> 예외가 발생했어요. </h3>
예외종류 : <%=exception%> <p>
예외메시지 :<%=exception.getMessage() %> <p>
예외클래스 : <%=exception.getClass() %><p>

<hr>
<a href="exceptionForm.jsp">폼으로이동</a>


</body>
</html>