$(function(){
	var width = $(".mainSuit").parent().width();
	$(".mainSuit").css({"font-size":"20px","width":width,"padding":"15px"});
	$(".comment").css({"font-size":"20px","width":width,"padding":"15px"});
	
	getAllDrug();
	
	timer=setInterval("msg()",1000);
	
	//患者姓名点击时间，显示患者信息
	$("#click").live("click",function(){
		var a=$(this).attr("v");
		liclick(a);
	})
	//诊断
	$(".mainSuit").bind('input propertychange', function() {
	    change();
	});
	//提交
	$(".sub").bind("click",(function(){
		sub();
	}));
	/**
	 *药品列表前小删除按钮点击事件
	 *用来移除当前的条目
	 */
	$(".tda").live("click",function(){
		tdaClick(this);
	});
})
/**
 *药品列表前小删除按钮点击事件
 *用来移除当前的条目
 */
function tdaClick(event){

	$(event).parent().parent().remove();
	
}
//提交诊断信息
function sub(){
	var lis = $(".chzn-choices li");
	var spanText = new Array();
	var spanNum = 0;
	for (var i = 0; i < lis.length; i++) {
		try {
			var s = $(lis[i]).find("span").text();
			if( s != "" ){
				spanText[spanNum] = s;
				spanNum++;
			}	
		} catch (e) {
			continue;
		}
	}
	//实现数组去重
	//新的数组是n
	//向数据库中提交信息时候就是使用n
	var n = []; // 这是药品集合
	for (var i = 0; i < spanText.length; i++) {
		if( i == 0 ){
			n.push(spanText[0]);
			continue;
		}
		for (var j = 0; j < n.length; j++) {
			if( spanText[i] == n[j] ){
				continue;
			}else{
				n.push(spanText[i]);
			}
		}
	}
	var regId=$("#regId").html();
	var text=$("#textarea").val();
	if(text==null || text=="" || typeof(text) == "undefined")
	{
		$("#myModal").addClass("in");
		$("#myModal").css("display","block");
		$("#myModal p").html("主诉为空，不允许进行提交");
	}
	if(regId=="" || regId==null || typeof(regId) == "undefined")
	{
		$("#myModal").addClass("in");
		$("#myModal").css("display","block");
		$("#myModal p").html("请先选择挂号信息");
		
		return;
	}
	else 
	{
		tj(regId,text,n);
	}
	
}
/**
 * 提交信息
 * 
 * @param regId
 * 		挂号编号
 * @param text
 * 		症状信息
 * @param n	
 * 		药品集合
 */
function tj(regId,text,n)
{
	console.log(n);
	var path=getRealPath();
	$.ajax({
		type:"post",
		dataType:"json",
		async: false,
		data : {"regId":regId,"symptom":text,"drugs":JSON.stringify(n)},
		url:path+"/servlet/docoff?opr=add",
		success:function(m)
		{
			console.log(m);
			if(m==null || m=="" || typeof(m)=="undefined") alert("m is null");
			else if(m=="shibai")
			{
				$("#myModal").addClass("in");
				$("#myModal").css("display","block");
				$("#myModal p").html("提交失败，原因未知！");
			}
			else if (m=="list is null")
			{
				$("#myModal").addClass("in");
				$("#myModal").css("display","block");
				$("#myModal p").html("提交失败");
			}
			else
			{
				$("#myModal").addClass("in");
				$("#myModal").css("display","block");
				$("#myModal p").html("提交成功");
				drug(m);
			}
		}
	})
}

//"头疼发热":[{"drugAlias":"阿莫西林","drugId":1,"drugName":"阿莫西林","drugTimes":[],"fixedPrescriptions":[],"prescriptions":[]}],
//"阵痛":[{"drugAlias":"阿莫西林","drugId":1,"drugName":"阿莫西林","drugTimes":[],"fixedPrescriptions":[],"prescriptions":[]}],
//"消炎":[{"drugAlias":"阿莫西林","drugId":1,"drugName":"阿莫西林","drugTimes":[],"fixedPrescriptions":[],"prescriptions":[]}]}

/**
 * 输入症状信息后提示有的对症药品
 */
