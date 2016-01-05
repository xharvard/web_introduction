package com.xharvard.learning.goosip.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/error.view")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Error() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8'" + "http-equiv='content-type'>");
		out.println("  <title>新增会员失败</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>新增会员失败</h1>");
		out.println("<ul style='color:red;'>");
		
		@SuppressWarnings("unchecked")
		List<String> errors = (List<String>) request.getAttribute("errors");
		for (String error : errors) {
			out.println("<li>" + error + "</li>");
		}
		
		out.println("</ul>");
		out.println("<a href='html/gossip/register.html'>返回注册页面</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
