package ex1011.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 로그 필터 : url, ip, 소요시간 출력 추가
 */
@WebFilter("/*")
public class LogFilter implements Filter {
	private Log log;

    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리
		String ip=request.getRemoteAddr();//접속자 ip
		HttpServletRequest req=(HttpServletRequest)request;//url구하기전 서블릿호출
		String url=req.getRequestURL().toString();//접속하는 url구하기
		log.debug("ip="+ip+",url="+url);//구한 ip, url 기록
		
		long start=System.currentTimeMillis();//시작시간 구하기
				
		chain.doFilter(request, response);//타겟대상 호출
		//사후처리
		long end=System.currentTimeMillis();//끝시간 구하기
		log.debug("총 소요 ms:"+(end-start)+"ms");//구한 시간 끝-시작으로 소요시간 계산
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log=LogFactory.getLog(getClass());
		System.out.println("log="+log);
	}

}
