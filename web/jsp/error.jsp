<%--
  Created by IntelliJ IDEA.
  User: xiyou3g
  Date: 2017/11/20
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错了</title>
    <style >
        div{
            background-image: url("../image/error.jpg");
            background-size: 100%;
            width: 800px;
            height: 800px;
            margin: 0 auto;

        }
    </style>
</head>
<body>
<div></div>
<script>
    window.setTimeout(function () {
        window.location.href="/jsp/index.jsp"
    },1000)
</script>
</body>
</html>
