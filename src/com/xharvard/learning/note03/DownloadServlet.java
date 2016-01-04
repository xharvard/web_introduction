package com.xharvard.learning.note03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DownloadServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String passwd = request.getParameter("passwd");

		if ("123456".equals(passwd)) {
			response.setContentType(Constant.CONTENT_TYPE);
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/git.pdf");
			OutputStream out = response.getOutputStream();
			writeBytes(in, out);
		}
	}

	private void writeBytes(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int length = -1;

		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}

		in.close();
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
