var button="totalVotes";
$(function(){	
	getAllUser(1,10,"totalVotes");
	$(".love").click(function(){
		button="loveNumber";
		getAllUser(1,10,"loveNumber");
	});
	$(".ball").click(function(){
		button="ballNumber";
		getAllUser(1,10,"ballNumber");
	});
	$(".box").click(function(){ 
		button="boxNumber";
		getAllUser(1,10,"boxNumber");
	});
	$(".vote").click(function(){ 
		button="totalVotes";
		getAllUser(1,10,"totalVotes");
	});
	
	
	$(".botton button").click(function(){
		
		var button = $(".botton button");
		for ( var i = 0 ; i < button.length ; i++ ) {
			$(button[i]).removeClass("btn-default");
			$(button[i]).addClass("btn-info");
		}
		$(this).removeClass("btn-info");
		$(this).addClass("btn-default");
	});
	
	
});
function getAllUser(pagesize,item,name)
{
	if(pagesize==null || pagesize=="")pagesize=1;
	if(item==null || item=="")item=10;
	var html="";
	$.ajax({
		type:"post",
		data:{"items":item,"pagesize":pagesize,"orderName":name},
		dataType:"json",
		url:"/VoteManage/votesRanking.action",
		success:function(m){
			$.each(m.rows,function(i,n){
				html+="<tr class='odd gradeX'>";
				html+="<td>"+( parseInt( (m.pageSize-1)*m.items)+i+1 )+"</td>";
				html+="<td>"+n.id+"</td>";
				html+="<td>"+n.name+"</td>";
				html+="<td>"+n.totalVotes+"</td>";
				html+="<td class='center'>"+n.boxNumber+"</td>";
				html+="<td class='center'>"+n.ballNumber+"</td>";
				html+="<td class='center'>"+n.loveNumber+"</td>";
				if(n.deleteds=="1")html+="<td class='center'>是</td></tr>";
				else html+="<td class='center'>否</td></tr>";
			});
			var h="";
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)getAllLable(pagesize-1,item);
			$(".pagenum").html(h);
			$("#tbody").html(html);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
		}
	});
}
function onpage(size)
{
	var pagesize=size-1;
	tiaozhuan1(pagesize);
}
function downpage(size)
{
	var pagesize=size+1;
	tiaozhuan1(pagesize);
}
function tiaozhuan()
{
	var name="";
	if(button=="")name="totalVotes";
	else name=button;
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		getAllUser(pageNmber,10,button);
	}
}
function tiaozhuan1(size)
{
	var name="";
	if(button=="")name="totalVotes";
	else name=button;
	getAllUser(size,10,button);
	
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