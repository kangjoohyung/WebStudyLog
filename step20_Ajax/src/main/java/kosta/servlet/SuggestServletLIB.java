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
	
	private String[] words= { //원래는 db연동해야하지만, 임의로 단어 이곳에 생성
			"java Programming","Java 잘하자","JAVA란","웹프로그래밍","Ajax란",
			"이도윤","박해원","강희진","이혜진","임홍제","웹 마스터과정","웹 기반의 Project", 
			"JavaScript란", "Jsp는 뷰", "Spring이란", "Spring의 AOP", "Spring DI개념",
			"Security란","Web의 언어", "WEB이란", "강주형"
			};
	
	/**
	 * 인수로 전달된 단어로 시작하는 단어를 찾아서 List에 저장한 후 리턴하는 메소드 
	 */
	public List<String> search(String keyWord){
		List<String> list=new ArrayList<String>();
		for(String word : words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}//if
		}//for
		return list;
	}//search 끝
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //한글 인코딩으로 보내기(ajax는 변환됨)
		String keyWord=request.getParameter("keyWord"); // 키워드받기
		List<String> list=this.search(keyWord);
		//보내기 전에 javaScript가 알 수 있는 데이터 형식으로 변환해야한다 : text, xml, html, json
		//2. json형태로 전송 [{key:value, key:vlaue, ...}] or 
		//   list처럼 키가 없을때는 [value, value, value...]
		//lib를 추가해서 제공하는 메소드를 제공한다. (백단에서 사용-위치 : web-inf)
		JSONArray arr=JSONArray.fromObject(list); //변환하는 메소드, list자리에 map넣으면 됨
		
		//front단으로 응답(데이터전송)
		PrintWriter out=response.getWriter();
		out.println(arr);
	}

}
