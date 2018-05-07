<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<%
String basePathuser = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
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

	
	<div class="row-fluid sortable">
		<div class="span1"></div>


		<!-- 在这里进行用户的信息自我完善 -->

		<div class="box span8">
			
			<div class="box-header well headertitle" data-original-title >
				<h2><i class="icon-user"></i> 账单信息</h2>
			</div>

			<div class="box-content">

				<p class="center" style="margin-top: 10px;">
					<input autofocus class="input-large text" type="text" placeholder="请输入挂号编号" />
					<button class="btn" style="position: relative; top: -3.5pt;">点击查询</button>
				</p>

				<table class="table" >
				  <thead>
					  <tr>
						  <th><a>姓名</a></th>
						  <th><a>年龄</a></th>
						  <th><a>金额</a></th>
						  <th><a>医生</a></th>                                          
					  </tr>
				  </thead>   
				  <tbody class="body">
					<tr>
						<td class="center">李宜昌</td>
						<td class="center">22</td>
						<td class="center">66</td>
						<td class="center">刘筱毅</td>                                       
					</tr>								
				  </tbody>
			 	</table>
				
				<table class="table" style="margin-top: 50px;">
				  <thead>
					  <tr>
						  <th><a>药品名称</a></th>
						  <th><a>总量</a></th>
						  <th><a>单位</a></th>
						  <th><a>规格</a></th>
						  <th><a>单价（元）/单位</a></th>
						  <th><a>总价（元）</a></th>   
					  </tr>
				  </thead>   
				  <tbody class="body">
				  <!-- 循环导入当前的处方的药品信息 -->
					<tr>
						<td class="center">莲花清瘟胶囊</td>
						<td class="center">2</td>
						<td class="center">盒</td>
						<td class="center">1X20</td>
						<td class="center">0.5/片</td>
						<td class="center">20</td>
					</tr>
					<tr>
						<td class="center">清肺消炎丸</td>
						<td class="center">2</td>
						<td class="center">盒</td>
						<td class="center">1X20</td>
						<td class="center">0.5/片</td>
						<td class="center">20</td>
					</tr>
					<tr>
						<td class="center">苏黄止咳胶囊</td>
						<td class="center">2</td>
						<td class="center">盒</td>
						<td class="center">1X20</td>
						<td class="center">0.5/片</td>
						<td class="center">26</td>
					</tr>
					<tr>
						<td class="center" style="font-weight: bolder; color: red;">总价</td>
						<td class="center"></td>
						<td class="center"></td>
						<td class="center"></td>
						<td class="center"></td>
						<td class="center" style="font-weight: bolder; color: red;">66</td>
					</tr>

				  </tbody>
			 	</table>
	<p class="center"><button id="tijiao">确定</button></p>
			</div>
		</div>

		<div class="span1"></div>

	</div><!--/span-->

</div><!--/row-->	
	
		
</div><!--/#content.span10-->


</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>收费提醒</h3>
	</div>
	<div class="modal-body">
		<h3 class="center">账单信息已经提交</h3>
		<div style="height:20px;"></div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" >确定</a>
	</div>
</div>



<script src="${pageContext.request.contextPath}/admin/adminJS/tool.js"></script>
<jsp:include page="foot.jsp"></jsp:include>