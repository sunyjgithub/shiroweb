<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-05-23
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
     <h2>登录页面</h2>
     <form action="/login" method="post">

         <span style="color: red">${errormsg}</span><br><br>
         用戶名：<input type="text" name="username">
         <br><br>
         密碼：<input type="password" name="password">
         <br><br>
         <input type="submit" name="登陸">
     </form>
</body>
</html>
