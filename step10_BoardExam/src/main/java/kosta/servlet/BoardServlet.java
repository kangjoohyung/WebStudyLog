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
 * ��������
 * 
<servlet>
	<servlet-name>board</servlet-name>
	<servlet-class>kosta.servlet.BoardServlet</servlet-class>
	<param-name></param-name>
	<param-value>�����α׷���</param-value>
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
				@WebInitParam(name = "subject", value = "�����α׷���"), 
				@WebInitParam(name = "content", value = "�ű��ϰ� f")
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
        System.out.println("BoardServlet ������");
    }
    /**
     * �Խù� 3���ʱ�ȭ�ؼ�ServletContext������ ����
     */
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		boardList.add(new BoardDTO(10, super.getInitParameter("subject"),super.getInitParameter("content")));
		boardList.add(new BoardDTO(20, "Sp", "dd"));
		boardList.add(new BoardDTO(30, "jQuery", "����"));
		
		ServletContext application=super.getServletContext();
		application.setAttribute("boardList", boardList);//�信�� ${applicationScope.boardList } ���
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post������� ���۵Ǵ� �ѱ� ���ڵ�
		request.setCharacterEncoding("UTF-8");
		
		//�Ѿ���� �� 3���� �޾Ƽ� BoradDTO�� ����� list�� �߰��Ѵ�.
		String no=request.getParameter("no");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		boardList.add(new BoardDTO(Integer.parseInt(no),subject,content));
		
		//�̵�
		response.sendRedirect("center.jsp");
	}

}
