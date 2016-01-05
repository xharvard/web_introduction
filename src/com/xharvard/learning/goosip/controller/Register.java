package com.xharvard.learning.goosip.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/register.done")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String USERS = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\Gossip\\users";
	private final String SUCCESS_VIEW = "success.view";
	private final String ERROR_VIEW = "error.view";

	public Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType(Constant.CONTENT_TYPE);

		// 取得请求参数
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmedPasswd = request.getParameter("confirmedPasswd");

		List<String> errors = new ArrayList<String>();

		if (isInvalidEmail(email)) {
			errors.add("未填写邮件或邮件格式不正确");
		}

		if (isInvalidUser(username)) {
			errors.add("用户名称为空或已存在");
		}

		if (isInvalidPassword(password, confirmedPasswd)) {
			errors.add("请确认密码格式正确，并再次确认密码");
		}

		String resultPage = ERROR_VIEW;
		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
		} else {
			resultPage = SUCCESS_VIEW;
			createUserData(email, username, password);
		}
		
		// 跳转到显示层
		request.getRequestDispatcher(resultPage).forward(request, response);

	}

	/**
	 * 验证email有效性
	 * 
	 * @param email
	 * @return
	 */
	private boolean isInvalidEmail(String email) {
		String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$";
		return email == null || !email.matches(regex);
	}

	/**
	 * 验证用户是否存在
	 * 
	 * @param username
	 * @return
	 */
	private boolean isInvalidUser(String username) {
		for (String file : new File(USERS).list()) {
			if (file.equals(username)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 验证密码
	 * 
	 * @param password
	 * @param confirmedPasswd
	 * @return
	 */
	private boolean isInvalidPassword(String password, String confirmedPasswd) {
		return password == null || password.length() < 6 || password.length() > 16 || !password.equals(confirmedPasswd);
	}

	/**
	 * 创建用户
	 * 
	 * @param email
	 * @param username
	 * @param password
	 * @throws IOException
	 */
	private void createUserData(String email, String username, String password) throws IOException {
		File userHome = new File(USERS + "/" + username);
		userHome.mkdir();

		BufferedWriter writer = new BufferedWriter(new FileWriter(userHome + "/profile"));
		writer.write(email + "\t" + password);
		writer.close();
	}

}
