package ex1005.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		System.out.println("LoginServlet ������");
		
	}

	/*protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LoginServlet service ȣ���");
	}*/

	public void init() throws ServletException {
		System.out.println("LoginServlet init ȣ���");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LoginServlet doGet ȣ���");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("LoginServlet doPost ȣ���");
	}

}
