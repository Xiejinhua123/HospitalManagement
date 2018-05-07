$(function(){
	
	$("#jiuzhen").click(function(){
		window.location.href="/HospitalManagement/JSP/doctor.jsp";
	});
	
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
				var depdata = {"docName":name,"docPwd":pwd};					
				$.ajax({
				   type: "POST",
				   url: "/HospitalManagement/doctor?opr=login",
				   data: depdata,
				   success:function(m){	
						if(m=="success"){
							window.location.href="/HospitalManagement/JSP/doctor.jsp";
						}else if(m=="pwdError"){
							$(".answer").html("<p>密码错误</p>");
							$(".answer").css("display","block");
						}else if(m=="noId"){
							$(".answer").html("<p>该工号不存在，请联系上级处理</p>");
							$(".answer").css("display","block");
						}else if(m==""){
							$(".answer").html("<p>登录失败</p>");
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
	var name = $(".name").val();
	var pwd = $(".pwd").val();
	
	if(name.length == 0){
		$(".answer").html("<p>工号不能为空</p>");
		$(".answer").css("display","block");
		return false;
	}
	if(name.length != 12){
		$(".answer").html("<p>工号必须是12位</p>");
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