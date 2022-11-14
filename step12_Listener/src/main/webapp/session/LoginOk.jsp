<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
 <%
    response.setHeader("Cache-Control", "no-store");
 
     //세션의 유효시간을 설정
     //session.setMaxInactiveInterval(30); //30초
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="../../js/jquery-3.6.1.min.js"></script> -->

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	  //alert(11)
	  
	  $("a").click(function(){
		  //로그아웃기능을하는 페이지로 이동해서 모든세션의 삭제
		  if(confirm("로그아웃할래?")){
			  location.href="Logout.jsp";
		  }
		  
	  });
  })
</script>
</head>
<body>

\${pageContext.request.contextPath} = ${pageContext.request.contextPath} <p>

<c:choose>
  <c:when test="${sessionScope.sessionId!=null}">
      <h3>
	     ${sessionScope.sessionName} (${sessionId})님 로그인 중 ^^
	     [접속시간 : ${creationTime} ] <p>
	     [접속자 수 : ${applicationScope.count}명]
	    </h3>
	  	<img src="images/bin.jpg"><p>
	  	<a href="#">로그아웃</a>
  </c:when>
  <c:otherwise>
        <script type="text/javascript">
	     alert("인증하고 이용해주세요.");
	     location.href="LoginForm.html";
	   </script>
  </c:otherwise>
</c:choose>

</body>
</html>