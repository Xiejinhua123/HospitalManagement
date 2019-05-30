$(function(){
	
	$("#updateBtn").hide();
	
	$(".mes").css("color","red");
	
	getAllBall();//获取所有龙珠
	
	$(".update").live("click",function(){
		var id = $(this).parent().parent().find(".id").text();
		var obj = getById( id );
		$("#updateBtn").click();
	});
	//修改龙珠信息
	$(".saveBall").click(function(){
		updateball();
	});
});
//修改龙珠信息
function updateball()
{
	var id=$(".ballid").html();
	var name=$(".upName").val();
	var gl=$(".upgl").val();
	var a=judgeSign(gl);
	if(name=="" || name==null)
	{
		$(".mes").html("名称不能为空");
		return;
	}
	else if(gl=="" || gl==null)
	{
		$(".mes").html("概率不能为空");
		return;
	}
	else if(a=="不是数字" || a=="是负数")
	{
		$(".mes").html("概率输入错误,请重新输入");
		return;
	}
	else{
		$.ajax({
			type:"post",
			dataType:"json",
			data:{"ball.id":id,"ball.ballName":name,"ball.probability":gl},
			url:"/VoteManage/updateBall.action",
			success:function(m){
				$("#updateBtn").click();
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
				getAllBall();
			}
		});
	}
}

/**
 * 通过编号获取当前的龙珠信息
 * 
 * @param id
 * 		龙珠的编号
 * @returns
 * 		将获取到的龙珠的详细信息返回，<br/>
 * 		应当是一个BallModel
 */
function getById(id){
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"id":id},
		url:"/VoteManage/getById.action",
		success:function(m){
			$(".ballid").html(m.id);
			$(".upName").val(m.ballName);
			$(".upgl").val(m.probability);
		}
	});
}

function getBallxx(id)
{
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"id":id},
		url:"/VoteManage/getBallxx.action",
		success:function(m){
			$("#ballxx tr:eq(0) td:eq(1)").html(m.id);
			$("#ballxx tr:eq(1) td:eq(1)").html(m.ballName);
			$("#ballxx tr:eq(2) td:eq(1)").html(m.probability);
			$("#ballxx tr:eq(3) td:eq(1)").html(m.text);
			$("#ballxx tr:eq(4) td:eq(1)").html(m.putIntoNumber);
			$("#ballxx tr:eq(5) td:eq(1)").html(m.exchangeNumber);
			$("#ballxx tr:eq(6) td:eq(1)").html(m.userballNumber);
		}
	});
}
/**
 * 获取全部龙珠信息
 */
function getAllBall()
{
	var html="";
	 $.ajax({
			type:"post",
			dataType:"json",
			url:"/VoteManage/getAllBall.action",
			success:function(m){
				$.each(m,function(i,n){
					html+=" <tr>";
					html+=" <td class='id7 id'>"+n.id+"</td>";
					html+=" <td>"+n.ballName+"</td>";
					html+=" <td class=''ball7'>"+n.probability+"</td>";
					html+="  <td>";
					html+=" <button type='button' class='btn btn-info' data-toggle='modal' data-target='#infoModal' onclick='getBallxx("+n.id+")'>详情</button>";
					html+=" <button type='button' class='btn btn-warning update' onclick='getById("+n.id+")'>修改</button>";
					html+="  </td>";
					html+="  </tr>";
				});
				$(".dragin").html(html);
			}
		}); 
}


//检测是否为正数
function judgeSign(num) {
    if ( Number(num) ) {
            var absVal = Math.abs(num);
            return num==absVal?'是正数':'是负数';
    }
    else {
            return '不是数字';
    }
}
