package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UpdateController 호출");
		// service호출-->dao 수정완료 결과뷰로 이동
		request.setAttribute("message", "수정이 완료되었습니다");
		
		return new ModelAndView("updateResult.jsp"); // 변수없이 바로 생성해서 리턴해봄
	}
}
