<!DOCTYPE html><html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String cookieSavedId="";
//쿠키에 저장된 아이디가 있는지 찾는다 - savedId 이름의 키
Cookie [] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie co:cookies){
		if(co.getName().equals("savedId")){
			cookieSavedId=co.getValue();
			break; //찾은 후 저장하고나서 for문 빠져나오기
		}
	}
}
//만약 있으면 폼에 출력한다. ->ID value값에 넣기


%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 회원인증 Page</h2>

<form method="post" action="LoginPro.jsp">
  ID : <input type="text" name="userId" value="<%=cookieSavedId%>"/><br/>
  PWD : <input type="password" name="userPwd" /></br/>
  NAME : <input type="text" name="userName" /></br/>
  
  <input type="submit" value="로그인" />
</form>

</body>
</html>