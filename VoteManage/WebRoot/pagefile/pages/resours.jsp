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
<title>权限管理</title>

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
    
    <style type="text/css">
    </style>
    
</head>
<body>
<body>
<input type="hidden" class="ret" value="${manage }"/>
<input type="hidden" class="rets" value="${flush }"/>
    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
           <div class="row">
               <!-- 权限 -->
                 	<h3 class="page-header" id="h3">
                 		<span style="color:blue; float: left;">权限管理（您只能查看和操作您自己所有拥有的权限）</span>
                 		<button class='btn btn-info' data-toggle="modal" data-target="#add" style="float: right; margin-right: 20px;">添加权限</button>
                 		<div style="clear: both;"></div>
                	</h3>
           </div>
                <div class="row">
                    <div class="col-lg-12">
               查看权限<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>id</th>
						<th>权限名称</th>
						<th>权限等级</th>
						<th>最后一次修改人</th>
						<th>最后一次修改时间</th>
						<th>创建人</th>
						<th>创建时间</th>
						<th>是否被删除</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
			<div class="pagenum"></div>
                    
            </div>
		
                </div>
            
            </div>
        </div>
        
 <div class="panel-body">
	<!-- Button trigger modal -->
	<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">添加权限</h4>
	            </div>
	            <form action="/VoteManage/addRes.action" method="post" id="addForm">
		            <div class="modal-body context">
		            	<div class="alert alert-success">
	                       	请输入权限名称：<input class="form-control" name="res.resName"/>
	                       	<p style="display:none;">权限名称不能为空</p>
	                   </div>
			            <div class="alert alert-info">
		                  	请输入访问地址：<input class="form-control addName" name="res.resAddress"/>
		                  	<p>访问地址不能为空</p>
		                </div>
		                <div class="alert alert-info">
		                  	请输入当前权限等级：<input class="form-control resGrade" name="res.resGrade"/>
		                  	<p>权限等级不能为空</p>
		                </div>
		                <div class="alert alert-info parentGrade" style="display:none;">
		                	权限等级不为1，请选择父级权限：
		                	<p>以下权限都是您可以操作的<span class="showGrade">1</span>级权限</p>
		                  	<select class="form-control parentSelect" name="res.resourceByParent.id">
                            </select>
		                </div>
	                </div>
                </form>
	            
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-info addSave">提交</button>
	                <button type="button" class="btn btn-default closeTan" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
<!-- /.modal -->
</div>       
        
<div class="panel-body">
	<!-- Button trigger modal -->
	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">修改权限</h4>
	            </div>
	            <div class="modal-body context">
		            <div class="alert alert-info">
			            <form action="/VoteManage/updRes.action" method="post" id="updateForm">
			            	<input type="hidden" name="res.id"/>
			            
                             <div class="form-group">
                                 	权限名称
                                 <input class="form-control resName" type="text" name="res.resName"/>
                                 <p class="tishi">权限名称不能为空</p>
                             </div>
	                    	<div class="form-group">
                                 	访问地址
                                 <input class="form-control resAddress" type="text" name="res.resAddress"/>
                                 <p class="tishi">访问地址不能为空</p>
                             </div>
                             <div class="form-group">
                                 	权限等级
                                 <input class="form-control resRank" type="text" name="res.resStatic"/>
                                 <p class="tishi">等级不能为空</p>
                             </div>
                             <div class="form-group parentRes">
                             <input type="hidden" id="parId">
                                 	父级权限
                                 <select class="form-control" name="res.resourceByParent.id">
                            	 </select>
                             </div>
		                </form>
	                </div>
	                <div class="alert alert-warning submitTishi">
                       <p>如果您看到这条信息，请确定所有的信息填写完整！</p>
                   </div>
	            </div>
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-default updateSave">提交</button>
	                <button type="button" class="btn btn-default closeTan" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
<!-- /.modal -->
</div>

<div class="panel-body">
	<!-- Button trigger modal -->
	<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">删除提醒</h4>
	            </div>
	            <div class="modal-body context">
	               <div class="alert alert-success">
                       	当前的权限信息，您确定要删除吗？
                       	<form action="/VoteManage/delRes.action" method="post" id="deleteForm">
                       		<input type="hidden" id="deleteId" name="res.id"/>
                       	</form>
                   </div>
	            </div>
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-info" onclick="$('#deleteForm').submit();">确定</button>
	                <button type="button" class="btn btn-default closeTan" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
<!-- /.modal -->
</div>    

<div class="panel-body">
<button class="btn btn-info tixingTan" data-toggle="modal" data-target="#tixing" style="display: none;">456</button>
	<!-- Button trigger modal -->
	<div class="modal fade" id="tixing" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">操作提醒</h4>
	            </div>
	            <div class="modal-body context">
	               <div class="alert alert-success abc">
                       	操作正在执行
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
                       	该用户已被删除
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
	<jsp:include page="foot.jsp"/>
	
	<script type="text/javascript" src="<%=basePath %>pagefile/js/resours.js"></script>
</body>

</html>
