package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	String dbId="jang", dbPwd="1234";

	 public LoginServlet() {
		 System.out.println("LoginServlet 생성됨.....");
	 }
	 
	 @Override
	public void init() throws ServletException {
		System.out.println("LoginServlet의 init 호출됨.....");
	}
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//post방식 한글인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//넘어오는 값 3개를 받는다.
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		//System.out.println("userName = " + userName);
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			//세션에 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", userId);
			session.setAttribute("sessionName", userName);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			//redirect방식 이동
			response.sendRedirect("LoginOk.jsp");
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 다시 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
		
		
		//아니면 메시지 출력하고 폼으로이동한다.
		
		
	}
	
	
	/* @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet의 doGet 호출됨....");
	}
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet의 doPost 호출됨....");
	}*/
}








