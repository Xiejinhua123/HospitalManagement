<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>龙珠兑换中心</title>

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
    	.ball{ text-align: center;}
    	.goods div{ text-align: center;}
    </style>
    
</head>
<body>
<body>

    <div id="wrapper">
		<jsp:include page="top.jsp"/>
		<jsp:include page="menu.jsp"/>

        <div id="page-wrapper">
           <div class="row">
               <div class="col-lg-12">
                   <h2 class="page-header">
                   	
                   	<span style="color:blue;">龙珠兑换中心</span>
                   	<button style="float: right; margin-right: 50px;" class="btn btn-warning">添加</button>
                   
                   </h2>
               </div>
           </div>
           
           <div class="row">
           		<div class="col-lg-5" style="text-align: center;"><h4>需要的龙珠数</h4></div>
           		<div class="col-lg-7" style="text-align: center;"><h4>可以兑换的商品</h4></div>
           </div>
           <hr/>
           <div class="aa">

           </div>
        </div>
    </div>
</body>

<jsp:include page="foot.jsp"/>

<script type="text/javascript" src='<%=basePath %>pagefile/js/goodsObj.js'></script>
<script type="text/javascript" src='<%=basePath %>pagefile/js/ballObj.js'></script>
<script type="text/javascript" src="<%=basePath%>pagefile/js/convert_ball.js"></script>

</body>
</html>
