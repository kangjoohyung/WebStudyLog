package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet 작성 방법
 * 1) 반드시 public class
 * 2) HttpServlet 상속
 * 3) 필요한 메소드를 재정의한다
 * 
 * 4) 실행을 위해서 등록을 한다
 * 	-web.xml에 등록
 * 	-@annotation 등록
 *
 */
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet의 생성자 호출");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet의 doGet call");
		
		//브라우져에 출력
		PrintWriter out=response.getWriter();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LifeCycleServlet의 doPost call");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LifeCycleServlet의 service call");
	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet의 destroy call");

	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet의 init call");
	}
	
}
