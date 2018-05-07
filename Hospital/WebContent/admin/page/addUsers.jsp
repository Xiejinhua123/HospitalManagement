<%@ page language="java" import="java.lang.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String basePath = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>

<jsp:include page="menu.jsp"></jsp:include>
<div>
	<ul class="breadcrumb">
		<li><a href="#">Home</a> <span class="divider">/</span></li>
		<li><a href="#">Tables</a></li>
	</ul>
</div>
<!-- 下面部分查看和修改信息 -->
<div class="row-fluid sortable">
	<div class="span2"></div>
	<!-- 修改用户信息 -->
	<div class="box span8">
		<div class="box-header well" data-original-title>
			<h2>
				<i class="icon-user"></i> 增加用户信息
			</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-setting btn-round"><i
					class="icon-cog"></i></a> <a href="#"
					class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
				<a href="#" class="btn btn-close btn-round"><i
					class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
			<p class="badge badge-important center" style="padding: 5px 0;">请输入用户必要信息</p>
			<form class="form-horizontal" action="<%=basePath %>/servet/user?ac=addsave" method="post">
				<fieldset>
					<div class="control-group success indent">
						<label class="control-label" for="optionsCheckbox2">姓名</label>
						<div class="controls">
							<input type="text" name="name" id="inputSuccess"> <span
								class="help-inline"></span>
						</div>
					</div>
					<div class="control-group success indent">
						<label class="control-label" for="optionsCheckbox2">身份证号</label>
						<div class="controls">
							<input type="text" name="IdCard" id="inputSuccess"> <span
								class="help-inline"></span>
						</div>
					</div>
					
					<div class="control-group success" style="margin-left: 50px;">
						<label class="control-label" for="inputSuccess">性别</label>
						<div class="controls">
							<label class="radio" style="margin-left: 50px;">
								<div class="radio">
									<span class=""> <input type="radio" name="sex"
										id="optionsRadios1" value="option1" checked=""
										style="opacity: 0;">
									</span>
								</div>男
							</label> <label class="radio" style="position: relative; top: 2pt;">
								<div class="radio">
									<span class="checked"> <input type="radio" name="sex"
										id="optionsRadios2" value="option2" style="opacity: 0;">
									</span>
								</div>女
							</label>
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="selectError1">Multiple Select / Tags</label>
						<div class="controls">
						  <select id="selectError1" class="selectroles" multiple data-rel="chosen">
							<option>Option 1</option>
							<option selected>Option 2</option>
							<option>Option 3</option>
							<option>Option 4</option>
							<option>Option 5</option>
						  </select>
						</div>
					  </div>
					  
					  
					<div class="control-group center indent">
						<button type="submit" class="btn btn-primary">批量添加用户</button>
						<button type="submit" class="btn btn-primary">添加一位用户</button>
						<button class="btn">取消</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<!-- 修改结束 -->
</div>
<!-- 查看和修改结束 -->

</div>
<!--/#content.span10-->
</div>
<!--/fluid-row-->
<script src="${pageContext.request.contextPath}/admin/adminJS/addUsers.js"></script>
<script>

</script>
<jsp:include page="foot.jsp"></jsp:include>


