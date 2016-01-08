package com.xharvard.learning.note05;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextParameterReader implements ServletContextListener {

    public ContextParameterReader() {
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	// IMAGE在web.xml中设置（context-param）
    	String image = context.getInitParameter("IMAGE");
    	context.setAttribute("image", image);
    	System.out.println("容器启动的时候自动加载并运行,Servlet3.0之前必须在web.xml中配置");
    	System.out.println(image);
    }
	
}
