FILEVIEW
===

静态资源不拦截配置
1. spring-mvc.xml
配置<mvc:default-servlet-handler/>
2. web.xml
不需要配置
3. 中文路径或文件名
需要配置tomcat的编码
conf/server.xml中的
~~~
<Connector port="8080" 
    protocol="HTTP/1.1" 
    connectionTimeout="20000" 
    redirectPort="8443" 
    URIEncoding="UTF-8" />
~~~