package com.xharvard.learning.goosip.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/member.view")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USERS = "E:\\xhh_work\\07_jsp\\workspace\\web_introduction\\Gossip\\users";
	private final String LOGIN_VIEW = "html/gossip/index.html";
	private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();
	private DateComparator comparator = new DateComparator();

	public Member() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断用户是否登录
		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect(LOGIN_VIEW);
		}

		String username = (String) request.getSession().getAttribute("login");

		response.setContentType(Constant.CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta content='text/html; charset=UTF-8' http-equiv='content-type'>");
		out.println("  <title>Gossip</title>");
		out.println("<link rel='stylesheet' href='css/gossip/member.css' type='text/css'>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class='leftPanel'>");
		out.println("<img src='images/bar.jpg' alt='图标' /><br><br>");
		out.println("<a href='/web_introduction/logout.done?username=" + username + "'>注销" + username + "</a>");
		out.println("</div>");

		out.println("<div>");
		out.println("<form method='post' action='/web_introduction/message.done'>");
		out.println("分享新鲜事...<br>");

		String blabla = request.getParameter("blabla");
		if (blabla == null) {
			blabla = "";
		} else {
			out.println("信息要140字以内<br>");
		}
		out.println("<textarea cols='60' rows='4' name='blabla'>" + blabla + "</textarea>");
		out.println("<br>");
		out.println("<button type='submit'>送出</button>");
		out.println("</form>");

		out.println(
				"<table style='text-align: left; width: 510px; height: 88px;' border='0' cellpadding='2' cellspacing='2'>");
		out.println("<thead>");
		out.println("<tr><th><hr></th></tr>");
		out.println("</thead>");
		out.println("<tbody>");

		Map<Date, String> messages = readMessage(username);
		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);

		for (Date date : messages.keySet()) {
			out.println("<tr><td style='vertical-align: top;'>");
			out.println(username + "<br>");
			out.println(messages.get(date) + "<br>");
			out.println(format.format(date)+"<br>");
			out.println("<a href='/web_introduction/delete.done?message=" + date.getTime() + "'>删除</a>");
			out.println("<hr></td></tr>");
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("<hr style='width: 100%; height: 1px; clear:both'>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	/**
	 * 从文件读取消息
	 * 
	 * @param username
	 * 			@return @throws IOException @throws
	 */
	private Map<Date, String> readMessage(String username) throws IOException {
		File border = new File(USERS + "/" + username);
		String[] txts = border.list(filenameFilter);

		Map<Date, String> messages = new TreeMap<Date, String>(comparator);

		for (String txt : txts) {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(USERS + "/" + username + "/" + txt), "UTF-8"));
			String text = null;
			StringBuilder builder = new StringBuilder();
			while ((text = reader.readLine()) != null) {
				builder.append(text);
			}

			Date date = new Date(Long.parseLong(txt.substring(0, txt.indexOf(".txt"))));
			messages.put(date, builder.toString());
			reader.close();
		}

		return messages;
	}

	/**
	 * 过滤 .txt文件
	 * 
	 */
	private class TxtFilenameFilter implements FilenameFilter {

		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".txt");
		}
	}

	/**
	 * TreeMap排序用，日期越近的排在前面
	 *
	 */
	private class DateComparator implements Comparator<Date> {

		@Override
		public int compare(Date o1, Date o2) {
			return -o1.compareTo(o2);
		}
	}
}
