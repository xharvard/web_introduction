package com.xharvard.learning.note03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(location = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\upload2")
@WebServlet("/upload3.do")
public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet3() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		for (Part part : request.getParts()) {
			// 上传按钮也会成为part对象，所以要排除掉
			if (part.getName().startsWith("file")) {
				String fileName = getFileName(part);
				part.write(fileName);
			}
		}
	}

	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
		String[] fileArray = fileName.split("\\\\");

		return fileArray[fileArray.length - 1];
	}

}
