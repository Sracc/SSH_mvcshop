<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/logo_icon.png">
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script  src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
			    $(".sysName").load("sysName.txt",function(data,x){
			    	document.title=data;
			    });	
			});
	</script>
	<title></title>
<script>
//��ҳ��ǰ״̬�ж�
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

function sync_backend(){
	if(document.cookie.match(/login_backend=([^;]+)(;|$)/)!=null){
        var arr=document.cookie.match(/login_backend=([^;]+)(;|$)/); //cookies�в�Ϊ�գ����ȡ������λ��
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
						url:'login!loginOutAjax',
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


// ��Ӽ���������title����ʾ״̬�仯
document.addEventListener(visibilityChange, function() {
// 	document.title = document[state];
if(document[state]=='visible'){
	if(document[state]=='hidden')clearInterval(timer); 
    sync_backend();
}


}, false);
//��ʼ��ҳ��״̬
// document.title = document[state];

window.onload = function(){
sync_backend();
};
</script>
</head>
<frameset rows="50,*" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
	<frame src="center.jsp" name="mainFrame" id="mainFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>

