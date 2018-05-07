<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <jsp:include page="menu.jsp"></jsp:include>
    
    <div>
		<ul class="breadcrumb">
			<li>
				<a href="#">开始</a> <span class="divider">/</span>
			</li>
			<li>
				<a href="#">就诊</a>
			</li>
		</ul>
	</div>
   </div><!--/#content.span10-->
   
   <div id="" class="span2">
   <div class="row-fluid">
   <div class="box span12">
   	<div class="box-header well headertitle">
         <h2>挂号信息</h2>
     </div>
     <div class="box-content">
     	<p class="center">点击挂号条目就诊</p>
     	<p class="center">当前最多显示前20条</p>
         <table class="table" id="table">
             <thead>
             <tr>
                 <th>患者姓名</th>
             </tr>
             </thead>
             <tbody id="guahao">
             </tbody>
         </table>
     </div>
   	</div>
   </div>
   </div>
   
	<div id="" class="span8">
    <!-- 患者信息 -->
		<div class="row-fluid">
			<div class="box span12">
				<div class="box-header well headertitle">
					<h2>患者基本信息</h2>
				</div>

				<!-- 患者信息总体显示 -->
				<div class="box-content">
					<!-- 以表格形式展现，患者表中的相关信息 -->
					<table class="table">
						  <thead>
							  <tr>
								  <th>患者姓名</th>
								  <th>年龄</th>
								  <th>性别</th>
								  <th>编号</th>                                          
							  </tr>
						  </thead>   
						  <tbody>
							<tr>
								<td id="patName"></td>
								<td class="center" id="patAge"></td>
								<td class="center" id="patSex"></td>
								<td class="center" id="regId"></td>     
							</tr>
						  </tbody>
					 </table>
					 <table class="table">
						  <tbody>
							<tr>
								<td style="width:120px;">遗产病史</td>
								<td class="center" id="ycbs">
								</td>
							</tr>
							<tr>
								<td>过敏症状</td>
								<td class="center" id="gmbz"> 
								</td>
							</tr>
							<tr>
								<td>家庭地址</td>
								<td class="center" id="jtzz">
								</td>
							</tr>
						  </tbody>
					 </table>  
				</div>
				</div>
			</div><!-- 患者信息结束 -->
			
			
		<!-- 医生提交主诉 -->
		<div class="row-fluid">
		
			<!-- 患者主诉 -->
			<div class="box span6">
				<div class="box-header well headertitle">
					<h2><span>患者主诉</span></h2>
				</div>

				<!-- 患者主诉信息 -->
				<div class="box-content" >
					<!-- 以textarea的文本框的形式记录 -->
					<h3><p style="font-size: 20px; height: 35px; line-height: 30px;"
					 class="center">请以中文“，”分割每一项症状</p></h3>
					<p>
						<textarea rows="10" placeholder="在这里输入病症信息" class="mainSuit" id="textarea"></textarea>
					</p>
				</div>
			</div>

			<!-- 右侧主诉记录患者的主诉信息 -->
			<div class="box span6">
				<div class="box-header well headertitle">
					<h2><span>患者症状信息记述</span></h2>
				</div>

				<!-- 患者主诉信息 -->
				<div class="box-content">
					<!-- 以textarea的文本框的形式记录 -->
					
					<h3>	
						<p style="font-size: 20px; height: 35px; line-height: 30px;"
						 class="center" id="mes">输入的信息在这里可以预览</p>
					 </h3>
					 <h3>
					 	<p style="font-size: 15px; height: 25px; line-height: 25px;"
					 	class="center" id="zzyl">对症药品选择</p>
					 </h3>
					 <table class="table">
					 	<!-- 这里是所有的药品不要动，页面加载时候加载该信息 -->
					 	<tbody>
					 		<tr>
					 			<td><a style="cursor: pointer;"><i class="icon-remove"></i></a></td>
								<td style="width:120px;">所有药品</td>
								<td class="center" id="">
									 <select id="selectError1" multiple data-rel="chosen">
										<option selected>药品1</option>
										<option>药品2</option>
										<option>药品3</option>
										<option>药品4</option>
										<option>药品5</option>
									  </select>
								</td>
							</tr>
					 	</tbody>
					 	<!-- 表格中的信息动态加载 -->
					 	<tbody class="zhengzhuang">
						  
						</tbody>
					</table>
					<button id="aaaa">测试</button>
					 <p class="center" ><button style="border-radius:20px;" class="sub">提交处方信息</button></p>
				</div>

			</div><!-- 右侧主诉记录患者的主诉信息 -->
		</div><!-- 医生提交主诉 -->

		<!-- 选择药品 -->
		<div class="row-fluid">
			<div class="box span12">
			
				<div class="box-header well headertitle">
					<h2><span>处方信息查看</span></h2>
				</div>

				<!-- 患者处方信息 -->
				<div class="box-content">
					<!-- 以textarea的文本框的形式记录 -->
					<h3><p style="font-size: 20px; height: 35px; line-height: 30px;"
					 class="table center">选择药品的计量</p></h3>
					 
					 <table class="table" style="width: 100%;">
					 	
					 	<!-- 这里是所有的药品不要动，页面加载时候加载该信息 -->
					 	
					 	<thead style="margin-bottom: 10px;">
					 		<tr class="center">
								<td style="width:30%;">药品名称</td>
								<td class="center" style="width: 25%;">数量/单位</td>
								<td class="center" style="width: 20%;">使用情况</td>
								<td class="center" style="width: 15%;">单次服用量</td>
							</tr>
					 	</thead>
					 	
					 	<!-- 表格中的信息动态加载 -->
					 	<tbody id="Drug">
							<tr class="center" >
								<td >阿莫西林</td>
								<td class="center">
									<input style="width: 40%; height:100%; vertical-align: middle;" type="text">
									<select style="width: 55%;">
										<option>瓶</option>
										<option>盒</option>
										<option>片</option>
										<option>支</option>
									</select>
								</td>
								<td class="center">
									<select style="width:100%;">
										<option>一日一次</option>
										<option>一日两次</option>
										<option>一日三次</option>
									</select>
								</td>
								<td class="center">
									<input style="width:100%; height: 100%;" type="text" value="平均">
								</td>						
							</tr>
							
						</tbody>
					</table>
					<textarea rows="3" placeholder="在这里输入病症信息" class="comment" id="textarea"></textarea>
					<p class="center" ><button style="border-radius:20px;">提交处方信息</button></p>
				</div>

			</div>
		</div><!-- 选择药品结束 -->
	</div><!--/fluid-row-->		
		<hr>
 		<!-- 提交之前的提示信息 -->
		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close closeModal" data-dismiss="modal">×</button>
				<h3>提交提醒</h3>
			</div>
			<div class="modal-body">
				<p></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
			</div>
		</div>
		
		
<script src="../adminJS/docoffer.js"></script>
<script>
$(function(){
	$(".chzn-results li").click(function(){
		var name=$(this).text();
		var id;
		var select=$(".chzn-results").parents("#selectError2_chzn").prev("select").find("option");
		$.each(select,function(i,d){
		var str=$(d).text();
		str=$.trim(str);
		if(name==str)
		{
				id=$(d).attr("drugId");
		}
		});
		InsertDrug(id,name);
	});
});
</script>
<jsp:include page="foot.jsp"></jsp:include>

    
