<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>处方</title>
</head>
<body>
<form>
		<label style="font-size: 25px; text-align: center;"><span style="color:red;">*</span>为必填项</label>
		    <ul data-role="listview" data-inset="true" data-theme="f">		    
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">请输入真实姓名：</label><span style="color: red;" class='checkName'></span>
		           <br/>
		            <input name='name' placeholder="真实姓名" data-clear-btn="true" type="text"/><span style="font-size:35px;color: red;"> *</span>
		        </li>
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">请输入密码：</label><span style="color: red;" class='checkPwd'></span>
		           <br/>
		            <input name='pwd' placeholder="请输入6到18位的密码" data-clear-btn="true" type="password"/><span style="font-size:35px;color: red;"> *</span>
		        </li>
		         <li data-role="fieldcontain">
		            <label style="font-size: 25px;">请确认密码：</label><span style="color: red;" class='qrPwd'></span>
		           <br/>
		            <input name='qrpwd' placeholder="请确认密码" data-clear-btn="true" type="password"/><span style="font-size:35px;color: red;"> *</span>
		        </li>
		        
		        
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">请输入身份证号：</label><span style="color: red;" class='card'></span>
		           <br/>
		            <input name='card'  placeholder="身份证号" data-clear-btn="true" type="text"/>
		        </li>
		        
		        
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">请输入手机号：</label><span style="color: red;" class='phone'></span>
		           <br/>
		            <input name='tel' placeholder="手机号码" data-clear-btn="true" type="text"/>
		        </li>
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">选择性别：</label>
		            <select  name="flip2" id="flip2" data-role="slider">
		                <option value="001">男</option>
		                <option value="002">女</option>
		            </select>
		        </li>
		        <li data-role="fieldcontain">
		        	<label style="font-size: 25px;">出生日期：</label><span style="color: red;"></span>
		        	<br/>
					<input type="date" name="date" id="date"/> 
		        </li>
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">家庭住址:</label><span style="color: red;"></span>
		            	<br/>
		        	<textarea cols="40" rows="8" name="address" id="textarea2" class="address"></textarea>
		        </li>
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">过敏症状:</label><span style="color: red;"></span>
		            	<br/>
		        	<textarea cols="40" rows="8" name="textarea2" class="bz"></textarea>
		        </li>
		        <li data-role="fieldcontain">
		            <label style="font-size: 25px;">遗传病史:</label><span style="color: red;"></span>
		            	<br/>
		        	<textarea cols="40" rows="8" name="textarea2" class="bs"></textarea>
		        </li>
		        <li data-role="fieldcontain">
		            <input style="font-size: 25px;" data-clear-btn="true" value="注册" type="button" id="zc"/>
	             </li>
	             <li data-role="fieldcontain" onclick="window.location.href='login.html'">
		            <input style="font-size: 25px;" data-clear-btn="true" value="已有账号    点击登录" type="button"/>
	             </li>
		    </ul>
		</form>
</body>
</html>