<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<style>
table{width:400px;border:solid red 1px; border-collapse: collapse;}
th,td{padding:5px; border: solid gray 1px; text-align:center;}
</style>
<script>
$(function(){
	//alert(11)
	$("tr:odd").css({backgroundColor:"skyblue"});
	$("tr:even").css({backgroundColor:"pink"});
	$("tr:eq(0)").css({backgroundColor:"orange", color:"white"});
});
</script>
</head>
<body>
<h3> &lt;c:forEach> 연습하기 </h3>

<c:forEach var="i" begin="1" end="10"><!-- 변수,범위 지정, 증감식 따로 없는듯 -->
	${i }<br>
</c:forEach>
<hr>
<%
String hobbys[]={"등산","수영","낚시","골프"};
%>
<%-- ${hobbys} 사용불가:scope에 저장된게 아니어서! --%>
<c:forEach var="hobby" items="<%=hobbys %>" varStatus="state">
	${hobby } / ${state.index } / ${state.count } <br>
</c:forEach>
<hr>
<h4> Bean에 있는 데이터 출력</h4>
<jsp:useBean id="bean" class="ex22101718.Ex02ForEachBean" />

menus:${bean.menus }<p> <!--bean.getMenus() 호출-->
names:${bean.names }<p>
boardList:${bean.boardList }<p>
map:${bean.map }<p>

<hr>
<select name="menu">
	<option value="0">--선택--</option> <!-- 선택 메뉴 반복문 돌리려고 밑에 c태그 사용(일부러 섞어서씀) -->
	<c:forEach items="${bean.menus}" var="menu">
		<option value="${menu }">${menu}</option>
	</c:forEach>
</select>
<p>
<!-- 이름은 체크박스로 해보기-->
<fieldset>
	<legend>이름선택</legend>
	<c:forEach items="${bean.names}" var="name">
		<input type="checkbox" name="userName" value="${state.count }"> ${name }
	</c:forEach>
</fieldset>
<p>
<table>
<tr>
	<th>순서</th>
	<th>번호</th>
	<th>제목</th>
</tr>
<c:forEach items="${bean.boardList}" var="board" varStatus="state"> <%-- 그냥하면 
	0번지에서 주소값 출력됨, boardDTO에 들어있는 no, subject 꺼내야함 --%>
<tr>
	<td>${state.count}</td>
	<td>${board.no}</td> <!-- board.getNo() 호출 -->
	<td>${board.subject}</td> <!-- board.getSubject()호출 -->
</tr>
</c:forEach>
</table>
<hr color="red">
<!--  map을 이용한 반복문 - radio
	<input type="radio" value="kr">대한민국 -->
<fieldset>
	<legend>나라선택</legend>
	<c:forEach items="${bean.map }" var="nation">
		<input type="radio" name="nation" value="${nation.key }"> ${nation.value }
	</c:forEach>
</fieldset>
가격 : 535353535000원 / <fmt:formatNumber value="535353535000" />원 <!-- 000,000찍힘 -->

<hr>
<a href="ex03_if_choose.jsp">이동1</a><p>
<a href="/ex03_if_choose.jsp">이동2-xx</a><p>
<a href="${pageContext.request.contextPath}/ex03_if_choose.jsp">이동3</a><p>

</body>
</html>