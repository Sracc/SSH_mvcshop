<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!--底部-->
 <div class="doc-backtop win-backtop icon-arrow-circle-up "></div>

    <footer class="layout bg-black bg-inverse">
      <div class="container">
        <div class="navbar">
          <div class="navbar-body hidden-l nav-navicon" id="navbar-footer">
            <div class="navbar-text navbar-left hidden-s hidden-l">
            <center>
           	 毕业设计 &copy; <a href="#" ><atitle></atitle>的设计与实现</a> All Rights Reserved
            </center>
            </div>
            <ul class="nav nav-inline navbar-right">
            	<li><a href="#" class="icon-home ">首页</a></li>
            <c:if test="${ login_user.username eq null}">
<li><a  class="dialogs icon-user" data-toggle="click" data-target="#login" data-mask="1" data-width="350px"style="float:right;" href="javascript:;" >个人中心</a></li>
	            <li><a href="/mvcshop/backend/login.jsp"class="icon-user ">后台管理</a></li>
			</c:if>
			<c:if test="${ login_user.username ne null }">
<c:if test="${ login_user.role.id eq 2}"><li><a href="site!member"class="icon-user ">个人中心</a></li></c:if>
	            <li><a href="/mvcshop/backend/login.jsp"class="icon-user " target="_blank">后台管理</a></li>
			</c:if>
            </ul>
            
            <br>
          </div>
        </div>
      </div>
    </footer>

