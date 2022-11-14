<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<style>
  table{width:100%; border:5px double skyblue}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none}
</style>
<script>
$(function(){
	$("[value=삭제]").on("click",function(){
		if(confirm("정말 삭제할래요?")){
			let idV=$(this).parent().parent().find("td:eq(1)").text(); //같은tr의 2번째 td찾기
			//alert(idV);// idV확인
			location.href="${pageContext.request.contextPath}/delete?id="+idV;
		}
	});//삭제끝
	/*//버튼일때
	$("[value=검색]").on("click",function(){
		if($("[name=keyField]").val()=="0"){//선택 안한경우(index0인경우)
			alert("검색종류를 선택해주세요");
			return;
		}
		if($("[name=keyWord]").val()==""){//빈칸일때
			alert("검색 단어를 입력해주세요");
			$("[name=keyWord]").focus();
			return;
		}		
		$("[name=search]").submit(); //폼전송한다
	});*/
	$("[name=search]").on("submit",function(){
		if($("[name=keyField]").val()=="0"){//선택 안한경우(index0인경우)
			alert("검색종류를 선택해주세요");
			return false;
		}
		if($("[name=keyWord]").val()==""){//빈칸일때
			alert("검색 단어를 입력해주세요");
			$("[name=keyWord]").focus();
			return false;
		}
	});
})
</script>
</head>

<body>



<div>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="#">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
  
  <c:choose>
  	<c:when test="${empty memberList }">
  		<tr><th colspan="9">검색된 정보가 없습니다.</th></tr>
  	</c:when>
  	<c:otherwise>
       
       <!-- scope에 저장된 정보를 forEach를 이용해서 출력한다. -->
  <c:forEach items="${memberList }" var="member" varStatus="state">
  <tr>
  <td>${state.count }</td>
  <td><a href="${pageContext.request.contextPath}/read?id=${member.id}">${member.id }</a></td> <!-- member.getId()호출 -->
  <td>${member.pwd }</td>
  <td>${member.name }</td>
  <td>${member.age }</td>
  <td>${member.addr }</td>
  <td>${member.phone }</td>
  <td>${member.joinDate }/
  <!-- db에서 가져온 String을 날짜형식으로 변환 -->
  <fmt:parseDate value="${member.joinDate }" pattern="yyyy-MM-dd HH:mm:ss" var="fmtDate"/>
  <fmt:formatDate value="${fmtDate }" pattern="yy-MM-dd"/></td>
  <td><input type="button" value="삭제"></td>
  </tr>
  </c:forEach>
 
  	</c:otherwise>
  </c:choose>
  
</table>
<p>

<form name="search" action="${pageContext.request.contextPath }/search" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="submit" value="검색" />  

</form>





</div>



</body>
</html>




