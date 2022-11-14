package ex1012.Listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TimerRequestListener
 *
 */
@WebListener
public class TimerRequestListener implements ServletRequestListener {
	long start, end;
	
    public TimerRequestListener() {
        System.out.println("TimerRequestListener 생성자");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("TimerRequestListener requestDestroyed");
        end=System.currentTimeMillis();
        System.out.println("총 소요 ms : "+(end-start)+"ms");
    }

   
    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("TimerRequestListener requestInitialized");
        start=System.currentTimeMillis();
    }
	
}
