package ex1012.servlet;

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
@WebServlet("/UpLoad")
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어오는 값 3개를 받기 -> 받을수 없음.MultipartRequest 필요
		/*String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String file=request.getParameter("file");*/
		
		//폼에서 enctype="multipart/form-data" 설정된 경우는 request로 받을 수 없다.
		String saveDir=request.getServletContext().getRealPath("/save"); //저장경로
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";//인코딩파일이름
		
		
		MultipartRequest m=new MultipartRequest
				(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String name=m.getParameter("name");
		String subject=m.getParameter("subject");
		String file=m.getParameter("file");
		
		String fileSystemName=m.getFilesystemName("file");//<input type="file" name="file" 인 경우
		String originalName=m.getOriginalFileName("file");
		
		//첨부된 파일의 용량
		long fileSize=m.getFile("file").length();
		
		//출력
		System.out.println("name="+name);
		System.out.println("subject="+subject);
		System.out.println("file="+file);
		
		System.out.println("fileSystemName="+fileSystemName);
		System.out.println("originalName="+originalName);
		System.out.println("fileSize="+fileSize);
		
		//scope영역에 저장
		request.setAttribute("name", name); //뷰에서 ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("originalName",originalName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);
		
		//결과페이지로 이동-뷰에서 출력할 정보를 저장해서 간다
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
	}

}
