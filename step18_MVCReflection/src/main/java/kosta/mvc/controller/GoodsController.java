package kosta.mvc.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ǰ���� Controller
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
	 * ��ǰ��� ��������
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController�� list");
		
		request.setAttribute("goodsList",Arrays.asList("���","����","����","�ٳ���"));
		
		return new ModelAndView("goods/list.jsp"); //forward�̵�
	}
	
	/**
	 * ��ǰ���
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController�� insert ȣ��");
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("goods/registerOk.jsp");
		mv.setRedirect(true); //redirect��� ����
		
		return mv;
	}
}
