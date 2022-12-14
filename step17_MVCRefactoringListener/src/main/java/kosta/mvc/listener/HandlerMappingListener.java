package kosta.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kosta.mvc.controller.Controller;

/**
 * 서버가 시작될때 각 Controller의 구현객체를미리 생성해서 Map에 저장한 후 
 * ServletContext영역에 map을 저장한다.
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

 
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // 생성해야하는 객체들의정보를 가지고 있는 ~.properties 파일을 로딩
    	ResourceBundle rb= //actionMapping.properties
    			ResourceBundle.getBundle("kosta/mvc/listener/actionMapping");
    	/*
    	 * String의 문자열을 Controller라는 객체로 생성해야한다. 
    	 * :Class<?>는 어떤 객체가 가지고 있는 필드, 생성자, 메소드의 정보를 동적으로 가져올 수 있도록 
    	 * 도와주는 객체이다. - reflection개념
    	 * 
    	 * :reflection개념은 동적으로 즉, 실행도중에 필요한 객체를 적절하게 생성하고 그 객체가 가지고
    	 * 있는 생성자나 메소드를 동적으로 호출할 수 있도록 도와주는 개념을 Reflection이라 한다.
    	 * 자바에서 이러한 개념을 적용해 놓은 API가 Class<?>이다.
    	 */
	    try {
	    	Map<String, Controller> map=new HashMap<String, Controller>();
	    	for(String key:rb.keySet()) {
	    		String value=rb.getString(key);
	    		
	    		Class<?> className=Class.forName(value);
	    		Controller con=(Controller)className.getDeclaredConstructor().newInstance();
	    		
	    		map.put(key, con);
	    		
	    		System.out.println(key+"="+con);
	    	}//for문끝
	    	
	    	//현재 프로젝트의 모든 영역에서 map을 사용할 수 있도록 ServletContext영역에 저장한다.
	    	ServletContext application=sce.getServletContext();
	    	application.setAttribute("map", map);
	    	application.setAttribute("path", application.getContextPath()); //${path}
	    	
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
    }//contextInitialized 끝
	
}
