$(function(){
	$("#tijiao").click(function(){
		alert("开始修改le")
		updateValue();
	})
	$("#delsub").click(function(){
		delName();
	})
	$("#delidsub").click(function(){
		delById();
	})
	//添加数据字典表单验证
	$("#add").click(function(){
		addCheck();
	})
	var path=getRealPath();
	//点击姓名显示子项
	$("#name").live("click",function(){
		var type=$(this).attr("type");
		value(type);
	})
	style();
	getTypeName();
	
	/**
	 * 添加类型
	 */
	$(".addtype").live("click",function(){
		$("#addtypeMobile").addClass("in");
		$("#addtypeMobile").css("display","block");
	});
	/**
	 * 修改类型
	 */
	$(".updateType").live("click",function(){
		$("#updateDicTypeMobile").addClass("in");
		$("#updateDicTypeMobile").css("display","block");
		var oldName=$(this).attr("type");
		$("#oldName").html(oldName);
	});
	/**
	 * 删除类型
	 */
	$(".deleteType").live("click",function(){
		$("#deleteDicTypeMobile").addClass("in");
		var name=$(this).attr("type");
		$("#names").html(name);
		$("#deleteDicTypeMobile").css("display","block");
	});
	/**
	 * 添加详细
	 */
	$(".addDic").live("click",function(){
		$("#addDicMobile").addClass("in");
		$("#addDicMobile").css("display","block");
	});
	/**
	 * 修改详细
	 */
	$(".updateDic").live("click",function(){
		var id=$(this).attr("type");
		getById(id);
		$("#updateDicMobile").addClass("in");
		$("#updateDicMobile").css("display","block");
		
	});
	/**
	 * 删除详细
	 */
	$(".deleteDic").live("click",function(){
		$("#deleteDicMobile").addClass("in");
		$("#deleteDicMobile").css("display","block");
		var id=$(this).attr("type");
		$("#int").html(id);
	});
	/**
	 * 关闭
	 */
	$(".closeDic").live("click",function(){
		$(this).parent().parent().remove();
	});
	
	/**
	 * 鼠标移上去
	 */
	$(".padd").live("mouseenter",function(){
		$(this).addClass("badge-info");
		$(this).find("p").show(500);
	});
	/**
	 * 移出去
	 */
	$(".padd").live("mouseout",function(){
		$(this).removeClass("badge-info");
		$(this).find("p").hide(500);
	});
	//修改类型名称
	$("#updateSub").click(function(){
		updateTypeCheck();
	})
	
});
var path=getRealPath();
function updateValue()
{
	alert("kaishi")
	var id=$("#bh").html();
	var typeCode=$("#wysbm").val();
	var typeName= $("#leixing").val();
	var typeValues= $("#mingcheng").val();
	var isVisible=$("#selected").val();
	var memo=$("#beizhu").val();
	$.ajax({
		type:"post",
		data:{"id":id,"typeCode":typeCode,"typeName":typeName,"typeValues":typeValues,"isVisible":isVisible,"memo":memo},
		dataType:"json",
		url:path+"/servlet/dic?ac=updateValue",
		success:function(m){
			alert("修改成功");
			$("#bh").html("");
			$("#wysbm").val("");
			$("#leixing").val("");
			$("#mingcheng").val("");
			$("#beizhu$").val("");
			if(m!=null && m!="shibai")
			{
				alert("修改成功");
			}
		}
		})
}
function getById(id)
{
	$.ajax({
		type:"post",
		data:{"id":id},
		dataType:"json",
		url:path+"/servlet/dic?ac=getById",
		success:function(m){
			if(m!=null && m!="noll")
			{
				$("#bh").html(m.dicId);
				$("#wysbm").val(m.typeCode);
				$("#leixing").val(m.typeName);
				$("#mingcheng").val(m.typeValus);
				if(m.isVisible==1)$("#selected option").eq(1).attr("selected","selected");
				else $("#selected option").eq(0).attr("selected","selected");
				$("#beizhu$").val(m.memo);
			}
		}
		})
	
}
function delById()
{
	var id=$("#int").html();
	$.ajax({
		type:"post",
		data:{"id":id},
		dataType:"json",
		url:path+"/servlet/dic?ac=delById",
		success:function(m){
			if(m!=false)
			{
			alert("删除成功");
			$("#int").html("");
			}
		}
		})
}
function delName()
{
	var name=$("#names").html();
	$.ajax({
		type:"post",
		data:{"name":name},
		dataType:"json",
		url:path+"/servlet/dic?ac=delByTypeName",
		success:function(m){
			if(m!=false)
			{
			alert("删除成功");
			$("#names").html("");
			}
			if(m!=true)
			{
			alert("删除失败");
			$("#names").html("");
			}
		}
		})
}
/**
 * 修改类型
 */
function updateTypeCheck(){
	var oldName=$("#oldName").html();
	var newName=$("#newName").val();
	if(newName==null || newName=="")
	{
	alert("新名称为空");
	}
	else
	{
		$.ajax({
			type:"post",
			data:{"oldName":oldName,"newName":newName},
			dataType:"json",
			url:path+"/servlet/dic?ac=updateType",
			success:function(m){
				if(m!=false)
				{
				alert("修改成功");
				$("#newName").val("");
				}
			}
			})
	}
}
/**
 * //添加数据字典表单验证
 */
