$(function(){
		$(".updatetan1").hide();
		$(".updatetx").hide();
		$(".updatetan").hide();
		$(".deletetx").hide();
		getGoods();//获取商品
		getAweardsByBoxGame();
		//删除
		$(".determines").click(function(){
			$.ajax({
					type:"post",
					dataType:"json",
					data:{"awardId":aid},
					url:"VoteManage/deleteAward.action",
					success:function(m){
						$(".deletetx").click();
						getAweardsByBoxGame();
					}
				});
			});
			//修改
			$(".savel").click(function(){
				 	var id=$(this).attr("name");
				 	update(id);
			});
			//商品名称变化
			$(".goodsNameInput").change(function(){
				var name=	$(".goodsNameInput").val();
				if(name=="无")
				{
					$("[name='goodsNumber']").val(0);
					$("[name='goodsNumber']").attr("readOnly",true);
				}
				else
				{
					$("[name='goodsNumber']").attr("readOnly",false);
				}
			});
			//龙珠变化
			$(".ballInput").change(function(){
				var ballName=	$(".ballInput").val();
				if(ballName=="无")
				{
					$("[name='ballNumber']").val(0);
					$("[name='ballNumber']").attr("readOnly","true");
				}
				else if(ballName!="无")
				{
					$("[name='ballNumber']").attr("readOnly",false);
				}
			});
});
function getAweardsByBoxGame(pagesize)
{
	var html="";
	if(pagesize==null)pagesize=1;
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"gameId":2,item:10,pageSize:pagesize},
		url:"VoteManage/getAweardsByGameId.action",
		success:function(n){
			$.each(n.rows,function(i,m){
				html+="<tr>";
				html+="<td>"+m.id+"</td>";
				if(m.loveNumber!=null)html+="<td>"+m.loveNumber+"</td>";
				else html+="<td>0</td>";
				if(m.boxNumber!=null)html+="<td>"+m.boxNumber+"</td>";
				else html+="<td>0</td>";
				if(m.goodsName!=null)html+="<td>"+m.goodsName+"</td>";
				else html+="<td>无</td>";
				if(m.goodsNumber!=null)html+="<td>"+m.goodsNumber+"</td>";
				else html+="<td>0</td>";
				if(m.ballName!=null)html+="<td>"+m.ballName+"</td>";
				else html+="<td>无</td>";
				if(m.ballNumber!=null)html+="<td>"+m.ballNumber+"</td>";
				else html+="<td>0</td>";
				if(m.participation!="")html+="<td>"+m.participation+"</td>";
				else html+="<td>无</td>";
				if(m.probability!=null)html+="<td>"+m.probability+"</td>";
				else html+="<td>0</td>";
				if(m.deletes=="1")
				{
					html+="<td>是</td>";
					html+="<td><button type='button' class='btn btn-warning' onclick='getAwardsById()'>修改</button>" +
					" <button type='button' class='btn btn-warning' onclick='deleteAwards()'>删除</button></td>";
				}
				else
				{
					 html+="<td>否</td>";
					 html+="<td><button type='button' class='btn btn-warning' onclick='getAwardsById("+m.id+")'>修改</button>" +
						" <button type='button' class='btn btn-warning' onclick='deleteAwards("+m.id+")'>删除</button></td>";
				}
		
				html+="</tr>";
			});
			var h="";
			var m=n;
			if(m.rows==null)return;
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount) getAllGoods(8,pagesize-1);
			$(".pagegood").html(h);
			$(".dragin").html(html);
		}
	});
}
//上一页
function onpage(size)
{
	var pagesize=size-1;
	getAweardsByBoxGame(pagesize);
}

//下一页
function downpage(size)
{
	var pagesize=size+1;
	getAweardsByBoxGame(pagesize);
}
var aid;
function deleteAwards(id)
{
	if(id==null)
	{
		$(".error").click();
		return;
	}
	$(".deletetx").click();
	aid=id;
}
function tiaozhuan()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		getAweardsByBoxGame(pageNmber);
	}
}
/**
 * 根据id查找单个
 * @param id
 */
