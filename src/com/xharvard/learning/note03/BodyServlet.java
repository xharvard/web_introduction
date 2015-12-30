package com.xharvard.learning.note03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/body.view")
public class BodyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BodyServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(Constant.CONTENT_TYPE);
		String body = readBody(request);

		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>getBody Servlet</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println(body);
		pw.println("解码后输出：<br>");
		pw.println(URLDecoder.decode(body, "UTF-8"));
		pw.println("</body>");
		pw.println("</html>");
	}

	private String readBody(HttpServletRequest request) {
		String requestBody = "";

		try {
			BufferedReader reader = request.getReader();
			String input = null;

			while ((input = reader.readLine()) != null) {
				requestBody = requestBody + input + "<br>";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return requestBody;
	}

}
