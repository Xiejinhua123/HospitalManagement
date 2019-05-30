<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>游戏管理</title>

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

    <div id="wrapper"> 
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-12"><h1><span style="color:blue;">开宝箱奖项设置</span></h1></div>
           </div>
           <div class="panel panel-default">
               <div class="panel-heading">
                  	<h4 style="float:left;">开宝箱奖项设置</h4>
                  	<button style="float: right;" type="button" onclick="add()" class="btn btn-danger">添加</button>
                  	<div style="clear: both;"></div>
               </div>
               <!-- /.panel-heading -->
               <div class="panel-body">
               		<div class="table-responsive">
                         <table class="table table-striped table-bordered table-hover">
                             <thead>
                                 <tr>
                                     <th>编号</th>
                                     <th>爱心数量</th>
                                     <th>宝箱数量</th>
                                     <th>商品名称</th>
                                     <th>商品数量</th>
                                     <th>龙珠名称</th>
                                     <th>龙珠数量</th>
                                     <th>参与奖</th>
                                     <th>概率</th>
                                     <th>是否被删除</th>
                                     <th>操作</th>
                                 </tr>
                             </thead>
                             <tbody class="dragin">
                               <!-- 奖励信息 -->
                             </tbody>
                         </table>
                          <div class="pagegood">
                	</div>
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
								<p>删除此标签,您确定要继续么？</p>
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
									<label>爱心数量</label> <input class="form-control updateName"  
										name="ax" placeholder="爱心数量">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>宝箱数量</label>
									<input class="form-control updateName"  
										name="box" placeholder="宝箱数量">
								</div>
								<div class="form-group">
									<label>商品名称</label>
									<select class="form-control goodsNameInput" name="ball">
									
									</select>
								</div>
								<div class="form-group">
									<label>商品数量</label>
									<input class="form-control updateName"  
										name="goodsNumber" placeholder="商品数量">
								</div>
								<div class="form-group">
									<label>龙珠名称</label>
									<select class="form-control ballInput" name="ball">
										<option value="无">无</option>
										<option value="一星珠">一星珠</option>
										<option value="二星珠">二星珠</option>
										<option value="三星珠">三星珠</option>
										<option value="三星珠">三星珠</option>
										<option value="五星珠">五星珠</option>
										<option value="六星珠">六星珠</option>
										<option value="七星珠">七星珠</option>
									</select>
								</div>
								<div class="form-group">
									<label>龙珠数量</label>
									<input class="form-control updateName"  
										name="ballNumber" placeholder="龙珠名称">
								</div>
								<div class="form-group">
									<label>参与奖</label>
									<input class="form-control updateName"  
										name="cyj" placeholder="参与奖">
								</div>
								<div class="form-group">
									<label>概率</label>
									<input class="form-control updateprobability"  
										name="probability" placeholder="概率">
								</div>
								<div class="mesage" style="color:red;font-size:18px"></div>
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
<!-- 修改 -->
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
	
	<!-- 添加 -->
	<div class="panel-body ">
		<button class="btn btn-primary updatetan1" data-toggle="modal"
			data-target="#updateModal1"></button>
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加游戏奖励</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
							<div class="col-lg-2 col-md-1"></div>

							<div class="col-lg-8 col-md-10">
								<div class="form-group">
									<label>爱心数量</label> <input class="form-control updateName"  
										name="ax1" placeholder="爱心数量">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>宝箱数量</label>
									<input class="form-control updateName"  
										name="box1" placeholder="宝箱数量">
								</div>
								<div class="form-group">
									<label>商品名称</label>
									<select class="form-control goodsNameInput1" name="ball">
									
									</select>
								</div>
								<div class="form-group">
									<label>商品数量</label>
									<input class="form-control updateName"  
										name="goodsNumber1" placeholder="商品数量">
								</div>
								<div class="form-group">
									<label>龙珠名称</label>
									<select class="form-control ballInput1" name="ball">
										<option value="无">无</option>
										<option value="一星珠">一星珠</option>
										<option value="二星珠">二星珠</option>
										<option value="三星珠">三星珠</option>
										<option value="三星珠">三星珠</option>
										<option value="五星珠">五星珠</option>
										<option value="六星珠">六星珠</option>
										<option value="七星珠">七星珠</option>
									</select>
								</div>
								<div class="form-group">
									<label>龙珠数量</label>
									<input class="form-control updateName"  
										name="ballNumber1" placeholder="龙珠名称">
								</div>
								<div class="form-group">
									<label>参与奖</label>
									<input class="form-control updateName"  
										name="cyj1" placeholder="参与奖">
								</div>
								<div class="form-group">
									<label>概率</label>
									<input class="form-control updateName"  
										name="probability1" placeholder="概率">
								</div>
								<div class="mesage1" style="color:red;font-size:18px"></div>
							</div>
							<div class="col-lg-2 col-md-1"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default submit" name="" onclick="save()">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
                       	该奖项已被删除
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
<script type="text/javascript" src="<%=basePath %>pagefile/js/box.js"></script>
</body>
</html>

