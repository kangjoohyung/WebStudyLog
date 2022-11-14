<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Cookie-서버가 클라이언트 PC쪽에 정보를 저장하는 기술</h3>
<%
//쿠키를 생성
Cookie cookie1=new Cookie("id","jang");
Cookie cookie2=new Cookie("age","20");

//쿠키에 옵션 설정
cookie1.setMaxAge(60*60*24);//1일(초단위)
cookie2.setMaxAge(60*60*24*365);//1년

cookie1.setPath("/");// "/"면 모든 문서 사용 가능, 없으면 폴더내에서만, cookie2는 이 폴더 벗어나면 쓸 수 없게 설정

//생성된 쿠키를 pc쪽에 저장
response.addCookie(cookie1);
response.addCookie(cookie2);
%>
</body>
</html>