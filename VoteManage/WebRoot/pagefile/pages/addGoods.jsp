<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加商品</title>

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
    	.imgDiv{float:left; margin-bottom: 10px;}
    	.imgView{margin-top: 10px; }
    </style>
</head>
<body>
<body>

	<input type="hidden" class="ret" value="${manage }"/>
	
    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-12">
                   <h2 class="page-header"><span style="color:blue;">  添加商品</span></h2>
               </div>
           </div>
           
           <div class="panel-body">
	            <div class="row">
	            
	            	<div class="col-lg-2 col-md-1"></div>
	            
	                <div class="col-lg-8 col-md-10 col-sm-12">
	                    <form action="<%=basePath %>addGoods.action" method="post" enctype="multipart/form-data">
	                    
	                        <div class="form-group">
	                            <label>商品名称（该名称将在前台显示）</label>
	                            <input class="form-control Goodsname" name="goods.goodsName" placeholder="商品名称，最好8个字以内">
	                            <p class="help-block checkName" style="color:red;"></p>
	                        </div>
	                        
	                        <div class="form-group">
	                            <label>兑换该商品需要的爱心数量</label>
	                            <input class="form-control Goodsai" name="goods.loveNumber" placeholder="请输入一个整数">
	                            <p class="help-block chenckAi" style="color:red;"></p>
	                        </div>
	                        
	                        <div class="form-group">
	                        	<label>请选择该商品的图片&nbsp; &nbsp; &nbsp; &nbsp; <input type="button" class="addImg" value="添加更多"/></label>
	                        	<p>为了保证观赏度，请保证图片为150*180,或等比例图片</p>
	                        	
	                        	<div class="img">
	                        	
		                        	<div class="imgDiv">
			                        	<input type="file" id="a1" name='file' onchange="javascript:setImagePreviews('a1','b1','150px','180px');" />
			                        	<div id="b1" class="imgView"></div>
			                        	
		                        	</div>
		                        	
		                        </div>
		                       
		                        <div style="clear: both;"></div>
		                          <p class="help-block chenckImg" style="color:red;"></p>
	                        </div>
								
	                        <div class="form-group">
	                            <label>描述信息</label>
	                            <textarea class="form-control" name="goods.description" rows="5"></textarea>
	                        </div>
	                        <button class="btn submit btn-default">保存</button>
	                    </form>
	                </div>
	               
	                <div class="col-lg-2 col-md-1"></div>
	            </div>
            </div>
            
        </div>
    </div>



<div class="panel-body">
	<!-- Button trigger modal -->
	<button class="btn btn-primary btn-lg tan" data-toggle="modal" data-target="#myModal"></button>
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
<!-- /.modal -->
</div>



</body>

<jsp:include page="foot.jsp"/>


<!-- 预览图片 -->
<script type="text/javascript" src="<%=basePath%>pagefile/js/ImgPreview.js"></script>

<!-- addGoods -->
<script type="text/javascript" src="<%=basePath%>pagefile/js/addGoods.js"></script>

</body>
</html>