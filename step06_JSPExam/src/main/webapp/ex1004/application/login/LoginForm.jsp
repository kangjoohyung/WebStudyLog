<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
    String cookieSaveId="";
 
    //쿠키에 저장된 아이디가 있는지 찾는다. - savedId
   Cookie [] cookies = request.getCookies();
    if(cookies!=null){
    	for(Cookie co : cookies){
    		if(co.getName().equals("savedId")){
    			cookieSaveId = co.getValue();
    			break; //반복문 빠져나가라.
    		}
    	}
    }
    
    //만약 있으면 폼에 출력한다. 
 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 회원 인증 Page - Cookie에 id 기억 시시키</h2>

<form method="post" action="LoginPro.jsp">
  ID : <input type="text" name="userId" value="<%=cookieSaveId%>" /><br/>
  PWD : <input type="password" name="userPwd" /></br/>
  NAME : <input type="text" name="userName" /></br/>
  
  <input type="submit" value="로그인" />
</form>

</body>
</html>