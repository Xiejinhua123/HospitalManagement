/**
 * 添加正常人用户
 */
function saveUser(){
	
	var bool = true;
	bool = checkedName($(".name"));
	bool = checkedPwd($(".pwd"));
	bool = checkedFile($("#a1"));
	bool = checkedBir($(".bir"));
	
	if( bool ){
		$(".help").hide();
		
		$("#fo").submit();
		
	}else{
		$(".help").show();
	}
}

/**
 * 验证用户名是否正确
 */
function checkedName(doc){
	
	var name = $(".name").val();
	if( name.length <= 0 ){
		$(doc).next("p").html("用户名不能为空");
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		
		$.ajax({
			type:"post",
			data:{"users.userName":name},
			url:"/VoteManage/checkedUserName.action",
			dateType:"json",
			async:false,
			success:function(msg){
				if( msg == "\"error\"" ){
					$(doc).next("p").html("服务器发生错误，请稍后重新尝试");
					$(doc).next("p").show();
					return false;
				}
				if( msg == "\"false\"" ){
					$(doc).next("p").html("您的用户名已经存在，请更改后重新尝试");
					$(doc).next("p").show();
					return true;
				}
			}
		});
	}
}

/**
 * 验证密码
 */
function checkedPwd(doc){
	var name = $(".pwd").val();
	
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}

/**
 * 验证图片是否选择
 */
function checkedFile(doc){
	var name = $("#a1").val();
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}

/**
 * 验证生日是否选择
 */
function checkedBir(doc){
	var name = $(".bir").val();
	
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}


/**
* 添加机器人用户
*/
function saveUser1(){
	
	var bool = true;
	bool = checkedName1($(".name1"));
	bool = checkedPwd1($(".pwd1"));
	bool = checkedFile1($("#a11"));
	bool = checkedBir1($(".bir1"));
	
	if( bool ){
		$(".help1").hide();
		
		$("#fo1").submit();
		
	}else{
		$(".help1").show();
	}
}

/**
* 验证用户名是否正确
*/
function checkedName1(doc){
	
	var name = $(".name1").val();
	
	if( name.length <= 0 ){
		$(doc).next("p").html("用户名不能为空");
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		
		$.ajax({
			type:"post",
			data:{"users.userName":name},
			url:"/VoteManage/checkedUserName.action",
			dateType:"json",
			async:false,
			success:function(msg){
				if( msg == "\"error\"" ){
					$(doc).next("p").html("服务器发生错误，请稍后重新尝试");
					$(doc).next("p").show();
					return false;
				}
				if( msg == "\"false\"" ){
					$(doc).next("p").html("您的用户名已经存在，请更改后重新尝试");
					$(doc).next("p").show();
					return true;
				}
			}
		});
	}
}

/**
* 验证密码
*/
function checkedPwd1(doc){
	var name = $(".pwd1").val();
	
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}

/**
* 验证图片是否选择
*/
function checkedFile1(doc){
	var name = $("#a11").val();
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}

/**
* 验证生日是否选择
*/
function checkedBir1(doc){
	var name = $(".bir1").val();
	
	if( name.length <= 0 ){
		$(doc).next("p").show();
		return false;
	}else{
		$(doc).next("p").hide();
		return true;
	}
}