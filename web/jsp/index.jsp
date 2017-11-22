<%--
  Created by IntelliJ IDEA.
  User: PUJW
  Date: 2017/11/14
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <%-- <head>
    <title>欢迎登录ttms影院</title>
      <script type="text/javascript" language="JavaScript">
          function register() {
              window.self.location = "register.jsp";
          }
      </script>
      <script src="${pageContext.request.contextPath}/js/ppp.js" type="text/javascript">

      </script>
  </head>--%>
 <head>
     <meta charset="UTF-8">
     <title>成人影院</title>
     <link rel="stylesheet" href="../lib/bootstrap.min.css">
     <link rel="stylesheet" href="../css/style.css">
     <script src="../lib/jquery-3.2.1.min.js"></script>
 </head>
  <body>

 <%--<form action="/loginServlet" method="post">

   name:<input type="text" name="user_name" value=""><br/>
   pwd:<input type="text" name="user_password" value=""><br/>
     <input type="button" value="注册" onclick="register()">
   <input type="submit" value="提交"><br/>


 </form>
 <form action="/Uploadservlet" method="post" enctype="multipart/form-data" >
     <input name="name" value="000001">
      上传头像:<input type="file" name="head_imge">
      <br/><br/>
      <input type="submit" value="上传">
 </form>
 <form action="/GetHeadImge" method="post" >
     <input type="text" name="url" value="timg.jpg">
     <br/><br/>
     <input type="submit" value="下载">
 </form>--%>
 <div class="content">
     <img src="../image/logo.png" class="loginImage">
     <div class="loginform">
         <form action="/loginServlet" method="post">
             <div class="form-group">
                 <h1 class="loginLogo">登  录</h1>
             </div>
             <div class="form-group">
                 <label for="account" class="control-label">账户：</label>
                 <input type="text" id="account" class="form-control" name="user_name">
             </div>
             <div class="form-group">
                 <label for="password" class="control-label">密码：</label>
                 <input type="password" id="password" class="form-control" name="user_password">
             </div>
             <div class="form-group">
                 <input type="submit"  class="btn btn-block btn-info" id="submit" value="提交">
             </div>
         </form>
     </div>
 </div>
 <script src="../js/login.js"></script>
  </body>
</html>
