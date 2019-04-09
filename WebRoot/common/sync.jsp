<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
//网页当前状态判断
var hidden, state, visibilityChange; 
if (typeof document.hidden !== "undefined") {
	hidden = "hidden";
	visibilityChange = "visibilitychange";
	state = "visibilityState";
} else if (typeof document.mozHidden !== "undefined") {
	hidden = "mozHidden";
	visibilityChange = "mozvisibilitychange";
	state = "mozVisibilityState";
} else if (typeof document.msHidden !== "undefined") {
	hidden = "msHidden";
	visibilityChange = "msvisibilitychange";
	state = "msVisibilityState";
} else if (typeof document.webkitHidden !== "undefined") {
	hidden = "webkitHidden";
	visibilityChange = "webkitvisibilitychange";
	state = "webkitVisibilityState";
}
function sync_site(){
	if(document.cookie.match(/login_site=([^;]+)(;|$)/)!=null){
        var arr=document.cookie.match(/login_site=([^;]+)(;|$)/); //cookies中不为空，则读取滚动条位置
        //判断login_site和登录的userid是不是相同
        $.ajax({
			type:"post",
			url:'user!getUserId',
			cache:false,
			async:false,
			data:{
				id:arr[1]
			},
			success:function(id){
				if(arr[1]!=id){
					$.ajax({
						type:"post",
						url:'login!loginAccount',
						cache:false,
						async:false,
						data:{
							id:arr[1]
						},
						success:function(data){
						}
					});
		         }
			}
		});
         
    }else{
    	$.ajax({
			type:"post",
			url:'user!getUserId',
			cache:false,
			async:false,
			data:{
				
			},
			success:function(id){
				if(id!=0){
					$.ajax({
						type:"post",
						url:'login!loginOutfAjax',
						cache:false,
						async:false,
						data:{
							
						},
						success:function(data){
							window.location.reload();
						}
					});
				}
			}
		});
		
    }
}

// 添加监听器，在title里显示状态变化
document.addEventListener(visibilityChange, function() {
// 	document.title = document[state];
if(document[state]=='visible'){
    sync_site();
}


}, false);
//初始化页面状态
// document.title = document[state];

window.onload = function(){
sync_site();
};
</script>