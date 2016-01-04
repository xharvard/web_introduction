package com.xharvard.learning.note03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/pet")
public class PetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PetServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter pw = response.getWriter();

		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>感谢填写</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println(
				"联系人： <a href='mailto:" 
				+ request.getParameter("email") + "'>" 
				+ request.getParameter("user") + "</a>");
		pw.println("<br>喜爱的宠物类型：");
		pw.println("<ul>");
		for (String type : request.getParameterValues("type")) {
			pw.println("<li>" + type + "</li>");
		}
		pw.println("</ul>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

}
