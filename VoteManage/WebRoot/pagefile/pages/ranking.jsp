<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>投票排行榜</title>

<!-- Bootstrap Core CSS -->
<link
	href="<%=basePath %>pagefile/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath %>pagefile/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="<%=basePath %>pagefile/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="<%=basePath %>pagefile/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath %>pagefile/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=basePath %>pagefile/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<style>
.pagenum {
	float: right;
	margin-right: 200px
}
</style>
</head>
<body>

	<div id="wrapper">
		<jsp:include page="top.jsp" />
		<jsp:include page="menu.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2 class="page-header">
						<span style="color:blue;"> 投票排行榜</span>
					</h2>
				</div>
			</div>
			<div class="row" style="margin-bottom: 10px;">

				<div class="col-lg-12 botton">
				
					<button type="button" class="btn btn-default vote">投票排行</button>
					<button type="button" class="btn btn-info box">宝箱排行</button>
					<button type="button" class="btn btn-info ball">龙珠排行</button>
					<button type="button" class="btn btn-info love">爱心排行</button>
					
				</div>

			</div>
			<div class="row">
				<div class="col-lg-12">
					<table class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
						
							<tr>
								<th>排名</th>
								<th>编号</th>
								<th>姓名</th>
								<th>得票总数</th>
								<th>拥有宝箱总数</th>
								<th>拥有龙珠总数</th>
								<th>拥有爱心总数</th>
								<th>是否被删除</th>
							</tr>
							
						</thead>
						<tbody id="tbody">

						</tbody>

					</table>
				</div>
			</div>
			<div class="pagenum"></div>
		</div>
	</div>

	<jsp:include page="foot.jsp" />
	<!-- 自定义js -->
	<script type="text/javascript" src="../js/rank.js"></script>
</body>
</html>