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
 * �α��� ���� üũ�ϴ�(Session) ����
 * elec ���ٿ��� ����
 * ������(destroy)�� �ʿ����
 */
@WebFilter("/front")
public class SessionCheckFilter implements Filter {

	public void destroy() {
		// �����Ҷ� -> ���� �Ұž���
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ����ó�� -> �������� üũ�Ѵ�.
		// elec�� �ɷ�����
		String key=request.getParameter("key");
		if(key==null||key.equals("elec")) {
			//������ ����ڸ� �Ҽ��ְ�
			HttpServletRequest req=(HttpServletRequest)request; //������ ���������� �ٿ�ĳ����(�ٷ� ���θ�)
			HttpSession session=req.getSession();
			if(session.getAttribute("loginUser")==null) { // ���� �������� ����
				req.setAttribute("errorMsg", "�α����ϰ� �̿����ּ���");
				req.getRequestDispatcher("error/error.jsp").forward(request, response);
				return; // �Լ��� ���������� -> �� �־����
			}
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// 
	}

}
