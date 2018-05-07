<%@page import="com.accp.demo.Patient"%>
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
		<title>主页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

		<!-- The styles -->
		<link id="bs-css" href="css/bootstrap-cerulean.min.css"
			rel="stylesheet">

		<link href="css/charisma-app.css" rel="stylesheet">
		<link href='bower_components/fullcalendar/dist/fullcalendar.css'
			rel='stylesheet'>
		<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
			rel='stylesheet' media='print'>
		<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
		<link href='bower_components/colorbox/example3/colorbox.css'
			rel='stylesheet'>
		<link href='bower_components/responsive-tables/responsive-tables.css'
			rel='stylesheet'>
		<link
			href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
			rel='stylesheet'>
		<link href='css/jquery.noty.css' rel='stylesheet'>
		<link href='css/noty_theme_default.css' rel='stylesheet'>
		<link href='css/elfinder.min.css' rel='stylesheet'>
		<link href='css/elfinder.theme.css' rel='stylesheet'>
		<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
		<link href='css/uploadify.css' rel='stylesheet'>
		<link href='css/animate.min.css' rel='stylesheet'>

		<!-- jQuery -->
		<script src="bower_components/jquery/jquery.min.js"></script>

		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon.ico">
		<style type="text/css">
body {
	padding: 8px;
}

.btn1 {
	margin-top: 20px;
}

.btn2 {
	margin-top: 20px;
}

.btn3 {
	margin-top: 20px;
}

