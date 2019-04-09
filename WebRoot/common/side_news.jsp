<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

		<div class="xl12  hotstore" >
        	<div class="side_title"><a href="site!newss" class="">新闻公告</a></div>
            <div class="padding bg-content">
            	<ul class="list-media list-underline">
            		<c:forEach items="${newsList}" var="s">
	                	<li> <div class="media media-x">
	                          <a class="float-left" href="site!news?id=${s.id}"><img src="upload_image/${s.img}"  height="60px" class="radius" alt="..."></a>
	                          <div class="media-body"style="font-size:11px"><strong >${s.name }</strong>
								${s.descp }
							  <a class="button button-little border-red swing-hover" href="site!news?id=${s.id }">查看详情</a></div>
	                    </div> </li>
					</c:forEach>                
                </ul>
            </div>
          </div>
