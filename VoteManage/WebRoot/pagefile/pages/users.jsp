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
<title>用户管理</title>

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
    	.ri{ float:right;}
    </style>
    
</head>
<body>
<input type="hidden" class="ret" value="${manage }"/>
    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
           <div class="row">
               <!-- 标签导航 -->
               	<h3 class="page-header" id="h3">
               		<span style="color:blue; float:left; margin-right: 10px;">查看标签用户 </span>
               		<p class="ri">
                		<button class="btn btn-info" data-toggle="modal" data-target="#addzuser">添加正常用户</button>
                		<button class="btn btn-info" data-toggle="modal" data-target="#addjuser">添加机器人用户</button>
               		</p>
               		<div style="clear: both;"></div>
              	</h3>
           </div>
                <div class="row">
                    <div class="col-lg-12">
                    
                 <div><select class="form-control selectConditions" style="width:9%;display: inline;">
                 	<option value="id">用户id</option>
                 	<option value="userName">用户姓名</option>
                 	<option value="tel">用户电话号码</option>
                 </select><input type="text" class="form-control selectUser" placeholder="请输入" style="width: 11%;display: inline;">
                 <span class="UserTX"></span>
                 <button id="button" class="btn btn-danger" style="margin:10px 10px 10px 0;">点击查询</button>
                 <button onclick="getAllUser()" class="btn btn-danger">查询全部</button></div> 
                 
               查看用户<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>编号</th>
						<th>用户类型</th>
						<th>姓名</th>
						<th>得票总数</th>
						<th>拥有宝箱总数</th>
						<th>拥有爱心总数</th>
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
        
        
        
        
        
<!-- 添加机器人 -->
<div class="panel-body ">
		<div class="modal fade" id="addjuser" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">添加机器人用户</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
						<div class="col-lg-8 col-md-10">
							<form id="fo1" action="/VoteManage/addUser.action" method="post" role="form" enctype="multipart/form-data">
								<input type="hidden" name="users.userType" value="1"/>
								<div class="form-group">
	                                <label>添加人数</label>
	                                <input class="form-control" value="1" name="userNumber"/>
	                                <p>添加人数超过一个，系统将会为所有剩余的用户分配用户名，添加后缀 1~n</p>
	                            </div>
	                            <div class="form-group">
	                                <label>用户名</label>
	                                <input class="form-control name1" placeholder="用户名" name="users.userName"/>
	                                <p class="help-block" style="color:red; display: none;">用户名不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label>用户密码</label>
	                                <input class="form-control pwd1" placeholder="密码" name="users.userPassword">
	                                <p class="help-block" style="color:red; display: none;">密码不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label>生日</label>
	                                <input class="form-control bir1" type="date" name="users.birthday">
	                                <p class="help-block" style="color:red; display: none;">生日不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                            	<label>请选择图片</label>
	                                <div class="imgDiv">
			                        	<input type="file" id="a11" name='file' onchange="javascript:setImagePreviews('a1','b1','50px','50px');" />
			                        	<div id="b11" class="imgView"></div>
		                        	</div>
	                            </div>
	                            
	                            <div style="height: 20px;"></div>
	                           
	                            <div class="form-group">
	                                <p class="help-block help1" style="color:red; display: none;">您的输入有问题，请排除所有的问题后提交</p>
	                            </div>
	                        </form>
						</div>
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-outline btn-success save1">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
</div>



<!-- 添加正常用户 -->
<div class="panel-body ">
		<div class="modal fade" id="addzuser" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">添加正常用户</h4>
					</div>
					
					<div class="modal-body context">
						<div class="row">
						<div class="col-lg-8 col-md-10">
							<form id="fo" action="/VoteManage/addUser.action" method="post" role="form" enctype="multipart/form-data">
								<input type="hidden" name="users.userType" value="0"/>
								<div class="form-group">
	                                <label>添加人数</label>
	                                <input class="form-control" value="1" name="userNumber"/>
	                                <p>添加人数超过一个，系统将会为所有剩余的用户分配用户名，添加后缀 1~n</p>
	                            </div>
	                            <div class="form-group">
	                                <label>用户名</label>
	                                <input class="form-control name" placeholder="用户名" name="users.userName"/>
	                                <p class="help-block" style="color:red; display: none;">用户名不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label>用户密码</label>
	                                <input class="form-control pwd" placeholder="密码" name="users.userPassword">
	                                <p class="help-block" style="color:red; display: none;">密码不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label>生日</label>
	                                <input class="form-control bir" type="date" name="users.birthday">
	                                <p class="help-block" style="color:red; display: none;">生日不能为空</p>
	                            </div>
	                            
	                            <div class="form-group">
	                            	<label>请选择图片</label>
	                                <div class="imgDiv">
			                        	<input type="file" id="a1" name='file' onchange="javascript:setImagePreviews('a1','b1','50px','50px');" />
			                        	<div id="b1" class="imgView"></div>
		                        	</div>
	                            </div>
	                            
	                            <div style="height: 20px;"></div>
	                           
	                            <div class="form-group">
	                                <p class="help-block help" style="color:red; display: none;">您的输入有问题，请排除所有的问题后提交</p>
	                            </div>
	                        </form>
						</div>
					</div>
					
					<div class="modal-footer">
						<button type="button" class="btn btn-outline btn-success save">保存</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>


<div class="panel-body">
    <!-- Button trigger modal -->
    <button class="btn btn-primary btn-lg hidden" data-toggle="modal" data-target="#updateUser">
        修改按钮点击事件执行按钮
    </button>
    <!-- Modal -->
    <div class="modal fade" id="updateUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
                </div>
                <div class="modal-body">
					<form role="form">
	                    <div class="form-group">
	                        <label>用户昵称</label>
	                        <input class="form-control">
	                        <p class="help-block">昵称不能为空</p>
	                    </div>
	                    <div class="form-group">
	                        <label>微信号</label>
	                        <input class="form-control" placeholder="Enter text">
	                    </div>
	                    <div class="form-group">
	                        <label>真实姓名</label>
	                        <input class="form-control" placeholder="Enter text">
	                    </div>
	                    <div class="form-group">
	                        <label>生日</label>
	                        <input type="date">
	                    </div>
	                    <div class="form-group">
	                        <label>电话</label>
	                        <input class="form-control" placeholder="Enter text">
	                    </div>
	                </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    
    
    <!-- Button trigger modal -->
    <button class="btn btn-primary btn-lg hidden" data-toggle="modal" data-target="#deleteUser">
        删除按钮点击事件执行按钮
    </button>
    <!-- Modal -->
    <div class="modal fade" id="deleteUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">删除用户提醒</h4>
                </div>
                <div class="modal-body">
                    <form action="">
                    	<input type="hidden" name="" value=""/>
                    </form>
                    <div class="alert alert-info">
                    	您确定要删除该用户吗？，，客户信息至关重要要，请谨慎操作！
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary">确定</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    
    <!-- Button trigger modal -->
	<button class="btn btn-primary btn-lg tan hidden" data-toggle="modal" data-target="#myModal"></button>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="myModalLabel">添加提醒</h4>
	            </div>
	            <div class="modal-body context">
	                
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default closeTan" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
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
                       	该用户已被删除
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
	<jsp:include page="foot.jsp"/>
	<script type="text/javascript" src="<%=basePath%>pagefile/js/ImgPreview.js"></script>
	<script type="text/javascript" src="<%=basePath%>pagefile/js/addUser.js"></script>
	<script type="text/javascript" src="<%=basePath%>pagefile/js/users.js"></script>
</body>

</html>
