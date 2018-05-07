$(function(){
	
	$("[name='username']").blur(function(){
		nameCheck();
		
	});
	$("[name='password']").blur(function(){
		pwdChecked();
	});

	$("[name='login']").click(function(){
		$(".clearfix").html("");

		if(nameCheck()==false || pwdChecked()==false){
		}
		else{
			var userName=$("[name='username']").val();
			var passWord=$("[name='password']").val();
			$.ajax({
				type : "post",
				url : "../servet/user?ac=login",
				data :{ "name" : userName,"pwd" : passWord},
				dataType:"JSON",
				success: function(m){
					if(m=="success")
					{
						window.location.href="page/zixun.jsp";
					}
					else if(m == '1')$(".clearfix").append("<p style='color: black;'>用户名或者密码后台没有接收到，请重新尝试</p>");
					else if(m == '2')$(".clearfix").append("<p style='color: black;'>您的工号不存在，请重新尝试</p>");
					else if(m == '3')$(".clearfix").append("<p style='color: black;'>密码错误</p>");
					else if(m == '4')$(".md-trigger").click();
				}
			});
		};
	});
	
});

function nameCheck(){
	
	var userName=$("[name='username']").val();
	if( userName == "" ){
		$(".clearfix").html("<p style='color: black;'>工号不能为空</p>");
		return false;
	}
	if( userName.length != 12 ){
		$(".clearfix").html("<p style='color: black;'>工号应该是12位的，请检查</p>");
		return false;
	}
	$(".clearfix").html("");
	return true;
	
}

function pwdChecked(){
	
	var passWord=$("[name='password']").val();
	if( passWord == "" ){
		$(".clearfix").html("<p style='color: black;'>密码不能为空</p>");
		return false;
	}
	if( passWord.length < 6 ){
		$(".clearfix").html("<p style='color: black;'>密码不能少于6位，请检查</p>");
		return false;
	}
	$(".clearfix").html("");
	return true;
	
}