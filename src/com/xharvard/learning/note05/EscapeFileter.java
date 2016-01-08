package com.xharvard.learning.note05;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "/send" })
public class EscapeFileter implements Filter {

	public EscapeFileter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 将收到的请求交给EscapeWrapper处理
		HttpServletRequest requestWrapper = new EscapeWrapper((HttpServletRequest) request);
		
		// 将处理后的请求request发给实际的servlet
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
