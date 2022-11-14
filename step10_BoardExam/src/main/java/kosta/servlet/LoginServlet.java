package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		urlPatterns="/login", loadOnStartup =1, initParams={
				@WebInitParam(name="dbId", value="jang"),
				@WebInitParam(name="dbPwd", value="1234")})
public class LoginServlet extends HttpServlet {
	String dbId, dbPwd;
		
	 public LoginServlet() {
		 System.out.println("LoginServlet ������.....");
	 }
	 
	 @Override
	public void init() throws ServletException {
		System.out.println("LoginServlet�� init ȣ���.....");
	}
	 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//post��� �ѱ����ڵ� ó��
		request.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� �� 3���� �޴´�.
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		//System.out.println("userName = " + userName);
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			//���ǿ� ������ ����
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", userId);
			session.setAttribute("sessionName", userName);
			session.setAttribute("creationTime", new Date().toLocaleString());
			
			//redirect��� �̵�
			response.sendRedirect("LoginOk.jsp");
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('������ �ٽ� Ȯ�����ּ���.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
		
		
		//�ƴϸ� �޽��� ����ϰ� �������̵��Ѵ�.
		
		
	}
	
	
	/* @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet�� doGet ȣ���....");
	}
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet�� doPost ȣ���....");
	}*/
}








