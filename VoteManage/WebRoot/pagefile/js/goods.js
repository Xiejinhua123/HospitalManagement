$(function(){	
		getAllGoods();
		$(".determines").click(function(){
			dele();});
});
var goodId;
//删除商品
function deleteGoods(id){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	goodId=id;
	$(".delltetx").click();
}
function dele()
{
	$.ajax({
		type:"post",
		data:{"goodsId":goodId},
		dataType:"json",
		url:"/VoteManage/deleteGoodById.action",
		success:function(m){
			if(m=="true")
			{
				var pagesize=$(".pagesize").html();
				getAllGoods(8,pagesize);
				window.location.reload();
			}
		}});
}
//获取所有商品
function getAllGoods(items,pagesize)
{
	if(items==null || items=="")items=8;
	if(pagesize==null || pagesize=="")pagesize=1;
	var shopName=$(".shopName").val();
	var html="";
	$.ajax({
		type:"post",
		data:{"items":items,"pagesize":pagesize,"name":shopName},
		dataType:"json",
		url:"/VoteManage/getAllGoods.action",
		success:function(m){
			$.each(m.rows,function(i,n){
				 html+="<div class='col-lg-3 col-md-4 col-sm-6' style='overflow:hidden'>";
				 html+="<div class='panel panel-info'>";
				 html+="<div class='panel-heading'>";
				 html+="<h4>"+n.goodsName+"</h4>";
				 html+="</div>";
				 html+="<div class='panel-body lableEvent' style='overflow:hidden; text-align: center;'>";
				 html+="<img src='"+n.url+"' style='height:80%	;width:100%;' title='查看更多图片'/>";
				 html+="<label style='margin-top: 20px;'>需要爱心总数：<span style='color:blue;' id='lablename'>"+n.loveNumber+"</span>";
				 if(n.shelvesStatus==1)html+="</label><br /> <label>是否下架：<span id='explain'>是</span>";
				 if(n.shelvesStatus==0)html+="</label><br /> <label>是否下架：<span id='explain'>否</span>";
				 html+="<span style='font-weight: normal; line-height: 25px;'> </span> </label><br/>";
				 if(n.deleteds=="1") html+=" 是否被删除：<span style='color:blue;' id='lablename'>是</span>";
				 else html+=" 是否被删除：<span style='color:blue;' id='lablename'>否</span>";
				 
				 html+="</div>";
				 html+="<div class='panel-footer'>";
				 if(n.deleteds=="1"){
					 html+="<button type='button' class='btn btn-primary'";
					 html+="onclick='updateGoods();'>修改</button>  ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='deleteGoods();'>删除</button>";
				 }
				 else{
					 html+="<button type='button' class='btn btn-primary'";
					 html+="onclick='updateGoods("+n.id+");'>修改</button>  ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='deleteGoods("+n.id+");'>删除</button>"; 
				 }
				 html+="</div>";
				 html+="</div>";
				 html+="</div>";
			});
			var h="";
			if(m.rows==null)return;
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount) getAllGoods(8,pagesize-1);
			$(".pagegood").html(h);
			$(".show").html(html);
		}
	});
}
/**
 * 线根据id查询
 * @param id
 * 	编号
 */
function updateGoods(id){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$(".updatetx").click();
	$.ajax({
		type:"post",
		data:{"goodsId":id},
		dataType:"json",
		url:"/VoteManage/findGoodsById.action",
		success:function(m){
			$(".spmc").val(m.goodsName);
			$(".xyaxs").val(m.loveNumber);
			$(".goodsid").val(m.id);
			if(m.shelvesStatus==0)
			{
			$(".select").html("" +
			"<option value='0' selected='selected'>否</option><option value='1' >是</option>");
			}
			if(m.shelvesStatus==1)
			{
			$(".select").html("" +
			"<option value='0'>否</option><option value='1' selected='selected'>是</option>");
			}
		}});
}

function  upGoods(){
	var name=$(".spmc").val();
	var love=$(".xyaxs").val();
	var shelvesStatus=$(".select").val();
	if(name==null || name=="")
	{
		$("#tx").html("");
		$("#tx").html("名称不能为空");
		return;
	}
	if(love==null || love=="")
	{
		$("#tx").html("");
		$("#tx").html("爱心数不能为空");
		return;
	}
	var a=judgeSign(love);
	if(a=="不是数字" || a=="是负数")
	{
		$("#tx").html("爱心数输入错误,必须为正整数");
		return;
	}
	var id=$(".goodsid").val();
	$.ajax({
		type:"post",
		data:{"goods.id":id,"goods.goodsName":name,"goods.loveNumber":love,"goods.shelvesStatus":shelvesStatus},
		dataType:"json",
		url:"/VoteManage/updateGoods.action",
		success:function(m){
			$(".updatetx").click();
			$("#tx").html("");
			if(m=='success')
			{
				$(".successs").html("修改成功");
				$(".updatetxk").click();
			}
			else
			{
				$(".successs").html("修改失败");
				$(".updatetxk").click();
			}
			var pagesize=$(".pagesize").html();
			getAllGoods(null,pagesize);
		}
	});
}

//上一页
function onpage(size)
{
	var pagesize=size-1;
	getAllGoods(null,pagesize);
}

//下一页
function downpage(size)
{
	var pagesize=size+1;
	getAllGoods(null,pagesize);
}
function tiaozhuan()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		getAllGoods(8,pageNmber);
	}
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