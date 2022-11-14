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
 * 모든 사용자 요청을 처리할 진입점 Controller의 역할
 * 사전초기화하는것이 좋음 : loadOnStartup=1 (서버올라갈때 미리 만들수있도록) 설정추가
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
		//System.out.println("되나"); //index.jsp에서 연결이 되는지 콘솔출력으로 확인
		String key=request.getParameter("key");//user,board,goods
		String methodName=request.getParameter("methodName");
		
		System.out.println("key="+key+",methodName="+methodName); //넘어오는 값 확인용-콘솔 출력
		try {
		Controller con=map.get(key);
		Class<?> clz=clzMap.get(key);
		Method method=clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); //Method가 reflect
		
		ModelAndView mv=(ModelAndView) method.invoke(con, request, response);
		
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//service끝

}
