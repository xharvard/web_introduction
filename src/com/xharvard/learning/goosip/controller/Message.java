package com.xharvard.learning.goosip.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message.done")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USERS = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\Gossip\\users";
	private final String SUCCESS_VIEW = "member.view";
	private final String ERROR_VIEW = "member.view";
	private final String LOGIN_VIEW = "html/gossip/index.html";

	public Message() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 判断用户是否登录
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect(LOGIN_VIEW);
		}

		request.setCharacterEncoding("UTF-8");
		String blabla = request.getParameter("blabla");
		if (blabla != null && blabla.length() != 0) {
			if (blabla.length() < 140) {
				String username = (String) request.getSession().getAttribute("login");
				addMessage(username, blabla);
				response.sendRedirect(SUCCESS_VIEW);
			} else {
				request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
			}
		} else {
			response.sendRedirect(ERROR_VIEW);
		}
	}

	/**
	 * 将输入的消息存入文件
	 * 
	 * @param username
	 * @param blabla
	 * @throws IOException
	 */
	private void addMessage(String username, String blabla) throws IOException {
		String file = USERS + "/" + username + "/" + new Date().getTime() + ".txt";
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
		writer.write(blabla);
		writer.close();
	}

}
