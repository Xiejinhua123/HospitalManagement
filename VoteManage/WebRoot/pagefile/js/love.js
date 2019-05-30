$(function(){
	getlLove();
});
function getlLove()
{
	$.ajax({
		type:"post",
		dataType:"json",
		url:"VoteManage/selLove.action",
		success:function(m)
		{
			$(".id").val(m.id);
			$(".lj_tfl").html(m.putNumber);
			$(".dh_hsl").html(m.recycleNumber);
			$(".gl").html(m.probability);
			$(".one").html(m.proportion);
			$(".user_love").html(m.loveNumber);
		}
		
		
	});

}
function updateL()
{
	var gl=$(".progl").val();
	var text=$(".text").val();
	var id=$(".id").val();
	if(gl=="")gl=null;
	if(text=="")text=null;
	$.ajax({
		type:"post",
		data:{"love.probability":gl,"love.proportion":text,"love.id":id},
		dataType:"json",
		url:"VoteManage/updateLove.action",
		success:function(m)
		{
			if(m=='true')
			{
				$(".successs").html("修改成功");
				$(".updatetxk").click();
			}
			else
			{
				$(".successs").html("修改失败");
				$(".updatetxk").click();
			}
			getlLove();
		}
	});
}
