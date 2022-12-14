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
	   "java Programming","Java 잘하자","JAVA란","웹프로그래밍","Ajax란" ,
	   "웹 마스터과정","웹 기반의 Project","Javascript란","JQuery란",
	   "jQuery의 Ajax","Jsp는 뷰","Spring이란","Spring의 AOP","Spring DI개념",
	   "Security란","Web의 언어","WEB이란"
	};
	
	/**
	 * 인수로 전달된 단어로 시작하는 단어를 찾아서 List에 저장한후 리턴하는 메소드
	 * */
	public List<String> search(String keyWord){
		List<String> list =new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}//search끝
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String keyWord = request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		
		//javascript가 알수 있는 데이터형식으로 변환!!!!- text, xml, html, json
		//1. text형태로 전송 : 개수|단어,단어,단어
		
		String str= list.size()+"|";
		
		for(int i=0; i < list.size() ; i++) {
			if(list.size()==(i+1))
			   str+=list.get(i);
			else
				str+=list.get(i)+",";	
		}
		
		
		//front단으로 응답(데이터전송)
		PrintWriter out = response.getWriter();
		out.println(str);
		
	}

}






