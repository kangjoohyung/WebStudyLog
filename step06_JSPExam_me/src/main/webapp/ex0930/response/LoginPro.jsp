<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
request.setCharacterEncoding("UTF-8");

String userId=request.getParameter("userId");
String userPwd=request.getParameter("userPwd");
String userName=request.getParameter("userName");
String dbId="jang";
String dbPwd="1234";

if(userId.equals(dbId)&&userPwd.equals(dbPwd)){
	response.sendRedirect("LoginOK.jsp");
}else{
	response.sendRedirect("LoginForm.html");
}

--%>
<%
request.setCharacterEncoding("UTF-8");
String dbId="jang", dbPwd="1234";
//전송된 데이터 받기
String userId=request.getParameter("userId");
String userPwd=request.getParameter("userPwd");
String userName=request.getParameter("userName");

//if(userId.equals(dbId)&&userPwd.equals(dbPwd)){ //userId가 null일경우(그냥submit) Exception생김
if(dbId.equals(userId)&&dbPwd.equals(userPwd)){ //userId를 null방지하기위해 위치 바꿈
	//response.sendRedirect("LoginOK.jsp");//redirect는 name을 넘길수가없음->보내면 넘길수있음
	//response.sendRedirect("LoginOK.jsp?userName="+userName);//name보내면서 넘기기, 한글깨짐
	response.sendRedirect("LoginOK.jsp?userName="+URLEncoder.encode(userName, "UTF-8"));//한글깨지기 보완
	//foward방식
	//request.getRequestDispatcher("LoginOK.jsp").forward(request,response);//보낼필요없이연결가능
}else{
	//out.println();//으로 넣어서 자바스크립트 써도 됨
	%>
	<script>
	
	alert("<%=userName%>아이디 또는 비번을 확인해주세요");
	//alert(<%=userName%>+"아이디 또는 비번을 확인해주세요");//안나옴 : userName이 String이라서 ""가 필요
	//location.href="LoginForm.html"; //실행순서 변경- 안됨
	history.back();//뒤로가기
	</script>
	<%
	response.sendRedirect("LoginForm.html");
}

%>
</body>
</html>