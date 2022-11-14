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
 * �α� ���� : url, ip, �ҿ�ð� ��� �߰�
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
		//����ó��
		String ip=request.getRemoteAddr();//������ ip
		HttpServletRequest req=(HttpServletRequest)request;//url���ϱ��� ����ȣ��
		String url=req.getRequestURL().toString();//�����ϴ� url���ϱ�
		log.debug("ip="+ip+",url="+url);//���� ip, url ���
		
		long start=System.currentTimeMillis();//���۽ð� ���ϱ�
				
		chain.doFilter(request, response);//Ÿ�ٴ�� ȣ��
		//����ó��
		long end=System.currentTimeMillis();//���ð� ���ϱ�
		log.debug("�� �ҿ� ms:"+(end-start)+"ms");//���� �ð� ��-�������� �ҿ�ð� ���
	}

	public void init(FilterConfig fConfig) throws ServletException {
		log=LogFactory.getLog(getClass());
		System.out.println("log="+log);
	}

}
