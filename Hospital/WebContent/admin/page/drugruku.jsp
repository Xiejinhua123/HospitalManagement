<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:include page="menu.jsp"></jsp:include>
<div>
	<ul class="breadcrumb">
		<li>
			<a href="#">管理</a> <span class="divider">/</span>
		</li>
		<li>
			<a href="#">药品管理</a>
		</li>
	</ul>
</div>
<div class="span2">	</div>
<div class="box span8">

			<div class="box-header well headertitle" style="height:35px;" data-original-title>
	           <h2><i class="icon-user"></i> 药品入库</h2>
	           <div class="box-icon">
	           </div>
      		 </div>
      		 <div class="box-content" style="height:500px;">
					<label></label>
				<h3 Style="margin-left:200px; height:60px; line-height:60px;">名称：复方氨酚葡锌片</h3>
				<h3 Style="margin-left:200px; height:60px; line-height:60px;">  进货时间：<input style="height: 30px;" type="date" name="date" id="date"/> </h3>
				<h3 Style="margin-left:200px; height:60px; line-height:60px;">  进货数量：<input style="height: 30px;" type="text">箱</h3>
				<h3 Style="margin-left:200px; height:60px; line-height:60px;">  生产日期：<input style="height: 30px;" type="date" name="date" id="date"/> </h3>
				<h3 Style="margin-left:220px; height:60px; line-height:60px;">  保质期：<input style="height: 30px;" type="text"></h3>
				
				<a href="drug.jsp" class="btn" Style="margin-left:300px;margin-top:40px">取消</a>
				<a href="#" id="sub" Style="margin-left:40px; margin-top:40px" class="btn btn-primary">提交</a>
			</div>
			</div>
	<div class="modal hide fade" id="deleteDicMobile">
	<div class="modal-header">
		<button type="button" class="close closeModal" data-dismiss="modal">×</button>
		<h3>药品入库</h3>
	</div>
	<div class="modal-body">
		提交成功！
	</div>
	<div class="modal-footer">
	<p style="display:none" id="int"></p>
		<a href="#" class="btn closeModal" data-dismiss="modal">关闭</a>
		<a href="#"	class="btn btn-primary" id="delidsub">确定</a>
	</div>
	<input type="hidden">
</div>
<script src="../js/jquery-1.8.3.js"></script>	
<script>
$(function(){
	$("#sub").click(function(){
		$("#deleteDicMobile").addClass("in");
		$("#deleteDicMobile").css("display","block");
	})
})
</script>
<jsp:include page="foot.jsp"></jsp:include>