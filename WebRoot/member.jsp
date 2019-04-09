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
<div id="navx4" style="" >
<div class=""style="width:1250px;margin:0 auto;height:700px">
      <div class=" " style="">
	      <div class="text-center xl12" style="padding:0px;">
	      
		      <div class="text-center xl2" style="padding:0px;height:700px">
		      <iframe height="100%" width="100%" frameborder="0" frameborder="0" src="/backend/left2.jsp" name="leftFrame" id="rightFrame" title="rightFrame"></iframe>
		      </div>
		      <div class="text-center xl10" style="padding:0px;height:700px">
		      <iframe height="100%" width="100%" frameborder="0" frameborder="0" src="member.do" name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
		      </div>
		      
      	</div>
      </div>
</div>
</div>
<div style="clear:both"></div>
<%@include file="/common/foot.jsp"%>
</body>
</html>
<!--index_ok-->
