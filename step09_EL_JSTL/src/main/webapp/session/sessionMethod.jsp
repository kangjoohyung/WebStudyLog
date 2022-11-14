<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> HttpSession - session 관련 메소드 </h1>
<h3>
session.getId()  : <%=session.getId() %> <br>
session.isNew()  : <%=session.isNew() %> <br>
session.getMaxInactiveInterval()  : <%=session.getMaxInactiveInterval() %> <br>
session.getCreationTime()  : 
<%
    long creationTime =  session.getCreationTime() ;
    String creationTimeStr =  new Date(creationTime).toLocaleString();
    
    out.println(creationTime +" : " + creationTimeStr);

%> 
<br>

session.getLastAccessedTime()  :
 <%
    long lastAccess = session.getLastAccessedTime() ;
    String lastAccessStr = new Date(lastAccess).toLocaleString();
     
    out.println(lastAccess +" : " + lastAccessStr);
%> <br>

<hr>
<%
   //세션에 정보를 저장 - 브라우져가 유지되는 동안 유효함.
   session.setAttribute("id", "jang");
   session.setAttribute("age", "20");
   session.setAttribute("hobbys", new String[]{"등산","수영","낚시","골프"});
%>

저장된 정보 조회하기 <p>
아이디 : <%=session.getAttribute("id") %><br>
나이  :<%=session.getAttribute("age") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>

</h3>

<a href="sessionGet.jsp">session정보 확인하러가자</a>


</body>
</html>




