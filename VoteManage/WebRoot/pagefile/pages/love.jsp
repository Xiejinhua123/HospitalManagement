<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>爱心管理</title>

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
               <div class="col-lg-12">
                   <h2 class="page-header"><span style="color:blue;">爱心管理中心</span></h2>
               </div>
           </div>
           
           <div class="row">
           		 <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> 爱心信息
                        </div>
                        <div class="panel-body">
                            <div class="list-group" style="font-size: 20px;">
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-comment fa-fw"></i>名称
                                    <span class="pull-right text-muted small"><em>爱心</em>
                                    </span>
                                </a>
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-twitter fa-fw"></i> 累计投放量
                                    <span class="pull-right text-muted small"><em class="lj_tfl"></em>
                                    </span>
                                </a>
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-envelope fa-fw"></i> 兑换回收量
                                    <span class="pull-right text-muted small"><em class="dh_hsl">200020</em>
                                    </span>
                                </a>
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> 投放概率
                                    <span class="pull-right text-muted small"><em class="gl">0.6%</em>
                                    </span>
                                </a>
                                
                                 <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> 投入用户未获得量
                                    <span class="pull-right text-muted small"><em class="user_love">0.6%</em>
                                    </span>
                                </a>
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-upload fa-fw"></i>投放比例(每充值1元投放数量)
                                    <span class="pull-right text-muted small"><em class="one">898</em>
                                    </span>
                                </a>
                                
                            </div>
                            <a href="javascript:void(0);" onclick="location.reload();" class="btn btn-default btn-block">刷新</a>
                        </div>
                    </div>
                </div>
                
                
                
                <input type="text" style="display:none" class="id"/>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> 修改爱心数据
                        </div>
                        <div class="panel-body">
                            <div class="list-group" style="font-size: 20px; ">
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-comment fa-fw"></i>名称
                                    <span class="pull-right text-muted small"><em>爱心</em>
                                    </span>
                                </a>
                                
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> 投放概率
                                    <span class="pull-right text-muted small"><input type="text" name="love.probability" style="width: 80px;" class="progl">%</em>
                                    </span>
                                </a>

                                <a href="#" class="list-group-item">
                                    <i class="fa fa-upload fa-fw"></i>投放比例(每充值1元投放数量)
                                    <span class="pull-right text-muted small"><input type="text" name="love.probability" style="width: 80px;" class="text">
                                    </span>
                                </a>
                                
                            </div>
                            <a onclick="updateL()" class="btn btn-default btn-block">提交</a>
                        </div>
                    </div>
                </div>
                
           </div>
        </div>
    </div>

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
</body>

<jsp:include page="foot.jsp"/>
<script type="text/javascript" src="<%=basePath %>pagefile/js/love.js"></script>
</body>
</html>

