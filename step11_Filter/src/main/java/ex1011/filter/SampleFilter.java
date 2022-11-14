package ex1011.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SampleFilter implements Filter{
	public SampleFilter() {
		System.out.println("SampleFilter ������");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���� ���� ó��");
		
		//���� Ÿ�ϴ�� ȣ��
		chain.doFilter(request, response); //���� ���� �Ǵ� ����, jsp�� ȣ���Ѵ�.
		System.out.println("���� ���� ó��");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}
}
