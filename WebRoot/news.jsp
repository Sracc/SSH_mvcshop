<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" CONTENT="-1">           
<meta http-equiv="Cache-Control" CONTENT="no-cache">           
<meta http-equiv="Pragma" CONTENT="no-cache">           
<title></title>
<meta name="description" content="">
<meta name="Keywords" content="">
</head>
<body>
<%@include file="/common/head.jsp"%>
	<!--内容-->
<section id="navx4" class="">
<div class="container">
      <div class="line-small">
      <div class=" maincontent" style="margin-bottom:10px">
	      <div class="text-center xl12" style=""> <h1>	${news.name }</h1> </div>
	      <div class="text-center xl12" style="margin:20px 0"> 发布时间:${news.settime } </div>
	      <div class=" xl12" style=""> ${news.content } </div>
      </div>
      </div>
      <br />
    </div>
    <br /><br />
</section>
<%@include file="/common/foot.jsp"%>
</body>
</html>
<!--index_ok-->
