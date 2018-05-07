<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String basePathuser = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
<jsp:include page="/admin/page/menu.jsp"></jsp:include>
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
<c:if test="${u == null }">

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
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
	</head>
	<body>

		<div class="md-modal md-effect-19" id="modal-19">
			<div class="md-content">
				<h3 style="background: red;"><span style="color: black;">没有数据可以显示</span></h3>
				<div>
					<p>原因有可能：</p>
					<ul>	
						<li><strong>一、</strong>网络断开</li>
						<li><strong>二、</strong>非法访问</li>
					</ul>
					<p>请您稍后重新以正确的形式访问</p>
					<button class="md-close">关闭</button>
				</div>
			</div>
		</div>

		<button id="setting" style="display: none;" class="md-trigger md-setperspective" data-modal="modal-19">Slip from top</button>

		<div class="md-overlay"></div><!-- the overlay element -->
	</body>
</html>

<script>
	var polyfilter_scriptpath = '/js/';
</script>
<script src="js/index.js"></script>
<script type="text/javascript">
setTimeout(function(){$("#setting").click();}, 1000);
</script>


</c:if>

         <!-- 下面部分查看和修改信息 -->
<div class="row-fluid sortable">
	<div class="span2"></div>
      <!-- 查看开始 -->
   <div class="box span8">
       <div class="box-header well" data-original-title>
           <h2><i class="icon-user"></i> 查看用户信息</h2>
           <div class="box-icon">
               <a href="#" class="btn btn-round"><i class="icon-cog"></i></a>
               <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
               <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
           </div>
       </div>
       <div class="box-content" style="padding-bottom: 20px;">
           
<from class="form-horizontal">
               <fieldset>
                   <div class="control-group badge" style="font-size:20px;">
                       <label class="control-label" for="disabledInput" style="font-size:20px;"><b>编号</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="idd" valign="middle"  style="font-size:20px; margin-left:20px;">${u.usersId}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>姓名</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.trueName}</p>
                       </div>
                   </div>

                   <div class="control-group badge" >
                       <label class="control-label" style="font-size:20px;"><b>在线状态</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class=""  style="font-size:20px; margin-left:20px;">${u.onlineState}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>创建时间</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.createTime}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>最后一次修改时间</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.modifyTime}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>最后一次登录时间</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.lastLogin}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>身份证号</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.idCard}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>性别</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.docSex}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>出生年月</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.docBirthday }</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>电话号码</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.telePhone}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>办公室电话</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;">${u.officePhone}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>在职状态</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.onjobState}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>邮箱</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.email}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>所在部门</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="" style="font-size:20px;margin-left:20px;">${u.department.depName }</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>专家情况</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="isSpecialist" style="font-size:20px;margin-left:20px;">${u.isSpecialist}</p>
                       </div>
                   </div>

                   <div class="control-group badge">
                       <label class="control-label" style="font-size:20px;"><b>职位</b></label>
                       <div class="controls" style="position: relative; top: 6px;">
                         <p class="duty" style="font-size:20px;margin-left:20px;">${u.duty}</p>
                       </div>
                   </div>
</fieldset>
</from>
                   <div class="control-group center">
                   <a href="../admin/page/user.jsp"><button class="btn btn-primary" >查看更多</button></a>
                 <a href="../../../Hospital/servet/user?ac=getUse1&userId=${u.usersId}">  <button class="btn btn-primary">点击修改</button></a>
                 </div>

       </div>

   </div><!--/查看用户信息结束-->
   
</div><!-- 查看和修改结束 -->
</div><!--/#content.span10-->
           
</div><!--/fluid-row-->
<hr>
 <jsp:include page="/admin/page/foot.jsp"></jsp:include>