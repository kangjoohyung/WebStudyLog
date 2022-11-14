package kosta.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.dto.BoardDTO;

/**
 * Servlet implementation class BoardServlet
 */
/**
 * 같은내용
 * 
<servlet>
	<servlet-name>board</servlet-name>
	<servlet-class>kosta.servlet.BoardServlet</servlet-class>
	<param-name></param-name>
	<param-value>웹프로그래밍</param-value>
</servlet>

<servlet-mapping>
	<servlet-name>board</servlet-name>
	<url-pattern>/board</url-pattern>
</servlet-mapping>

 * @author Buck
 *
 */
@WebServlet(
		urlPatterns = { "/board" }, 
		initParams = { 
				@WebInitParam(name = "subject", value = "웹프로그래밍"), 
				@WebInitParam(name = "content", value = "신기하고 f")
		}, loadOnStartup=1)
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BoardDTO> boardList=new ArrayList<BoardDTO>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("BoardServlet 생성자");
    }
    /**
     * 게시물 3개초기화해서ServletContext영역에 저장
     */
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		boardList.add(new BoardDTO(10, super.getInitParameter("subject"),super.getInitParameter("content")));
		boardList.add(new BoardDTO(20, "Sp", "dd"));
		boardList.add(new BoardDTO(30, "jQuery", "ㅇㅇ"));
		
		ServletContext application=super.getServletContext();
		application.setAttribute("boardList", boardList);//뷰에서 ${applicationScope.boardList } 사용
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 전송되는 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//넘어오는 값 3개를 받아서 BoradDTO로 만들고 list에 추가한다.
		String no=request.getParameter("no");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		boardList.add(new BoardDTO(Integer.parseInt(no),subject,content));
		
		//이동
		response.sendRedirect("center.jsp");
	}

}