function addCheck(){
	var TypeCode=$("[name=TypeCode]").val();
	var TypeName=$("[name=TypeName]").val();
	var IsVisible=$("[name=IsVisible]").val();
	var TypeValus=$("[name=TypeValus]").val();
	var Memo=$("[name=Memo]").val();
	if(TypeCode=="")
	{
	alert("唯一编码不能为空")
	}
	else if(TypeName=="")
	{
	alert("类型名称不能为空")
	}
	else if(TypeValus=="")
	{
	alert("名称不能为空")
	}
	else
	{
		$.ajax({
	
		type:"post",
		data:{"typeCode":TypeCode,"typeName":TypeName,"isVisible":IsVisible,"typeValues":TypeValus,"memo":Memo},
		dataType:"json",
		url:path+"/servlet/dic?ac=addDic",
		success:function(m){
			if(m=="shibai")
			{
			alert("添加有误")
			}
			else
			{
				alert("添加成功")	
			}
			
			
		}
	})}
}
/**
 * 根据名称查询其子项
 */
function value(type){
	var s="";
	$.ajax({
		type:"post",
		data:{"type":type},
		dataType:"json",
		url:path+"/servlet/dic?ac=getByName",
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			 alert(XMLHttpRequest.status);
			 alert(XMLHttpRequest.readyState);
			 alert(textStatus);
			   },
		success:function(m){
			console.log(m);
			$("#caozuo").html(m[0].typeName)
			for( i =0;i<m.length;i++)
			{	
			if(i%4==0 ||i==0)s+="<div class = 'row-fluid''>";
			s+="<div class='box span3 details'>";
			s+="<table class='table'>";
			s+="<tr>";
			s+="<td align='right'>类型名称：</td>";
			s+="<td align='left'>"+m[i].typeName+"</td>";
			s+="</tr>";
			s+="<tr>";
			s+="<td align='right'>名称：</td>";
			s+="<td align='left'>"+m[i].typeValus+"</td>";
			s+="</tr>";
			s+="<tr>";
			s+="<td align='right'>是否禁用：</td>";
			s+="<td align='left'>"+m[i].isVisible+"</td>";
			s+="</tr>";
			s+="<tr>";
			s+="<td align='right'>备注：</td>";
			s+="<td align='left'>"+m[i].memo+"</td>";
			s+="</tr>";
			s+="</table>";
			s+="<p class=box center>";
			s+="<span class='icon32 icon-darkgray icon-gear updateDic'  type="+m[i].dicId+"></span>";
			s+="<span class='icon32 icon-darkgray icon-trash deleteDic'  type="+m[i].dicId+"></span>";
			s+="<span class='icon32 icon-darkgray icon-close closeDic'></span>";
			s+="</p>";
			s+="</div>";
			if((i+1)%4==0 && i!=0)s+="</div>";
			}
			$("#values").html(s);
			 
		}
	})
}

/**
 * 显示dictionary 名称
 */
function getTypeName(){
	$.ajax({
		type:"post",
		dataType:"json", 
		async:"false",
		url:path+"/servlet/dic?ac=GroupByTypeName",
		success:function(m){
			var h="";
			h+="<div class='center box' style='padding: 10px;'>数据字典类型</div>";
			$.each(m,function(i,n){
					h+="<div class='center type  padd' id='name' type='"+n+"'>";
					h+="<div class='center box' style='padding: 10px; font-size: 20px;cursor:pointer'>"+n;
					h+="<p class='center' style='display: none;margin:10px;'>" ;
					h+=	"<span class='icon32 icon-darkgray icon-gear updateType' type='"+n+"'></span>";
					h+=	"<span class='icon32 icon-darkgray icon-trash deleteType' type='"+n+"'></span></p>";
					h+="</div>";
					h+="</div>";
			})
			$("#typeName").html(h);
			
		}
	});
}

/**
 * 样式更改
 * 
 * 
 */
function style(){
	
	$("#setting").css({"border-radius":"60px","width":"60px","height":"60px","font-size":"60px","line-height":"45px"});
	$(".padd").css({"padding":"10px","font-size":"20px"});
	$(".type p").css({"margin":"10px"});
	//$(".details").css({"padding":"15px"});
	$(".updateDic").css({"cursor":"pointer"});
	$(".deleteDic").css({"cursor":"pointer"});
	
}
//js绝对路径
function getRealPath(){
	  //获取当前网址，如： http://localhost:8083/myproj/view/my.jsp
	  var curWwwPath=window.document.location.href;
	  //获取主机地址之后的目录，如： myproj/view/my.jsp
	  var pathName=window.document.location.pathname;
	  var pos=curWwwPath.indexOf(pathName);
	  //获取主机地址，如： http://localhost:8083
	  var localhostPaht=curWwwPath.substring(0,pos);
	  //获取带"/"的项目名，如：/myproj
	  var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	 
	 //得到了 http://localhost:8083/myproj
	  var realPath=localhostPaht+projectName;
	  return realPath;
	}