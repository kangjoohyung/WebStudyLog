package kosta.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.mvc.dto.Electronics;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.service.ElectronicsService;
import kosta.mvc.service.ElectronicsServiceImpl;
/**
 * key=user
 *
 */
public class ElectronicsController implements Controller {
	
	private ElectronicsService elecService=new ElectronicsServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 전체검색 (db연동)
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse reponse)
			throws Exception {
		//db를 리스트로 호출
		List<Electronics> list=elecService.selectAll();
		//전송하기위해 담기
		request.setAttribute("list", list);
		
		//index.jsp이동 - forward
		return new ModelAndView("elect/list.jsp");//기본 false
	}
	
	/**
	 * 등록하기
	 */
}
