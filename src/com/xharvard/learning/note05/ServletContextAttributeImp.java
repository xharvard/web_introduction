package com.xharvard.learning.note05;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextAttributeImp implements ServletContextAttributeListener {

    public ServletContextAttributeImp() {
    }

    public void attributeAdded(ServletContextAttributeEvent sce)  {
    	ServletContext context = sce.getServletContext();
    	Enumeration<String> attrs = context.getAttributeNames();
    	while(attrs.hasMoreElements()){
    		System.out.println(attrs.nextElement() + "属性追加了");
    	}
    	
    }

    public void attributeRemoved(ServletContextAttributeEvent sce)  { 
    }

    public void attributeReplaced(ServletContextAttributeEvent sce)  { 
    }
	
}
