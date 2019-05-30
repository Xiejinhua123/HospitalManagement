<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<style>
.pagenum{float: right;margin-right: 200px}
</style>
<head>
<meta charset="utf-8">
<title>文章管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath %>pagefile/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath %>pagefile/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%=basePath %>pagefile/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=basePath %>pagefile/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath %>pagefile/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath %>pagefile/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<body>
    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
           <div class="row">
                 	<h3 class="page-header" id="h3">
                 		<span style="color:blue; float:left; margin-right: 10px;">查看文章 </span>
                	</h3>
           </div>
                <div class="row">
                    <div class="col-lg-12">
                    <select class="form-control selectArti" style="width:7%;display: inline;">
                    <option value="id">编号</option>
                    <option value="title">标题</option>
                    <option value="name">作者</option>
                    </select><input type="text" class="form-control selectUser" placeholder="请输入" style="width: 11%;display: inline;">
                <button type='button' class='btn btn-info ri' onclick='selectm()'>查询</button>
                    
            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>id</th>
						<th>标题</th>
						<th>作者</th>
						<th>创建时间</th>
						<th>得票总数</th>
						<th>是否被删除</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<!-- 分页 -->
			<div class="pagenum"></div>
                    
            </div>
                </div>
            </div>
        </div>
     <!-- 删除提醒 -->
	<div class="panel-body ">
		<button class="btn btn-primary delltetx" data-toggle="modal"
			data-target="#deltx" style="display:none"></button>
		<div class="modal fade" id="deltx" >
			<div class="modal-dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">删除</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
						<div class="col-lg-8 col-md-10">
								<div class="form-group">
								<p>删除文章，删除后不可恢复！！ 您确定要删除吗？？</p>
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
	</div></div></div>
	
	<!-- 错误提醒框 -->
<div class="panel-body ">
		<button class="btn btn-primary updatetxk" data-toggle="modal"
			data-target="#updatetxk"></button>
		<div class="modal fade" id="updatetxk" >
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
	<jsp:include page="foot.jsp"/>
	<script type="text/javascript" src="<%=basePath %>pagefile/js/listArticles.js"></script>
</body>

</html>
