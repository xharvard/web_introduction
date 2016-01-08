package com.xharvard.learning.note05.requestwrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;

public class EscapeWrapper extends HttpServletRequestWrapper {

	public EscapeWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		
		// 取得请求参数，通过StringEscapeUtils将<,>等转换成&lt;,&gt;等实体表示
		String value = getRequest().getParameter(name);
		return StringEscapeUtils.escapeHtml4(value);
	}

}
