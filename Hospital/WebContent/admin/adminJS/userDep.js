$(function(){
	$("[var='delUsers']").live("click",function(){ //删除选中用户
		var inputs = $("#tableinput table input");
		var j = 0;
		var html = "<tr>";
		for(var i = 0; i < inputs.length; i++){
			if( inputs[i].checked == true ){
				var username = $( inputs[i] ).parent().parent().find(".username").text();
				if( j != 0 && j % 5 == 0 ){
					html += "</tr><tr>";
				}
				html += "<td>"+ username +"</td>";
				j++;
			}
		}
		html += "</tr>";
		$( "#modal-19 #tanchuangTable" ).html(html);
		$(".md-trigger").click();
	});

	$("[va=del]").live("click",function(){	//删除用户
		var username = $(this).parent().parent().find(".userid").val();
		var html = "<tr><td>"+ username +"</td></tr>";
		$( "#modal-19 #tanchuangTable" ).html(html);
		$(".md-trigger").click();
	});
	
	$("[var='sel']").click(function(){ // 工号查询和姓名查询
		var pageSize = $(".pagesize").val();
		var pageItems = $(".pageNum").val();
		user(pageSize,pageItems);
	})
	
	$(".pageNum").change(function(){ // 页码下拉框变化
		var pageSize = 1;
		var pageItems = $(".pageNum").val();
		user(pageSize,pageItems);
	});
	
	$(".depName").change(function(){ // 科室下拉框变化
		var pageSize = 1;
		var pageItems = $(".pageNum").val();
		user(pageSize,pageItems);
	});	
	
	$(".first").click(function(){ // 首页按钮点击事件
		var pageSize = $(this).val();
		var thispagesize = $(".pagesize").val();
		if( pageSize == thispagesize)return;
		var pageItems = $(".pageNum").val();
		user(pageSize,pageItems); // 需要两个参数，一个是当前页码，一个是条目数
	});
	
	$(".last").click(function(){ // 末页按钮点击事件
		var pageSize = $(this).val();
		var thispagesize = $(".pagesize").val();
		if( pageSize == thispagesize)return;
		var pageItems = $(".pageNum").val();
		user(pageSize,pageItems); // 需要两个参数，一个是当前页码，一个是条目数
	});
	
	$(".next").click(function(){ // 下一页按钮点击事件
		var thispagesize = $(".pagesize").val(); // 当前页码
		if( $(".last").val() == thispagesize)return;
		thispagesize = thispagesize + 1; // 下一页
		var pageItems = $(".pageNum").val();
		user(thispagesize,pageItems); // 需要两个参数，一个是当前页码，一个是条目数
	});
	
	$(".previous").click(function(){ // 下一页按钮点击事件
		var thispagesize = $(".pagesize").val(); // 当前页码
		if( $(".first").val() == thispagesize)return;
		thispagesize = thispagesize - 1; // 下一页
		var pageItems = $(".pageNum").val();
		user(thispagesize,pageItems); // 需要两个参数，一个是当前页码，一个是条目数
	});
	
	//全选
	$("[name='qx']").toggle(
		function(){
			 var   getCK=$("#tableinput input");   
			 var userId=new Array(); 
			  for(var   i=0;i<getCK.length;i++)   
			  {   
			      whichObj=getCK[i];   
			      if(whichObj.type=="checkbox")   
			      {   
			    	  whichObj.checked=true;
			      }   
			  }
		},function(){
			 var   getCK=$("#tableinput input");   
			 var userId=new Array(); 
			  for(var i=0;i<getCK.length;i++)   
			  {   
			      whichObj=getCK[i];   
			      if(whichObj.type=="checkbox")   
			      {   
			    	  whichObj.checked=false;
			      }   
			  }
		})
	$("#yg tr td input").live("click",function(){
		 var getCK=$("#tableinput table input"); 
		 var b=true;
		 for(var i=0;i<getCK.length;i++)   
		  {   
		      whichObj=getCK[i];   
		      if(whichObj.checked==true)   
		      {   
		    	  b=true;
		      } 
		      else b=false;
		  }
		if(b) {
			console.log($("[name='qx']"));
//			$("[name='qx']").checked=true;
			$("[name='qx']").attr("checked","checked");
			  }
		else 
			{
			return;
			}
	})
	//刷新科室
	dep();
	user();
})	


