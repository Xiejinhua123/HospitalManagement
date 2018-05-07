var value = [];
var i = 0;
var num = 0;
var ket = []; // 药品名称
var value = []; // 数量
var html = "<tr>" +
"<td style='text-align: right; width: 50%; padding-right: 10%;'>药品名名称</td>" +
"<td style='width: 50%;' class='docName'>数量</td>" +
"</tr>";

$(function(){
	num = $(".no li").size();
	
	var timer = setInterval(msg,1000);
	
	$(".btn_cancel").click(function(){
		$("#sympton").val("");
		$("#yaofang").val("");
	});
	
	$(".delInput").click(function(){
		var index = $(this).parent().index();
		$(".no li").eq(index).remove();		
		$(".num li").eq(index).remove();
	});
		
	$(".btn_submit").click(function(){
		ket = [];
		value = [];
		var text = $("#yaofang").val();
			
		var str = text.split(",");
			
		for(var i = 0; i < str.length;i++){
			
			var s = str[i].split("*");
			
			for(var j = 0; j < s.length; j++){
				
				if(j%2==0){
					ket[ket.length] = s[j];
				}else{
					value[value.length] = s[j];
				}
			}
		}
		var ht = html;
		for ( var i = 0; i < ket.length; i++) {
			ht+="<tr>" +
					"<td style='text-align: right; width: 50%; padding-right: 10%;'><input name='drugName' value='"+ket[i]+"'/></td>" +
					"<td style='width: 50%;' class='docName'><input name='drugNum' value='"+value[i]+"'/</td>" +
				"</tr>";
		}
		
		$("#tanchuang").html(ht);
		$("#myModal").addClass("in").attr("aria-hidden","flase").css({"display":"block"});
	});
	
	//关闭按钮
	$("#close").click(function(){
		$("#tanchuang").html(html);
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
	});
	
	//取消按钮
	$("#callNo").click(function(){
		$("#tanchuang").html(html);
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
	});
	
	//确定按钮
	$("#callYes").click(function(){

		var text = $("#yaofang").val();
		var rid = $("#regId").val();
		var sympton = $("#sympton").val();
		
		$.ajax({
			type:"post",
			url:"/HospitalManagement/Prescription?opr=add",
			data:{"yaofang":text,"rid":rid,"sympton":sympton},
			dataType:"json",
			success:function(data){
				if(data == "success")
					alert("提交成功");
			}
		});
		
		
		$("#tanchuang").html(html);
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
	});
	
});

function btnClick(index){
//	var index = $(this);
	var newindex = index;
	$(".no li").eq(newindex).remove();
	$(".num li").eq(newindex).remove();
	console.log(newindex);
}

var html1 = "<li class='nav-header' value='a'>挂号信息</li>";
function msg(index){
	var h = html1;
	$.ajax({
		type: "POST",
		url: "/HospitalManagement/registered?opr=getNoDispose",
		dataType:"json",
		success:function(data){
			if(data!=""){
				$.each(data,function(index,d){
					h += "<li onclick=liclick("+d.patId+","+d.regId+")><a class='ajax-link'><i class='glyphicon glyphicon-plus'></i><span>"+d.patId+"</span><span style='float:right;'>"+d.regId+"</span></a></li> ";
				});
			}
			$("#table").html(h);
		}
		});
}

function liclick(patId,regId){
	$.ajax({
		type:"post",
		data:{"patId":patId},
		dataType:"json",
		url:"/HospitalManagement/Patients?opr=getById",
		success:function(data){
			if(data!=""){				
				$("#patName").html("<a href='#'>"+data.patName+"</a>");
				$("#patSex").html("<a href='#'>"+data.patSex+"</a>");
				$("#patAge").html("<a href='#'>"+data.age+"</a>");
				$("#regId").val(regId);
				$("#guomin").html("<p>"+data.patSymotoms+"</p>");
				$("#yichuan").html("<p>"+data.geneticDisorders+"</p>");
			}
		}
	});
}
	
	
	
	
	
	