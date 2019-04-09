<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>

<link href="css/style_nav.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="js/left.js"></script>
<style type="text/css">
<!--

-->
</style>
</head>
<body>
<div  style="height:100%;">
  <ul id="navigation">

	<li> <a class="head"><i class="mb-head-icon"></i>会员管理</a>
      <ul>
        <li><a href="member!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加会员</a></li>
        <li><a href="member.do" target="rightFrame"><i class="mb-list-icon"></i>查看会员信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>新闻公告管理</a>
      <ul>
        <li><a href="news!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加新闻公告</a></li>
        <li><a href="news.do" target="rightFrame"><i class="mb-list-icon"></i>查看新闻公告信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>商品分类管理</a>
      <ul>
        <li><a href="goodsClassify!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加商品分类</a></li>
        <li><a href="goodsClassify.do" target="rightFrame"><i class="mb-list-icon"></i>查看商品分类信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>商品管理</a>
      <ul>
        <li><a href="goods!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加商品</a></li>
        <li><a href="goods.do" target="rightFrame"><i class="mb-list-icon"></i>查看商品信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>订单管理</a>
      <ul>
        <li><a href="orders!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加订单</a></li>
        <li><a href="orders.do" target="rightFrame"><i class="mb-list-icon"></i>查看订单信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>评论管理</a>
      <ul>
        <li><a href="commentMsg!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加评论</a></li>
        <li><a href="commentMsg.do" target="rightFrame"><i class="mb-list-icon"></i>查看评论信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>收藏管理</a>
      <ul>
        <li><a href="memberCollect!addInput" target="rightFrame"><i class="mb-list-icon"></i>添加收藏</a></li>
        <li><a href="memberCollect.do" target="rightFrame"><i class="mb-list-icon"></i>查看收藏信息</a></li>
      </ul>
    </li>


    <li> <a class="head"><i class="mb-role-icon"></i>角色管理</a>
      <ul>
        <li><a href="role/add_role.jsp" target="rightFrame"><i class="mb-list-icon"></i>添加角色</a></li>
        <li><a href="role.do" target="rightFrame"><i class="mb-list-icon"></i>查看角色信息</a></li>
      </ul>
    </li>
    <li> <a class="head"><i class="mb-sys-icon"></i>系统管理</a>
      <ul>
        <li><a href="state.do" target="rightFrame"><i class="mb-list-icon"></i>查看订单状态信息</a></li>
        <li><a href="sys/update_password.jsp" target="rightFrame"><i class="mb-list-icon"></i>修改个人密码</a></li>
        <li><a href="/log.log" target="rightFrame"><i class="mb-list-icon"></i>查看登录日志</a></li>
        <li><a href="user!users" target="rightFrame"><i class="mb-list-icon"></i>查看在线用户</a></li>
      </ul>
    </li>
  </ul>
</div>
</body>
</html>

