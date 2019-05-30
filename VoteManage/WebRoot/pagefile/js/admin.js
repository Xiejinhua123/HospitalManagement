$(function(){
	
	$("#updateForm p").hide();
	$(".submitTishi").hide();
	
	getAllAdmin(); // 页面加载获取所有的管理员
	
	$(".addSave").click(function(){ addSave(); });
	
	$(".deleteSave").click(function(){ deleteSave();});
	
	$(".updateSave").click(function(){ updateSave(); });
	
	$(".name").blur(function(){ 
		var text = /^\S{1,}$/;
		var name = $(this).val();
		if( !text.test(name) ){
			$(this).next(".tishi").show();
			$(".updateSave").attr("disabled", true);
		}else{
			$(this).next(".tishi").hide();
			$(".updateSave").attr("disabled", false);
		}
	});
	
	$(".rank").blur(function(){ 
		var loginrank = $(".sessionrank").val();
		var rank = $(".newRank").val(); // 新的等级
		var oldRank = $(".oldRank").val(); // 之前的等级
		if( rank <= loginrank ){ // 修改的等级跟登录人的等级高或者相同
			$(this).next(".tishi").show();
			$(".updateSave").attr("disabled", true);
		}else{
			$(this).next(".tishi").hide();
			$(".updateSave").attr("disabled", false);
		}
	});
	
	$(".addName").blur(function(){
		var text = /^\S{1,}$/;
		var name = $(this).val();
		if( !text.test(name) ){
			$(this).next("p").show();
			$(".addSave").attr("disabled", true);
		}else{
			$(this).next("p").hide();
			$(".addSave").attr("disabled", false);
		}
	});
	
});
//获取所有管理员
function getAllAdmin()
{
	var manage = $(".ret").val();
	var id = $(".rets").val();
	if(id == "true"){
		id = false;
	}else{
		id=true;
	}
	
	var html="";
	$.ajax({
		type:"post",
		dataType:"json",
		url:"getAllAdmin.action",
		success:function(m){
			$.each(m,function(i,n){
				html+="<tr class='odd gradeX'>";
				html+="<td>"+n.id+"</td>";
				html+="<td>"+n.name+"</td>";
				html+="<td>"+n.rank+"</td>";
				html+="<td>"+n.updName+"</td>";
				html+="<td>"+n.updTime+"</td>";
				html+="<td>"+n.createName+"</td>";
				html+="<td>"+n.createTime+"</td>";
				if(n.deldetes=="1")html+="<td>是</td>";
				else html+="<td>否</td>";
				if( !n.noOption ){
					if(n.deldetes=="1")
					{
						html+="<td><button class='btn btn-info update' data-toggle='modal' onclick='upClick()'>编辑</button> ";
						html+=" <button class='btn btn-primary delete' data-tog onclick='Click()'>删除</button>";
						html+=" <button class='btn btn-primary delete' data-toggle='modal' onclick='resourceClick()'>权限操作</button></td>";
					}else{
						html+="<td><button class='btn btn-info update' data-toggle='modal' data-target='#update' onclick='upClick(" + n.id + ")'>编辑</button> ";
						html+=" <button class='btn btn-primary delete' data-toggle='modal' data-target='#delete' onclick='Click(" + n.id + ")'>删除</button>";
						html+=" <button class='btn btn-primary delete' data-toggle='modal' data-target='#resource' onclick='resourceClick("+n.id+")'>权限操作</button></td>";
					}
				}else{
					html+="<td>平级用户，不允许操作</td>";
				}
				html+="</tr>";
			$("#tbody").html(html);
			});
		}
	});
}

/**
 * 按钮的点击事件，获取到点击的用户的用户编号
 * @param id
 */
function Click( id ){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$("[name='admin.id']").val(id);
}

/**
 * 修改按钮点击事件
 * 
 * 获取修改用户的基本信息
 * 
 * @param id
 * 	用户编号
 */
