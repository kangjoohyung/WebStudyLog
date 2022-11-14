<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	
	String name = request.getParameter("name");  // name_시간.txt 파일생성
	String subject = request.getParameter("subject"); //그파일의 내용
	String content = request.getParameter("content");//그 파일의 내용
	
	
	String realPath = application.getRealPath("/ex1004_exam/application/save");
	
	long time = System.currentTimeMillis();
	String path = realPath + "/" + name+"_"+time+".txt";
	 
	BufferedWriter bw =  new BufferedWriter(new FileWriter(path)); //new FileOutpuStream(path)
	
	
	bw.write("이름 : "+name+"\n");
	bw.write("제목 : "+subject+"\n");
	bw.write("내용 : "+content+"\n");
	
	bw.flush();
	bw.close();
	
	//application영역에 realPath저장
	application.setAttribute("realPath", realPath); //
	
    out.println("<script>");
    out.println("alert('생성되었습니다.')");
    out.println("location.href='FileReader.jsp';");
   out.println("</script>");
%>


</body>
</html>