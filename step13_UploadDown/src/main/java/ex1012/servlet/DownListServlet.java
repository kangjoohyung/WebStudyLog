package ex1012.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownListServlet
 */
@WebServlet("/downList")
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//save������ �ִ� ������ ������ �����ͼ� ������ �� �������� �̵��Ѵ�.
		//service�� �޼ҵ� �߰� : ��� ȣ��, �����б�, if������ list-�迭 ����, request ��
		String saveDir=request.getServletContext().getRealPath("/save"); //��� ��������
		File file=new File(saveDir); //�����б�
		if(file.exists()) {//�����Ѵٸ�
			String fileNames[]=file.list();
			request.setAttribute("fileNames", fileNames); //�信�� ${fileNames}�� ���
		}
		//�̵�
		request.getRequestDispatcher("downList.jsp").forward(request, response);
		
	}

}
