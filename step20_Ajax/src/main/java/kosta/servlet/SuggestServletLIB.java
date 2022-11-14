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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestLIB")
public class SuggestServletLIB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] words= { //������ db�����ؾ�������, ���Ƿ� �ܾ� �̰��� ����
			"java Programming","Java ������","JAVA��","�����α׷���","Ajax��",
			"�̵���","���ؿ�","������","������","��ȫ��","�� �����Ͱ���","�� ����� Project", 
			"JavaScript��", "Jsp�� ��", "Spring�̶�", "Spring�� AOP", "Spring DI����",
			"Security��","Web�� ���", "WEB�̶�", "������"
			};
	
	/**
	 * �μ��� ���޵� �ܾ�� �����ϴ� �ܾ ã�Ƽ� List�� ������ �� �����ϴ� �޼ҵ� 
	 */
	public List<String> search(String keyWord){
		List<String> list=new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}//if
		}//for
		return list;
	}//search ��
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //�ѱ� ���ڵ����� ������(ajax�� ��ȯ��)
		String keyWord=request.getParameter("keyWord"); // Ű����ޱ�
		List<String> list=this.search(keyWord);
		//������ ���� javaScript�� �� �� �ִ� ������ �������� ��ȯ�ؾ��Ѵ� : text, xml, html, json
		//2. json���·� ���� [{key:value, key:vlaue, ...}] or 
		//   listó�� Ű�� �������� [value, value, value...]
		//lib�� �߰��ؼ� �����ϴ� �޼ҵ带 �����Ѵ�. (��ܿ��� ���-��ġ : web-inf)
		JSONArray arr=JSONArray.fromObject(list); //��ȯ�ϴ� �޼ҵ�, list�ڸ��� map������ ��
		
		//front������ ����(����������)
		PrintWriter out=response.getWriter();
		out.println(arr);
	}

}
