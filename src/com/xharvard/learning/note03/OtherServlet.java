package com.xharvard.learning.note03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other.view")
public class OtherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OtherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		pw.println("other servlet do ...");
		pw.println("<br>");
		
		// 被包含的servlet里不能关闭流
		// pw.close();
	}

}