.btn4 {
	margin-top: 20px;
}
</style>
	</head>

	<body>

		<c:if test="${sessionScope.patient == null}">
			<script>
				alert("您还没有登录，请登录");
				window.location.href = "/HospitalManagement/JSP/login.jsp";
			</script>
		</c:if>
		
		<!-- 弹窗 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" id="close" data-dismiss="modal">
							×
						</button>
						<h3>
							医生详细信息
						</h3>
					</div>
					<div id="error" class="modal-body">
						<table class="table" cellpadding="0" cellspacing="0"
							style="font-size: 20px;">
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									姓名：
								</td>
								<td style="width: 50%;" class="docName"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									职务：
								</td>
								<td style="width: 50%;" class="docDuty"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									性别：
								</td>
								<td style="width: 50%;" class="docSex"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									出身日期：
								</td>
								<td style="width: 50%;" class="docBir"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									学历：
								</td>
								<td style="width: 50%;" class="docSchool"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									电话：
								</td>
								<td style="width: 50%;" class="docPhone"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									邮箱：
								</td>
								<td style="width: 50%;" class="docEmail"></td>
							</tr>
							<tr>
								<td style="text-align: right; width: 50%; padding-right: 10%;">
									当前挂号人数：
								</td>
								<td style="width: 50%;" class="docRegNum"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<a href="#" id="callNo" class="btn btn-default"
							data-dismiss="modal">取消</a>
						<a href="#" id="callYes" class="btn btn-primary"
							data-dismiss="modal">确认</a>
					</div>
				</div>				
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 center login-header">
				<h2 style="color: black;">
					XXXX医院挂号系统
				</h2>
			</div>
		</div>

		<!-- 这是头部的四个大的div的父级盒子，可以看到其中的四个盒子 -->
		<div class=" row" style="display:none;">

			<!-- 这是第一个盒子，用来查看当前登录的用户的信息 -->
			<div class="col-md-3 col-sm-3 col-xs-6 btn1"
				style="text-align: center;">
				<div style="marigin: 0px auto;">
					<a style="width: 80%; text-align: center;" href="#"
						class="btn btn-danger">历史记录</a>
				</div>
			</div>

			<!-- 第二个盒子，查看当前账户之前的所有的就诊信息 -->
			<div class="col-md-3 col-sm-3 col-xs-6 btn2"
				style="text-align: center;">
				<div style="marigin: 0px auto;">
					<a style="width: 80%; text-align: center;" href="#"
						class="btn btn-danger">历史记录</a>
				</div>
			</div>

			<!-- 第三个盒子，查看当前的挂号信息，在下方盒子内显示医生信息，用户信息 -->
			<div class="col-md-3 col-sm-3 col-xs-6 btn3"
				style="text-align: center;">
				<div style="marigin: 0px auto;">
					<a style="width: 80%; text-align: center;" href="#"
						class="btn btn-danger">历史记录</a>
				</div>
			</div>

			<!-- 第四个盒子，点击查看我之前的就诊评价信息 -->
			<div class="col-md-3 col-sm-3 col-xs-6 btn4"
				style="text-align: center;">
				<div style="marigin: 0px auto;">
					<a style="width: 80%; text-align: center;" href="#"
						class="btn btn-danger">历史记录</a>
				</div>
			</div>
		</div>


		<!-- 中间部分显示查询信息 -->
		<div class="row">
			<div class="box col-md-12">

				<!-- 总体的大盒子 用来适应屏幕 -->
				<div class="box-inner">

					<!-- 上部分的高亮显示条，折叠功能的小按钮所在显示框 -->
					<div class="box-header well">
						<h2>
							<i class="glyphicon glyphicon-tasks"></i>当前登陆用户：
							<c:if test="${sessionScope.patient != null}">
								<%=((Patient) session.getAttribute("patient")).getPatName()%>
								<input id="patId" type="hidden"
									value=<%=((Patient) session.getAttribute("patient"))
						.getPatId()%> />
							</c:if>
						</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i> </a>
						</div>
					</div>



					<!-- 主体部分，在主题中显示查询到的所有信息 -->
					<div id="reg" class="box-content row box-con">

						<!-- 选择挂号信息 -->
						<div id="gua" class="col-lg-12 col-md-12">

							<div class="row">
								<div class="col-md-12 center login-header">
									<h2 style="color: black;">
										选择挂号信息
									</h2>
								</div>
								<!--/span-->
							</div>
							<div class="row">
								<div class="box col-lg-2 col-md-2"></div>
								<div class="box col-lg-8 col-md-8">
									<div class="box-inner">
										<div class="box-content" style="text-align: center;">

											<table class="table" cellpadding="0" cellspacing="0"
												style="font-size: 20px;">
												<thead>
													<tr>
														<td
															style="text-align: right; width: 50%; padding-right: 10%;">
															请选择挂号信息：
														</td>
														<td style="width: 50%;">
															<input type="radio" name="regType" value="401" />
															专家号
															<input type="radio" name="regType" value="402" />
															普通号
														</td>
													</tr>
												</thead>
												<thead>
													<tr>
														<td
															style="text-align: right; width: 50%; padding-right: 10%;">
															请选择科室：
														</td>
														<td style="width: 50%;" class="select">
															<select name="dep" style="width: 60%;">
																<option>
																	请选择
																</option>
															</select>
														</td>
													</tr>
												</thead>
											</table>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12 center login-header">
											<h2>
												选择医生
											</h2>
										</div>
										<!--/span-->
									</div>
									<!--/row-->
									<div class="box-inner" style="margin-top: 10px;">
										<div style="margin: 5px auto; text-align: center;">
											<p style="color: red;">
												今天没有值班的医生，这里是找不到的哟
											</p>
										</div>
										<div class="box-content" style="text-align: center;">
											<div class="row doc-box">
											</div>
										</div>
									</div>

								</div>
								<div class="box col-lg-2 col-md-2"></div>
							</div>
						</div>

						<div id="regsuccess" class="box-content" style="display:none;">
							<div class="col-lg-12 col-md-12">
							<div class="row">
								<div class="col-md-12 center login-header">
									<h2 style="color: black; margin-top:10px; margin-bottom:10px;">
										请确认挂号信息
									</h2>
								</div>
								<!--/span-->
							</div>

							<div class="col-lg-12 col-md-12">
								<div class="row">
									<div class="box col-lg-2 col-md-2"></div>
									<div class="box col-lg-8 col-md-8">
										<div class="box-inner">
											<div class="box-content" style="text-align: center;">
												<table class="table table-bordered" style="font-size: 20px;">
													<thead>
														<tr>
															<th
																style="text-align: right; width: 50%; padding-right: 10%;">
																条目
															</th>
															<th style="width: 50%;">
																详细
															</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td
																style="text-align: right; width: 50%; padding-right: 10%;">
																挂号科室：
															</td>
															<td style="width: 50%;" id="reg_dep"></td>
														</tr>
														<tr>
															<td
																style="text-align: right; width: 50%; padding-right: 10%;">
																挂号医生：
															</td>
															<td style="width: 50%;" id="reg_doc"></td>
														</tr>
														<tr>
															<td
																style="text-align: right; width: 50%; padding-right: 10%;">
																挂号金额：
															</td>
															<td style="width: 50%;" id="reg_price"></td>
														</tr>
													</tbody>
												</table>
												<div class="row">
													<div class="col-sm-4 col-lg-3"></div>
													<div class="col-xs-6 col-sm-2 col-lg-3">
														<button class="btn_submit">
															确定
														</button>
													</div>
													<div class="col-xs-6 col-sm-2 col-lg-3">
														<button class="btn_cancel">
															取消
														</button>
													</div>
													<div class="col-sm-4 col-lg-3"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="box col-lg-2 col-md-2"></div>
								</div>
							</div>
							</div>
						</div>
						<div id="abc" class="col-lg-12 col-md-12" style="display:none;">

							<div class="row">
								<div class="col-md-12 center login-header">
									<h2>
										就诊信息(请等待)
									</h2>
								</div>
								<!--/span-->
							</div>
							<div class="row">
								<div class="box col-lg-2 col-md-2"></div>
								<div class="box col-lg-8 col-md-8">
									<div class="box-inner">
										<div class="box-content" style="text-align: center;">

											<table class="table" cellpadding="0" cellspacing="0"
												style="font-size: 20px;">
												<thead>
													<tr>
														<td
															style="text-align: right; width: 50%; padding-right: 10%;">
															当前科室：
														</td>
														<td class="a" style="width: 50%;">
															
														</td>
													</tr>
												</thead>
												<thead>
													<tr>
														<td
															style="text-align: right; width: 50%; padding-right: 10%;">
															当前医生：
														</td>
														<td class="b" style="width: 50%;" class="select">
															
														</td>
													</tr>
												</thead>
												<thead>
													<tr>
														<td
															style="text-align: right; width: 50%; padding-right: 10%;">
															位置：
														</td>
														<td class="c" style="width: 50%;">
															
														</td>
													</tr>
												</thead>
											</table>
										</div>
									</div>
								</div>
							</div>
					</div>
					
					
					
					<div id="chufangxinxi" class="col-lg-12 col-md-12" style="display:none;">

							<div class="row">
								<div class="col-md-12 center login-header">
									<h2>
										处方信息
									</h2>
								</div>
								<!--/span-->
							</div>
							<div class="row">
								<div class="box col-lg-2 col-md-2"></div>
								<div class="box col-lg-8 col-md-8">
									<div class="box-inner">
										<div id = "con" class="box-content" style="text-align: center;">
											<table class="table center">
												<thead>
													<tr>
														<td>
															药品名称
														</td>
														<td>
															数量
														</td>
														<td>
															单价
														</td>
													</tr>
												</thead>
												<tbody id="chufangyaopin">
													
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
					</div>
					
					
					<div id="erweima" class="col-lg-12 col-md-12" style="display:none;">

							<div class="row">
								<div class="col-md-12 center login-header">
									<h2>
										请到领药处扫码领药
									</h2>
								</div>
								<!--/span-->
							</div>
							<div id="output" class="center">aaa</div>
							
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<!-- 下方的四个盒子 -->
	<div class=" row">
		<div class="col-md-3 col-sm-3 col-xs-6 btn5">
			<a title="6 new members." class="well top-block" href="#"> <i
				class="glyphicon glyphicon-user blue"></i>
				<div>
					Total Members
				</div>
				<div>
					507
				</div> </a>
		</div>

		<div class="col-md-3 col-sm-3 col-xs-6 btn6">
			<a title="4 new pro members." class="well top-block" href="#"> <i
				class="glyphicon glyphicon-star green"></i>
				<div>
					Pro Members
				</div>
				<div>
					228
				</div> </a>
		</div>

		<div class="col-md-3 col-sm-3 col-xs-6 btn7">
			<a title="$34 new sales." class="well top-block" href="#"> <i
				class="glyphicon glyphicon-shopping-cart yellow"></i>
				<div>
					Sales
				</div>
				<div>
					$13320
				</div> </a>
		</div>

		<div class="col-md-3 col-sm-3 col-xs-6 btn8">
			<a title="12 new messages." class="well top-block" href="#"> <i
				class="glyphicon glyphicon-envelope red"></i>
				<div>
					Messages
				</div>
				<div>
					25
				</div> </a>
		</div>
	</div>


	<footer class="row">
	<p class="col-md-9 col-sm-9 col-xs-12 copyright">
		&copy;
		<a href="http://usman.it" target="_blank">Muhammad Usman</a> 2012 -
		2015
	</p>

	<p class="col-md-3 col-sm-3 col-xs-12 powered-by">
		Powered by:
		<a href="http://usman.it/free-responsive-admin-template">Charisma</a>
	</p>
	</footer>


	<!-- external javascript -->
	<script src="js/jquery-2.0.0.min.js" type="text/javascript"></script>
	<!--  -->
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
	<!-- 进行ajax异步加载访问 -->
	<script type="text/javascript" src="js/registration.js"></script>
	<!-- 二维码生成 -->
	<script src="js/jquery.qrcode.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
</body>
</html>
