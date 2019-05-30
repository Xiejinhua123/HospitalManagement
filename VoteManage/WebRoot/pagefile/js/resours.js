$(function(){

	getAll();

	//提交添加表单
	$(".addSave").click(function(){ $("#addForm").submit(); });
	
	//提交修改表单
	$(".updateSave").click(function(){ $("#updateForm").submit(); });
	
	//权限等级失焦事件
	$(".resGrade").bind('input propertychange', function() {
		resGradeBlur( $(".resGrade") );
	});
});

/**
 * 获取当前登录用户可以操作的所有的权限信息
 */
function getAll(){
	
	var manage = $(".ret").val();
	var id = $(".rets").val();
	if(id == "true"){
		id = false;
	}else{
		id=true;
	}
	
	if( manage != "" && manage.length == 4 && id ){
		
		$(".abc").html(manage);
		$(".tixingTan").click();
	}
	
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/VoteManage/getAllRes.action",
		success:function(msg){
			if( msg != "error" ){
				var html = "";
				for(var i = 0; i < msg.length ; i++){
					var r = msg[i];
					html += "<tr>";
					html += "<td>"+ r.id +"</td><th>"+ r.name
							+"</td><td>"+ r.resRank +"</td><td>"
							+ r.updateName +"</td><td>"+ r.updateTime 
							+"</td><td>"+ r.createName+"</td><td>"
							+ r.createTime +"</td>";
					if(r.deletes=="1")html += "<td>是</td>";
					else html += "<td>否</td>";
					html += "<td>"+ r.options +"</td>";
					html += "</tr>";
				}
				$("#tbody").html(html);
			}
		}
	});
}

/**
 * 修改按钮点击事件
 * 
 * 在这里需要执行ajax
 * @param id
 * 		编号
 */
function updateClick(id){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$.ajax({
		type:"post",
		url:"/VoteManage/getResById.action",
		data:{"res.id":id},
		async:false,
		dataType:"json",
		success:function(msg){
			if( msg != "error" ){
				$("[name='res.id']").val( msg.id );
				$(".resName").val( msg.name );
				$(".resAddress").val( msg.resAddress );
				$(".resRank").val( msg.resRank );
				if( msg.resRank != 1 ){
					$(".parentRes").show();
					$(".parentRes #parId").val( msg.parentId );
				}else{
					$(".parentRes").hide();
				}
			}
		}
	});
	
	var grade = $(".resRank").val();
	if( grade > 1 )
	$.ajax({
		type:"post",
		dataType:"json",
		async:false,
		data:{"res.resGrade":grade},
		url:"/VoteManage/getAjaxRes.action",
		success:function(msg){
			var html = "";
			if( msg != "" && msg != "error" ){
				var parId = $("#parId").val();
				for( var i = 0; i < msg.length; i++ ){
					if( msg[i].id == parId )
						html += "<option selected value=" + msg[i].id + "> " + msg[i].name + " </option>";
					else
						html += "<option value=" + msg[i].id + "> " + msg[i].name + " </option>";
				}
			}
			if( html == "" ){
				html = "<option value='-1'>暂无可以操作的权限</option>";
			}
			$(".parentRes select").html( html );
		}
	});
}

/**
 * 删除按钮点击事件，将编号放入文本框中
 * 
 * @param id
 * 需要删除的编号
 */
function aclick(id){
	if(id==null)
	{
		$(".error").click();
		return;
	}	
	$("#delete").click();
	$("#deleteId").val(id);
}

/**
 * 权限等级文本框失焦事件
 * @param doc
 */
function resGradeBlur(doc){
	var grade = $(doc).val();
	
	if( grade == "" || grade <= 0 ){
		$(this).next("p").show();
		$(".parentGrade").hide();
		return false;
	}
	
	if( grade > 0 && grade != 1 ){
		
		$.ajax({
			type:"post",
			dataType:"json",
			data:{"res.resGrade":grade},
			url:"/VoteManage/getAjaxRes.action",
			success:function(msg){
				var html = "";
				if( msg != "" && msg != "error" ){
					for( var i = 0; i < msg.length; i++ ){
						html += "<option value=" + msg[i].id + "> " + msg[i].name + " </option>";
					}
				}
				if( html == "" ){
					html = "<option value='-1'>暂无可以操作的权限</option>";
				}
				$(".parentSelect").html( html );
				$(".showGrade").html( grade - 1 );
			}
		});
		
		$(".parentGrade").show();
		
	}else{
		$(".parentGrade").hide();
	}
}