package com.xharvard.learning.note03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello.do")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HelloModel model = new HelloModel();

	public HelloController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String message = model.doHello(user);
		request.setAttribute("message", message);
		request.getRequestDispatcher("hello.go").forward(request, response);
	}

}
