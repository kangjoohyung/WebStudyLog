package kosta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao=new MemberDAOImpl(); //DAO로 넘기기위해 호출
		List<Member> list=dao.selectAll(); //List에 DTO담기
		
		//list를 scope영역에 저장
		request.setAttribute("memberList", list); //키,밸류 저장 -> 뷰에서 키 : ${memberList} 호출
		
		//memberSelect.jsp로 이동한다.
		request.getRequestDispatcher("memberSelect.jsp").forward(request, response);
	}

}
