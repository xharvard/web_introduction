package com.xharvard.learning.note02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Hello Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");

		if ("xhh".equals(username) && "123456".equals(password)) {
			pw.println("<p>登录成功。</p>");
			pw.println("<p>欢迎： " + username + "</p>");
		} else {
			pw.println("<p>登录失败。</p><br/>");
			pw.println("<a href='http://localhost:8080/web_introduction/html/note02/user_login.html'>跳转到登录页面</a><br/>");
		}

		pw.println("</body>");
		pw.println("</html>");

	}

}
