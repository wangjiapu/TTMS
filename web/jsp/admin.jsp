<%--
  Created by IntelliJ IDEA.
  User: xiyou3g
  Date: 2017/11/20
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>成人影院</title>
    <link rel="stylesheet" href="../lib/bootstrap.min.css">
    <link rel="stylesheet" href="../css/studio.css">
    <link rel="stylesheet" href="../css/account.css">
    <link rel="stylesheet" href="../css/seat.css">
    <script src="../lib/jquery-3.2.1.min.js"></script>
    <script src="../lib/bootstrap.min.js"></script>
</head>
<body>
<div class="pakage">
    <div class="header" id="header">
        <img src="../image/adult.png" class="adultImagge">
        <button class="btn btn-danger logout">登出</button>
        <%--<a href=""><img src="./image/head.jpg" class="img-circle headImage"></a>--%>
    </div>

    <div class="content">
        <div class="nav">
            <ul>
                <li id="studio"><a href="#">演出厅管理</a></li>
                <div class="nav2_1">
                </div>
                <li id="user"><a href="#">用户管理</a></li>
                <div class="nav2_3">

                </div>
                <li><a href="#" id="seat">座位管理</a></li>
                <div class="nav2_2">
                </div>
            </ul>
        </div>

        <div class="subs">

            <div class="studio">
                <div class="subs_left">
                    <div class="pingmu">
                    </div>
                    <div class="seatsRoom">
                    </div>
                </div>
                <div class="subs_right selectAreat">
                    <%--<p id="st_name">一号演出厅</p>--%>
                    <%--<p>行：8&emsp;&emsp;&emsp;列：10</p>--%>
                    <%--<p>状态：可用</p>--%>
                    <%--<button id="updateStudio" class="btn btn-info btnus" data-toggle="modal"--%>
                    <%--data-target="#updateStudio1">修改演出厅--%>
                    <%--</button>--%>
                    <%--<button id="deleteStudio" class="btn btn-info btnus">删除演出厅</button>--%>
                </div>
            </div>


            <div class="account">

            </div>

            <div class="seat">
                <div class="seatArea">
                    <div class="pingmu">
                    </div>
                    <div class="seatsRoom">
                    </div>
                </div>
                <div class=" seatTag">
                    <%--<p id="st__name">一号演出厅</p>--%>
                    <%--<p>行：<span id="rows"></span>&emsp;&emsp;&emsp;列：<span id="cols"></span></p>--%>
                    <%--<p>状态：可用</p>--%>
                    <%--<button id="updateSeat" class="btn btn-info btnus ">--%>
                    <%--确认修改--%>
                    <%--</button>--%>
                    <%--可用：--%>
                    <%--<button class="seatgood"></button>--%>
                    <%--故障：--%>
                    <%--<button class="seatbad"></button>--%>
                </div>
            </div>

        </div>
    </div>
