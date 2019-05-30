$(function(){
	
	$(".updatetx").hide();
	$(".deletetx").hide();
	$(".updatetan").hide();
	
	 getAllLable();
	 //修改
	 $(".savel").click(function(){
	 	var id=$(this).attr("name");
	 	var name=$(".updateName").val();
	 	var ms=$(".updms").val();
		 $.ajax({
			type:"post",
			data:{"lables.id":id,"lables.lableName":name,"lables.explains":ms},
			dataType:"json",
			url:"/VoteManage/updateLable.action",
			success:function(m){
				if(m=='true')
				{
					$(".successs").html("修改成功");
					$(".updatetan").click();
					$(".updatetx").click();
					var pagesize=$(".pagesize").html();
					getAllLable(pagesize,8);
				}
				else
				{
					$(".successs").html("修改失败");
					$(".updatetan").click();
				}
			},error:function(m){
				console.log(m);
			}
		}); 
	 });
	 
	 //添加标签
	 $("#saveLable").live("click",function(){
	    var b=true;
		if(checkName()==false) b=false;
		if(checkevent()==false) b=false;
		 var name=$("[name='lableName']").val();
		 var event=$("[name=event]").val();
		 if(b)
		 {
			 $.ajax({
					type:"post",
					data:{"lables.lableName":name,"lables.explains":event},
					dataType:"json",
					url:"/VoteManage/addLable.action",
					success:function(m){
						$(".modal").click();
						var pagesize=$(".pagesize").html();
						getAllLable(pagesize,8);
					}
				});
		 }	 
		});
});


//验证描述
function checkevent()
{
	var event=$("[name=event]").val();
	if(event==null || event=="")
	{
		$(".checkevevt").html("标签描述不能为空");
		return false;
	}
	$(".checkevevt").html("");
	return true;
}
//验证标签名称
function checkName()
{
	var name=$("[name='lableName']").val();
	if(name==null || name=="")
	{
		$(".checkname").html("标签名称不能为空");
		return false;
	}
	$(".checkname").html("");
	return true;
}
//获取所有标签
function getAllLable(pagesize,item)
{
	if(pagesize==null || pagesize=="")pagesize=1;
	if(item==null || item=="")item=8;
	var html="";
	$.ajax({
		type:"post",
		data:{"items":item,"pagesize":pagesize},
		dataType:"json",
		url:"/VoteManage/getLable.action",
		success:function(m){
			$.each(m.rows,function(i,n){
				 html+="<div class='col-lg-3 col-md-4 col-sm-6'>";
				 html+="<div class='panel panel-info'>";
				 html+="<div class='panel-heading'>";
				 html+="<h4>标签名称:"+n.lableName+"</h4>";
				 html+="</div>";
				 html+="<div class='panel-body lableEvent'>";
				 
				 html+="</label><br/> <label>标签描述：<span id='explains'>"+n.explains+" </span><span";
				 html+="style='font-weight: normal; line-height: 25px;'> </span> </label>";
				 
				 html+="</label><br/> <label>标签使用量：<span id='explains'>"+n.number+" </span><span";
				 html+="style='font-weight: normal; line-height: 25px;'> </span> </label>";
				 
				if(n.deletes=="1") {
					 html+="</label><br/> <label>是否被删除：<span id='explains'>是</span><span";
					 html+="style='font-weight: normal; line-height: 25px;'> </span> </label>";
					 html+="</div>";
					 html+="</div>";
					 html+="<div class='panel-footer'>";
					 html+="<button type='button' class='btn btn-primary'";
					 html+="onclick='javascript:update();'>修改</button>    ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='javascript:deletea();'>删除</button>";
					 html+="</div>";
					 html+="</div>";
					 html+="</div>";
				}else {
					 html+="</label><br/> <label>是否被删除：<span id='explains'>否</span><span";
					 html+="style='font-weight: normal; line-height: 25px;'> </span> </label>";
					 html+="</div>";
					 html+="</div>";
					 html+="<div class='panel-footer'>";
					 html+="<button type='button' class='btn btn-primary'";
					 html+="onclick='javascript:update("+n.id+");'>修改</button>    ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='javascript:deletea("+n.id+");'>删除</button>";
					 html+="</div>";
					 html+="</div>";
					 html+="</div>";
				}
				 
				 
			
			});
			var h="";
			if(m.rows==null) return;
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)getAllLable(pagesize-1,item);
			$(".pagenum").html(h);
			$(".show").html(html);
		}
	});
}
function tiaozhuan()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		getAllLable(pageNmber,8);
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
function onpage(size)
{
	var pagesize=size-1;
	getAllLable(pagesize,null);
}
function downpage(size)
{
	var pagesize=size+1;
	getAllLable(pagesize,null);
}
/**
 * 根据id查找单个
 * @param id
 */
function getLableById(id)
{
	
	$(".nr").show();
	$(".savel").attr("name",id);
	$.ajax({
		type:"post",
		data:{"id":id},
		dataType:"json",
		url:"/VoteManage/getLableById.action",
		success:function(m){
			$(".updateName").val(m.lableName);
			$(".updms").val(m.explains);
		}
	});
}

/**
 * 根据id查找
 * @param id
 * 	编号
 */
function update(id){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	getLableById(id);
	$(".updatetan").click();
	$(".ipdlable").show();
}

/**
 * 删除
 * @param id
 * 	编号
 */
function deletea(id){	
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$(".deletetx").click();
	$(".determines").click(function(){
		 $.ajax({
		type:"post",
		data:{"id":id},
		dataType:"json",
		url:"/VoteManage/deleteLable.action",
		success:function(m){
			if(m=="true")
			{
				$(".deletetx").click();
				var pagesize=$(".pagesize").html();
				getAllLable(pagesize,8);
			}
		}
	});
	});
		
		


}