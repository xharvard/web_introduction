<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, java.util.Date"%>
<%@ page errorPage="error.jsp" %>

<html>
<head>
    <title>JSP编译指令</title>
</head>

<body>
<%@ include file="header.html"%>

<h3>3个编译指令</h3>
<ol>page</ol>
<ol>include</ol>
<ol>taglib</ol>


<%
ArrayList<String> arrayList = new ArrayList<>();
new Date();

//模拟异常，如果设置了page的errorPage属性，则会跳转到指定页面，否则页面显示异常信息
//    int i = 5/0;
%>

<%@ include file="footer.jsp"%>

</body>
</html>
