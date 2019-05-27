<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
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

         <div>
             <input type="text" class="form-login width_code input-errow" id="validateCode"
                    name="validateCode"
                    placeholder="输入验证码">
             <div>
                 <img src="${ctx}/Kaptcha.jpg"
                      id="kaptcha"
                      onclick="this.src='${ctx}/Kaptcha.jpg?id='+Math.random()*100"
                      title="点击变换验证码"/>
             </div>
         </div>

         <input type="submit" name="登陸">
     </form>
</body>
</html>
