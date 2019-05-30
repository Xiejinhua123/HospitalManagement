$(function(){
	$.ajax({
		type:"post",
		data:{"name":"1" , "pwd":"123456"},
		dataType:"json",
		url:"/VoteManage/userdoLogin.action",
		success:function(msg){
			console.log(msg);
		},
		error:function(msg){
			console.log(msg);
		}
	});
});