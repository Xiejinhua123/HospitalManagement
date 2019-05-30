$(function(){
	getAllArticle();
	$(".determines").click(function(){dele();$(".delltetx").click();});
});
//查询条件
var selectBy=null;
var articId;
//查询所有文章
function getAllArticle(pagesize,tj)
{
	if(pagesize==null) pagesize=1;
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"pagesize":pagesize,"items":8,"selectBy":selectBy,"tj":tj},
		url:"/VoteManage/getArticleAll.action",
		success:function(m){
			$("#tbody").html("");
			$(".pagenum").html("");
			if(m=="null" || m=="error")return;
			var html="";
			$.each(m.rows,function(i,n){
				 html+="<tr class='odd gradeX'>";
				 html+="<td>"+n.id+"</td>";
				 html+="<td>"+n.title+"</td>";
				 html+="<td>"+n.name+"</td>";
				 html+="<td>"+n.crateTime.replace("T"," ")+"</td>";
				 html+="<td class='center'>"+n.voteNumber+"</td>";
				 if(n.deletes=="1"){
					 html+="<td class='center'>是</td>";
					 html+="<td><button type='button' class='btn btn-primary'";
					 html+="onclick='lookArticle();'>编辑</button>  ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='deleteArticle();'>删除</button></td></tr>";
				 }
				 else{
					 html+="<td class='center'>否</td>";
					 html+="<td><button type='button' class='btn btn-primary'";
					 html+="onclick='lookArticle("+n.id+");'>编辑</button>  ";
					 html+="<button type='button' class='btn btn-success'";
					 html+="onclick='deleteArticle("+n.id+");'>删除</button></td></tr>";
				 }
			});
			var h="";
			if(m.pageCount==0) return;
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)getAllArticle(pagesize-1,null);
			$(".pagenum").html(h);
			$("#tbody").html(html);
		}
	});
}
function lookArticle(id)
{
	if(id==null)
	{
		$(".successs").html("该文章已被删除，不可惭怍");
		$(".updatetxk").click();
		return;
	}
	window.location.href="content.action?articleId="+id;
}
function selectm()
{
	var tj=$(".selectUser").val();
	if(tj=="" || tj==null)
	{
		selectBy=null;
		getAllArticle(1,null);
		return;
	}
	else selectBy=$(".selectArti").val();
	if(selectBy=="id")
	{
		var b=judgeSign(tj);
		if(b!='是正数')
		{
			$(".successs").html("请输入正确的编号");
			$(".updatetxk").click();
			return;
		}
		if(tj.length>=11)
		{
			$(".successs").html("请输入正确的编号");
			$(".updatetxk").click();
			return;
		}	
	}
	getAllArticle(1,tj);
}

//删除文章
function deleteArticle(id)
{
	if(id==null)
	{
		$(".successs").html("该文章已被删除，不可惭怍");
		$(".updatetxk").click();
		return;
	}
	$(".delltetx").click();
	articId=id;
}

function dele(){
	
	$.ajax({
		type:"post",
		data:{"articleId":articId},
		dataType:"json",
		url:"/VoteManage/delArticle.action",
		success:function(m){
			$(".successs").html("删除成功");
			$(".updatetxk").click();
			getAllArticle();
		}
	});
}
//上一页
function onpage(size)
{

	var pagesize=size-1;
	getAllArticle(pagesize,null);
	
}
//下一页
function downpage(size)
{
	
	var pagesize=size+1;
	getAllArticle(pagesize,null);

}
//跳转页数
function tiaozhuan()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		getAllArticle(pageNmber,null);
	}
}

//检测是否为正数
function judgeSign(num) {
    if ( Number(num) ) {
        var absVal = Math.abs(num);
        return num==absVal?'是正数':'是负数';
    } else {
        return '不是数字';
    }
}


function getLength(str) {
  return str.replace(/[\u0391-\uFFE5]/g,"aa").length;  //先把中文替换成两个字节的英文，在计算长度
};  
