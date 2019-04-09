<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="shortcut icon" href="style/images/logo.png">
<link rel="stylesheet" href="style/css/pintuer.css">
<script src="style/js/jquery.js"></script>
<!-- 延迟加载的jQuery插件 -->
<script src="style/js/jquery.lazyload.min.js"></script>
<!-- jQuery动画插件 -->
<script src="style/js/jquery.easing.min.js"></script>
<!-- 前端框架类似于BootStracp -->
<script src="style/js/pintuer.js"></script>
<link rel="stylesheet" href="style/css/style-out-base.css">
<script src="style/js/respond.js"></script>
<link type="image/x-icon" href="#/favicon.ico" rel="shortcut icon" />
<link href="#/favicon.ico" rel="bookmark icon" />
<link rel="stylesheet" href="style/css/style.css">
<link rel="stylesheet" href="style/css/portal.css">
<link rel="stylesheet" href="style/css/portal_002.css">
<%@include file="/common/login-regist.jsp"%>  
<%@include file="/common/upload.jsp"%>  
<%@include file="/common/sync.jsp"%>  
<header>
	<!--顶部-->
<form action="site!search" method="post" name="store_search" id="storeSearch" onSubmit="" >
<input type="hidden" name="method"  value="index"/>
<input type="hidden" name="goodsClassifysearch" id="searchid" value=""/>
<input type="hidden" name="namesearch" id="str" value="${search.namesearch }"/>
</form>
	<!--导航-->
    <div class="hidden-l demo-nav  padding-bottom ">
    <div class="container padding-top ">
      <div class="line">
        <div class="xl12 xs12 xm4 xb4 " id="logo" >
			<div class="xl12" style="margin:0 20px 0 0"><a target="_self" href="/">
			<span style="color:#383838;font:900 40px/40px 幼圆;font-size:2em"><img class="" src="style/images/logo.png" width="50px"  border="0" alt="">&nbsp;<atitle></atitle></span>
			</a></div>
			<div class="xl2 xs2 xm1 xb1" ><button class="button icon-navicon float-right" style="margin-top:10px" data-target="#header-demo"></button></div>
		</div>
        <div class=" xl12 xs12 xm8 xb8 nav-navicon" id="header-demo">
          <div class="hidden-l xs7 xm6 xb7  "  style="margin:0 0px 0 ">
              <div id="headsearch" class="input-group padding-little-top">
                <input type="text" id="searchstr"  class="input border-main search_bar1" name="keywords" size="1000" placeholder="关键词" value="${search.namesearch }"/>
				 <span class="addbtn search_bar2" >
					<div class="button-group">
					 <button type="button" id="search_bar2"  class="button  dropdown-toggle border-main search_bar2" ><span class="searchvalue">分类</span> <span class="downward"></span></button> 
					 <ul class="drop-menu"> 
<c:forEach items="${goodsClassifyList}" var="s">
<li><a href="javascript:setsearch('searchid','${s.id }','${s.name }')">${s.name }</a></li> 
</c:forEach>  
					 </ul>
					 </div>
				 </span>
                <span class="addbtn search_bar3" ><button type="button" class="button bg-main icon-search" onclick="strsearch()"> 搜索</button></span>
              </div>
<span class="" style="font-size:12px;color:#969696">热门搜索：
<c:forEach items="${goodsClassifyList}" var="s"> <a href="site!goodsClassify?id=${s.id }"><span>${s.name }</span></a>&nbsp; </c:forEach>
</span>
          </div>
          <div id="" class="hidden-l xs5 xm5 xb4  " style="width:auto;float:right">
<c:if test="${ login_user.username eq null}">
			  <span class="show-l"style=" float:right;width:100px">
				  <a class="text-main  dialogs" data-toggle="click" data-target="#login" data-mask="1" data-width="350px" href="javascript:;">[登录]</a><span> | </span>
				  <a class="text-main  dialogs" data-toggle="click" data-target="#regist" data-mask="1" data-width="500px" href="javascript:;"> [注册]</a>
			  </span>
</c:if>
			  <c:if test="${ login_user.username ne null}"> 欢迎你，${ login_user.username }<a href="login!loginOutf" target="_parent">【退出】</a> </c:if>
<!-- 			  shoppingcart  -->
          <div style="width:auto;float:left;padding:0 10px;">
          <div class="xl12">
					<div id="" class="text-left" style="width:100%;margin:3px 0 0 ;float:right">
						<div id="shoppingcart" class="shoppingcart">
							<dl class="">
								<dt class="ld">
									<s> </s>
									<span class="shopping"> <span class="shopping-amount"> <c:if test="${not empty shoppingCarts }">${count }</c:if><c:if test="${ empty shoppingCarts }">0</c:if> </span> </span>
									<a href="javascript:;" class="settleup-url"> 我的购物车 </a> <b> </b>
								</dt>
								<dd>
								<c:if test="${ empty shoppingCarts }">
								<div class="prompt"><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div></div>
								</c:if>
								<c:if test="${ not empty shoppingCarts }">
									<div id="" class="settleup-content">
										<div class="smt" style="text-align:left"> <span class=""> 最新加入的商品 </span> </div>
										<div class="smc">
											<ul class="mcart-sigle">
											<c:forEach items="${shoppingCarts}" var="s">
												<li>
													<div class="p-img fl">
														<a href="site!goods?id=${s.goods.id }" target="_blank">
															<img src="upload_image/${s.goods.img }" alt="" height="48" width="48" />
														</a>
													</div>
													<div class="p-name fl">
														<a href="site!goods?id=${s.goods.id }"  title="${s.goods.name }" target="_blank"><span style="font-weight:100;">${s.goods.name } </span> <br>${s.goods.descp } 
														</a>
														
													</div>
													<div class="p-detail fr ar">
														<span class="p-price"> <strong>
														 ￥${s.goods.price }
														 </strong> &times;${s.num } </span> 
														<a class="delete" data-id="1102181" data-type="RemoveProduct" href="javascript:shoppingdelete('${s.goods.id }')"> 删除 </a>
													</div>
												</li>
												</c:forEach>
											</ul>
											
										</div>
										<div class="smb ar">
											共 <b> ${count } </b> 件商品　共计 <strong> ￥ ${prices } </strong> <br />
											<c:if test="${ login_user.username eq null}">
				  <a class="btn-payforgoods  dialogs" style="color:#fff;"data-toggle="click" data-target="#login" data-mask="1" data-width="350px" href="javascript:;"> 下单购买</a><span> | </span>
</c:if>
			  <c:if test="${ login_user.username ne null}"> 
					<a href="javascript:window.location.href='/orders!add1';" title="下单购买" class="btn-payforgoods"style="color:#fff;"> 下单购买 </a>
			  </c:if>
										</div>
									</div>
								</c:if>
								</dd>
							</dl>
						</div>
			  </div>
				</div>
          </div>
          </div>
        </div>
      </div>
    </div>
    </div>
<!--nav-->
<nav id="navx" class=" hidden-l hidden-s">
	<div class="container">
		<div class="line-small margin-big-bottom ">
			<div class=" navbox  text-center navx1"><a href="/"><span class="icon-home nav_icon"></span><span>首页</span></a></div>
			<c:forEach items="${goodsClassifyList}" var="s">
	<c:if test="${s.id ne '' }">
			<div class=" navbox  text-center navx1"><a href="site!goodsClassify?id=${s.id }"><span class=" nav_icon"></span><span>${s.name }</span></a></div>
	</c:if>
	</c:forEach>  
		</div>
	</div>
</nav>
<div id="" class="clear"></div>
</header>



