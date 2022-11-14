<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
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
<%
//1. 기존 count 값을 읽어온다. (application 영역에 저장된 값)
Object obj=application.getAttribute("count");
//2. 만약 1의 값이 null이라면 기본 0으로 저장
if(obj==null) {
	//application.setAttribute("count",0); //AtomicInteger()로 대체
	application.setAttribute("count",new AtomicInteger());
	obj=application.getAttribute("count");
}
//3. 읽어온 데이터에 +1을 해서 다시 저장(똑같은 이름으로 저장->덮어쓰기됨)하고 화면에 출력한다.
//int count=(int)obj;
AtomicInteger at=(AtomicInteger)obj;//AtomicInteger()로 대체

int count=at.intValue();//AtomicInteger()로 대체후 count 선언,초기화
if(session.isNew()){
//count++;//증가
//application.setAttribute("count",count);
count=at.incrementAndGet();//증가-AtomicInteger() 증가하는 함수
}
%>
<h3>방문자 수 : <%=count %>명</h3>
</body>
</html>