<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="menu.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/admin/adminCSS/edit.css" rel="stylesheet">
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
            <form class="form-horizontal" action="${pageContext.request.contextPath}/servet/user?ac=editsave" method="post">
                <fieldset>

                    <div class="control-group indent a">
                        <label class="control-label"><a>编号</a></label>
                        <div class="controls">
                          <span class="uneditable-input">${u.usersId}</span>
                          <input type="hidden" name="id" value="${u.usersId}" />
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>在线状态</a></label>
                        <div class="controls">
                          <span class="uneditable-input">在线</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>创建时间</a></label>
                        <div class="controls">
                          <span class="uneditable-input">${u.createTime}</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次修改时间</a></label>
                        <div class="controls">
                          <span class="uneditable-input">${u.modifyTime}</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次登录时间</a></label>
                        <div class="controls">
                          <span class=" uneditable-input">${u.lastLogin }</span>
                        </div>
                    </div>
                    <div class="control-group indent a">
                        <label class="control-label"><a>专家</a></label>
                        <div class="controls">
                          <span class="uneditable-input">不是</span>
                        </div>
                    </div>
                    

					<div class="control-group indent a">
                        <label class="control-label"><a>职位</a></label>
                        <div class="controls">
                          <span class="uneditable-input">${u.duty}</span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="optionsCheckbox2">姓名</label>
                        <div class="controls">
                          <input type="text" name="name" value="${u.trueName }" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label"   for="optionsCheckbox2">身份证号</label>
                        <div class="controls">
                          <input type="text" name="idCard" value="${u.idCard}" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <c:if test="${u.docSex=='001'}">
	                            <div class="control-group success indent">
									<label class="control-label" for="optionsCheckbox2">性别</label>
									<div class="controls" style=" padding-left: 20px;">
									  <label class="radio">
										<input type="radio" name="sex" id="optionsRadios1" value="001" checked="checked">
										男
									  </label>
									  <div style="clear:both"></div>
									  <label class="radio">
										<input type="radio" name="sex" id="optionsRadios2" value="002">
										女
									  </label>
									</div>
								  </div>
                           </c:if> 
                           
                        <c:if test="${u.docSex=='002'}">
                         	<div class="control-group success indent">
						<label class="control-label" for="optionsCheckbox2">性别</label>
						<div class="controls" style=" padding-left: 20px;">
						  <label class="radio">
							<input type="radio" name="sex" id="optionsRadios1" value="001" >
							男
						  </label>
						  <div style="clear:both"></div>
						  <label class="radio">
							<input type="radio" name="sex" id="optionsRadios2" value="002" checked="checked">
							女
						  </label>
						</div>
					  </div>
                        </c:if> 
                    
                    <div class="control-group success indent">
                      <label class="control-label" for="inputSuccess">出生日期</label>
                      <div class="controls">
                        <input type="text"  name="DocBirthday"  class="datepicker" value="${u.docBirthday}">
                      </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">电话号码</label>
                        <div class="controls">
                          <input type="text" name="TelePhone" value="${u.telePhone}" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">办公室电话</label>
                        <div class="controls">
                          <input type="text" name="OfficePhone" value="${u.officePhone}" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">在职状态</label>
                        <div class="controls">
                          <select data-rel="chosen" name="OnjobState">
                            <option>${u.onjobState}</option>
                          </select>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">邮箱</label>
                        <div class="controls">
                          <input type="text" name="Email" value="${u.email}" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>
					
					
                    

					<div class="control-group center indent">
                    <button type="submit" class="btn btn-primary">确认修改</button>
                    <button class="btn">取消</button>
                  </div>
					
                   <!-- <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">部门</label>
                        <div class="controls">
                          <span class="uneditable-input"><c:if test="${u.department.depName!=null}">${u.department.depName}</c:if></span>
                        </div>
                    </div>-->
                  
                </fieldset>
            </form> 
        </div>
    </div><!-- 修改结束 -->
</div><!-- 查看和修改结束 -->

</div><!--/#content.span10-->
</div><!--/fluid-row-->

<jsp:include page="foot.jsp"></jsp:include>
    
