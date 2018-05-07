<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">
<!--112 -->

<link href="css/charisma-app.css" rel="stylesheet" type="text/css">
<link href='bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<!--12 -->
<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<!--1 -->
<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
<!--11 -->
<link href='bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<!--3 -->
<link href='bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<!-- 2-->
<link
	href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<!--2 -->
<link href='css/jquery.noty.css' rel='stylesheet'>
<!--3 -->
<link href='css/noty_theme_default.css' rel='stylesheet'>
<!--9 -->
<link href='css/elfinder.min.css' rel='stylesheet'>
<!-- 29-->
<link href='css/elfinder.theme.css' rel='stylesheet'>
<!--2 -->
<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
<!--4 -->
<link href='css/uploadify.css' rel='stylesheet'>
<!-- 3-->
<link href='css/animate.min.css' rel='stylesheet'>
<!--54 -->

<!-- jQuery -->
<script src="bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="img/favicon.ico">

<style>
body {
	padding-right: 80px;
	padding-left: 80px;
}

.big {
	margin-bottom: 10px;
}

.b{
	font-size:20px;
}

.register{
	margin-right:20px;
}

.login{
}
</style>

</head>

<body>

	<div class="ch-container">
		<div class="row">

			<div class="row">
				<div class="col-md-12 center login-header">
					<h2>患者注册</h2>
				</div>
				<!--/span-->
			</div>
			<!--/row-->

			<div class="row">
				<div class="col-md-5 center">
					<ul class="nav nav-tabs">
						<li class="active phonebtn">
							<a href="#">手机号注册</a>
						</li>
						<li class="idcardbtn">
							<a href="#">身份证注册</a>
						</li>
						<li class="namebtn">
							<a href="#">用户名注册</a>
						</li>
					</ul>
				</div>
			</div>

			<div class="row">
				<div class="well col-md-5 center login-box">

					<div class="namein">
						<!-- 用户名 -->
						<div class="input-group input-group-lg">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user red"></i>
							</span>
							<input type="text" class="form-control name" placeholder="请输入用户名">
						</div>
						<div class="clearfix"></div>
						<br>
					</div>

					<div class="phonein">
						<!-- 手机号码 -->
						<div class="input-group input-group-lg">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user red"></i>
							</span>
							<input type="text" class="form-control phone" placeholder="请输入手机号">
						</div>
						<div class="clearfix"></div>
						<br>
					</div>

					<div class="idcardin">
						<!-- 用户名 -->
						<div class="input-group input-group-lg">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user red"></i>
							</span>
							<input type="text" class="form-control idcard" placeholder="请输入身份证号">
						</div>
						<div class="clearfix"></div>
						<br>
					</div>

					<!-- 密码 -->
					<div class="input-group input-group-lg">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock red"></i>
						</span>
						<input type="password" class="form-control pwd" placeholder="请输入密码"
							name="pwd">
					</div>
					<div class="clearfix"></div>
					<br>

					<!-- 确认密码-->
					<div class="input-group input-group-lg">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock red"></i>
						</span>
						<input type="password" class="form-control mm" placeholder="请再次输入密码"
							name="mm">
					</div>
					<div class="clearfix"></div>
					<br>
					
					<div class="alert alert-info answer" style="margin-top:10px; display:none;">						
					</div>
						
					
					<button class="b register">注册</button>
					<button class="b login">登录</button>
			</div>


			</div>
		</div>
		<!--/fluid-row-->
	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->
	<script src="js/jquery-2.0.0.min.js"></script>

	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='bower_components/moment/min/moment.min.js'></script>
	<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script src="bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>

	<script type="text/javascript" src="js/zhuce.js"></script>

</body>
</html>