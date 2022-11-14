package kosta.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 로그인 유무 체크하는(Session) 필터
 * elec 접근에만 지정
 * 끝날때(destroy)는 필요없음
 */
@WebFilter("/front")
public class SessionCheckFilter implements Filter {

	public void destroy() {
		// 종료할때 -> 딱히 할거없음
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사전처리 -> 인증여부 체크한다.
		// elec만 걸러낸다
		String key=request.getParameter("key");
		if(key==null||key.equals("elec")) {
			//인증된 사용자만 할수있게
			HttpServletRequest req=(HttpServletRequest)request; //세션을 얻어오기위해 다운캐스팅(바로 못부름)
			HttpSession session=req.getSession();
			if(session.getAttribute("loginUser")==null) { // 에러 페이지로 연결
				req.setAttribute("errorMsg", "로그인하고 이용해주세요");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return; // 함수를 빠져나가라 -> 꼭 있어야함
			}
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// 
	}

}
