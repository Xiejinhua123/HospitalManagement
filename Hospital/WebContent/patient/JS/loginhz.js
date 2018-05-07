$(function(){
	
$(".hzlogin").click(function(){
	var name=$("input").eq(0).val();
	var pwd=$("input").eq(1).val();
	if(name=="")
	{
		$("#li").css("display","block");
		$(".ts").html("账号不能为空");
		$(".ts").css("color","red");
		return;
	}
	else if(pwd=="")
	{
		$("#li").css("display","block");
		$(".ts").html("密码不能为空");
		$(".ts").css("color","red");
		return;
	}
	else
	{
		$.ajax({
		 type : "post",
		 url :"../../../Hospital/servlet/patient?opr=patLogin",
		 data :{"name":name,"pwd":pwd},
		 dataType:"json",
		 success:function(m){
			 console.log(m);
			if(m=="name")
			{
				$("#li").css("display","block");
				$(".ts").html("登录失败，账号不存在");
				$(".ts").css("color","red");
			}
			else if(m=="pwd")
			{
				$("#li").css("display","block");
				$(".ts").html("登录失败，密码错误");
				$(".ts").css("color","red");
			}else if( m == "have login" ){
				$("#nologin").click();
			}
			else if(m=="yes")
			{
				console.log(m);
				$(".ts").html("");
				window.location.href="page/guahao.html";
			}
		 },
		 error:function(m){
			 $(".ts").html("请求失败，有可能是服务器问题请稍后重新尝试");			
		 }
		})
	}
})
})