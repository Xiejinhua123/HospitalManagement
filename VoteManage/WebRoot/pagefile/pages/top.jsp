<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

  <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">投票管理系统后台管理</a>
  </div>
  
    <ul class="nav navbar-top-links navbar-right">
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#" >
              <i class="fa fa-user fa-fw"></i> <span id="loginAdmiName"> ${sessionScope.loginAdmin.name }</span>  <i class="fa fa-caret-down"></i>
          </a>
          <ul class="dropdown-menu dropdown-user">
              <li><a href="javascript:void(0)"><i class="fa fa-user fa-fw"></i> <span id="loginAdmiName">${sessionScope.loginAdmin.name}</span></a>
              </li>
              <li onclick="getAdminMes()"><a href="javascript:void(0)"><i class="fa fa-gear fa-fw"></i> 编辑个人信息</a>
              </li>
              <li onclick="updapassword1()"><a href="javascript:void(0)"><i class="fa fa-gear fa-fw"></i> 修改密码</a>
              </li>
              <li class="divider"></li>
              <li><a href="${pageContext.request.contextPath}/adminlogout.action"><i class="fa fa-sign-out fa-fw"></i> 注销登录</a>
              </li>
          </ul>
      </li>
  </ul>
 
	