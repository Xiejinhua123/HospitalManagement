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
            <h2><i class="icon-user"></i>编辑个人信息</h2>
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
                          <span class="uneditable-input">201701100677</span>
                          <input type="hidden" name="id" value="201701100677" />
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
                          <span class="uneditable-input">2017-01-13</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次修改时间</a></label>
                        <div class="controls">
                          <span class="uneditable-input">2017-01-15</span>
                        </div>
                    </div>

                    <div class="control-group indent">
                        <label class="control-label"><a>最后一次登录时间</a></label>
                        <div class="controls">
                          <span class=" uneditable-input">2017-05-26</span>
                        </div>
                    </div>
                    
                    

					<div class="control-group indent a">
                        <label class="control-label"><a>职位</a></label>
                        <div class="controls">
                          <span class="uneditable-input">信息科主任</span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="optionsCheckbox2">姓名</label>
                        <div class="controls">
                          <input type="text" name="name" value="努尔哈赤" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label"   for="optionsCheckbox2">身份证号</label>
                        <div class="controls">
                          <input type="text" name="idCard" value="410325188302222222" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

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
                           
                    
                    <div class="control-group success indent">
                      <label class="control-label" for="inputSuccess">出生日期</label>
                      <div class="controls">
                        <input type="text"  name="DocBirthday"  class="datepicker" value="1970-10-5">
                      </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">电话号码</label>
                        <div class="controls">
                          <input type="text" name="TelePhone" value="132133577889" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">办公室电话</label>
                        <div class="controls">
                          <input type="text" name="OfficePhone" value="132133577889" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">在职状态</label>
                        <div class="controls">
                          <select data-rel="chosen" name="OnjobState">
                            <option>在职</option>
                          </select>
                        </div>
                    </div>

                    <div class="control-group success indent">
                        <label class="control-label" for="inputSuccess">邮箱</label>
                        <div class="controls">
                          <input type="text" name="Email" value="nuerhachi@yiyan.com" id="inputSuccess">
                          <span class="help-inline"></span>
                        </div>
                    </div>
					
					<div class="control-group center indent">
                    <button type="submit" class="btn btn-primary">确认</button>
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
    
