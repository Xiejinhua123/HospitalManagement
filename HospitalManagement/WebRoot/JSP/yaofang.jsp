<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'yaofang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<STYLE type="text/css">
td{ text-align: center;}
</STYLE>
  </head>
  
  <body>
  <div style="margin: 0px auto; width: 900px; text-align: center;">
	  <h2>XXXX医院药房系统</h2>
	   <table style="width: 900px;">
	   		<tr>
	   			<td width="300">药品名称</td>
	   			<td width="300">数量</td>
	   			<td width="300">单价</td>
	   		</tr>
	   		<c:forEach items="${list}" var="d">
	   		<tr>
	   			<td width="300">${d.drugName}</td>
	   			<td width="300">${d.drugNum}</td>
	   			<td width="300">${d.drugPrice}</td>
	   		</tr>
	   		</c:forEach>
	   </table>
   </div>
  </body>
</html>
