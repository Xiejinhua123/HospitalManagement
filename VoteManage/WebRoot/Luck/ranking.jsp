<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ranking.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<Script src="<%=basePath%>/pagefile/js/jquery-1.8.3.min.js"></Script>
	<script>
	//获取票数排行榜前十名
	$.ajax({
		type:"post",
				url:"getvoteTen.action",
				dataType:"json",
				success:function(m){
				var h="";
				$.each(m, function(i,n){
					h+="<div class='total' style='float:left'><p><img src="+n.imgUrl+ " style=' width: 100px; height: 100px;'></p><p>"+n.name+"</p></div>";
				});
					$(".rank").html(h);
				}
	});
	//随机获取三名用户
	$.ajax({
		type:"post",
				url:"getThreeUser.action",
				dataType:"json",
				success:function(m){
				var h="";
				$.each(m, function(i,n){
					h+="<div class='total' style='float:left'><p><img src="+n.imgUrl+ " style=' width: 100px; height: 100px;'></p><p>"+n.name+"</p><p>总票数："+n.totalVotes+"</p><p><button onclick='dovote("+n.id+")'>投票</button></p></div>";
				});
					$(".randow").html(h);
				}
	});
	//执行投票
		function dovote(id){
			var voteNumber=1;
			$.ajax({
			type:"post",
			data:{"uuid":id,"users.totalVotes":voteNumber},
			dataType:"json",
			url:"/VoteManage/voteing.action",
			success:function(m){
				
			}
			});
		}
	</script>
  </head>
  <body>
  <!-- 这里显示排行榜，头像名称 -->
    <div class="rank" style="width:2000px; height:150px">
    
    </div>
   <!-- 这里随机推荐，头像名称，总票数  投票按钮    标签投票数 -->
   <div class="randow">
   
   </div>
  </body>
</html>
