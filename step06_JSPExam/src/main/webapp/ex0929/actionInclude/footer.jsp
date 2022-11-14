<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    //parameter(폼으로)로 전송된 데이터를 받기
    String id = request.getParameter("id");
    String addr = request.getParameter("addr");
    
%>
<h3> footer.jsp입니다.</h3>
<h4> 주소 : <%=addr%> <br>
      개발자 : <%=id%>

</h4>



</body>
</html>