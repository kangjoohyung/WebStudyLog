package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;
import kosta.dto.Member;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="error.jsp";
		
		//넘어오는 id를 받기
		String id = request.getParameter("id");
		MemberDAO dao = new MemberDAOImpl();
		Member member = dao.selectById(id);
		
		if(member==null) {
			request.setAttribute("errMsg", id+"에 해당하는 정보가 없습니다.");
		}else {
			request.setAttribute("member", member);//read.jsp에서 ${member.속성}
			url="read.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}//serviceEnd

}










