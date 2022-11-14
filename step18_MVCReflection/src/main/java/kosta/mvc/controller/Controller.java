package kosta.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//메소드이름은 각자 정하기, 인수는 request, response
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)throws ServletException, IOException; 
}
