<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-02
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>手机号查询页面</title>
</head>
<body>
<div style="margin:0 auto;width:500px;height:500px;text-align: center;">
    <h3>手机号码查询</h3>
    <form method="post" action="${pageContext.request.contextPath}/query.do" >
        <input type="text" placeholder="请输入可查询手机号码" name="phone" value="${phone}" />
        <button>查询</button>
    </form>
    <span style="color:red;">${msg}</span>
</div>
</body>
</html>
