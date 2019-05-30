$(function(){
	$(".new2pwd").blur(function(){
		
		var newpwd=$(".newpwd").val();
		var new2pwd=$(".new2pwd").val();
		if(new2pwd!=newpwd)
		{
			$(".mesage3").html("两次密码不一致");
		}else{
			$(".mesage3").html("");
		}
	});
});
function getAdminMes()
{
	$(".updatetan1").click();
	$.getJSON("/VoteManage/getAdminMsg.action", function(json){
		 $(".adminId").val(json.id);
		 $(".adminId").attr("readonly","readonly");
		 $(".manageAccount").val(json.manageAccount);
		 $(".names").val(json.name);
		});
}

//修改管理员信息
function updateAdminMes()
{
	var id=$(".adminId").val();
	var  manageAccount=$(".manageAccount").val();
	var name=$(".names").val();
	if(manageAccount==null ||manageAccount=="")
	{
		$(".mesage2").html("请输入用户名");
		return;
	}
	else if(name==null ||name=="")
	{
		$(".mesage2").html("请输入名称");
		return;
	}
	$(".updatetan1").click();
	$.ajax({
		type:"post",
		dataTyoe:"json",
		url:"/VoteManage/updateAdminMes.action",
		data:{"admin.name":name,"admin.id":id,"admin.manageAccount":manageAccount},
		success:function(m){
			$(".mesage2").html("");
			$("#loginAdmiName").html(m.name);
			$(".successs1").html("修改成功");
			$(".updatetx1").click();
		}
		
	});
}

function updapassword1()
{
	$(".uppassword1").click();
}
//修改密码
function updapassword()
{
	var ypwd=$(".ypwd").val();
	var newpwd=$(".newpwd").val();
	var new2pwd=$(".new2pwd").val();
	if(ypwd=="" || ypwd==null)
	{
		$(".mesage3").html("原密码不能为空");
		return;
	}
	if(newpwd=="" || newpwd==null)
	{
		$(".mesage3").html("新密码不能为空");
		return;
	}
	if(newpwd.length<3)
	{
		$(".mesage3").html("密码至少三位数");
		return;
	}
	if(new2pwd!=newpwd)
	{
		$(".mesage3").html("两次密码不一致");
		return;
	}else
	{$(".uppassword1").click();
		$.ajax({
			type:"post",
			data:{"pwd":ypwd,"newPwd":newpwd},
			dataTyoe:"json",
			url:"/VoteManage/updatePassword.action",
			success:function(m){
				$(".mesage3").html("");
				$(".successs1").html("修改成功");
				$(".updatetx1").click();
				window.location.href = "/VoteManage/pagefile/pages/login.htm";
			}
		});
	}
}

