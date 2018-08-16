<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page buffer="10kb" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>

<h3>9个内置对象</h3>
<ol>out</ol>
<ol>request</ol>
<ol>response</ol>
<ol>session</ol>
<ol>application</ol>
<ol>config</ol>
<ol>page</ol>
<ol>exception</ol>
<ol>pageContext</ol>

<%
    //out对象
    out.println("test"); //页面不会换行，源码会换行
    out.println("<br/>");
    out.println("当前缓冲区大小:" + out.getBufferSize()); //可以通过pege指令修改
    out.println("<br/>");
    out.println("当前缓冲区剩余字节数目:" + out.getRemaining());

    //response对象
    response.setHeader("Cache-Control", "no-cache");
//    response.sendRedirect("http://www.baidu.com");
    Cookie cookie = new Cookie("key", "value");
    response.addCookie(cookie);

    session.setMaxInactiveInterval(600);

    application.getServerInfo();

    config.getInitParameter("param"); //从web.xml中读取配置信息
    out.println("<br/>");

    out.println("page对象字符串" + page.toString());

    //exception需结合page指令的 isErrorPage=true使用

    out.println("<br/>");
    pageContext.getOut().println("pageContext打印方法");
%>

<br/>
<br/>
<%-- request对象 --%>
请求方法名: <%=request.getMethod()%> <br/>
请求的资源: <%=request.getRequestURI()%>

</body>
</html>
