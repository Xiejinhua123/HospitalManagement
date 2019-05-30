<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>标签管理</title>

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
        
            <div class="container-fluid">
            
                <div class="row">

                    <div class="col-lg-12">
                    <form action="updateGoods.action" method="post">
                 	  商品图片<img src=""/>
                 	  id<input type="text" name="goods.id" value='${ goods.id}'>
           			  商品名称	<input type="text" name="goods.goodsName" value='${ goods.goodsName}'>
                  	  消耗爱心数<input type="text" name="goods.loveNumber" value='${ goods.loveNumber}'/>
                  	  <s:if test="goods.shelvesStatus==1">
               		  是否下架	 <select name="goods.shelvesStatus">
							 <option value="0">是</option>
                   			 <option value="1">否</option>
               				 </select>  </s:if>
               			<s:else>  是否下架	 <select name="goods.shelvesStatus">
                   			<option value="1">否</option>
                   			<option value="0">是</option>
               				 </select> </s:else> 
               				 <button type="submit">修改</button>	
               			 </form> 	
                </div>
            </div>
        </div>
    </div>
</body>

<jsp:include page="foot.jsp"/>
</body>
</html>