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
       font-size:25px;
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
		  			<li><a href="chufang.jsp"><span style="font-size:25px;">处方信息</span></a></li>
		  			<li><a href="record.jsp" class="ui-btn-active"><span style="font-size:25px;">历史病例</span></a></li>
				</ul>
		  	</div>
		</div>
		
		
	  <div data-role="content" style="padding: 20px 80px 0 80px;">
	    
			
			<ul data-role="listview">
			　<li data-role="list-divider">我的历史挂号信息<span class="ui-li-count">3</span></li>
			　<li>
			　　 <h3><a href="">2017052410035689</a></h3>
			　　<p><strong>时间：2017-05-24</strong></p>
			　　 <p><strong>点击查看详情</strong></p>
			　　 <p class="ui-li-aside"><strong>2:24PM</strong></p>
			　 </li>
			　<li>
			　　 <h3><a href="">2017032310032345</a></h3>
			　　<p><strong>时间：2017-03-23</strong></p>
			　　 <p><strong>点击查看详情</strong></p>
			　　 <p class="ui-li-aside"><strong>08:56AM</strong></p>
			　 </li>
			<li></li>
			<li>
			　<h3><a href="">2017011310032386</a></h3>
			　　<p><strong>时间：2017-01-13</strong></p>
			　　 <p><strong>点击查看详情</strong></p>
			　　 <p class="ui-li-aside"><strong>10:05AM</strong></p>
			　</li>
			
			</ul>
			
		
	  </div>
	  <div data-role="footer" data-position="fixed">
	    <h1>版权所有&copy; 翻录必究</h1>
	  </div>
  	</div>
  	<script src="../JS/chufang.js"></script>
</body>
    
