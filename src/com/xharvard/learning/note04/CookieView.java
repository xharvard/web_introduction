package com.xharvard.learning.note04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/view-cookie.do")
public class CookieView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENT_TYPE);

		if (request.getAttribute("user") == null) {
			response.sendRedirect("html/note04/login.html");
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet User</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + request.getAttribute("user") + "已登录</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
