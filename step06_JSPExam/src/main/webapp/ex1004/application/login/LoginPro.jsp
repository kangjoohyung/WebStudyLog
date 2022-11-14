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
<%
  //비교정보
  String dbId="jang", dbPwd="1234";

  //post방식 인코딩설정
  request.setCharacterEncoding("UTF-8");

  //전송된 데이터 받기
  String userId = request.getParameter("userId");
  String userPwd= request.getParameter("userPwd");
   String userName= request.getParameter("userName");
   
   if(dbId.equals(userId) && dbPwd.equals((userPwd))){
	   //세션에 아이디, 이름, 접속시간 을 저장
	   session.setAttribute("sessionId", userId);
	   session.setAttribute("sessionName", userName);
	   session.setAttribute("creationTime", new Date(session.getCreationTime()).toLocaleString());
	   
	   //쿠키에 아이디를 저장한다.(유효기간, path옵션설정) - savedId
	   Cookie co = new Cookie("savedId", userId);
	   co.setMaxAge(60*60*24*365);//365일
	   co.setPath("/");
	   response.addCookie(co);
	   
	   //이동한다.
	   response.sendRedirect("LoginOk.jsp");
	   
   }else{
	 out.println("<script>");  
	 out.println("alert('" + userName + "님 정보를 다시 확인해주세요.')");  
	 out.println("history.back();");
	 out.println("</script>");  
   }
%>







</body>
</html>




