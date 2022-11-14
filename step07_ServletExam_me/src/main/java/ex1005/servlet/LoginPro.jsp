<%@page import="java.util.Date"%>
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

<%
request.setCharacterEncoding("UTF-8");//post방식 인코딩설정
String dbId="jang", dbPwd="1234";//db정보 임의입력(비교정보)
//전송된 데이터 
String userId=request.getParameter("userId");
String userPwd=request.getParameter("userPwd");
String userName=request.getParameter("userName");

long creationTime = session.getCreationTime();//세션 생성 시간
//String userTime=new Date(creationTime).toLocaleString(); //세션 생성 시간
String userTime=new Date().toLocaleString(); //로그인 순간의 시간

//받은이후에 세션에 정보 저장
if(dbId.equals(userId)&&dbPwd.equals(userPwd)){ //userId를 null방지하기위해 앞에 db정보(기존정보)
	//세션에 정보를 저장한다 : id,이름,접속시간
	session.setAttribute("userId",userId);
	session.setAttribute("userName",userName);
	session.setAttribute("userTime",userTime);
    //이동한다.
    response.sendRedirect("LoginOK.jsp");
	//foward방식
	//request.getRequestDispatcher("LoginOK.jsp").forward(request,response);
}else{
	out.println("<script>");
	out.println("alert('"+userName+" 님 아이디 또는 비번을 확인해주세요')");
	out.println("history.back();");
	out.println("</script>");
}

%>
</body>
</html>