package com.xharvard.learning.note05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet(name = "ServletConfigDemo", urlPatterns = "/servlet.demo", 
		initParams = {
			@WebInitParam(name = "SUCCESS", value = "success.view"),
			@WebInitParam(name = "ERROR", value = "error.view") })
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String SUCCESS;
	private String ERROR;

	public ServletConfigDemo() {
		super();
	}

	public void init() throws ServletException {
		SUCCESS = getServletConfig().getInitParameter("SUCCESS");
		ERROR = getServletConfig().getInitParameter("ERROR");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>ServletConfig 配置显示</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("SUCCESS: " + SUCCESS);
		out.println("<br>");
		out.println("ERROR: " + ERROR);

		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
