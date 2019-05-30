<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>

<meta charset="utf-8">
<title>商品管理</title>

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
<style>
*{ margin: 0px; padding: 0px; list-style: none; text-decoration: none;}
table p{ overflow:  hidden}
img{ cursor:pointer}
.goodsid{ display: none}
.pagegood{ float: right;margin-right: 200px;}
</style>
</head>
<body>
    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>
        <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-12">
                   <h2 class="page-header"><span style="color:blue;">查看所有商品</span></h2>
               </div>
           </div>
           	 <div class="row">
           	 <div class="col-lg-12">
          		  </div>
          	 </div>
                <div class="row show">
                  <!-- 显示所有商品 -->
                </div>
                <div class="pagegood">
                </div>
               
             </div>
        </div>
        <!-- 修改商品 -->
	<div class="panel-body ">
	<button class="btn btn-primary updatetx" data-toggle="modal"
			data-target="#updatetx" style="display:none"></button>
		<div class="modal fade" id="updatetx" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">修改标签</h4>
					</div>
					<div class="modal-body context">
						<div class="row">
							<div class="col-lg-2 col-md-1"></div>
							<div class="col-lg-8 col-md-10">
								<div class="form-group">
									 商品名称<input type="text" class="form-control spmc" name="goodsName"  placeholder="商品名称">
									<p class="help-block " style="color:red;"></p>
								</div>
								<div class="form-group">
									<label>需要爱心数</label>
									<input class="form-control xyaxs" type="text" name="loveNumber" placeholder="需要爱心数"/>
								</div>
								<div class="form-group">
									<label>是否下架</label>
									<input type="text" name="goods.id" class="goodsid" />
									 <select class="form-control select" name="goods.shelvesStatus">
               				 		</select>  
               				 	</div>
								<div class="form-group">
									<label id="tx" style="color:red"></label>
								</div>
							</div>
							<div class="col-lg-2 col-md-1"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" onclick="upGoods()" class="btn btn-default submit savel">保存标签信息</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
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
								<p>删除商品，会将该商品对应的兑换记录删除！！ 您确定要删除吗？？</p>
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
	
	<!-- 修改提醒框 -->
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
								<p class="successs">修改成功</p>
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
                       	该商品已被删除
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
<!-- 自定义js -->
<script type="text/javascript" src="<%=basePath %>pagefile/js/goods.js"></script>
</body>
</html>

