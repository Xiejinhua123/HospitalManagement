<%@page import="com.accp.demo.Users"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String basePath = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>

	<meta charset="utf-8">
	<title>主页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
	<meta name="author" content="Muhammad Usman">

	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link id="bs-css" href="<%=basePath %>admin/css/bootstrap-cerulean.css" rel="stylesheet">
	<link href="<%=basePath %>admin/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="<%=basePath %>admin/css/charisma-app.css" rel="stylesheet">
	<link href="<%=basePath %>admin/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='<%=basePath %>admin/css/fullcalendar.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='<%=basePath %>admin/css/chosen.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/uniform.default.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/colorbox.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/jquery.noty.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/noty_theme_default.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/elfinder.min.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/elfinder.theme.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/opa-icons.css' rel='stylesheet'>
	<link href='<%=basePath %>admin/css/uploadify.css' rel='stylesheet'>
	<link rel="stylesheet" href="<%=basePath %>admin/page/css/style.css" media="screen" type="text/css" />
	<!-- The fav icon -->
	<link rel="shortcut icon" href='<%=basePath %>admin/img/favicon.ico'>	
	<link rel='stylesheet' href='<%=basePath %>admin/css/jquery.mobile-1.3.2.css'>
	
	<style>
		.headertitle{ height:35px;}
		.fold-ico{ position: relative; top:-3px; left:-2px;}
		#menu li i{ position: relative; top: 3px; left:-5px;}
	</style>
	
	<script type="text/javascript" src='<%=basePath %>admin/js/jquery-1.8.3.js'></script>
</head>

<body>
		<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"> <img alt="Charisma Logo" src="<%=basePath %>admin/img/logo20.png" /> <span>医院后台管理</span></a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone"> 更换主题/皮肤</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> 经典</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> 机械</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> 治愈</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> 报表</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> 清新</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> 石板</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> 太空</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> 统一</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone">
							<%=((Users)session.getAttribute("admin")).getTrueName() %>
						</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a href="#">切换用户</a></li>
						<li class="divider"></li>
						<li><a href="<%=basePath %>servet/user?ac=Writeoff">注销</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">返回首页</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="搜索" class="search-query span2" name="query" type="text">
							</form>
						</li>
					</ul>
				</div><!--/.nav-collapse -->

			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				
				<div class="well nav-collapse sidebar-nav">
					<div class="box well">管理菜单</div>
					<ul class="nav nav-tabs nav-stacked main-menu" id="menu">
						<li><a class="ajax-link" href="#"><i class="icon-home"></i><span class="hidden-tablet"> 就诊</span></a></li>
						<li><a class="ajax-link" href="#"><i class="icon-home"></i><span class="hidden-tablet"> Dashboard</span></a></li>
					</ul>
				</div><!--/.well -->
			</div><!--/span12-->
			<!-- left menu ends -->
			
			<div id="content" class="span10"><!-- span10 -->

			