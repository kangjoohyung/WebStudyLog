<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- c태그+$비교 -->
<h3>JSTL - &lt;c:out> and &lt;c:set></h3>
<c:out value="안녕1"></c:out><br>
<c:out value="<h4>안녕2</h4>" escapeXml="true" /><br> <!-- escapeXml true쓰면 전부 text -->
<c:out value="<h4>안녕3</h4>" escapeXml="false" /><br><!-- escapeXml false쓰면 태그사용 -->
${"<h4>안녕4</h4>"}<br>

<!-- 변수 c태그로 저장, scope도 설정가능 -->
<c:set var="id" value="king" />
<c:set var="age" value="20" scope="session" /><!-- page|request|session|application -->
<c:set var="addr" value="제주도" scope="application" />

<%
String name="장희정"; //jsp선언만 하고 저장 안하면 출력 불가->setAttri~~나 c태그set으로 저장후 사용해야함
//xxx.setAttribute("name",name);
%>
<c:set var="name" value="<%=name%>" /> <!-- setAttribute와 동일하게 c태그로 사용할수있음 -->
이름 : ${name}<!-- 선언만해서는 나오게할수없음-저장후엔 사용가능 --> / <p>

저장된 정보 출력하기 <p>
아이디 : ${id} / <c:out value="${id}" /> <br>
나이 : ${age} / ${sessionScope.age } / <c:out value="${age}" /> <br>
주소 : ${addr} / ${applicationScope.addr } / <c:out value="${addr}" /> <br>
이름 : ${name} / <c:out value="${name}" /> <br>

<a href="ex02_result.jsp">확인하러 가자</a>
</body>
</html>