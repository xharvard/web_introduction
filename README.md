# web_introduction
jsp servlet jdbc介绍

######servlet参考网站：
https://docs.oracle.com/javaee/7/JEETT.pdf <br>
https://docs.oracle.com/javaee/7/api/<br>
http://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html<br>

###JSP&Servlet学习笔记
######cap2:
* com.xharvard.learning.note02.HelloServlet ->  http://localhost:8080/web_introduction/hello.view?name=xhh(http://localhost:8080/web_introduction/hello?name=xhh)<br>
 web-app 3.1版本可以通过[metadata-complete="false"]设置是否扫描class文件中的注解。true:表示忽略，false:表示要扫描。

* com.xharvard.learning.note02.PathServlet -> http://localhost:8080/web_introduction/servlet/test
* com.xharvard.learning.note02.IpDemoServlet -> http://localhost:8080/web_introduction/ip_demo?name=xhh&password=123

######cap3:
* com.xharvard.learning.note03.HeaderServlet -> http://localhost:8080/web_introduction/header.view
* com.xharvard.learning.note03.EncodingServlet -> http://localhost:8080/web_introduction/html/note03/form-get.html
  http://localhost:8080/web_introduction/html/note03/form-post.html
