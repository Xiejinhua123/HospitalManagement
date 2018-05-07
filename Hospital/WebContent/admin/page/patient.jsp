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
								  <th>患者姓名</th>
								  <th>患者性别</th>
								  <th>患者电话</th>
								  <th>账号创建时间</th>
								  <th>最后一次登录时间</th>
								  <th>操作</th>
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>1000</td>
								<td>青小鸟</td>
								<td class="center">女</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" id="ind">
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
								<td>青小龙</td>
								<td class="center">男</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" id="ind">
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
								<td>饶小豪</td>
								<td class="center">男</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
								<td class="center">
									<a class="btn btn-info upd"  href="#upd" id="ind">
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
								<td>西岚</td>
								<td class="center">男</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" id="ind">
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
								<td>凯丽</td>
								<td class="center">女</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
								<td class="center">
									<a class="btn btn-info upd" href="#upd" id="ind">
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
								<td>诺顿</td>
								<td class="center">男</td>
								<td class="center">1369632356</td>
								<td class="center">2017-5-3</td>
								<td class="center">2017-05-25</td>
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
		<p>请注意！删除用户可能给患者带来不便。</p>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" >取消</a>
		<a href="#" id="submit" class="btn btn-primary">确定</a>
	</div>
</div>

<div class="modal hide fade" id="upd">

	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>修改患者</h3>
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