</div>
<%--模态框--%>
<!--//增加演出厅-->
<div class="modal fade" id="addStudio1" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    增加演出厅
                </h4>
            </div>
            <div class="modal-body">
                <form action="#" style="padding: 30px;">
                    <div class="form-group ">
                        <label for="stName" class="control-label">演出厅名：</label>
                        <input type="text" class="form-control" id="stName" required>
                    </div>
                    <div class="form-group">
                        <label for="stRows" class="control-label">行数:</label>
                        <input type="number" class="form-control" id="stRows" required value="5" max="10" min="3">
                    </div>
                    <div class="form-group">
                        <label for="stCols" class="control-label">行数:</label>
                        <input type="number" class="form-control" id="stCols" required value="5" max="10" min="3">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    确认添加
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!--//修改演出厅-->
<div class="modal fade" id="updateStudio1" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改演出厅
                </h4>
            </div>

            <div class="modal-body">
                <form action="#" style="padding: 30px;">
                    <div class="form-group ">
                        <label for="stNewName" class="control-label">演出厅名：</label>
                        <input type="text" class="form-control" id="stNewName" required>
                    </div>
                    <div class="form-group">
                        <label for="stNewRows" class="control-label">行数:</label>
                        <input type="number" class="form-control" id="stNewRows" required value="5" max="10" min="3">
                    </div>
                    <div class="form-group">
                        <label for="stNewCols" class="control-label">列数:</label>
                        <input type="number" class="form-control" id="stNewCols" required value="5" max="10" min="3">
                    </div>
                    <div class="form-group">
                        <label for="good">可用：</label>
                        <input type="radio" value="good" id="good" name="status">&emsp;&emsp;
                        <label for="bad">故障：</label>
                        <input type="radio" value="bad" id="bad" name="status">
                    </div>
                </form>
            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    提交更改
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!--//修改用户-->
<div class="modal fade" id="updateAccount" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改用户
                </h4>
            </div>

            <div class="modal-body">
                <form action="#" style="padding: 30px;">
                    <div class="form-group ">
                        <label for="acNewName" class="control-label">新用户名：</label>
                        <input type="text" class="form-control" id="acNewName" required value="栋哥">
                    </div>
                    <div class="form-group">
                        <label for="boy">男：</label>
                        <input type="radio" value="boy" id="boy" name="sex">&emsp;&emsp;&emsp;&emsp;
                        <label for="gril">女：</label>
                        <input type="radio" value="gril" id="gril" name="sex">
                    </div>
                    <div class="form-group">
                        <label for="admin">admin：</label>
                        <input type="radio" value="admin" id="admin" name="status">&emsp;&emsp;
                        <label for="manager">manager：</label>
                        <input type="radio" value="manager" id="manager" name="status">
                    </div>
                </form>
            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    提交更改
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!--//添加用户-->
<div class="modal fade" id="addAccount" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    添加用户
                </h4>
            </div>

            <div class="modal-body">
                <form action="#" style="padding: 30px;">
                    <div class="form-group ">
                        <label for="acName" class="control-label">用户名：</label>
                        <input type="text" class="form-control" id="acName" required value="栋哥">
                    </div>
                    <div class="form-group">
                        <label for="boy1">男：</label>
                        <input type="radio" value="boy" id="boy1" name="sex">&emsp;&emsp;&emsp;&emsp;
                        <label for="gril1">女：</label>
                        <input type="radio" value="gril" id="gril1" name="sex">
                    </div>
                    <div class="form-group">
                        <label for="admin1">admin：</label>
                        <input type="radio" value="admin" id="admin1" name="status">&emsp;&emsp;
                        <label for="manager1">manager：</label>
                        <input type="radio" value="manager" id="manager1" name="status">
                    </div>
                </form>
            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    确认添加
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!--//修改剧目-->
<div class="modal fade" id="updatePlayer" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改剧目
                </h4>
            </div>

            <div class="modal-body">
                <form action="#" style="padding: 30px;">
                    <div class="form-group ">
                        <label for="plNewName" class="control-label">新剧目名：</label>
                        <input type="text" class="form-control" id="plNewName" required value="剧目一">
                    </div>
                    <div class="form-group">
                        <label for="xiju">喜剧：</label>
                        <input type="radio" value="xiju" id="xiju" name="type">
                        <label for="dongman">动漫：</label>
                        <input type="radio" value="dongman" id="dongman" name="type">
                        <label for="active">动作片：</label>
                        <input type="radio" value="active" id="active" name="type">
                        <label for="xuanyi">悬疑片：</label>
                        <input type="radio" value="xuanyi" id="xuanyi" name="type">
                    </div>

                    <div class="form-group">
                        <label for="time">播放时长：</label>
                        <input type="number" id="time" min="60" max="150" placeholder="(分钟)"  class="form-control">&emsp;&emsp;
                    </div>
                </form>
            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">
                    提交更改
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--修改头像--%>
<div class="modal fade" id="updateHead" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title">
                    修改头像
                </h4>
            </div>

            <div class="modal-body">
                <form action="#" enctype="multipart/form-data" id="headForm">
                    <input type="file">
                </form>
            </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary" id="updateHeadBtn">
                    提交更改
                </button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script src="../js/admin.js"></script>
</body>
</html>
