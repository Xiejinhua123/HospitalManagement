$(function(){
	
	$(".namein").css("display","none");
	$(".phonein").css("display","block");
	$(".idcardin").css("display","none");
	
	$(".nav li").click(function(){
		$(".nav li").removeClass("active");
		$(this).addClass("active");
	});
	$(".namebtn").click(function(){
		$(".namein").css("display","block");
		$(".phonein").css("display","none");
		$(".idcardin").css("display","none");
	});
	$(".phonebtn").click(function(){
		$(".namein").css("display","none");
		$(".phonein").css("display","block");
		$(".idcardin").css("display","none");
	});
	$(".idcardbtn").click(function(){
		$(".namein").css("display","none");
		$(".phonein").css("display","none");
		$(".idcardin").css("display","block");
	});
	
	
	$(".login").click(function(){
		window.location.href="/HospitalManagement/JSP/login.jsp";
	});
	
	$(".register").click(function(){
		
		var b = submit();
		if(b){
			
			$(".answer").html("<b>正在注册\n</b><img src='img/ajax-loaders/ajax-loader-5.gif' title='img/ajax-loaders/ajax-loader-5.gif'>");
			$(".answer").css("display","block");
			
			var name = $(".namein input").val();
			var phone = $(".phonein input").val();
			var idcard = $(".idcardin input").val();
			var pwd = $("[name='pwd']").val();
			
			var json;
			if(name.length > 0){
				json = {"PatName":name,"PatPwd":pwd};
			}else if(phone.length > 0){
				json = {"PatPhone":phone,"PatPwd":pwd};
			}else if(idcard.length >0){
				json = {"PatIdCard":idcard,"PatPwd":pwd};
			}
			
			$.ajax({
				type:"post",
				url:"/HospitalManagement/Patients?opr=add",
				data:json,
				dataType:"json",
				success:function(data){
					if(data=="success"){
						
						$(".answer").html("<p>注册成功，点击登录按钮返回登录</p>");
						
					}else if(data == "error"){
						
						$(".answer").html("<p>注册失败，服务器出错，请稍后重新尝试</p>");
						
					}else if(data == "nothing"){
						
						$(".answer").html("<p>注册失败，请检查信息后重新提交</p>");
						
					}else if(data == "hasName" ){
						
						$(".answer").html("<p>当前用户名已经被注册</p>");
						$(".answer").css("display","block");
						
					}else if(data == "hasPhone"){
						
						$(".answer").html("<p>当前手机号码已经被注册</p>");
						$(".answer").css("display","block");
						
					}else if(data == "hasCard"){
						
						$(".answer").html("<p>当前身份证号已经被注册</p>");
						$(".answer").css("display","block");
						
					}else if(data == null){
						
						$(".answer").html("<p>注册失败，请重新尝试</p>");
						$(".answer").css("display","block");						
					}
				}
			});
		}
	});
});

function submit(){
	var name = "";
	var phonestatc = $(".phonein").css("display");
	var namestatc = $(".namein").css("display");
	var idcard = $(".idcardin").css("display");
	
	var phoneregular = /^1(3|4|5|7|8)[0-9]\d{8}$/;
	
	
	if(phonestatc == "block"){
		name = $(".phone").val();
		if(!phoneregular.test(name)){
			$(".answer").html("<p>您的手机号码输入不正确，请检查</p>");
			$(".answer").css("display","block");
			return false;
		}
	}else if(namestatc == "block"){
		name = $(".name").val();
		if(name==""){
			$(".answer").html("<p>用户名不能为空，请检查</p>");
			$(".answer").css("display","block");
			return false; 
		}
	}else if(idcard == "block"){
		name = $(".idcard").val();
		var idcardregular;
		if(name.length == 18)idcardregular = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}[0-9a-zA-Z]{1}$/;
		else if(name.length == 15)idcardregular = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/; 
		else{
			$(".answer").html("<p>请输入15位或者18位身份证号</p>");
			$(".answer").css("display","block");
			return false;
		}
		if(!idcardregular.test(name)){
			$(".answer").html("<p>您的身份证号输入不正确，请检查</p>");
			$(".answer").css("display","block");
			return false;
		}
	}
	
	var pwd = $(".pwd").val();
	var mm = $(".mm").val();
	if(pwd == ""){
		$(".answer").html("<p>密码不能为空，请检查</p>");
		$(".answer").css("display","block");
		return false;
	}
	if(pwd.length < 6){
		$(".answer").html("<p>密码最少为六位，请检查</p>");
		$(".answer").css("display","block");
		return false;
	}
	if(mm != pwd){
		$(".answer").html("<p>两次输入的密码不正确，请检查</p>");
		$(".answer").css("display","block");
		return false;
	}
	
	return true;
}