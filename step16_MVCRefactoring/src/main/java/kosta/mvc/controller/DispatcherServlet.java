package kosta.mvc.controller;

import java.io.IOException;
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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("되나"); //index.jsp에서 연결이 되는지 콘솔출력으로 확인
		String key=request.getParameter("key");
		System.out.println("key="+key); //넘어오는 키값 확인용-콘솔 출력
		
		Controller con=null;
		
		//if문으로 각각의 기능 설정
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
		//호출
		ModelAndView mv=con.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}//service끝

}
