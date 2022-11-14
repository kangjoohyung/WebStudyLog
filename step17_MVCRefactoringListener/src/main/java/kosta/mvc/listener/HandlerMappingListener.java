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
 * ������ ���۵ɶ� �� Controller�� ������ü���̸� �����ؼ� Map�� ������ �� 
 * ServletContext������ map�� �����Ѵ�.
 */
@WebListener
public class HandlerMappingListener implements ServletContextListener {

 
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // �����ؾ��ϴ� ��ü���������� ������ �ִ� ~.properties ������ �ε�
    	ResourceBundle rb= //actionMapping.properties
    			ResourceBundle.getBundle("kosta/mvc/listener/actionMapping");
    	/*
    	 * String�� ���ڿ��� Controller��� ��ü�� �����ؾ��Ѵ�. 
    	 * :Class<?>�� � ��ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� ������ �� �ֵ��� 
    	 * �����ִ� ��ü�̴�. - reflection����
    	 * 
    	 * :reflection������ �������� ��, ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������
    	 * �ִ� �����ڳ� �޼ҵ带 �������� ȣ���� �� �ֵ��� �����ִ� ������ Reflection�̶� �Ѵ�.
    	 * �ڹٿ��� �̷��� ������ ������ ���� API�� Class<?>�̴�.
    	 */
	    try {
	    	Map<String, Controller> map=new HashMap<String, Controller>();
	    	for(String key:rb.keySet()) {
	    		String value=rb.getString(key);
	    		
	    		Class<?> className=Class.forName(value);
	    		Controller con=(Controller)className.getDeclaredConstructor().newInstance();
	    		
	    		map.put(key, con);
	    		
	    		System.out.println(key+"="+con);
	    	}//for����
	    	
	    	//���� ������Ʈ�� ��� �������� map�� ����� �� �ֵ��� ServletContext������ �����Ѵ�.
	    	ServletContext application=sce.getServletContext();
	    	application.setAttribute("map", map);
	    	application.setAttribute("path", application.getContextPath()); //${path}
	    	
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
    }//contextInitialized ��
	
}
