package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("DeleteController호출");
		// service->dao호출해서 삭제완료된 후 이동
		//이번엔 forward방식으로, 메인화면으로 이동시켜봄
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
