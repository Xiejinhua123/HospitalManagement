$(function(){
	
	$(".logout").click(function(){
		$.ajax({
			type:"posts",
			url:"/HospitalManagement/Patients?opr=logout",
			dataType:"json",
			success:function(data){
				if(data=="success"){
					window.location.href="/HospitalManagement/JSP/login.jsp";
				}
			}
		});
	});
	
	$(".submit").click(			
		function(){
			var bo = submit();
			if(bo == true){
				$(".answer").html("<b>正在登陆\n</b><img src='img/ajax-loaders/ajax-loader-5.gif' title='img/ajax-loaders/ajax-loader-5.gif'>");
				$(".answer").css("display","block");
				var name = $(".name").val();
				var pwd = $(".pwd").val();					
				var depdata = {"patName":name,"patPwd":pwd};					
				$.ajax({
				   type: "POST",
				   url: "/HospitalManagement/Patients?opr=login",
				   data: depdata,
				   success:function(m){	
						if(m=="success"){
							window.location.href="/HospitalManagement/JSP/registration.jsp";
						}else if(m=="pwdError"){
							$(".answer").html("<p>登录失败，密码错误，请检查后重新登陆</p>");
							$(".answer").css("display","block");
						}else if(m=="noName"){
							$(".answer").html("<p>登录失败，用户信息不存在，请检查后重新登陆</p>");
							$(".answer").css("display","block");
						}
				   }
				});
			}
		}
	);
	
	$(".btn1").click(function(){
		window.location.href="/HospitalManagement/JSP/zhuce.jsp";
	});
	
	$(".btn2").click(function(){
		window.location.href="/HospitalManagement/JSP/zhuce.jsp";
	});
});
function submit(){
	console.log("开始");
	var name = $(".name").val();
	var pwd = $(".pwd").val();
	
	if(name.length <= 0){
		$(".answer").html("<p>当前的用户信息不能为空</p>");
		$(".answer").css("display","block");
		return false;
	}
	if(!pwd){
		$(".answer").html("<p>密码不能为空</p>");
		$(".answer").css("display","block");
		return false;
	}
	if(pwd.length < 6){
		$(".answer").html("<p>密码不能少于六位</p>");
		$(".answer").css("display","block");
		return false;
	}
	return true;
}