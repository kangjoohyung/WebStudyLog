<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> ServletContext-application관련 메소드<p>
application.getContextPath() : <%=application.getContextPath()%><br><!-- 프로젝트인듯? -->
application.getRealPath("/") : <%=application.getRealPath("/")%><br><!-- 파일 실제 경로 -->
application.getMajorVersion() : <%=application.getMajorVersion()%><br><!-- 버젼 정수 -->
application.getMinorVersion() : <%=application.getMinorVersion()%><br><!-- 버젼 소수 -->
application.getServerInfo() : <%=application.getServerInfo()%><br><!-- WAS 서버정보(탐캣) -->

<%
//application 영역에 정보 저장
application.setAttribute("message","배고프다");
application.setAttribute("addr","경기도 성남시 오리역");
application.setAttribute("menus", Arrays.asList("중식","한식","일식"));

%>

application영역에 저장된 정보를 확인 <p>
메세지 : <%=application.getAttribute("message") %><br>
주소 : <%=application.getAttribute("addr")%><br>
메뉴 : <%=application.getAttribute("menus") %><br>

<a href="${pageContext.request.contextPath}/ex1004/session/sessionGet.jsp">
정보 확인하러 가자</a>


</h3>

</body>
</html>