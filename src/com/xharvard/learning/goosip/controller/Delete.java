package com.xharvard.learning.goosip.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete.done")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USERS = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\Gossip\\users";
	private final String LOGIN_VIEW = "html/gossip/index.html";
	private final String SUCCESS_VIEW = "member.view";

	public Delete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 判断用户是否登录
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect(LOGIN_VIEW);
			return;
		}

		String username = (String) request.getSession().getAttribute("login");
		String message = request.getParameter("message");

		File file = new File(USERS + "/" + username + "/" + message + ".txt");
		if (file.exists()) {
			file.delete();
		}

		response.sendRedirect(SUCCESS_VIEW);
	}

}
