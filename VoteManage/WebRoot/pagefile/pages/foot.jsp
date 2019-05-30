<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="panel-body ">
		<button class="btn btn-primary updatetan1 hidden" data-toggle="modal"
			data-target="#updateModal"></button>
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<form method="post" class="form1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改标签</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
							<div class="col-lg-2 col-md-1"></div>

							<div class="col-lg-8 col-md-10">
							
							<div class="form-group">
									<label>编号</label> <input class="form-control adminId"  
										name="admin.id" placeholder="编号">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>账号</label> <input class="form-control manageAccount"  
										name="admin.manageAccount" placeholder="账号" value="${sessionScope.loginAdmin.manageAccount }">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>名称</label> <input  class="form-control names"  
										name="admin.name" placeholder="名称" />
									<p class="help-block " style="color:red;" ></p>
								</div>
								<p class="mesage2" style="color:red"></p>
							</div>
							<div class="col-lg-2 col-md-1" ></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default submit savel" onclick="updateAdminMes()">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					
				</div></form>
			</div>
		</div>
	<!--修改提醒 -->
	<div class="panel-body ">
		<button class="btn btn-primary updatetx1 hidden" data-toggle="modal"
			data-target="#updatetx"></button>
		<div class="modal fade" id="updatetx" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">提醒框</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
						<div class="col-lg-8 col-md-10">
								<div class="form-group">
								<p class="successs1"></p>
								</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	
		<!--修改密码-->
	<div class="panel-body ">
		<button class="btn btn-primary uppassword1 hidden" data-toggle="modal"
			data-target="#uppassword"></button>
		<div class="modal fade" id="uppassword" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<form method="post" class="form1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改标签</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
							<div class="col-lg-2 col-md-1"></div>

							<div class="col-lg-8 col-md-10">
							
							<div class="form-group">
									<label>原密码</label> <input class="form-control ypwd"  
										 placeholder="原密码">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>新密码</label> <input class="form-control newpwd"  
										 placeholder="新密码" >
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>确认密码</label> <input  class="form-control new2pwd"  
										 placeholder="确认密码" />
									<p class="help-block " style="color:red;" ></p>
								</div>
								<p class="mesage3" style="color:red"></p>
							</div>
							<div class="col-lg-2 col-md-1" ></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default submit savel" onclick="updapassword()">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					
				</div></form>
			</div>
		</div>

<!-- jQuery -->
<script src="<%=basePath %>pagefile/vendor/jquery/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath %>pagefile/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<%=basePath %>pagefile/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<%=basePath %>pagefile/dist/js/sb-admin-2.js"></script>

<!-- menu JavaScript -->
<script src="<%=basePath %>pagefile/js/menu.js"></script>

<script src="<%=basePath %>pagefile/js/foot.js"></script>
