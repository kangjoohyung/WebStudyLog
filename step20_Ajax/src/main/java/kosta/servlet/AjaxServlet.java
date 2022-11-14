package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String imgNames[]= 
		{"spring.jpg","android.jpg","jquery.jpg","jsmasterbook.jpg"}; //여러개 담기위해 배열로 선언
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어오는 변수 담기
		String book=request.getParameter("book"); //0 1 2 3...
		
		String imgInfo=imgNames[Integer.parseInt(book)];
		
		//front에 전송
		PrintWriter out=response.getWriter();
		out.println(imgInfo);
	}

}
