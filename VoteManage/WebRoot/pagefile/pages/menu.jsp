<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
          <ul class="nav" id="side-menu">
          
          <c:if test="${sessionScope.menuHtml == '' }">
          
          	<li>您暂无任何权限信息，联系上级为您的账号添加访问权限</li>
          
          </c:if>
          
           <c:if test="${sessionScope.menuHtml != '' }">
          
          	 ${sessionScope.menuHtml }
          	 
          </c:if>
           
          </ul>
      </div>
  </div>
</nav>