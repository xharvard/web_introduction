package com.xharvard.learning.note04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/search.view")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通过url重写 实现分页效果

		response.setContentType(Constant.CONTENT_TYPE);

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>搜索结果</title>");
		out.println("</head>");
		out.println("<body>");

		String start = request.getParameter("start");
		if (start == null) {
			start = "1";
		}

		int count = Integer.parseInt(start);
		// 假定每页显示10条
		int begin = 10 * count - 9;
		int end = 10 * count;

		out.println("第 " + begin + " 到 " + end + " 搜索结果<br>");
		out.println("<ul>");

		for (int i = 1; i <= 10; i++) {
			out.println("<li>");
			out.println("搜索结果" + i);
			out.println("</li>");
		}

		for (int j = 1; j < 10; j++) {

			if (j == count) {
				out.println(j);
				continue;
			}

			out.println("<a href='search.view?start=" + j + "'>" + j + "</a>");
		}

		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
