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
   //post방식 인코딩설정
   request.setCharacterEncoding("UTF-8");

   String dbId="jang" , dbPwd="1234";

    //전송된 데이터 받기
   String userId = request.getParameter("userId");
   String userPwd = request.getParameter("userPwd");
   String userName= request.getParameter("userName");
   
   if(dbId.equals(userId) && dbPwd.equals(userPwd)){//모두 일치하면
	   //이동
	   response.sendRedirect("LoginOK.jsp?userName=" + URLEncoder.encode(userName, "UTF-8") );
   
       //forward방식
       //request.getRequestDispatcher("LoginOK.jsp").forward(request, response);
       
   }else{
	   
	   %>
	     <script type="text/javascript">
	       alert("<%=userName%> 님 아이디 또는 비번을 확인해주세요.");
	       
	       //location.href="LoginForm.html";
	       history.back(); //뒤로가기
	     </script>
	   <% 
	   
	   //response.sendRedirect("LoginForm.html");
   }

%>





<%=userName %>


</body>
</html>