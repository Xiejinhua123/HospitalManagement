<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<%
String basePathuser = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title></title>
		<meta name="description" content="Nifty Modal Window Effects with CSS Transitions and Animations" />
		<meta name="keywords" content="modal, window, overlay, modern, box, css transition, css animation, effect, 3d, perspective" />
		<meta name="author" content="Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="<%=basePathuser %>admin/page/css/default.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePathuser %>admin/page/css/component.css" />
		<script src="<%=basePathuser %>aqdmin/page/js/modernizr.custom.js"></script>
	</head>
<body>
<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well headertitle" data-original-title>
						<h2><i class="icon-user"></i> 科室管理</h2>
						<div class="box-icon">
			    <!--添加按钮 -->  <a href="#myModal" id="setting" class="btn btn-round"><i style="position: relative; top:-3px; left:-2px;" class="icon-plus"></i></a>
			          	</div>
					</div>
					
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
							  	  <th>编号</th>
								  <th>科室名称</th>
								  <th>科室位置</th>
								  <th>创建人</th>
								  <th>创建时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>1000</td>
								<td>儿科</td>
								<td class="center">二楼201</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#upd" id="ind">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							<tr>
								<td>1001</td>
								<td>妇科</td>
								<td class="center">二楼303</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							<tr>
								<td>1002</td>
								<td>皮肤科</td>
								<td class="center">二楼205</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1003</td>
								<td>放射科</td>
								<td class="center">一楼108</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1004</td>
								<td>心血管</td>
								<td class="center">二楼208</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1005</td>
								<td>脑科</td>
								<td class="center">四楼403</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1006</td>
								<td>耳鼻喉科</td>
								<td class="center">五楼505</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1007</td>
								<td>眼科</td>
								<td class="center">四楼404</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1008</td>
								<td>肿瘤科</td>
								<td class="center">五楼508</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1009</td>
								<td>中医1</td>
								<td class="center">四楼401</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							<tr>
								<td>1009</td>
								<td>中医2</td>
								<td class="center">四楼401</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1009</td>
								<td>中医3</td>
								<td class="center">四楼401</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1010</td>
								<td>内科</td>
								<td class="center">三楼308</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
							<tr>
								<td>1011</td>
								<td>骨科</td>
								<td class="center">三楼305</td>
								<td class="center">神大人</td>
								<td class="center">2017-5-3</td>
								<td class="center">
									<a class="btn btn-info" href="#">
										<i class="icon-edit icon-white"></i>  
										修改                                            
									</a>
									<a class="btn btn-danger del" href="#del">
										<i class="icon-trash icon-white"></i> 
										删除
									</a>
								</td>
							</tr>
							
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			</div>
			

<div class="modal hide fade" id="myModal">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>添加科室</h3>
	</div>
	<div class="modal-body">
		<h3 class="center">请修改</h3>
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
		<a href="#" class="btn closeModal" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">提交</a>
	</div>

</div>



<div class="modal hide fade" id="upd">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>修改科室信息</h3>
	</div>
	<div class="modal-body">
		<h3 class="center">请勿随意修改信息</h3>
		<div style="height:20px;"></div>
		<from class="form-horizontal">
           <fieldset>
           <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b>编号</b></label>
                 <div class="controls" style="position: relative; top: 6px;">
                   <label>1000</label>
                 </div>
             </div>
           
			<div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b>科室名称</b></label>
                 <div class="controls" style="position: relative; top: 6px;">
                   <input style="" type="text" value="儿科" >
                 </div>
             </div>

             <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b>科室位置</b></label>
                 <div class="controls" style="position: relative; top: 3px;">
                    <input type="text" value="二楼201" >
                  </div>
             </div>

             <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b>创建人</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                    <input type="text" value="神大人" >
                  </div>
             </div>
             <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b>创建时间</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                  <input type="text" value="2017-5-3" >
                  </div>
             </div>
		</fieldset>
	</from>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">提交</a>
	</div>

</div>


<div class="modal hide fade" id="del">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>确定要删除吗？</h3>
	</div>
	<div class="modal-body">
		<p>请注意！删除可能造成不可预知的错误！</p>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">确定</a>
	</div>

</div>

<script>
$(function(){
	
	$("#setting").click(function(){
		$("#myModal").addClass("in");
		$("#myModal").css("display","block");
		
	});
	
	$("#ind").click(function(){
		$("#upd").addClass("in");
		$("#upd").css("display","block");
		
	});
	
	$(".del").click(function(){
		$("#del").addClass("in");
		$("#del").css("display","block");
		
	});
})
</script>
</body>
</html>
<jsp:include page="foot.jsp"></jsp:include>