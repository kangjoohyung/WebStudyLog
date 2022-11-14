package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * ȸ�������� ���� Controller
 */
public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		return null;
	}
	/**
	 * �α���
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController�� login");
		// service->daoȣ��
		
		//�α��� �����ϸ� ���ǿ� ���� ���� 
		//session�� redirect�ΰ����(�����������ִµ��� �����Ǵϱ�)
		HttpSession session=request.getSession();
		session.setAttribute("sessionMessage", "�α��ε� �����Դϴ�");
		
		return new ModelAndView("user/login.jsp",true);//redirect������� �̵��Ѵ�.
	}
	
	/**
	 * ȸ����������
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController�� update");
		// ����ȣ��->dao
		//request�����̴ϱ� forward�̵�
		request.setAttribute("message", "�����Ϸ�Ǿ����ϴ�");
		
		return new ModelAndView("user/update.jsp"); //forward������� �̵�����.
	}
	
	/**
	 * �����ϱ�
	 */
	
	/**
	 * �α׾ƿ�
	 */

}
