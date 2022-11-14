package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  Servlet 작성 방법
 *    1) 반드시 public class
 *    2) HttpServlet 상속
 *    3) 필요한 메소드를 재정의한다.
 *    
 *    4) 실행을 위해서 등록을 한다.
 *         - web.xml에 등록
 *         - @annotation 등록
 * */
public class LifeCycleServlet extends HttpServlet{
    
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet 의 생성자 호출...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet의 init call.....");
	}
	
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 service call....");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//문서 첫줄에 한글인코딩설정
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("LifeCycleServlet의 doGet call.....");
		
		//브라우져에 출력
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head><title>Servlet실습중</title></head>");
		 out.println("<body>");
		 
		 out.println("<h3 style='color:red'>Servlet 시작하기</h3>");
		 
		 
		 //HttpSession
		 HttpSession session = request.getSession();
		 session.setAttribute("name", "희정");
		 
		 //ServletContext
		 ServletContext application = request.getServletContext();
		 application.setAttribute("message", "servlet재미있다.");
		 
		 //Cookie사용
		 Cookie cookie = new Cookie("lastDate", System.currentTimeMillis()+"");
		 response.addCookie(cookie);
		 
		 
		 out.println("</body>");
		 out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet 의 doPost call....");
	}

	

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet의 destroy call....");
	}

	
	
	
}






