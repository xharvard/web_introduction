package com.xharvard.learning.note02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/ip_demo")
public class IpDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IpDemoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter pw = response.getWriter();
		String ip = request.getRemoteAddr();
		String time = new Date().toString();
		String queryStr = request.getQueryString();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>获得用户信息</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>用户IP： " + ip + "</p><br/>");
		pw.println("<p>用户访问时间: " + time +"</p><br/>");
		pw.println("<p>用户查询字符串: " + queryStr +"</p><br/>");
		pw.println("</body>");
		pw.println("</html>");

	}

}
