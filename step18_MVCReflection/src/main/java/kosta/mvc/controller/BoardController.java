package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �Խ��ǿ� ���õ� Controller
 *
 */
public class BoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �Խù� �˻�
	 */
	public ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController�� list");
		
		request.setAttribute("message", "�˻�����Դϴ�");
		return new ModelAndView("board/list.jsp");
	}
	
	/**
	 * �󼼺���
	 */
	public ModelAndView read(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController�� read");
		
		return new ModelAndView("board/read.jsp", true);
	}
}
