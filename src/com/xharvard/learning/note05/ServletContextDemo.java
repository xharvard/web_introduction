package com.xharvard.learning.note05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet(name = "ServletContextDemo", urlPatterns = "/context.demo", initParams = {
		@WebInitParam(name = "IMAGE_DIR", value = "/images") })
public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String IMAGE_DIR;

	public ServletContextDemo() {
		super();
	}

	public void init() throws ServletException {
		IMAGE_DIR = getServletConfig().getInitParameter("IMAGE_DIR");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>ServletContext 用法</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<P>getServletContext().getResourcePaths()取得目录下的所有文件</p>");
		out.println("<P>getServletContext().getResourceAsStream()取得文件的内容（路径以/开头，表示应用程序根目录，如：/WEB-INF/resources）</p>");

		for (String imageDir : getServletContext().getResourcePaths(IMAGE_DIR)) {
			imageDir = imageDir.replaceFirst("/", "");
			out.println("<img src='" + imageDir + "'>");
			out.println("<br>");
		}

		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
