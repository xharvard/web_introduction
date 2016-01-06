package com.xharvard.learning.note04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xharvard.learning.constant.Constant;

@WebServlet("/questionnaire")
public class QuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionnaireServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * 处理逻辑 使用隐藏域来管理会话
	 * 
	 * @param request @param response @throws
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType(Constant.CONTENT_TYPE);
		
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>问卷调查</title>");
		pw.println("</head>");
		pw.println("<body>");
		
		String page = request.getParameter("page");
		pw.println("<form action='/web_introduction/questionnaire' method='post'>");
		
		// 第一页
		if(page == null){
			pw.println("问题一： <input type='text' name='p1q1'><br>");
			pw.println("问题二： <input type='text' name='p1q2'><br>");
			pw.println("<input type='submit' name='page' value='下一页'>");
		// 第二页
		}else if("下一页".equals(page)){
			String p1q1 = request.getParameter("p1q1");
			String p1q2 = request.getParameter("p1q2");
			
			pw.println("问题三： <input type='text' name='p2q1'><br>");
			pw.println("<input type='submit' name='page' value='完成'>");
			pw.println("<input type='hidden' name='p1q1' value='"+p1q1+"'><br>");
			pw.println("<input type='hidden' name='p1q2' value='"+p1q2+"'><br>");
		// 最后提交
		}else if ("完成".equals(page)) {
			pw.println("问题一： " + request.getParameter("p1q1") + "<br>");
			pw.println("问题二： " + request.getParameter("p1q2") + "<br>");
			pw.println("问题三： " + request.getParameter("p2q1") + "<br>");
		}
		
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");		

	}

}
