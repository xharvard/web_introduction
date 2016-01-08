package com.xharvard.learning.note05.serverpush;

import java.io.IOException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AsyncNumServlet", asyncSupported = true)
public class AsyncNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<AsyncContext> asyncs;

	public AsyncNumServlet() {
		super();
	}

	public void init() throws ServletException {
		asyncs = (List<AsyncContext>) getServletContext().getAttribute("asyncs");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AsyncContext ctx = request.startAsync();
		synchronized (asyncs) {
			asyncs.add(ctx);
		}
	}
}
