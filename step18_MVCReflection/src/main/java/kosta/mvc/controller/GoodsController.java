package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 상품관련 Controller
 *
 */
public class GoodsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 상품목록 가져오기
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController의 list");
		
		request.setAttribute("goodsList",Arrays.asList("사과","딸기","포도","바나나"));
		
		return new ModelAndView("goods/list.jsp"); //forward이동
	}
	
	/**
	 * 상품등록
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController의 insert 호출");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("goods/registerOk.jsp");
		mv.setRedirect(true); //redirect방식 전송
		
		return mv;
	}
}
