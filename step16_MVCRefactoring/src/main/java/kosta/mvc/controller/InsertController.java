package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("InsertController ȣ��");//Ȯ�ο� �ּܼ���
		
		// serviceȣ��-->daoȣ��-->����� �Ϸ�Ǹ� redirect������� ��ü�˻����� �̵�
		ModelAndView mv=new ModelAndView("front?key=select", true);
		
		return mv;
	}

}