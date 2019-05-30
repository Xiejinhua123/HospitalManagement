$(function(){	
	$("#mesName").css({"line-height":"30px","text-align":"center","color":'red'});
	$("#mesPwd").css({"line-height":"30px","text-align":"center","color":'red'});
	$("#name").blur(function(){
		var name=$(this).val();
		if(name=="" || name==null)
		{
			$("#mesName").html("");
			$("#mesName").html("用户名不能为空");
		}
		else 
		{
			checkName(name);
		}
		});
});
function checkName(name)
{
	$.ajax({
		type:"post",
		url:"/VoteManage/checkedName.action",
		data:{"name":name},
		dataType:"json",
		success:function(m){
			if(m=="false")
			{
				$("#mesName").html("");
				$("#mesName").html("账号不存在");
			}
			else $("#mesName").html("");
		}
	});	
}
function dologin()
{
	var html=$("#mesName").html();
	if(html!="") return;
	var name=$("[name='name']").val();
	var pwd=$("[name='password']").val();
	if(name=="" || name==null)
	{
		$("#mesName").html("");
		$("#mesName").html("用户名不能为空");
		return;
	}
	else if(pwd=="" || pwd==null)
	{
		$("#mesPwd").html("");
		$("#mesName").html("");
		$("#mesPwd").html("密码不能为空");
		return;
	}
	else
	{
		$("#mesPwd").html("");
		$.ajax({
			type:"post",
			url:"/VoteManage/doLogin.action",
			data:{"name":name,"pwd":pwd},
			dataType:"json",
			success:function(m){
				if( m == "success" )
					window.location.href="/VoteManage/pagefile/pages/shouye.jsp";
				else if( m == "state" ){
					$("#state").html("");
					$("#state").html("账号状态异常，不允许登录，请更换后重新尝试");
				}
				else{
					$("#mesPwd").html("");
					$("#mesPwd").html("密码错误");
				}
			},
			error:function(m){
				
			}
		});	
	}
}