function upClick( id ){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$("[name='admin.id']").val(id);
	$.ajax({
		type:"post",
		data:{"admin.id":id},
		url:"/VoteManage/getAdminById.action",
		dataType:"json",
		success:function(manage){
			if( manage != "error" ){
				$(".name").val(manage.name);
				$(".rank").val(manage.rank);
			}
		}
	});
}

/**
 * 执行添加
 */
function addSave(){
	$("#addForm").submit();
}

/**
 * 删除管理员
 */
function deleteSave(){
	$("#deleteForm").submit();
	getAllAdmin();
}

/**
 * 修改保存按钮点击事件
 */
function updateSave(){
	var ps = $(".tishi");
	var bool = true;
	for ( var i = 0 ; i < ps.length ; i++) {
		var sta = $(ps[i]).css("display");
		if( sta == 'block' ){
			bool == false;
		};
	}
	if( bool ){
		$("#updateForm").submit();
	}else{
		$(".submitTishi").css("display" , block);
	};
}

var adId;
/**
 * 获取一级权限
 * @param id
 * res.resGrade
 */
function resourceClick(id)
{
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	 gid=3;
	adId=id;
	var h="";
	$.ajax({
		type:"post",
		data:{"res.resGrade":1,"adminId":id},
		url:"/VoteManage/getLevel1.action",
		dataType:"json",
		success:function(m){
			$.each(m,function(i,n){
				h+="<ul>" ;
				if(n.statu==1)h+="<li onclick='getLevel2("+n.id+",this,2)'><input type='checkbox' checked='checked' value='"+n.id+"' /><span  style='cursor:pointer' >"+ n.name + "</span> </li>";
				if(n.statu==2)h+="<li onclick='getLevel2("+n.id+",this,2)'><input type='checkbox' checked='checked' value='"+n.id+"' disabled='disabled'/><span  style='cursor:pointer'  >"+ n.name + "</span> </li>";
				if(n.statu==3)h+="<li onclick='getLevel2("+n.id+",this,2)'><input type='checkbox' value='"+n.id+"' /><span  style='cursor:pointer' >"+ n.name + "</span> </li>";
				h+=	"</li>";
				h+="</ul>";
			});
			$(".level1").html(h);
			
		}
	});
}	
//获取子集元素
function getLevel2(id,level1,grade)
{
	var h="";
	$.ajax({
		type:"post",
		data:{"parent":id,"res.resGrade":grade,"adminId":adId},
		url:"/VoteManage/getResByParent2.action",
		dataType:"json",
		success:function(m){
			h+=" <ul> ";
			$.each(m,function(i,n){
				if(n.statu==1)h+="<li onclick='getLevel2("+n.id+",this,"+n.greadeId+")'><input type='checkbox' checked='checked' value='"+n.id+"' /><span  style='cursor:pointer' >"+ n.name + "</span> </li>";
				if(n.statu==2)h+="<li onclick='getLevel2("+n.id+",this,"+n.greadeId+")'><input type='checkbox' checked='checked' value='"+n.id+"' disabled='disabled'/><span  style='cursor:pointer' >"+ n.name + "</span> </li>";
				if(n.statu==3)h+="<li onclick='getLevel2("+n.id+",this,"+n.greadeId+")'><input type='checkbox' value='"+n.id+"' /><span  style='cursor:pointer' >"+ n.name + "</span> </li>";
			});
			h+=" </ul> ";
			var a=$(level1).next("ul").remove();
			$(level1).after(h);
		}
	});
}
//修改用户权限信息
function updateResource()
{	
	var mycars=new Array();
	var i=0;
	var resourse=$("input[type='checkbox']").each(function(i,n){
		if(n.checked)
		{
			mycars.push($(n).val());
		}
	});
	$.ajax({
		type:"post",
		data:{"adminId":adId,"mycars":mycars.toString()},
		url:"/VoteManage/addresous.action",
		dataType:"json",
		success:function(m){
			$(".closeTan").click();
			$(".suces").click();
	}});
	
}
