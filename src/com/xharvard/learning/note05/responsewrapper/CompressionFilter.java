package com.xharvard.learning.note05.responsewrapper;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/gzip")
public class CompressionFilter implements Filter {

	public CompressionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String encoding = req.getHeader("accept-encoding");
		if ((encoding != null) && encoding.indexOf("gzip") > -1) {
			CompressionWrapper responseWrapper = new CompressionWrapper(resp);
			responseWrapper.setHeader("content-encoding", "gzip");
			chain.doFilter(request, responseWrapper);
			GZIPOutputStream gzipOutputStream = responseWrapper.getGZipOutputStream();
			if (gzipOutputStream != null) {
				gzipOutputStream.finish();
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
