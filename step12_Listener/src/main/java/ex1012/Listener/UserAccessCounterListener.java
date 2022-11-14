package ex1012.Listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class UserAccessCounterListener
 *
 */
@WebListener
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {
	private ServletContext application;
	
    public UserAccessCounterListener() {
        System.out.println("UserAccessCounterListener ������");
    }

	/**
     * ������ ���۵ɶ� count������Ű��
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         AtomicInteger at=(AtomicInteger)application.getAttribute("count");
         int nowCount=at.incrementAndGet();
         System.out.println("��������(���� �����ڼ�)="+nowCount+"��");
    }

	/**
     * ������ ����ɶ� count ����
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	AtomicInteger at=(AtomicInteger)application.getAttribute("count");
        int nowCount=at.decrementAndGet();
        System.out.println("��������(���� �����ڼ�)="+nowCount+"��");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * ������ ���۵ɶ�
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         application=sce.getServletContext();
         application.setAttribute("count", new AtomicInteger());//�信�� ${applicationScope.count}�� ���
    }
	
}
