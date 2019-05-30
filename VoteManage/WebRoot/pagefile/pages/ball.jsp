<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>龙珠管理</title>

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
               <div class="col-lg-12"><h1><span style="color:blue;">龙珠管理</span></h1></div>
           </div>
           
           <div class="row">
           		<div class="col-log-12">
           			
           			<div class="panel panel-default">
                        <div class="panel-heading">
                           	<h5>七龙珠信息</h5>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>编号</th>
                                            <th>龙珠</th>
                                            <th>投放比例</th>
                                            <th>描述信息</th>
                                        </tr>
                                    </thead>
                                    <tbody class="dragin">
                                       
                                       
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
           		</div>
           </div>
        </div>
    </div>



<!-- 龙珠详情 -->
 <div class="panel-body">
    <!-- Modal -->
    <div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">龙珠详情</h4>
                </div>
                <div class="modal-body">
                 <table class="table table-striped table-bordered table-hover">
                            <tbody id="ballxx">
                                <tr>
                                    <td>编号</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>名称</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>概率(千分率)</td>
                                    <td> </td>
                                </tr>
                                <tr>
                                    <td>概率说明</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>目前已投放数量</td>
                                    <td></td>
                                </tr>
                                 <tr>
                                    <td>已兑换被回收数量</td>
                                    <td></td>
                                </tr>
                                 <tr>
                                    <td>用户拥有数量</td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</div>

<!-- 修改龙珠 -->
<div class="panel-body">
	 <button class="btn btn-primary btn-lg" id="updateBtn" data-toggle="modal" data-target="#updateModal"></button>
    <!-- Modal -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改龙珠</h4>
                </div>
                <div class="modal-body">
                   <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <tbody>
                                <tr>
                                    <td>编号</td>
                                    <td class="updateId ballid"></td>
                                </tr>
                                <tr>
                                    <td>名称</td>
                                    <td> <input type="text" name="name" class="upName"/></td>
                                </tr>
                                <tr>
                                    <td>概率(百分率)</td>
                                    <td><input type="text" name="name" class="upgl"/></td>
                                </tr>
                            </tbody>
                        </table>
                        <p class="mes"></p>
                    </div>
                </div>
                <div class="modal-footer">
                	<button type="button" class="btn btn-default saveBall">保存</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
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
<jsp:include page="foot.jsp"/>

<script type="text/javascript" src="<%=basePath%>pagefile/js/ball.js"></script>

</body>
</html>

