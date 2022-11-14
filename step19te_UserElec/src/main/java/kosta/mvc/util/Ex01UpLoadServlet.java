package kosta.mvc.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpLoadServlet
 */
@WebServlet("/ex221023Ex01UpLoad")
public class Ex01UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex01UpLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �Ѿ���� �� 3���� �ޱ� -> ������ ����.MultipartRequest �ʿ�
		/*String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String file=request.getParameter("file");*/
		
		//������ enctype="multipart/form-data" ������ ���� request�� ���� �� ����.
		String saveDir=request.getServletContext().getRealPath("/save"); //������
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";//���ڵ������̸�
		
		
		MultipartRequest m=new MultipartRequest
				(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name=m.getParameter("name");
		String subject=m.getParameter("subject");
		String file=m.getParameter("file");
		
		String fileSystemName=m.getFilesystemName("file");//<input type="file" name="file" �� ���
		String originalName=m.getOriginalFileName("file");
		
		//÷�ε� ������ �뷮
		long fileSize=m.getFile("file").length();
		
		//���
		System.out.println("name="+name);
		System.out.println("subject="+subject);
		System.out.println("file="+file);
		
		System.out.println("fileSystemName="+fileSystemName);
		System.out.println("originalName="+originalName);
		System.out.println("fileSize="+fileSize);
		
		//scope������ ����
		request.setAttribute("name", name); //�信�� ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("originalName",originalName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);
		
		//����������� �̵�-�信�� ����� ������ �����ؼ� ����
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
	}

}
