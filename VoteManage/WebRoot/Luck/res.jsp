<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'res.jsp' starting page</title>
    
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
		var name="xiaoming";
		var pwd="123";
		var born="1995-5-5";
		var tel="12311231231";
	$.ajax({
		type:"post",
				url:"regUsers.action",
				data:{"users.userName":name,"users.userPassword":pwd,"users.birthday":born,"users.telephone":tel},
				dataType:"json",
				success:function(m){
				alert(m);
				}
	});
	</script>
  </head>
  
  <body>
    <p>用户名<input type="text"></p>
    <p>密码<input type="text"></p>
    <p>生日<input type="text"></p>
    <p>电话<input type="text"></p>
  </body>
</html>
