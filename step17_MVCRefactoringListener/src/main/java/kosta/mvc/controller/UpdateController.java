package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UpdateController ȣ��");
		// serviceȣ��-->dao �����Ϸ� ������ �̵�
		request.setAttribute("message", "������ �Ϸ�Ǿ����ϴ�");
		
		return new ModelAndView("updateResult.jsp"); // �������� �ٷ� �����ؼ� �����غ�
	}
}
