package com.xharvard.learning.note02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/*")
public class PathServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PathServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Servlet Pattern</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("requestURI: " + req.getRequestURI() + "<br/>");
		pw.println("contextPath: " + req.getContextPath() + "<br/>");
		pw.println("servletPath: " + req.getServletPath() + "<br/>");
		pw.println("pathInfo: " + req.getPathInfo() + "<br/>");
		pw.println("</body>");
		pw.println("</html>");
	}

}
