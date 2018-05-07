<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<%
String basePathuser = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>

<div>
	<ul class="breadcrumb">
		<li>
			<a href="#">Home</a> <span class="divider">/</span>
		</li>
		<li>
			<a href="#">Tables</a>
		</li>
	</ul>
</div>

<!-- row -->
<div class="row-fluid sortable" id='tableinput'>
	
	<!-- span12开始 -->
	<div class="box span12">

			<div class="box-header well" style="height:35px;" data-original-title>
	           <h2><i class="icon-user"></i> 药品信息</h2>
	           <div class="box-icon">
	               <a href="#" id="setting" class="btn btn-round"><i style="position: relative; top:-3px; left:-2px;" class="icon-plus"></i></a>
	           </div>
      		 </div>
      		 	


		<!-- 折叠部分开始 -->
		<div class="box-content">
		
			<!-- 条件部分开始 -->
        	<div class="row-fluid">
                <label class="span2 center"> <input type="checkbox" name="qx">
                	<button class="btn" var='delUsers'  style="position: relative; top: -1.5pt;">删除所选</button></label>
                <label class="span2 center">
                
                <select style="width: 60px;" class="pageNum">
					<option value="10" select="select">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
					
				   条目数量 
                       </label>
                       <label class="span2 center">
                       <select style="width: 70px;" class="depName">
                <option>全部</option>
                    </select>
              			      部门
                </label>
                <label class="span3 center"><input type="text" style="width: 90px;" name="userId">
                <button class="btn" style="position: relative; top: -3.5pt;" var='sel'>工号查询</button>
                </label>
               <label class="span3 center"><input type="text" style="width: 90px;" name="trueName">
                 <button class="btn" style="position: relative; top: -3.5pt;" var='sel'>姓名查询</button>
               </label>
   			</div><!-- 条件结束 --> 
   			  
   			<!-- 表格开始 -->
			<table class="table">
				<thead>
					<tr>
                     <th class="center">勾选</th>
					    <th class="center">编号</th>
					    <th class="center">名称</th>
					    <th class="center">曾用名</th>
					    <th class="center">类型</th>
					    <th class="center">剂型</th>
				  </tr>
			  </thead>   
			  
			  <tbody  id="yg">
			  <tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">复方氨酚葡锌片</td>
					<td class="center">康必得</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					 
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">咖酚伪麻美芬片</td>
					<td class="center">咖酚伪麻美芬片</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">氨麻苯美片</td>
					<td class="center">白加黑</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					<td class="center">
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">氨酚曲麻片</td>
					<td class="center">联邦非迪乐</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">布洛伪麻分散片</td>
					<td class="center">可泰舒</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">氯酚黄敏片</td>
					<td class="center">感瑞克</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">盐酸氨溴索片</td>
					<td class="center">沐舒坦</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">葡醛内酯片</td>
					<td class="center">百喘朋</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">呋喃暖硫胺片</td>
					<td class="center">康必得</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">格列吡嗪缓释片</td>
					<td class="center">秦苏</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
					<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">人工硫磺甲硝唑</td>
					<td class="center">牙痛安</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
			  <tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">酮洛芬肠溶片</td>
					<td class="center">尤步芬</td>     
					<td class="center">处方药</td> 
					<td class="center">片剂</td> 
					
					</tr>
				<tr>
					<td class="center"><input type="checkbox"></td>
					<td class="center">2013/02/01</td>
					<td class="center">阿莫西林</td>
					<td class="center">阿莫西林</td>     
					<td class="center">处方药</td> 
					<td class="center">阿莫西林</td> 
					                         
				</tr>
				</tbody>
			</table><!-- 表格结束 -->

			<!-- 页码 -->
			 <div class="pagination pagination-centered">
						  <ul>
							<li><a href="#">上一页</a></li>
							<li class="active">
							  <a href="#">1</a>
							</li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">下一页</a></li>
						  </ul>
						</div>     <!-- 页码结束 -->
			
        </div><!-- 折叠结束 -->
	</div><!-- span12 -->
