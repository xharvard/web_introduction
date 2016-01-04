package com.xharvard.learning.note03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.go")
public class HelloGoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String htmlTemplate = 
			"<html>"
			+ "<head>"
			+ "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>"
			+ "<title>%s</title>"
			+ "</head>"
			+ "<body>"
			+ "<h1>%s</h1>"
			+ "</body>"
			+ "</html>";

	public HelloGoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String message = (String) request.getAttribute("message");
		String html = String.format(htmlTemplate, user, message);

		response.getWriter().println(html);
	}

}
