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
<body >
<%@include file="/common/head.jsp"%>
 <!--内容--> 
<section id="navx4"  >
	<div class="container ">
	      <div class="line-small">
				<%@include file="/common/banner.jsp"%>
		      <div class="xl9 list_main">
<c:forEach items="${goodsClassifyList}" var="g">
<!-- cif标签如果true执行 -->
	<c:if test="${g.id ne '' }">
		<c:if test="${fn:length(g.goods) ne 0 }">
	      <div class="xl12 cltitle list_title">
		      <a href="site!goodsClassify?id=${g.id }">${g.name}</a> 
	      </div>
		       <%int i = 1; %>
	      <div class="xl12 list_img">
	<c:forEach items="${g.goods}" var="s">
		      <%if(i<=400){ %>
	 		  <%i++; %>
				<%@include file="/common/list_goods.jsp"%> 
		      <%} %>
	</c:forEach>
	      </div>
﻿<div style="clear:both"></div>
		</c:if>
	</c:if>
</c:forEach> 
﻿<div style="clear:both"></div><br /><br />
		      </div>
		      <aside class="xl3 side_container"> 
		      	<%@include file="/common/side_news.jsp"%> 
		      </aside>
	      </div>
	      <br />
	</div>	
	<br /><br />
</section>
<%@include file="/common/foot.jsp"%>
</body>
</html>
<!--index_ok-->
