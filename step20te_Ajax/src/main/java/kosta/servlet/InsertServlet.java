package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dao.CustomerDAO;
import kosta.dao.CustomerDAOImpl;
import kosta.dto.CustomerDTO;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class SelectAllServlet
 */
@WebServlet("/insertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String add = request.getParameter("addr");
		
		CustomerDTO dto =
				new CustomerDTO(id, name, Integer.parseInt(age), tel, add);
		
		CustomerDAO dao = new CustomerDAOImpl();
		int result = dao.insert(dto);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}














