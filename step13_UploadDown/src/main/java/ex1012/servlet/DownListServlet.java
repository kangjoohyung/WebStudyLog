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
		//save폴더에 있는 파일의 정보를 가져와서 저장한 후 뷰쪽으로 이동한다.
		//service에 메소드 추가 : 경로 호출, 파일읽기, if문으로 list-배열 생성, request 셋
		String saveDir=request.getServletContext().getRealPath("/save"); //경로 가져오기
		File file=new File(saveDir); //파일읽기
		if(file.exists()) {//존재한다면
			String fileNames[]=file.list();
			request.setAttribute("fileNames", fileNames); //뷰에서 ${fileNames}로 사용
		}
		//이동
		request.getRequestDispatcher("downList.jsp").forward(request, response);
		
	}

}
