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
	<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
							  	  <th>编号</th>
								  <th>权限名称</th>
								  <th>权限路径</th>
								  <th>权限创建时间</th>
								  <th>权限修改时间</th>
								  <th>权限是否启用</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>1000</td>
								<td>就诊</td>
								<td class="center">doctoroffer.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>收费</td>
								<td class="center">tool.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>取药</td>
								<td class="center">checked_medicin.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>用户管理</td>
								<td class="center">user.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>我的信息</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>患者管理</td>
								<td class="center">patient.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>数据字典维护</td>
								<td class="center">dictionary.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>角色管理</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>权限管理</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>科室管理</td>
								<td class="center">department.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>药品管理</td>
								<td class="center">drug.jsp</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>药品入库</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1012</td>
								<td>报表管理</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1013</td>
								<td>提交报表</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1014</td>
								<td>查阅报表</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1015</td>
								<td>新闻管理</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1017</td>
								<td>科室员工管理</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1018</td>
								<td>查看所有药品</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1019</td>
								<td>查看就诊信息</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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
								<td>1020</td>
								<td>查看固定处方</td>
								<td class="center">url</td>
								<td class="center">2017-05-22</td>
								<td class="center">2017-05-26</td>
								<td class="center">true</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" >
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

</body>
	<div class="modal hide fade" id="del">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>确定要删除吗？</h3>
	</div>
	<div class="modal-body">
		<p>请注意！在没有上级命令下不要删除权限！</p>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">确定</a>
	</div>
</div>

<div class="modal hide fade" id="upd">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>修改权限</h3>
	</div>
	<div class="modal-body">
		<h3 class="center">请勿随意修改信息</h3>
		<div style="height:20px;"></div>
		<from class="form-horizontal">
           <fieldset>
           <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >编号</b></label>
                 <div class="controls" style="position: relative; top: 6px;">
                   <label class="b0">1000</label>
                 </div>
             </div>
           
			<div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >患者名称</b></label>
                 <div class="controls" style="position: relative; top: 6px;">
                   <input style="" class="b1"  type="text" value="儿科" >
                 </div>
             </div>

             <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >患者性别</b></label>
                 <div class="controls" style="position: relative; top: 3px;">
                    <input type="text" class="b2"  value="二楼201" >
                  </div>
             </div>

             <div class="control-group"> 
                 <label class="control-label" style="font-size:20px;"><b >患者电话</b></label>
                  <div class="controls" style="position: relative; top: 3px;">
                    <input type="text" class="b3" value="神大人" >
                  </div>
             </div> 
             <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >账号创建时间</b></label>
                  <div class="controls"  style="position: relative; top: 3px;">
                  <input type="text" class="b4" value="2017-5-3" >
                  </div>
             </div>
              <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >最后一次登录</b></label>
                  <div class="controls"  style="position: relative; top: 3px;">
                  <input type="text" class="b5" value="2017-5-3" >
                  </div>
             </div>
              <div class="control-group">
                 <label class="control-label" style="font-size:20px;"><b >账号创建时间</b></label>
                  <div class="controls" class="b6" style="position: relative; top: 3px;">
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
<script>
$(function(){
	$(".del").click(function(){
		$("#del").addClass("in");
		$("#del").css("display","block");
	});
	$(".upd").click(function(){
		var r=$(this).parents("tr")
		r=$(r).find("td").not("td:last");
		//alert(r.html());
		$.each(r,function(i,d){
			if(i==0)$(".b"+i).text($(d).text());
			else
			{
				$(".b"+i).val($(d).text());
			}
			//alert($(d).text());
			//$(".b1").text(d);
		})
		
		
	$("#upd").addClass("in");
	$("#upd").css("display","block");
		
	});
})
</script>
</html>
<jsp:include page="foot.jsp"></jsp:include>