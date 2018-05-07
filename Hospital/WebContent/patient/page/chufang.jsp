<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="utf-8"/>
	<link rel=stylesheet href="../jqm/css/jquery.mobile-1.3.2.css">
	<style>
	   border:none;   <!-- 边框 -->
       margin:none;     <!-- 外边距 -->
       line-height:20px;     <!-- 行高-->
       padding:0px;               <!-- 内边距-->
	tr td{ height: 50px; line-height: 50px;}
	*{font-size: 30px;}
	</style>
	
	<script src="../jqm/js/jquery.js"></script>
	<script src="../jqm/js/jquery-1.8.3.js"></script>
	<script src="../jqm/js/jquery.mobile-1.3.2.js"></script>
</head>
<body>
	<div data-role="page">
	 <div data-role="header" data-position="fixed">
		    <h1 style=" font-size: 40px;">处方</h1>
		  	<div data-role="navbar">
		  		<ul>
		  			<li><a href="MyMenage.html"><span style="font-size: 25px;">我的信息</span></a></li>
		  			<li><a href="guahao.html"><span style="font-size:25px;">挂号就诊</span></a></li>
		  			<li><a href="chufang.jsp" class="ui-btn-active"><span style="font-size:25px;">处方信息</span></a></li>
		  			<li><a href="record.jsp"><span style="font-size:25px;">历史病例</span></a></li>
				</ul>
		  	</div>
		</div>
		
		
	  <div data-role="content">	    
		<div style="width:500px; margin: 0px auto; text-align: center;">
			<h2>您当前没有就诊的挂号信息</h2>
			<div style="height: 20px"></div>
			<h2>挂号信息</h2>
			<table style="margin: 0px auto; font-size: 25px;">
				<tbody>
					<tr>
						<td>挂号编号：</td>
						<td id="regId">${reg.regId }</td>
					</tr>
					<tr>
						<td>医生姓名：</td>
						<td>${reg.doctorName }</td>
					</tr>
					<tr>
						<td>科室名称：</td>
						<td>${reg.depName }</td>
					</tr>
					<tr>
						<td>科室地址：</td>
						<td>${reg.depAddress }</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div style="width:780px; margin: 0px auto; text-align: center;">
			<div style="height: 20px"></div>
			<h2>处方</h2>
			<table width="780" id="tr">
			<thead>
			  <tr>
			    <td width="200" height="42">药品名称</td>
			    <td width="97">总量</td>
			    <td width="88">单位</td>
			    <td width="88">规格</td>
			    <td width="307">单价（元）/ 单位</td>
			  </tr>
			  </thead>
			  <tbody>
			  </tbody>
			</table>
		</div>
	  </div>
	  <div data-role="footer" data-position="fixed">
	    <h1>版权所有&copy; 翻录必究</h1>
	  </div>
  	</div>
  	<script src="../JS/chufang.js"></script>
</body>
    
