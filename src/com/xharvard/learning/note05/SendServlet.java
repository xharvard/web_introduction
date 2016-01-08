package com.xharvard.learning.note05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>输出消息</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<p>会屏蔽HTML标签的内容</p>");
		out.println(request.getParameter("message"));
		out.println("<br>");
		
		out.println("</body>");
		out.println("</html>");

		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
