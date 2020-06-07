# webservice
本项目是一个基于CXF+Spring框架发布WebService以及利用Axis框架调用WebService的学习型项目。WebService是开发中比较常用的技术，方便不同平台下的系统之间的交互协同工作。

## 项目依赖环境
1. idea 2018.3.*
2. maven 3.5.*
3. jdk 1.8.*
4. tomcat 8.5

## 使用说明
### 利用Axis框架调用WebService
1. 首先添加axis所需的依赖
```
dom4j.jar;
axis.jar;
axis-ant.jar;
commons-discovery-0.2.jar;
commons-logging-1.0.4.jar;
dom4j-1.5.2.jar;
jaxrpc.jar;
saaj.jar;
wsdl4j.jar;
```
2. 右键项目，选择webservice生成代码(自行看项目)
3. 在项目中调用手机号码查询webservice(自行看项目)
4. 启动项目，进入首页
![首页](C:\Users\mingo\Desktop\搜狗截图20200607164417.png)
5. 输入手机号，即可查询号码归属地及手机卡信息，号码查询的webservice网上现成的，大家可以自行上网搜索或在本项目的配置文件去查找，在此就不重复啰嗦了
![手机号查询](C:\Users\mingo\Desktop\搜狗截图20200607165147.png)

### CXF+Spring框架发布简单计算器WebService
1. 首先添加CXF所需的依赖，Spring所需的依赖在此不重复说明
```
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-core</artifactId>
    <version>3.1.4</version>
  </dependency>
  <dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-transports-http</artifactId>
    <version>3.1.4</version>
  </dependency>
  <dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-rt-frontend-jaxws</artifactId>
    <version>3.1.4</version>
    <exclusions>
        <exclusion>
            <artifactId>neethi</artifactId>
            <groupId>org.apache.neethi</groupId>
        </exclusion>
    </exclusions>
  </dependency>
```
2. 编写CXF配置文件applicationContext-cxf.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:jaxws="http://cxf.apache.org/jaxws"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
	    http://cxf.apache.org/jaxws
	    http://cxf.apache.org/schemas/jaxws.xsd">

    <!--
		address 客户端访问服务器路径
		serviceClass 配置接口
		serviceBean 配置实现
	 -->
    <!--<jaxws:server id="calcService" address="/calcService" serviceClass="com.mingoxu.ws.webservice.CalcService">
        <jaxws:serviceBean>
            <bean class="com.mingoxu.ws.webservice.impl.CalcServiceImpl" />
        </jaxws:serviceBean>
    </jaxws:server>-->
    <!--其中id是自己定义的，implementor是接口实现类，address就是访问的地址 -->
    <!-- 相当于Endpoint.publish("http://localhost:8080/service", newHelloServiceImp()); -->

    <jaxws:endpoint id="calcService" implementor="com.mingoxu.ws.webservice.impl.CalcServiceImpl" address="/calcService"/>

</beans>
```
3. 在web.xml那配置spring监听及CXF基于web访问的servlet，启动项目
```
<!-- 配置加载Spring文件的监听器 -->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath*:spring/applicationContext*.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

  <!-- CXF WS基于web访问的servlet -->
  <servlet>
    <servlet-name>CXFService</servlet-name>
    <servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>CXFService</servlet-name>
    <url-pattern>/services/*</url-pattern>
  </servlet-mapping>
```
4. 项目启动好之后，访问url为；http://localhost:端口号/webservice/services/calcService?wsdl ，大家可以自行用接口工具，例如SOAP进行测试
