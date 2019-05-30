<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div>
    	用户名：<input class="name" type="text" name="name"/><span style="display: none;">用户名不存在</span><br/>
    	密码：<input class="pwd" type="password" name="pwd"/><span style="display: none;">密码至少为6位</span><br/>
    	<input type="submit" value="登录"/>
    </div>
  </body>
  <script type="text/javascript" src="<%=basePath %>Luck/js/jquery.js"></script>
  <script type="text/javascript">
  
  	$(function(){
  		$(".name").blur(function(){ checkedName($(this)); });
  		$(".pwd").blur(function(){ checkedPwd($(this)); });
  		
	});
	
	//验证用户名是否正确
	function checkedName(document){
		var name = $(".name").val();
		if( name.length <= 0 ){
			$(docment).next("span").show();
		}else{
			$(docment).next("span").hide();
		}
	}
	
	//验证密码格式是否正确
	function checkedPwd(document){
		var pwd = $(".pwd").val();
		if( pwd.length <= 6 ){
			$(docment).next("span").show();
		}else{
			$(docment).next("span").hide();
		}
	}
	
  </script>
</html>
