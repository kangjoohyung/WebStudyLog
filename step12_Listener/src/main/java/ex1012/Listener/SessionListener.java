package ex1012.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() {
        System.out.println("SessionListener ������");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionCreated");
    }
    
    /**
     * ������ ����ɶ� ȣ��
     * 1)session.invalidate();//���Ǹ���
     * 2)session timeout�Ǿ�����(�⺻30��)
     * 
     * 3)�������� x�� Ŭ���������� ȣ����� �ʴ´�.
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionDestroyed");
    }
	
}
