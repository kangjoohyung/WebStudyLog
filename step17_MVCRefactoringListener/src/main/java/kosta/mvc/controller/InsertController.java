package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("InsertController 호출");//확인용 콘솔송출
		
		// service호출-->dao호출-->등록이 완료되면 redirect방식으로 전체검색으로 이동
		ModelAndView mv=new ModelAndView("front?key=select", true);
		
		return mv;
	}

}
