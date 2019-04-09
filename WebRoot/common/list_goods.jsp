<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		      <div class="xl3" style="margin-bottom:10px">
			      <div class="xl12">
			      <a href="site!goods?id=${s.id }"><img alt="" src="upload_image/${s.img }" width="100%" ></a>
			      </div>
			      <div class="xl12"style="margin-top:10px;max-height:40px;overflow:hidden">
			      	 <a href="site!goods?id=${s.id } ">${s.name }</a>
			      </div>
		      </div>
