package com.xharvard.learning.goosip.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/member.view")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>会员登入成功</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>会员 " + request.getParameter("username") + " 你好</h1>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
