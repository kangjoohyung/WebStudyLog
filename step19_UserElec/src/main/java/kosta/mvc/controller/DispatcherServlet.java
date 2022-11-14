package kosta.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
	
	private Map<String, Controller> map;
	private Map<String, Class<?>> clzMap;

	@Override
	public void init() throws ServletException {
		ServletContext application=super.getServletContext();
		map=(Map<String, Controller>)application.getAttribute("map");
		clzMap=(Map<String, Class<?>>)application.getAttribute("clzMap");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("�ǳ�"); //index.jsp���� ������ �Ǵ��� �ܼ�������� Ȯ��
		String key=request.getParameter("key");//user,board,goods
		String methodName=request.getParameter("methodName");
		
		if(key==null||key.equals("")) {
			key="elec"; //key�����϶� elec
		}
		if(methodName==null||methodName.equals("")) {
			methodName="select"; //method�����϶� select
		}
		
		System.out.println("key="+key+",methodName="+methodName); //�Ѿ���� �� Ȯ�ο�-�ܼ� ���
		try {
		Controller con=map.get(key);
		Class<?> clz=clzMap.get(key);
		Method method=clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); //Method�� reflect
		
		ModelAndView mv=(ModelAndView) method.invoke(con, request, response);
		
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());//���� ��Ȯ�� �޼��� �����Գ���
			request.getRequestDispatcher("error/error.jsp").forward(request, response);//���������� ������
		}
	}//service��

}
