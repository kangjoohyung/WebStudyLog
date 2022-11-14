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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//변수 선언
		String url="error.jsp";
		String errMsg="등록되지 않았습니다";//에러메세지
		boolean isRedirect=false; //true이면 redirect방식, false이면 forward방식으로 할 예정
		
		
		// 입력해서 넘어오는 값들을 받기
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String age=request.getParameter("age"); //있는지 중복체크후에 숫자변환
		String addr=request.getParameter("addr");
		String phone=request.getParameter("phone");
		//유효성 체크-공백오류
		if(id==null||id.equals("")||pwd==null||pwd.equals("")||name==null||
				name.equals("")||age==""||age.equals("")||addr==null||age.equals("")||
				phone==null||phone.equals("")) {
			//if로 들어온다면 공백 오류가 있다.
			errMsg="입력값이 충분하지 않습니다. \\n다시 확인해주세요."; // \n 만쓰면 script에러남
		}else {
			//중복체크
			MemberDAO dao=new MemberDAOImpl();
			if(dao.duplicateCheckById(id)) {
				errMsg=id+"는 이미 사용중입니다";
			}else {
				//등록하기
				Member member=new Member(id, pwd, name, Integer.parseInt(age), phone, addr, null);
				if(dao.insert(member)>0) {//등록 성공했을때
					url="selectAll";//서블릿
					isRedirect=true; //초기값false에서 성공시 true로 변경
				}//if끝 - 등록 성공했을때 전송관련
			}
		}//유효성-공백,중복 체크 끝
		
		
		//모든것이 성공하면 selectAll 서블릿으로 이동 - redirect방식 (scope저장 안하니까 redirect)
		//오류가 있으면 오류메세지를 scope에 저장하고 error.jsp 이동 - forward방식
		if(isRedirect) { //성공시 redirect전송
			response.sendRedirect(url);
		}else { //실패시(기본 초기값) forward전송
			request.setAttribute("errMsg",errMsg);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
