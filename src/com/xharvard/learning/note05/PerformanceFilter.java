package com.xharvard.learning.note05;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="/PerformanceFilter",urlPatterns={"/*"},servletNames={""},
			initParams={
					@WebInitParam(name="param1",value="value1")
			},
			dispatcherTypes={
					DispatcherType.REQUEST,
					DispatcherType.INCLUDE
			}
		)
public class PerformanceFilter implements Filter {

	public PerformanceFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();

		System.out.println("执行时间： " + (end - begin));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String param1 = fConfig.getInitParameter("param1");
		System.out.println("param1的值： " + param1);
	}

}
