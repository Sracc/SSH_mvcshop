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
      <div class="xl12 " style="margin:18px 10px 10px 0;padding:0 10px 0 0;width:100%;background-color:#fff">
	<c:if test="${not empty newsList }">
	   <div class="xl12 cltitle"style="padding: 0 20px"> <a href="javascript:;">新闻公告</a> </div> <br> <br>
      <div class="xl12" style="padding: 0 10px 0 10px">
<c:forEach items="${newsList}" var="s">
		      <div class="xl2" style="margin-bottom:10px">
			      <div class="xl12">
			      <a href="site!news?id=${s.id }"><img alt="" src="upload_image/${s.img }" width="100%" ></a>
			      </div>
			      <div class="xl12"style="margin-top:10px;max-height:40px;overflow:hidden">
			      	 <a href="site!news?id=${s.id } ">${s.name }</a>
			      </div>
		      </div>
</c:forEach>
      </div>
	</c:if>
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
