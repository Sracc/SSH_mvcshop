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
		      <div class=" xl8" style=""> ${goods.content } </div>
		      <div class=" xl4" style="">
		      <div class=" xl12 cxtitle" style="">
		      	${goods.name }
		      </div>
		      <div class=" xl12 " style="margin:10px">
		      	${goods.descp } 
		      </div>
		      <div class=" xl12 " style="margin:10px">
		      	上架时间：${goods.settime }
		      </div>
		      <div class=" xl12 " style="margin:10px">
		      	价格：${goods.price }元
		      </div>
		      
		      <div class=" xl12 cxtitle" style="margin:10px">
		      	<span  class="button asksubmit"style="float:right;" onclick="shoppingAdd('${goods.id}',1,0)">加入购物车</span>
	      <c:if test="${ login_user.username eq null}">
	       		<a  class="hidden-l float-right  dialogs button asksubmit"style="float:right;margin:0 10px;" id="answerbut" data-toggle="click" data-target="#login" data-mask="1" data-width="350px"style="" href="javascript:;" >收藏</a>
		  </c:if>
		  <c:if test="${ login_user.username ne null}">
		  	<span  class="button asksubmit"style="float:right;margin:0 10px;" onclick="window.location.href='site!addMemberCollect?member=${member.id }&goods=${goods.id }&url=site!member'">收藏</span>
		  </c:if>
		      </div>
		      
		 
			      <%@include file="/common/content_goods_comment.jsp"%>
		      </div>
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
