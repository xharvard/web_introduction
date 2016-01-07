package com.xharvard.learning.note04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login-cookie.do")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CookieLogin() {
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
		String user = request.getParameter("user");
		String passwd = request.getParameter("passwd");

		if ("xhh".equals(user) && "123456".equals(passwd)) {
			String login = request.getParameter("login");
			if ("auto".equals(login)) {
				Cookie cookie = new Cookie("xhh", "123456");
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
			}
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("view-cookie.do").forward(request, response);
		}else{
			response.sendRedirect("html/note04/login.html");
		}

	}

}
