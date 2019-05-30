$(function(){	
	getlabel();
	getAllUser();
	$("#button").click(function(){selectUser();});
	//正常用户验证
	$(".save").click(function(){saveUser();});
	$(".name").blur(function(){checkedName($(this));});
	$(".pwd").blur(function(){checkedPwd($(this));});
	$(".bir").blur(function(){checkedBir($(this));});
	$("#a1").blur(function(){checkedFile($(this));});
	//机器人用户验证
	$(".save1").click(function(){saveUser1();});
	$(".name1").blur(function(){checkedName1($(this));});
	$(".pwd1").blur(function(){checkedPwd1($(this));});
	$(".bir1").blur(function(){checkedBir1($(this));});
	$("#a11").blur(function(){checkedFile1($(this));});
	
	var re = $(".ret").val();
	if (re == "添加成功") {
		$(".context").html("添加成功");
		$(".tan").click();
	} else if (re == "添加失败") {
		$(".context").html("添加失败");
		$(".tan").click();
	}
	$(".closeTan").click(function() {
		window.location.href = "/VoteManage/pagefile/pages/users.jsp?resId=3";
	});
});

var usersName;
function getAllUser(pagesize,item)
{
	usersName="";
	if(pagesize==null || pagesize=="")pagesize=1;
	if(item==null || item=="")item=10;
	var html="";
	$.ajax({
		type:"post",
		data:{"items":item,"pagesize":pagesize},
		dataType:"json",
		url:"/VoteManage/getAllUser.action",
		success:function(m){ 
			$.each(m.rows,function(i,n){
				html+="<tr class='odd gradeX'>";
				html+="<td>"+n.id+"</td>";
				html+="<td>"+n.userType+"</td>";
				html+="<td>"+n.name+"</td>";
				html+="<td>"+n.totalVotes+"</td>";
				html+="<td class='center'>"+n.boxNumber+"</td>";
				html+="<td class='center'>"+n.loveNumber+"</td>";
				if(n.deleteds=="1")html+="<td class='center'>是</td>";
				else html+="<td class='center'>否</td>";
				html+="<td>" + n.operations + "</td>";
				html+="</tr>";
			});
			var h="";
			if(m.pageCount==0) var a=1;
			if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)getAllLable(pagesize-1,item);
			$(".pagenum").html(h);
			$("#tbody").html(html);
		}
	});
}

function onpage(size)
{
	if(usersName=="" || usersName==null)
	{
		var pagesize=size-1;
		getAllUser(pagesize,null);
	}else
	{
		var pagesize=size-1;
		selectUser(pagesize);
	}
}

function downpage(size)
{
	if(usersName=="" || usersName==null)
	{
		var pagesize=size+1;
		getAllUser(pagesize,null);
	}else
	{
		var pagesize=size+1;
		selectUser(pagesize);
	}
}

function selectUser(pagesize)
{
	if(pagesize==""|| pagesize==null) pagesize=1;
	var tj=$(".selectConditions").val();
	var UserName=$(".selectUser").val();
	if(UserName=="" || UserName==null)
	{
		getAllUser();
		return;
	}
	
	usersName=UserName;
	var html="";
	$.ajax({
		type:"post",
		data:{"items":10,"pagesize":pagesize,"name":usersName,"tj":tj},
		dataType:"json",
		url:"/VoteManage/getAllUser.action",
		success:function(m){
			$.each(m.rows,function(i,n){
				html+="<tr class='odd gradeX'>";
				html+="<td>"+n.id+"</td>";
				html+="<td>"+n.userType+"</td>";
				html+="<td>"+n.name+"</td>";
				html+="<td>"+n.totalVotes+"</td>";
				html+="<td class='center'>"+n.boxNumber+"</td>";
				html+="<td class='center'>"+n.loveNumber+"</td>";
				if(n.deleteds=="1")html+="<td class='center'>是</td>";
				else html+="<td class='center'>否</td>";
				html+="<td>" + n.operations + "</td>";
				html+="</tr>";
			});
			$("#tbody").html(html);
			var h="";
			if(m.pageCount==0) var a=1;
			if(m.pageCount==0) h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+1+"</span> / <span style='margin:10px;font-size:16px''>"+1+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan1()'>跳转</button><button onclick='downpage(1)' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan1()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan1()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan1()'>跳转</button><button onclick='downpage("+pagesize+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage("+pagesize+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan1()'>跳转</button><button onclick='downpage("+pagesize+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)selectUser();
			$(".pagenum").html(h);
		}
	});
}



