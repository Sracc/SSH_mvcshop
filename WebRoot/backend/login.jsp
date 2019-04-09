<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";

%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <script  src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	if(window.parent!=window){
		window.parent.location=window.location;
	}
			$(document).ready(function(){
			    $(".sysName").load("sysName.txt",function(data,x){
			    	document.title=data;
			    });	
			});
	</script>
	<title></title>
	<script type="text/javascript" src="js/js.js"></script>

    <link href="css/style_list.css" rel="stylesheet">
	<link rel="shortcut icon" href="images/logo_icon.png">
	
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form id="login" class="form-signin" action="login.do"  >
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登录</h1>
            <img src="images/login-logo.png"  style="max-width:300px" alt=""/><br>
            <b class="sysName loginsysname"></b>
        </div>
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="用户名"name="username" >
            <input type="password" class="form-control" placeholder="密码" name="password" >
            
			
      
            
            <button class="btn btn-lg btn-login btn-block" type="submit">
                <i class="fa fa-check"></i>
            </button>
			<div class="registration">
             ${login_error}
            </div>
            <div class="registration">
       <a class="loginbutton" href="member!addInput"> 注册  </a>
            </div>

        </div>


    </form>

</div>



<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>

</body>
</html>