//加载用户
function user(pageSize,pageItems){
	var num=$(".pageNum").val();
	var userId=$("[name='userId']").val();
	var name=$(".depName").val();
	var trueName=$("[name=trueName]").val();
	$.ajax({
		type:'post',
		dataType:'json',
		data:{"num":num,"pagesize":pageSize,"pageitems":pageItems,"userId":userId,"name":name,"trueName":trueName},
		url:"../../../Hospital/servet/user?ac=getPage",
		success:function(m){
			$(".pageCount").html("<a>总页数：" + m.pagetotal + "</a>")
			$(".last").val(m.pagetotal); // 末页
			$(".pagesize").val(m.pagesize); // 当前页码
			$(".pagesize").html("<a>当前页码："+ m.pagesize +"</a>");
			var s = "";
			$.each(m.list,function(i,n){
				s += "<tr><td class='center'><input type='checkbox' ></td><td class='center userid' value="+n.userId+">"+n.userId+"</td><td class='center username' value='a'>"+n.userName+"</td><td class='center'>"+n.createTime+"</td><td class='center'>"+n.lastLogin+"</td><td class='center'>"+n.depName+"</td>'<td class='center'><a href='../../../Hospital/servet/user?ac=getUser&userId="+n.userId+"' class='btn btn-success' var='look'><i class='icon-zoom-in icon-white'></i>查看 </a><a class='btn btn-info' href='../../../Hospital/servet/user?ac=getUse1&userId="+n.userId+"'><i class='icon-edit icon-white'></i> 修改  </a><a class='btn btn-danger'' va='del' value='"+n.userId+"'><i class='icon-trash icon-white'></i>删除</a></td></tr>";
			});
			$("#yg").append(s);
		}
})
}
//刷新部门
function dep(){
	$.ajax({
		type:'POST',
		dataType:"json",
		data:{},
		url:"../../../Hospital/servlet/department?opr=Department",
		success:function(m){
			$.each(m,function(i,n){
					$(".depName").append("<option value="+n.depId+" >"+n.depName+"</option>");
			})
			}
	  })
}

//删除用户
function delUser(uid)
{
	var pageSize = $(".pagesize").val();
	var pageItems = $(".pageNum").val();
	var userId=$("[name='userId']").val();
	var name=$(".depName").val();
	var trueName=$("[name=trueName]").val();
	var userid = $(uid).val();
	console.log(userid);
	$.ajax({
		type:'POST',
		dataType:"json",
		data:{"uid":userid,"pagesize":pageSize,"pageitems":pageItems,"userId":userId,"name":name,"trueName":trueName},
		url:"../../../Hospital/servet/user?ac=delUser",
		success:function(m){
			var s = "";
			$.each(m.list,function(i,n){
				s += "<tr><td class='center'><input type='checkbox'></td><td class='center'>"+n.userId+"</td><td class='center'>"+n.userName+"</td><td class='center'>"+n.createTime+"</td><td class='center'>"+n.lastLogin+"</td><td class='center'>"+n.depName+"</td>'<td class='center'><a href='/Hospital/servet/user?ac='getUser'&userId='"+n.userId+"'' class='btn btn-success' var='look'><i class='icon-zoom-in icon-white'></i>查看 </a><a class='btn btn-info' href='../../../Hospital/servet/user?ac=getUse1&userId="+n.userId+"'><i class='icon-edit icon-white'></i> 修改  </a><a class='btn btn-danger'' va='del' value='"+n.usersId+"'><i class='icon-trash icon-white'></i>删除</a></td></tr>";
			});
			$("#yg").append(s);
		}
  })

}
//删除选中用户
function delUsers()
{
	var pageSize = $(".pagesize").val();
	var pageItems = $(".pageNum").val();
	var usersId=$("[name='userId']").val();
	var name=$(".depName").val();
	var trueName=$("[name=trueName]").val();
	var getCK=$(".delxz"); 
	var userId=new Array()  ;
	  for(var   i=0;i<getCK.length;i++)   
	  { 	 
	      if(getCK[i].checked)
		  {
	    	  userId[i]=getCK[i].id;
		  }
	  }
	  if(userId.length==0) return;
	 $.ajax({  
		    url: '../../../Hospital/servet/user?ac=delUsers',  
		    data: { "usersId": usersId,"pagesize":pageSize,"pageitems":pageItems,"userId":userId,"name":name,"trueName":trueName},  
		    dataType: "json",  
		    type: "POST",  
		    traditional: true,  
		    success: function (m) {
				var s = "";
				$.each(m.list,function(i,n){
					s += "<tr><td class='center'><input type='checkbox'></td><td class='center'>"+n.userId+"</td><td class='center'>"+n.userName+"</td><td class='center'>"+n.createTime+"</td><td class='center'>"+n.lastLogin+"</td><td class='center'>"+n.depName+"</td>'<td class='center'><a href='/Hospital/servet/user?ac='getUser'&userId='"+n.userId+"'' class='btn btn-success' var='look'><i class='icon-zoom-in icon-white'></i>查看 </a><a class='btn btn-info' href='../../../Hospital/servet/user?ac=getUse1&userId="+n.userId+"'><i class='icon-edit icon-white'></i> 修改  </a><a class='btn btn-danger'' va='del' value='"+n.usersId+"'><i class='icon-trash icon-white'></i>删除</a></td></tr>";
				});
				$("#yg").append(s);
			}  
		});  
}




		
		
		
		
	
