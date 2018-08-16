<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<!-- HTML注释,里面可以包含java代码,而且浏览器里查看源代码可见。 当前时间：<%= new java.util.Date().toString()%> -->

<%-- JSP注释，浏览器里查看源代码看不到 --%>

JSP表达式输出：<%="我是JSP表达式"%>
<br>

<%!
    //全局变量
    String all_str = "我是全局变量";
%>

<%
    String str = "Hello World!";
    out.println(str);
    out.println(all_str);
%>

</body>
</html>