function getlabel()
{
	var html="";
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/VoteManage/getAllLabel.action",
		success:function(m){
			$.each(m,function(i,n){
				html+="<button type='button' class='btn btn-outline btn-danger labelName' style=' margin-right: 10px;' onclick='getlabeluser("+n.id+",1)'>"+n.lableName+"</button>";
			});
			$("#h3").append(html);
		}
	});
}

function getlabeluser(id,pagesize)
{
	var html="";
	if(pagesize==null)pagesize=1;
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"items":10,"pagesize":pagesize,"labelId":id},
		url:"/VoteManage/getUserByLavelId.action",
		success:function(m){
			if(m.rows==null)$("#tbody").html("此标签暂无用户");
			else {
			$.each(m.rows,function(i,n){
				html+="<tr class='odd gradeX'>";
				html+="<td>"+n.id+"</td>";
				html+="<td>"+n.userType+"</td>";
				html+="<td>"+n.name+"</td>";
				html+="<td>"+n.totalVotes+"</td>";
				html+="<td class='center'>"+n.boxNumber+"</td>";
				html+="<td class='center'>"+n.loveNumber+"</td>";
				if(n.deleteds=="1")html+="<td class='center'>是</td></tr>";
				else html+="<td class='center'>否</td>";
				html+="<td>" + n.operations + "</td>";
				html+="</tr>";
			});
			}
			var h="";
			if(m.pageCount==0) return;
			else if(pagesize==1&&m.pageCount==1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> / <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan2("+id+")'>跳转</button><button onclick='downpage1("+pagesize+","+id+")' class='btn btn-primary' disabled>下一页</button>";
			else if(pagesize==1&&m.pageCount>1)h+="<button class='btn btn-primary'  disabled>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan2("+id+")'>跳转</button><button onclick='downpage1("+pagesize+","+id+")' class='btn btn-primary'>下一页</button>";
			else if(m.pageCount>pagesize) h+="<button class='btn btn-primary' onclick='onpage1("+pagesize+","+id+")'>上一页</button><span style='margin:10px;font-size:16px'  class='pagesize'>"+pagesize+" </span>/ <span style='margin:10px;font-size:16px''>"+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan2("+id+")'>跳转</button><button onclick='downpage1("+pagesize+","+id+")' class='btn btn-primary'>下一页</button>";
			else if(pagesize>1&&m.pageCount==pagesize) h+="<button class='btn btn-primary' onclick='onpage1("+pagesize+","+id+")'>上一页</button><span style='margin:10px;font-size:16px' class='pagesize'>"+pagesize+"</span> /<span style='margin:10px;font-size:16px''> "+m.pageCount+"</span><input type='text' class='pagenumbers' style='width:30px;'/><button  class='btn btn-link' onclick='tiaozhuan2("+id+")'>跳转</button><button onclick='downpage1("+pagesize+","+id+")' disabled class='btn btn-primary'>下一页</button>";
			else if(pagesize>m.pageCount)getlabeluser(id,pagesize-1);
			$(".pagenum").html(h);
			$("#tbody").html(html);
		}
	});
}
function onpage1(size,id)
{
		getlabeluser(id,size-1);
}
function downpage1(size,id)
{
	getlabeluser(id,size+1);
}

function tiaozhuan()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		 getAllUser(pageNmber,10);
	}
}

function tiaozhuan1()
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		selectUser(pageNmber);
	}
}

function tiaozhuan2(id)
{
	var pageNmber=$(".pagenumbers").val();
	if(pageNmber==null || pageNmber=="")return;
	var a=judgeSign(pageNmber);
	if(a=='是正数')
	{
		 getlabeluser(id,pageNmber);
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

/**
 * 修改用户点击事件
 * @param id
 */
function updateUser( id ){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	console.log( id );
}

/**
 * 删除用户点击事件
 * 
 * @param id
 * 		编号
 */
function deleteUser( id ){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	console.log( id );
}