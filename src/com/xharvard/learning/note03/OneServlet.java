package com.xharvard.learning.note03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/one.view")
public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OneServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		pw.println("one servlet do start...");
		pw.println("<br>");
		
		// include other.view
		RequestDispatcher dispatcher = request.getRequestDispatcher("other.view");
		dispatcher.include(request, response);

		pw.println("one servlet do end...");
		pw.println("<br>");

		pw.close();
	}

}
