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
* com.xharvard.learning.note03.BodyServlet -> http://localhost:8080/web_introduction/html/note03/form.html
* com.xharvard.learning.note03.UploadServlet -> http://localhost:8080/web_introduction/html/note03/upload.html
* com.xharvard.learning.note03.UploadServlet2 -> http://localhost:8080/web_introduction/html/note03/upload2.html
* com.xharvard.learning.note03.UploadServlet3 -> http://localhost:8080/web_introduction/html/note03/upload3.html
* com.xharvard.learning.note03.OneServlet -> http://localhost:8080/web_introduction/one.view
* com.xharvard.learning.note03.HelloController -> http://localhost:8080/web_introduction/hello.do?user=xhh
* com.xharvard.learning.note03.PetServlet -> http://localhost:8080/web_introduction/html/note03/form-response.html
* com.xharvard.learning.note03.DownloadServlet -> http://localhost:8080/web_introduction/download?passwd=123456
* com.xharvard.learning.goosip.controller.Login -> http://localhost:8080/web_introduction/html/gossip/index.html
* com.xharvard.learning.note03.demo.DrawImageServlet -> http://localhost:8080/web_introduction/draw-image
* com.xharvard.learning.note03.demo.VerificationServlet -> http://localhost:8080/web_introduction/html/note03/demo/verification.html

######cap4:
* com.xharvard.learning.note04.QuestionnaireServlet -> http://localhost:8080/web_introduction/questionnaire
* com.xharvard.learning.note04.CookieLogin -> http://localhost:8080/web_introduction/html/note04/login.html
* com.xharvard.learning.note04.CookieIndex -> http://localhost:8080/web_introduction/cookie-index
* com.xharvard.learning.note04.SearchServlet -> http://localhost:8080/web_introduction/search.view
* com.xharvard.learning.goosip.controller.Login -> http://localhost:8080/web_introduction/html/gossip/index.html

######cap5:
* com.xharvard.learning.note05.ServletConfigDemo -> http://localhost:8080/web_introduction/servlet.demo
* com.xharvard.learning.note05.ServletContextDemo -> http://localhost:8080/web_introduction/context.demo
