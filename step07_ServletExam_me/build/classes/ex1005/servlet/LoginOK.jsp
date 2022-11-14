<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.setHeader("Cache-Control","no-store"); //로그아웃후 보이는 캐시 삭제기능
//세션의 유효시간을 설정
//30초-초단위 세션 유효시간 설정 시간내 동작하면 다시 시간 리셋, 시간이후 동작하면 끊김
session.setMaxInactiveInterval(30); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	$("a").on("click",function(){
		//로그아웃 기능을 하는 페이지로 이동해서 모든 세션을 삭제
		if(confirm("로그아웃할래?")){
			location.href="logout";//web.xml설정후 변경
		}
	});//a태그 온클릭끝 
});//jquery끝
</script>
</head>
<body>
<%
if(session.getAttribute("userId") !=null){//인증된 사용자
	//화면에 출력
	out.println("<h3>"+session.getAttribute("userName")+"("+
	session.getAttribute("userId")+") 님 로그인 중[접속시간 : "+
	session.getAttribute("userTime")+"]<p>");

	out.println("<img src='images/b.jpg'><p>");
	out.println("<a href='#'>로그아웃</a>");
}else{
	out.println("<script>");
	out.println("alert('인증후 이용해주세요')");
	out.println("location.href='LoginForm.html'");
	out.println("</script>");
}

%>
</body>
</html>