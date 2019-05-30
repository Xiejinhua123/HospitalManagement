$(function(){
		$(".tj").click(function(){
		var name=$("[name=name]").val();
		var pwd=$("[name=pwd]").val();
		$.ajax({
			dataType:"json",
			data:{"name":name,"pwd":pwd},
			url:"VoteManage/userdoLogin.action",
			success:function(m){
				alert(m);
			}
		});		
		});
});