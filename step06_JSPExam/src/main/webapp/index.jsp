
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> JSP �����ϱ� !!</h1>
<%
   //java����
   String name="����"; //���������̹Ƿ� �ݵ�� �ʱ�ȭ �ʼ� 
   int age=20;
   
   //�ܼ����
   System.out.println("�� ��� ��µ���?");
%>

<h3>
  �̸� : <%=name%> <br>
  ���� : <%=age %> ��<br>
</h3>

<%
 
   String message="�ű��ϴ�";
   List<String> list = Arrays.asList("���","����","����","����","�౸");
   
   //�������� ���
   out.println("�޼��� " + message +"<br>");
   out.println("<h4 style='color:red'>��� : " + list +"</h4>");
   
   String addr="��⵵ ������ ������";
   
   request.getParameter("dd");
   
%>

<hr>
�̸� : <%=name%> <br>
�̸� : <%=this.name%><br>

�Լ�ȣ�� : <%=this.test()%>





<%!
   //�������� ���� , �޼ҵ� ����
   String name;
   String phone;
   
   public String test(){
	   System.out.println("test() ȣ���~~");
	   return "����ִ�.";
   }
%>


</body>
</html>
















