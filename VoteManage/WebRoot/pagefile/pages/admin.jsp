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
<title>管理员管理</title>

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
<input type="hidden" class="ret" value="${manage }"/>
<input type="hidden" class="rets" value="${flush }"/>
<input type="hidden" class="sessionrank" value="${sessionScope.loginAdmin.rank }"/>

    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
           <div class="row">
               <!-- 标签导航 -->
              	<h3 class="page-header" id="h3">
              		<span style="color:blue; float: left;">管理员(您所查看的管理员是级别不高于您的管理员) </span>
              		<button class="btn btn-info tan" data-toggle="modal" data-target="#add" style="float: right; margin-right: 20px;"> 添加管理员</button>
              		<div style="clear: both;"></div>
             	</h3>
           </div>
                <div class="row">
                    <div class="col-lg-12">
               查看用户<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>id</th>
						<th>姓名</th>
						<th>用户等级</th>
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
	                <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
	            </div>
	            <div class="modal-body context">
	            	<div class="alert alert-success">
                       	当前用户默认密码:123456
                   </div>
	            <div class="alert alert-info">
	            <form action="/VoteManage/addAdmin.action" method="post" id="addForm">
                    	请输入用户名：<input class="form-control addName" name="admin.name"/>
                    	<p style="display:none;">用户名不能含有空格，不能为空</p>
                </form>
                </div>
	            </div>
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
	                <h4 class="modal-title" id="myModalLabel">修改提醒</h4>
	            </div>
	            <div class="modal-body context">
		            <div class="alert alert-info">
			            <form action="/VoteManage/updAdmin.action" method="post" id="updateForm">
			            	<input type="hidden" name="admin.id"/>
			            	<!-- 
                             <div class="form-group">
                                 	请输入原密码
                                 <input class="form-control old" type="password"/>
                                 <p class="tishi">密码不能为空</p>
                             </div>
	                    	<div class="form-group">
                                 	请输入新密码
                                 <input class="form-control pwd" type="password" name="admin.managePassword"/>
                                 <p class="tishi">密码不能为空</p>
                             </div>
                             <div class="form-group">
                                 	确认密码
                                 <input class="form-control repwd" type="password"/>
                                 <p class="tishi">两次输入密码不一致</p>
                             </div> -->
                             <div class="form-group">
                                 	真实姓名
                                 <input class="form-control name" name="admin.name"/>
                                 <p class="tishi">真实姓名不能为空,并且不能有空格</p>
                             </div>
                             <input class="rank oldRank" type="hidden"/>
                             <div class="form-group">
                                 	用户等级
                                 <input class="form-control rank newRank" name="admin.rank"/>
                                 <p class="tishi">您选择的用户等级不正确，只能不高于比操作员等级低</p>
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
                       	管理员资料将会全部被删除，您确定要删除吗？
                       	<form action="/VoteManage/delAdmin.action" method="post" id="deleteForm">
                       		<input type="hidden" name="admin.id"/>
                       	</form>
                   </div>
	            </div>
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-info deleteSave">确定</button>
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
	<div class="modal fade" id="resource" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">权限操作</h4>
	            </div>
	            <div class="modal-body context">
	               <div class="alert alert-success">
	               		您所能操作的权限是您所拥有的，您没有的权限不能进行操作！
	               </div>
	               <div class="alert alert-success level1">
	               		
	               </div>
	            </div>
	            <div class="modal-footer">
	            	<button type="button" class="btn btn-info" onclick='updateResource()'>确定</button>
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
	               <div class="alert alert-success">
                       	该管理员已被删除
                   </div>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
	</div>
<!-- /.modal -->
</div>       


	<!-- 权限操作提醒 -->
<div class="panel-body">
<button class="btn btn-info suces" data-toggle="modal" data-target="#suces" style="display: none;">456</button>
	<!-- Button trigger modal -->
	<div class="modal fade" id="suces" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">权限操作</h4>
	            </div>
	            <div class="modal-body context">
	               <div class="alert alert-success abcd">
                      修改成功
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
	<script type="text/javascript" src="<%=basePath%>pagefile/js/admin.js"></script>
</body>

</html>
