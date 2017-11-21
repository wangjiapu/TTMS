<%--
  Created by IntelliJ IDEA.
  User: xiyou3g
  Date: 2017/11/20
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/registerServlet" method="post">
    用户名：<input type="text" name="user_name" ><br/>
    密码：<input type="password" name="pwd"><br/>
    确认密码：<input type="password" name="pwd2"><br/>
    成员身份：<select name="type">
                    <option value="0">普通用户</option>
                    <option value="1">管理员</option>
            </select><br/>
    <input type="submit" value="注册">
</form>
</body>
</html>