</div><!--/row-->


</div><!--/#content.span10-->
</div><!--/fluid-row-->
</div><!--/container-fluid -->
<!-- 弹窗 -->
   <html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>提示信息</title>
		<meta name="description" content="Nifty Modal Window Effects with CSS Transitions and Animations" />
		<meta name="keywords" content="modal, window, overlay, modern, box, css transition, css animation, effect, 3d, perspective" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="<%=basePathuser %>admin/page/css/default.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePathuser %>admin/page/css/component.css" />
		<style type="text/css">
			#modal-19 p{ margin-top: 20px; padding-left: 20px; padding-right: 20px;}
			#modal-19 p td{ text-align: center;}
		</style>
		<script src="<%=basePathuser %>admin/page/js/modernizr.custom.js"></script>
	</head>
	<body id="tanchuang">

		<div class="md-modal md-effect-19" id="modal-19" style="overflow:inherit;">
			<div class="md-content" style="background: #0F4367; orphans: 0.9;">
				<h3><span style="color: white;">您确定要删除选中的药品吗？</span></h3>
				<p>在删除当前药品的时候，我们会将处方中的该药品信息删除，请谨慎操作</p>
				
				<p>
					<table id = "tanchuangTable" cellspacing="20" cellpadding="20">
						
					</table>
				</p>
				
				<div style="height: 20px; margin-top: 60px; position:relative; top:-10px; text-align: center;">
					<button class="md-close" style="display: inline;">关闭</button><button class="submit" style="display: inline; margin-left: 20px;">确定</button>
				</div>
				
			</div>
		</div>

		<button style="display: none;" class="md-trigger" data-modal="modal-19">开始</button>

		<div class="md-overlay" style="background: black;opacity:0.5;"></div><!-- the overlay element -->
	</body>
</html>

<script>
	var polyfilter_scriptpath = '/js/';
</script>
<script src="<%=basePathuser %>admin/page/js/index.js"></script>

<hr>

<div class="modal hide fade" id="myModal">
<form id="adduser" method="post" action="../../servet/user?ac=addUser">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>添加药品</h3>
	</div>
	<div class="modal-body">
		<h3 class="center">添加主要选项，其余由用户个人完善</h3>
		<div style="height:20px;"></div>
		<from class="form-horizontal">
           <fieldset>
			<div class="control-group badge badge-info">
                 <label class="control-label" style="font-size:20px;"><b>姓名</b></label>
                 <div class="controls" style="position: relative; top: 6px;">
                   <input type="text">
                 </div>
             </div>

             <div class="control-group badge">
                 <label class="control-label" style="font-size:20px;"><b>在职状态</b></label>
                 <div class="controls" style="position: relative; top: 3px;">
                    <select data-rel="chosen" name="OnjobState" class="">
                    	<option>在职状态</option>
                    </select>
                  </div>
             </div>

             <div class="control-group badge">
                 <label class="control-label" style="font-size:20px;"><b>所在部门</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                    <select data-rel="chosen" name="OnjobState" class="">
                    	<option>所在部门</option>
                    </select>
                  </div>
             </div>

             <div class="control-group badge">
                 <label class="control-label" style="font-size:20px;"><b>挂号类型</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                    <select data-rel="chosen" name="OnjobState" class="">
                    	<option>挂号类型</option>
                    </select>
                  </div>
             </div>

             <div class="control-group badge">
                 <label class="control-label" style="font-size:20px;"><b>职位</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                       <select data-rel="chosen" name="OnjobState" class="">
                       	<option>职位</option>
                       </select>
                     </div>
              	</div>
		</fieldset>
	</from>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">提交</a>
	</div>
</form>
</div>

<script>
$(function(){
	$("#setting").click(function(){
		
		$("#myModal").addClass("in");
		$("#myModal").css("display","block");
		
	});
})
</script>

<jsp:include page="foot.jsp"></jsp:include>