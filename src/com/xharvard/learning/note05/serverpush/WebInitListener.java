package com.xharvard.learning.note05.serverpush;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebInitListener implements ServletContextListener {
	private List<AsyncContext> asyncs = new ArrayList<AsyncContext>();

	public WebInitListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("asyncs", asyncs);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep((int) (Math.random() * 10000));
						double num = Math.random() * 10;

						synchronized (asyncs) {
							for (AsyncContext async : asyncs) {
								async.getResponse().getWriter().println(num);
								async.complete();
							}
							asyncs.clear();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

}
