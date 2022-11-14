<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> action include TEST </h2>

 <jsp:include page="top.jsp" />
 
 <%
   String addr="서울-Seoul";
 
    //request의 인코딩변경
    request.setCharacterEncoding("UTF-8");
 %>
 
 인코딩 : <%=request.getCharacterEncoding() %><br> 
 
 <hr color="red">
 <h3>여기는 메인 입니다.</h3>
 
 <hr color="blue">
 
 <!--  footer.jsp로 id, addr 정보를 전송한다. -->
 <jsp:include page="footer.jsp" >
   <jsp:param name="id"  value="8253jang" /> 
   <jsp:param  name="addr" value="<%=addr%>"/>
 </jsp:include>
 


</body>


</html>