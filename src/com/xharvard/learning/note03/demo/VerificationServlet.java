package com.xharvard.learning.note03.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成动态验证码图片
 * 
 */
@WebServlet("/verification")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CONTENT_TYPE = "image/jpeg";

	public VerificationServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
