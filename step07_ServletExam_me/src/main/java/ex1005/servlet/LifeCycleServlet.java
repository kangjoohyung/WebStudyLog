package ex1005.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet �ۼ� ���
 * 1) �ݵ�� public class
 * 2) HttpServlet ���
 * 3) �ʿ��� �޼ҵ带 �������Ѵ�
 * 
 * 4) ������ ���ؼ� ����� �Ѵ�
 * 	-web.xml�� ���
 * 	-@annotation ���
 *
 */
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet�� ������ ȣ��");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet�� doGet call");
		
		//�������� ���
		PrintWriter out=response.getWriter();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LifeCycleServlet�� doPost call");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LifeCycleServlet�� service call");
	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet�� destroy call");

	}

	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet�� init call");
	}
	
}
