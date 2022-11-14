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
        System.out.println("UserAccessCounterListener 생성자");
    }

	/**
     * 세션이 시작될때 count증가시키기
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         AtomicInteger at=(AtomicInteger)application.getAttribute("count");
         int nowCount=at.incrementAndGet();
         System.out.println("증가한후(현재 접속자수)="+nowCount+"명");
    }

	/**
     * 세션이 종료될때 count 감소
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	AtomicInteger at=(AtomicInteger)application.getAttribute("count");
        int nowCount=at.decrementAndGet();
        System.out.println("감소한후(현재 접속자수)="+nowCount+"명");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * 서버가 시작될때
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         application=sce.getServletContext();
         application.setAttribute("count", new AtomicInteger());//뷰에서 ${applicationScope.count}로 사용
    }
	
}
