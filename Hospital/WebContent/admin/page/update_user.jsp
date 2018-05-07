<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String basePathuser = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
<jsp:include page="menu.jsp"></jsp:include>
<script src="<%=basePathuser %>admin/adminJS/update_user.js"></script>

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
         <!-- 下面部分查看和修改信息 -->
<div class="row-fluid sortable">
   <div class="span2"></div>   
    <!-- 修改用户信息 -->
    <div class="box span8">
        <div class="box-header well" data-original-title>
            <h2><i class="icon-user"></i> 修改用户信息</h2>
            <div class="box-icon">
                <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
                <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <p class="badge badge-important center" style="padding: 5px 0;">不能点击属性不可更改</p>
            <form class="form-horizontal" action="<%=basePathuser %>servet/user?ac=update" method="post">
                <fieldset>

                    <div class="control-group indent">
                        <label class="control-label"><a>编号</a></label>
                        <div class="controls" >
                          <span class="uneditable-input"  style="height:25px">201701135677</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>在线状态</a></label>
                        <div class="controls">
                          <span class="uneditable-input" style="height:25px">下线</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label" ><a>创建时间</a></label>
                        <div class="controls">
                          <span class="uneditable-input" style="height:25px">2017/01/01</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次修改时间</a></label>
                        <div class="controls">
                          <span class="uneditable-input" style="height:25px">2017/02/03</span>
                        </div>
                        
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次登录时间</a></label>
                        <div class="controls">
                          <span class=" uneditable-input" style="height:25px">2017/05/04</span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="optionsCheckbox2">姓名</label>
                        <div class="controls">
                          <input type="text" name="name" id="inputSuccess" value="${u.trueName}">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label"   for="optionsCheckbox2">身份证号</label>
                        <div class="controls">
                          <input type="text" name="IdCard" id="inputSuccess" value="${u.idCard}">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success">
                        <label class="control-label" for="inputSuccess">性别</label>
                        
                        <input type="hidden"  value="${u.docSex }" class="hisex">
                        <div class="controls sex" >
                        

                        </div>
                        
                    </div>
                    
                    <div class="control-group success indent">
                      <label class="control-label" for="inputSuccess">出生日期</label>
                      <div class="controls">

                        <input type="text"  name="sr"  class="datepicker" value="${u.docBirthday }">

						<input type="date" name="date" value="2015-03-27" id="date" /> 
                      </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">电话号码</label>
                        <div class="controls">
                          <input type="text" name="TelePhone" id="inputSuccess" value="${u.telePhone}">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">办公室电话</label>
                        <div class="controls">
                          <input type="text" name="OfficePhone" id="inputSuccess" value="${u.officePhone}">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" name="zt" for="inputSuccess">在职状态</label>
                        <div class="controls">
                        <p class="ss" style="display:none">${u.onjobState}</p>
                          <select data-rel="chosen" name="OnjobState" class="zt">
                          </select>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">邮箱</label>
                        <div class="controls">
                          <input type="text" name="Email" id="inputSuccess" value="${u.email}">
                          <span class="help-inline"></span>
                        </div>
                    </div>
  					<p class="bm" style="display:none">${u.department.depName}</p>
                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">部门</label>
                        <div class="controls">
                          <select data-rel="chosen" name="dep" class="selbm">
                          </select>
                        </div>
                    </div>
                    <input type="text" name="userId" value="${u.usersId}" style="display:none">
				<p class="zj" style="display:none">${u.isSpecialist}</p>
                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">挂号类型</label>
                        <div class="controls">
                        
                          <select class="selzj" name="type" >
                          </select>
                        </div>
                    </div>
				<p class="zw" style="display:none">${u.duty}</p>
                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">职位</label>
                        <div class="controls">
                          <select data-rel="chosen" name="duty" class="selzw">
                          </select>
                        </div>
                    </div>
                  <div class="control-group center indent">
                    <button type="submit" class="btn btn-primary">确认修改</button>
                    <button class="btn">取消</button>
                  </div>
                </fieldset>
            </form> 
        </div>
    </div><!-- 修改结束 -->
</div><!-- 查看和修改结束 -->
</div><!--/#content.span10-->
</div><!--/fluid-row-->
<jsp:include page="foot.jsp"></jsp:include>
    
