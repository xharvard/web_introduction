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
	private final String LOGIN_VIEW = "html/gossip/index.html";

	public Member() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断用户是否登录
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect(LOGIN_VIEW);
		}

		String username = (String) request.getSession().getAttribute("login");

		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>Gossip</title>");
		out.println("<link rel='stylesheet' href='css/gossip/member.css' type='text/css'>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='leftPanel'>");
		out.println("<img src='images/bar.jpg' alt='图标' /><br><br>");
		out.println("<a href='/web_introduction/logout.done?username=" + username + "'>注销" + username + "</a>");
		out.println("</div>");

		out.println("<form method='post' action='/web_introduction/message.done'>");
		out.println("分享新鲜事...<br>");

		String blabla = request.getParameter("blabla");
		if (blabla == null) {
			blabla = "";
		} else {
			out.println("信息要140字以内<br>");
		}
		out.println("<textarea cols='60' rows='4' name='blabla'>" + blabla + "</textarea>");
		out.println("<br>");
		out.println("<button type='submit'>送出</button>");
		out.println("</form>");
		
		out.println("<table style='text-align: left; width: 510px; height: 88px;' border='0' cellpadding='2' cellspacing='2'>");
        out.println("<thead>");
        out.println("<tr><th><hr></th></tr>");
        out.println("</thead>");
        out.println("<tbody>");

        
        out.println("</tbody>");
        out.println("</table>");
		out.println("<hr style='width: 80%; height: 1px;'>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
}
