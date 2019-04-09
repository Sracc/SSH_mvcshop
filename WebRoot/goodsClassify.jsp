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
      <div class="xl9 list_main">
	<c:if test="${goodsClassify.id ne '' }">
	   <div class="xl12 cltitle list_title"> <a href="javascript:;">商品</a> </div> <br> <br>
      <div class="xl12 list_img">
<c:forEach items="${goodsClassify.goods}" var="s">
	<%@include file="/common/list_goods.jsp"%> 
</c:forEach>
      </div>
	</c:if>
      </div>
     <div class="xl3 side_container"> 
		      	<%@include file="/common/side_news.jsp"%> 
     </div>
      <div class="xl12 list_main">
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
