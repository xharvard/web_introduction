package com.xharvard.learning.note03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/header.view")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HeaderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter pw = response.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hello Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>HeaderServlet at " + request.getContextPath() + "</h1>");
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			pw.println(name + ": " + request.getHeader(name) + "<br>");
		}
		pw.println("</body>");
		pw.println("</html>");
	}
}