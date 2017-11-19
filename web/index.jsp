<%--
  Created by IntelliJ IDEA.
  User: PUJW
  Date: 2017/11/14
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <form action="/loginservlet" method="post">

   name:<input type="text" name="user_name" value=""><br/>
   pwd:<input type="text" name="user_password" value=""><br/>
   <input type="submit" value="提交">
 </form>
  </body>
</html>
