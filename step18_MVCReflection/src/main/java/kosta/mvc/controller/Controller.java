package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//�޼ҵ��̸��� ���� ���ϱ�, �μ��� request, response
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)throws ServletException, IOException; 
}