var spLength;
function change()
{
	var msgs=$(".mainSuit").val();
	var msg = msgs.substr(msgs.length-1,1); // 截取最后一位输入用来判断是不是逗号

	if( msg != '，' )return; // 最后一位不是逗号，就不执行当前操作
	
	var sp=msgs.split('，');
	var h="";
	try{
		var str; // 获取前输入的信息解析集合最后一项
		if( sp.length == 1 ){
			str = sp[0];
		}else{
			str = sp[sp.length-2];
		}
		if( str.valueOf != undefined ){ // 获取到了当前的症状条目
			/**
			 * 现在应该做的是根据条目模糊查询到药品信息
			 */
			h += '<tr><td><a class="tda" style="cursor: pointer;"><i class="icon-remove"></i></a></td><td style="width:120px;">'+str+'</td><td class="center"><select id="selectError'+sp.length+'" multiple data-rel="chosen">';
			$.ajax({
				type:"post",
				data:{"m":str},
				dataType:"json",
				async: false,
				url:"../../servlet/docoff?opr=getDrugByZ",
				success:function(r){
					$.each(r,function(i,ra){
						h += '<option selected >'+ra.drugName+'</option>';
					});
					h += "</tr>";
					$(".zhengzhuang").append(h);
					loadScript(getRealPath()+"/admin/js/charisma.js");
				},
				error:function(r){
					console.log(r);
				}
			});
			
		}
		
	}catch(e){
		
	}
	
}
/**
 * 重新加载js文件
 * 
 * @param url
 * 		文件地址
 * @param callback
 * 		加载成功后的方法
 */
function loadScript(url, callback) {  
     var script = document.createElement("script");  
     script.type = "text/javascript";  
     if(typeof(callback) != "undefined"){  
         if (script.readyState) {  
             script.onreadystatechange = function () {  
                 if (script.readyState == "loaded" || script.readyState == "complete") {  
                     script.onreadystatechange = null;  
                     callback();  
                 }  
             };  
         } else {  
             script.onload = function () {  
                 callback();  
             };  
         }  
     }  
     script.src = url;
     document.body.appendChild(script);
 }

/**
 *轮询访问当前的一声的挂号信息 
 */
function msg(){
	var h = "";
	$.ajax({
		type: "POST",
		url: "../../../Hospital/servlet/registered?opr=getNoDispose",
		dataType:"json",
		success:function(data){
			if(data != null ){
				$.each(data,function(index,d){
					h +="<tr><td style='margin-top: 10px;' class='center'><a id='click' href='#' v="+d.patId+">"+d.patName+"</a></td> </tr>";
				});
			}
			$("#guahao").html(h);
		}
		});
}

/**
 * 挂号信息条目的点击事件
 * @param patId
 * 		患者编号
 * @param regId
 * 		挂号编号
 */

function liclick(patId){
	$.ajax({
		type:"post",
		data:{"patId":patId},
		dataType:"json",
		url:"../../../Hospital/servlet/patient?opr=getById",
		success:function(data){
			if(data!=""){	
				$("#regId").html(data.registereds[0].regId);
				
				$("#patName").html("<a href='#'>"+data.patName+"</a>");
				
				if(data.patSex!=null)$("#patSex").html("<a href='#'>"+data.patSex+"</a>");
				else $("#patSex").html("<a href='#'>"+暂无+"</a>");
				
				if(data.age!=null)$("#patAge").html("<a href='#'>"+data.age+"</a>");
				else $("#patAge").html("<a href='#'>"+暂无+"</a>");
				
				if(data.geneticDisorders!=null)$("#ycbs").html(data.geneticDisorders);
				else $("#ycbs").html("暂无此项信息");
				
				if(data.patSymotoms!=null) $("#gmbz").html(data.patSymotoms);
				else $("#gmbz").html("暂无此项信息");
				
				if(data.patAddress!=null)$("#jtzz").html(data.patAddress);
				else  $("#jtzz").html("暂无此项信息");
				
			}
		}
	});
}
/**
 * 获取所有的药品信息
 */
function getAllDrug(){
	$.ajax({
		type:"post",
		dataType:"json",
		async: false,
		url:"../../servlet/drug?opr=getAll",
		success:function(m){
			var h = "";
			if( m != "" || m != null ){
				for (var i = 0; i < m.length; i++) {
					if( i == 0 )
						h += "<option value="+m[i].drugId+" selected>"+m[i].drugName+"</option>";
					else
						h += "<option value="+m[i].drugId+">"+m[i].drugName+"</option>";
				}
			}
			$("#selectError1").html(h);
		}
	})
}

function InsertDrug(id,name)
{
	if(id==undefined||id==null||name==undefined||name==null)return;
	var tr='<tr class="center" data-val='+id+'>';
	tr+='<td>'+name+'</td>';
	tr+='<td class="center">';
	tr+='<input style="width: 40%; height:100%; vertical-align: middle;" type="text">';
	tr+='<select style="width: 55%;">';
	tr+='<option>瓶</option>';
	tr+='<option>盒</option>';
	tr+='<option>片</option>';
	tr+='<option>支</option>';
	tr+='</select>';
	tr+='</td>';
	tr+='<td class="center">';
	tr+='<select style="width:100%;">';
	tr+='<option>一日一次</option>';
	tr+='<option>一日两次</option>';
	tr+='<option>一日三次</option>';
	tr+='</select>';
	tr+='</td>';
	tr+='<td class="center">';
	tr+='<input style="width:100%; height: 100%;" type="text" value="平均">';
	tr+='</td>';
	tr+='</tr>';
	$("#Drug").append(tr);
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