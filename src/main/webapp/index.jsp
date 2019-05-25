
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>系统主页</title>
</head>
<body>
<h2>系统主页</h2>

welcome:<shiro:principal></shiro:principal>

<a href="/logout">注销</a>

<shiro:hasRole name="user">
    <a href="user.jsp">用户列表</a>
</shiro:hasRole>



</body>
</html>



