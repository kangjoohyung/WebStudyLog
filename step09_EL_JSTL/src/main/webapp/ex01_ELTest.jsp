<%@page import="ex1006.el.Product"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> EL(Expression Language)=표현언어</h3>
<h4>
\${5}=${5}<br>
\${5+2}=${5+2}<br>
\${5*2}=${5*2}<br>
\${5>2}=${5>2}<br>
\${5 lt 2}=${5 lt 2}<br>

\${"안녕"}=${"안녕"}<br>
\${'반가워'}=${'반가워'}<br>

\${5 gt 3 && 10 eq 10} = ${5 gt 3 && 10 eq 10}<br>
\${5 gt 3 and 10 eq 10} = ${5 gt 3 and 10 eq 10}<br>

\${5 gt 3 || 10 eq 10} = ${5 gt 3 || 10 eq 10}<br>
\${5 gt 3 or 10 eq 10} = ${5 gt 3 or 10 eq 10}<br>

\${5 gt 3 ? "크다":"작다"} = ${5 gt 3 ? "크다":"작다"}<br>

<!-- 
만약,
http://localhost:9000/step09_EL_JSTL/ex01_ELTest.jsp?age=10
요청이 된다고 가정하고 나이를 출력해보고 나이에 따른
성인, 미성년자를 출력한다.
 -->
<%--
int age=Integer.parseInt(request.getParameter("age"));
if(age>18)  
--%>
나이 : ${param.age}살<br><!-- 주소뒤에 ?age=~~  에서 ~~가 param -->
구분 : ${param.age>18 ? "성인" : "미성년자"} <br><!-- 주소 뒤에 ?age=~~   ~~자리에 넣는 값들, 숫자 아니면 오류생기네 -->
아이디 : ${param.id==null ? "Guest" : param.id }<br><!-- id가 guest인지 아니면 id가 있는지 -->
아이디 : ${empty param.id ? "Guest" : param.id }<br><!-- 위의 뒤==null 과 똑같은 기능의 앞empty -->

아이디 : ${param.id!=null ? param.id : "Guest" }<br><!-- != 사용해서 위와 똑같이 출력되게함 -->
아이디 : ${not empty param.id ? param.id : "Guest" }<br><!--  !=과 똑같이 not empty사용해서 위들과 같게함 -->
<!--  표현언어에서 문자열 연결하는 방법 -->
아이디 : ${param.id==null ? "Guest" : param.id}님<br>
아이디 : ${param.id==null ? "Guest" : param.id += "님"}<br><%--${}안에서는 +를 쓰면연결이아니고 숫자 연산자가 되어 에러남, +=로 고치면 기존처럼 사용 가능, ~.concat(~)로 동일함 --%>
아이디 : ${param.id==null ? "Guest" : param.id.concat("님")}<br>

Scope영역(pageContext &lt; request &lt; session &lt; application)있는 정보 가져오기
<%
//영역 예제 사용을 위해(정보 불러오기위해) 정보 저장
request.setAttribute("id", "82523jang");

session.setAttribute("addr","오리역");
session.setAttribute("message","표현언어 연습중");

application.setAttribute("message","즐거운 연휴다");
application.setAttribute("hobbys", Arrays.asList("등산","수영","낚시","골프")); //Arrays jsp임포트필요
%>
<hr>
아이디(request):<%=request.getAttribute("id") %> / ${requestScope.id} / ${id}<!-- 이름이 중복안될때 영역 생략가능 --> <br>

addr(session):<%=session.getAttribute("addr") %> / ${sessionScope.addr} / ${addr} <br>
message(session):${sessionScope.message} / ${message} <br>

message(application):<%=application.getAttribute("message") %> / ${applicationScope.message} / ${message}<br>
hobbys(application):${applicationScope.hobbys} / ${hobbys}<!-- 이름이 중복되면 가장 작은 범위것으로 출력 -->

자바 객체의 속성 및 메소드 접근
<%-- 아래것을 바꿔서 코딩해보기
Product p=new Product();
out.println(p.getCode());
--%>

<!-- 객체 생성 위의 코드와 같은 내용-->
<jsp:useBean id="p" class="ex1006.el.Product" />
상품 코드 : <%=p.getCode() %> / ${p.code} <!-- p.getCodde()호출  --><br>
상품 이름 : ${p.name} <br> <!-- p.getName()호출 -->
가격 : <fmt:formatNumber value="${p.price}" /><br>
수량 : ${p.qty}<br>
총금액(가격*수량) : <fmt:formatNumber value="${p.price*p.qty}" />원 <br>

</h4>

</body>
</html>