function getAwardsById(id)
{
	if(id==null)
	{
		$(".error").click();
		return;
	}
	$(".savel").attr("name",id);
	$.ajax({
		type:"post",
		data:{"awardId":id},
		dataType:"json",
		url:"/VoteManage/getAwardsById.action",
		success:function(m){
			console.log(m);
			if(m.loveNumber!=null)$("[name=ax]").val(m.loveNumber);
			else $("[name=ax]").val(0);;
			if(m.boxNumber!=null)$("[name='box']").val(m.boxNumber);
			else $("[name='box']").val(0);
			if(m.goodsName!=null)
			{
			$(".goodsNameInput option").attr("selected",false);
			$(".goodsNameInput option[value='"+m.goodsName+"']").attr("selected",true);
			}
			else
			{
				$(".goodsNameInput option").attr("selected",false);
				$(".goodsNameInput option[value='无']").attr("selected",true);
			}
			if(m.goodsNumber!=null)$("[name='goodsNumber']").val(+m.goodsNumber);
			else $("[name='goodsNumber']").val(0);
			if(m.ballName!=null)
			{
			$(".ballInput option[value='"+m.ballName+"']").attr("selected","selected");
			}
			else $(".ballInput option[value='无']").attr("selected","selected");
			if(m.ballNumber!=null)$("[name='ballNumber']").val(m.ballNumber);
			else $("[name='ballNumber']").val(0);
			if(m.participation!="")$("[name=cyj]").val(m.participation);
			else $("[name=cyj]").val("无	");;
			if(m.probability!=null)$("[name='probability']").val(m.probability);
			else $("[name='probability']").val(0);
			
			var name=$(".goodsNameInput").val();
			if(name=="无")
			{
				$("[name='goodsNumber']").val(0);
				$("[name='goodsNumber']").attr("readOnly",true);
			}
			else
			{
				$("[name='goodsNumber']").attr("readOnly",false);
			}
			var ballName=	$(".ballInput").val();
			if(ballName=="无")
			{
				$("[name='ballNumber']").val(0);
				$("[name='ballNumber']").attr("readOnly","true");
			}
			else if(ballName!="无")
			{
				$("[name='ballNumber']").attr("readOnly",false);
			}
		}
	});
	$(".updatetan").click();
}
//修改
function update(id){
	var ax=	$("[name=ax]").val();
	var box=	$("[name='box']").val();
	var name=	$(".goodsNameInput").val();;
	var goodsNumber=	$("[name='goodsNumber']").val();
	var ballName=	$(".ballInput").val();
	var ballNumber =	$("[name='ballNumber']").val();
	var cyj=	$("[name=cyj]").val();;
	var probability=	$("[name='probability']").val();
	if(probability=="" || probability==null)
	{
		$(".mesage").html("概率不能为空");
		return;
	}
	if(probability!="" && probability!=null)
	{
		var a=judgeSign(probability);
		if(a=="不是数字" || a=="是负数")
		{
		$(".mesage").html("概率输入错误,必须为正整数");
		return;
		}
	}
	if(ax!="" && ax!=null && box!=0)
	{
		var a1=judgeSign(ax);
		if(a1=="不是数字" || a1=="是负数")
		{
			$(".mesage").html("爱心数输入错误,必须为正整数");
			return;
		}
	}
	if(box!="" && box!=null && box!=0)
	{
		var a2=judgeSign(box);
		if(a2=="不是数字" || a2=="是负数")
		{
			$(".mesage").html("宝箱输入错误,必须为正整数");
			return;
		}
	}	
	if(name!="无")
	{
		if(goodsNumber==0 || goodsNumber=="")
		{
			$(".mesage").html("请输入商品数量");
			return;
		}
	}
	if(ballName!="无")
	{
		if(ballNumber==0 || ballNumber=="")
		{
			$(".mesage").html("请输入龙珠数量");
			return;
		}	
	}
	$(".mesage").html("正确");
	$(".updatetan").click();
	 $.ajax({
			type:"post",
			data:{"awards.id":id,"awards.loveNumber":ax,"awards.boxNumber":box,"awards.goodsName":name,"awards.goodsNumber":goodsNumber,"awards.ballName":ballName,"awards.ballNumber":ballNumber,"awards.probability":probability,"awards.participation":cyj},
			dataType:"json",
			url:"/VoteManage/updateAwards.action",
			success:function(m){
				if(m=='success')
				{
					$(".successs").html("修改成功");
					$(".updatetx").click();
				}
				else
				{
					$(".successs").html("修改失败");
					$(".updatetx").click();
				}
				 getAweardsByBoxGame();
			}
		});
}

function getGoods()
{
	var html="<option value='无'>无</option>";
	 $.ajax({
			type:"post",
			dataType:"json",
			url:"/VoteManage/getAllGoodsName.action",
			success:function(m){
				$.each(m,function(i,n){
					html+="<option value="+n+">"+n+"</option>";
				});
				$(".goodsNameInput").html(html);
				$(".goodsNameInput1").html(html);
			}
		});
}
function save()
{
	var ax=	$("[name=ax1]").val();
	var box=	$("[name='box1']").val();
	var name=	$(".goodsNameInput1").val();;
	var goodsNumber=	$("[name='goodsNumber1']").val();
	var ballName=	$(".ballInput1").val();
	var ballNumber =	$("[name='ballNumber1']").val();
	var cyj=	$("[name=cyj1]").val();;
	var probability=	$("[name='probability1']").val();
	if(probability=="" || probability==null)
	{
		$(".mesage1").html("概率不能为空");
		return;
	}
	if(probability!="" && probability!=null)
	{
		var a=judgeSign(probability);
		if(a=="不是数字" || a=="是负数")
		{
		$(".mesage1").html("概率输入错误,必须为正整数");
		return;
		}
	}
	if(ax!="" && ax!=null)
	{
		var a1=judgeSign(ax);
		if(a1=="不是数字" || a1=="是负数")
		{
			$(".mesage1").html("爱心数输入错误,必须为正整数");
			return;
		}
	}
	if(box!="" && box!=null)
	{
		var a2=judgeSign(box);
		if(a2=="不是数字" || a2=="是负数")
		{
			$(".mesage1").html("宝箱输入错误,必须为正整数");
			return;
		}
	}	
	if(name!="无")
	{
		if(goodsNumber==0 || goodsNumber=="")
		{
			$(".mesage1").html("请输入商品数量");
			return;
		}
	}
	
	if(ballName!="无")
	{
		if(ballNumber==0 || ballNumber=="")
		{
			$(".mesage1").html("请输入龙珠数量");
			return;
		}	
	}
	$(".mesage1").html("正确");
	$(".updatetan1").click();
	 $.ajax({
			type:"post",
			data:{"awards.loveNumber":ax,"awards.boxNumber":box,"awards.goodsName":name,"awards.goodsNumber":goodsNumber,"awards.ballName":ballName,"awards.ballNumber":ballNumber,"awards.probability":probability,"awards.participation":cyj},
			dataType:"json",
			url:"/VoteManage/addAwards.action",
			success:function(m){
				if(m=='success')
				{
					$(".successs").html("添加成功");
					$(".updatetx").click();
				}
				else
				{
					$(".successs").html("添加失败");
					$(".updatetx").click();
				}
				 getAweardsByBoxGame();
			}
		});
}

function add(){
	$(".updatetan1").click();
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
