<%@page import="com.accp.demo.Doctor"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>医生就诊</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
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
	<style>
	li{ list-style:none;}
	</style>
</head>

<body>
    
    <c:if test="${sessionScope.doctor == null}">
		<script>
			alert("您还没有登录，请登录");
			window.location.href = "/HospitalManagement/JSP/doclogin.jsp";
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
					请确认您的药方信息
				</h3>
			</div>
			<div id="error" class="modal-body">
			
				<form action="/HospitalManagement/DoctorOffer?opr=add" method="post"></form>
					<table id="tanchuang" class="table" cellpadding="0" cellspacing="0"
						style="font-size: 20px;">				
					</table>
		
			</div>
			<div class="modal-footer">
				<a href="#" id="callNo" class="btn btn-default"
					data-dismiss="modal">取消</a>
				<a href="#" id="callYes" class="btn btn-primary"
					data-dismiss="modal">确认</a>
					
			</div>
				</form>
		</div>				
	</div>
</div>
    
    
    
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#">工号：</a></li>
                <li>
                    <a href="#"><c:if test="${sessionScope.doctor != null}">
					
					<%=((Doctor) session.getAttribute("doctor")).getDocId()%>
					</c:if></a>
                </li>
                <li>                   
                </li>
                 <li><a href="#">姓名：</a></li>
                <li>
                    <a href="#"><c:if test="${sessionScope.doctor != null}">
					
					<%=((Doctor) session.getAttribute("doctor")).getTrueName()%>
					</c:if></a>
                </li>
                <li><a href="#">职务：</a></li>
                <li>
                    <a href="#"><c:if test="${sessionScope.doctor != null}">
					
					<%=((Doctor) session.getAttribute("doctor")).getDuty()%>
					</c:if></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                
                    <ul id = "table" class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">挂号信息</li>
                    </ul>                    
                </div>
            </div>
        </div>
        <!--/span-->        

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            
            
<div class="row">
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                 
                <h2>				
					<ul class="collapse navbar-collapse nav navbar-nav" style="position:relative; top:-5px;">
		                <li><a href="#">姓名：</a></li>
		                <li id="patName">
		                </li>
		                <li>                   
		                </li>
		                 <li><a href="#">性别：</a></li>
		                <li id="patSex">
		                </li>
		                <li><a href="#">年龄：</a></li>
		                <li id="patAge">
		                </li>
		                <input type="hidden" id="regId"/>
			        </ul>  
				</h2>
							
                <div class="box-icon">
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content row">
            	
            	<div class="box-content" style="text-align: center;">
	            	<table class="table table-bordered" width="100%">
						<tbody>
							<tr>
								<td valign="middle" style="text-align:center;">过敏病史</td>
								<td colspan="2" id = "guomin" width=70%></td>
							</tr>
							<tr>
								<td valign="middle" style="text-align:center;">遗传病史</td>
								<td colspan="2" id = "yichuan" width=70%></td>											
							</tr>
						</tbody>
					</table>
				</div>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-info-sign"></i> 病例处方</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content row">
                <div class="col-lg-12 col-md-12">
					<div class="row">
						<div class="box col-lg-2 col-md-2"></div>
						<div class="box col-lg-8 col-md-8">
							<div class="box-inner">
								<div class="box-content" style="text-align: center;">
									<table id="disease" class="table table-bordered" width="100%">
										<tbody>
											<tr>
												<td valign="middle" style="text-align:center;">主诉</td>
												<td colspan="2"><textarea id = "sympton"  rows=8 style="display:block; width:100%;"></textarea></td>
											</tr>
											<tr>
												<td valign="middle" style="text-align:center;">
													药方
												</td>
												<td colspan="2"><textarea id = "yaofang"  rows=8 style="display:block; width:100%; font-size:25px;"></textarea></td>
											</tr>
										</tbody>
									</table>
									
									<div class="row">
										<div class="col-sm-4 col-lg-3"></div>
										<div class="col-xs-6 col-sm-2 col-md-3">
											<button class="btn_submit">
												确定
											</button>
										</div>
										
										<div class="col-xs-6 col-sm-2 col-md-3">
											<button class="btn_cancel">
												清空
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
    </div>
</div>
</div>

<!-- external javascript -->

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
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
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

<script src="js/doctor.js"></script>


</body>
</html>
