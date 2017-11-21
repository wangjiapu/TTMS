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
    <title>欢迎登录ttms影院</title>
      <script type="text/javascript" language="JavaScript">
          function register() {
              window.self.location = "register.jsp";
          }
      </script>
  </head>
  <body>
 <form action="/loginServlet" method="post">

   name:<input type="text" name="user_name" value=""><br/>
   pwd:<input type="text" name="user_password" value=""><br/>
     <input type="button" value="注册" onclick="register()">
   <input type="submit" value="提交"><br/>


 </form>
 <form action="/Uploadservlet" method="post" enctype="multipart/form-data" >
      上传头像:<input type="file" name="head_imge">
      <br/><br/>
      <input type="submit" value="上传">
 </form>
 <form action="/downimge" method="post" >
     <input type="text" name="url" value="timg.jpg">
     <br/><br/>
     <input type="submit" value="下载">
 </form>
  </body>
</html>
