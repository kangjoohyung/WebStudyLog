package kosta.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.MemberDAO;
import kosta.dao.MemberDAOImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		MemberDAO dao=new MemberDAOImpl();
		if(dao.delete(id)==0) {
			//삭제안됨 -> 메세지 송출, 에러페이지로 넘어감
			request.setAttribute("errMsg", id+"정보를 삭제할 수 없습니다");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}else {
			//삭제됨 -> 다시 검색하러
			response.sendRedirect("selectAll");//삭제되어 정보갱신겸 서블릿 response로
		}
	}//service끝

}
