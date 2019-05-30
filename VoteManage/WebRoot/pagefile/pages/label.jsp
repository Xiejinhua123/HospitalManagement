<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>标签管理</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=basePath%>pagefile/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath%>pagefile/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="<%=basePath%>pagefile/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- Social Buttons CSS -->
<link
	href="<%=basePath%>pagefile/vendor/bootstrap-social/bootstrap-social.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=basePath%>pagefile/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath%>pagefile/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=basePath%>pagefile/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
.tan {
	float: right;
	margin-right: 20px;
}

.details {
	margin-left: 5px;
	text-align: center;
}

.lableEvent {
	height: 180px;
	overflow: hidden;
}
.pagenum{float: right;margin-right: 200px;  }
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="top.jsp" />
		<jsp:include page="menu.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">
						<span style="color:blue;">标签管理</span>

						<!-- Button trigger modal -->
						<button class="btn btn-primary tan" data-toggle="modal"
							data-target="#addModal">添加标签</button>
					</h2>
			
					<div class="panel panel-default">
						<div class="panel-heading">查看所有的投票标签</div>
					</div>
					<div class="row show">

					<!-- row show -->
					</div>
					<div class="pagenum">
					
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- 添加标签 -->
	<div class="panel-body">
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加标签</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
							<div class="col-lg-2 col-md-1"></div>

							<div class="col-lg-8 col-md-10">
								<div class="form-group">
									<label>标签名称</label> <input class="form-control"
										name="lableName" placeholder="标签名称">
									<p class="help-block checkname" style="color:red;"></p>
								</div>

								<div class="form-group">
									<label>标签描述</label>
									<textarea class="form-control" name="event" rows="5"></textarea>
									<p class="help-block checkevevt" style="color:red;"></p>
								</div>
							</div>
							<div class="col-lg-2 col-md-1"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default submit"
							id="saveLable">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>

	<!-- 修改标签 -->
	<div class="panel-body ">
		<button class="btn btn-primary updatetan" data-toggle="modal"
			data-target="#updateModal"></button>
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
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
									<label>标签名称</label> <input class="form-control updateName"  
										name="lableName" placeholder="标签名称">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>标签描述</label>
									<textarea class="form-control updms" name="event" rows="5"></textarea>
								</div>
							</div>
							<div class="col-lg-2 col-md-1"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default submit savel" name="">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 删除提醒 -->
	<div class="panel-body ">
		<button class="btn btn-primary deletetx" data-toggle="modal"
			data-target="#del"></button>
		<div class="modal fade" id="del" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">删除</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
						<div class="col-lg-8 col-md-10">
								<div class="form-group">
								<p>
								
								删除该标签的时候，用户已经产生的对于该标签的投票记录，将会一并删除！！！您确定要删除吗？
								
								</p>
								</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default determines">确定</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!--修改提醒 -->
	<div class="panel-body ">
		<button class="btn btn-primary updatetx" data-toggle="modal"
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
								<p class="successs"></p>
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
	
	<!-- 错误提醒 -->
<div class="panel-body">
<button class="btn btn-info error" data-toggle="modal" data-target="#error" style="display: none;">456</button>
	<!-- Button trigger modal -->
	<div class="modal fade" id="error" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">错误提醒</h4>
	            </div>
	            <div class="modal-body context">
	               <div class="alert alert-success abc">
                       	该标签已被删除
                   </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default closeTan" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
<!-- /.modal -->
</div>
<jsp:include page="foot.jsp" />
<!-- 自定义js -->
<script type="text/javascript" src="<%=basePath %>pagefile/js/lable.js"></script>

</body>
</html>
