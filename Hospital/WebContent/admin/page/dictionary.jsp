<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="menu.jsp"></jsp:include>
<script src="../adminJS/dictionary.js"></script>
<div>
	<ul class="breadcrumb">
		<li><a href="#">开始</a> <span class="divider">/</span></li>
		<li><a href="#">数据字典管理</a></li>
	</ul>
</div>
</div>

<!--/#content.span10-->

<div id="" class="span2">
	<div class="row-fluid">
		<div class="box span12">
			<div class="box-header well headertitle">
			
				<h2>数据字典维护 谨慎操作</h2>
				
			</div>
			<div class="box-content" id="typeName">
				<div class="center box" style="padding: 10px;">数据字典类型</div>
				<div class='center'><span class='icon32 icon-add addDic'></span></div>
				<div class="center type">
					<div class="center box padd">性别
						<p class="center" style="display: block;">
							<span class="icon32 icon-darkgray icon-gear updateType"></span>
							<span class="icon32 icon-darkgray icon-trash deleteType"></span>
						</p>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

<div id="" class="span8">

	<!-- 数据字典整体详情 -->
	<div class="row-fluid">
		<div class="box span12">
			<div class="box-header well headertitle">
				<h2>当前操作：<span id='caozuo'>性别</span></h2>
				<div class="box-icon">
					<span class="btn addDic">点击添加</span>
				</div>
			</div>

			<!-- 数据字典详情 -->
			<div class="box-content" id="values">
			
				<!-- 每四个为一条 -->	
				<div class = "row-fluid">
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12131</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
				
							
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12132</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
				
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12133</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>

				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12134</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
			</div>
			<!-- 每四个为一条 -->
			<div class="row-fluid">

				
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12135</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
				
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">12136</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
				
				<div class="box span3 details">
				
					<table class="table">
						<tr>
							<td align="right">类型名称：</td>
							<td align="left">1217</td>
						</tr>
						<tr>
							<td align="right">名称：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">是否禁用：</td>
							<td align="left">12138</td>
						</tr>
						<tr>
							<td align="right">备注：</td>
							<td align="left">12138</td>
						</tr>
					</table>
					
					<p class="box center">
						<span class="icon32 icon-darkgray icon-gear updateDic"></span>
						<span class="icon32 icon-darkgray icon-trash deleteDic"></span>
						<span class="icon32 icon-darkgray icon-close closeDic"></span>
					</p>
				</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 数据字典整体详情结束 -->

</div>


<!--/fluid-row-->
<hr>
<!-- 修改字典类型弹窗 -->
<div class="modal hide fade" id="updateDicTypeMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>修改数据字典类型</h3>
	</div>
	<div class="modal-body">
		<table class="table">
			<tr>
				<td align="right">原名称：</td>
				<td align="left" id="oldName">12138</td>
			</tr>
			<tr>
				<td align="right">修改后的名称：</td>
				<td align="left">
					<input type="text" id="newName" style="width: 50%; height: 100%;">
				</td>
			</tr>
		</table>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="updateSub">提交</a>
	</div>
</div>

<!-- 删除数据字典类型弹窗 -->
<div class="modal hide fade" id="deleteDicTypeMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>您确定要删除该项类型信息吗？</h3>
		
		<p style="display:none" id="names"></p>
	</div>
	<div class="modal-body">
		数据字典对于程序的运行异常关键，在删除时务必小心！当前操作有可能导致数据紊乱，程序出现崩溃
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="delsub">提交</a>
	</div>
	<input type="hidden">
</div>

<!-- 添加数据字典弹窗 -->
<div class="modal hide fade" id="addDicMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>添加数据字典类型</h3>
	</div>
	<div class="modal-body">
		<table class="table">
			<tr>
				<td align="left">唯一标识码：</td>
				<td align="left"><input name="TypeCode" type="text" style="width: 50%; height: 100%;"></td>
			</tr>
			<tr>
				<td align="right">类型名称：</td>
				<td align="left"><input name="TypeName" type="text" style="width: 50%; height: 100%;"></td>
			</tr>
			<tr>
				<td align="right">名称：</td>
				<td align="left"><input name="TypeValus" type="text" style="width: 50%; height: 100%;"></td>
			</tr>
			<tr>
				<td align="right" >是否禁用：</td>
				<td align="left">
					<select name="IsVisible">
						<option value="0">禁用</option>
						<option value="1">不禁用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" name="Memo">备注：</td>
				<td align="left"><textarea rows="3" cols="20"></textarea></td>
			</tr>
		</table>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="add">提交</a>
	</div>
</div>

<!-- 修改字典弹窗 -->
<div class="modal hide fade" id="updateDicMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>修改数据字典</h3>
	</div>
	<div class="modal-body">
		<table class="table">
			<tr>
				<td align="right">编号：</td>
				<td align="left" id="bh">12138</td>
			</tr>
			<tr>
				<td align="right">唯一标识码：</td>
				<td align="left">
					<input type="text" style="width: 50%; height:100%;" id="wysbm">
				</td>
			</tr>
			<tr>
				<td align="right">类型名称：</td>
				<td align="left">
					<input type="text" style="width: 50%; height:100%;" id="leixing">
				</td>
			</tr>
			<tr>
				<td align="right">名称：</td>
				<td align="left">
					<input type="text" style="width: 50%; height:100%;" id="mingcheng">
				</td>
			</tr>
			<tr>
				<td align="right">是否禁用：</td>
				<td align="left">
					<select id="selected">
						<option value="0">禁用</option>
						<option value="1">不禁用</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">备注：</td>
				<td align="left">
					<textarea rows="3" cols="20" id="beizhu"></textarea>
				</td>
			</tr>
		</table>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="tijiao">提交</a>
	</div>
	<input type="hidden">
</div>

<!-- 删除数据字典弹窗 -->
<div class="modal hide fade" id="deleteDicMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>您确定要删除该项信息吗？</h3>
	</div>
	<div class="modal-body">
		数据字典对于程序的运行异常关键，在删除时务必小心！当前操作有可能导致数据紊乱，程序出现崩溃
	</div>
	<div class="modal-footer">
	<p style="display:none" id="int"></p>
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="delidsub">确定</a>
	</div>
	<input type="hidden">
</div>




<jsp:include page="foot.jsp"></jsp:include>

