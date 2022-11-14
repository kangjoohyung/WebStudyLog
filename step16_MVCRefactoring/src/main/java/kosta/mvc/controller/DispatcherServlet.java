package kosta.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� ����� ��û�� ó���� ������ Controller�� ����
 * �����ʱ�ȭ�ϴ°��� ���� : loadOnStartup=1 (�����ö󰥶� �̸� ������ֵ���) �����߰�
 */
@WebServlet(urlPatterns="/front", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("�ǳ�"); //index.jsp���� ������ �Ǵ��� �ܼ�������� Ȯ��
		String key=request.getParameter("key");
		System.out.println("key="+key); //�Ѿ���� Ű�� Ȯ�ο�-�ܼ� ���
		
		Controller con=null;
		
		//if������ ������ ��� ����
		if(key.equals("select")) {
			con=new SelectController();
		}else if(key.equals("update")) {
			con=new UpdateController();
		}else if(key.equals("delete")) {
			con=new DeleteController();
		}else if(key.equals("insert")) {
			con=new InsertController();
		}
		//////////////////////////////
		//ȣ��
		ModelAndView mv=con.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}//service��

}
