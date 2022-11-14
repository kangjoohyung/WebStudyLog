package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggest")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private String [] words= {
	   "java Programming","Java ������","JAVA��","�����α׷���","Ajax��" ,
	   "�� �����Ͱ���","�� ����� Project","Javascript��","JQuery��",
	   "jQuery�� Ajax","Jsp�� ��","Spring�̶�","Spring�� AOP","Spring DI����",
	   "Security��","Web�� ���","WEB�̶�"
	};
	
	/**
	 * �μ��� ���޵� �ܾ�� �����ϴ� �ܾ ã�Ƽ� List�� �������� �����ϴ� �޼ҵ�
	 * */
	public List<String> search(String keyWord){
		List<String> list =new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}//search��
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		
		//javascript�� �˼� �ִ� �������������� ��ȯ!!!!- text, xml, html, json
		//1. text���·� ���� : ����|�ܾ�,�ܾ�,�ܾ�
		
		String str= list.size()+"|";
		
		for(int i=0; i < list.size() ; i++) {
			if(list.size()==(i+1))
			   str+=list.get(i);
			else
				str+=list.get(i)+",";	
		}
		
		
		//front������ ����(����������)
		PrintWriter out = response.getWriter();
		out.println(str);
		
	}

}






