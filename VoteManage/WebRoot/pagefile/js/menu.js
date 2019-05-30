$(function(){
	
	var menu = $(".nav-second-level").find(".nav-second-level").get(0);
	var li = $(menu).parent("li").find("a").get(0);
	$(li).append("<span class='fa arrow'></span>");
	$(menu).removeClass("nav-second-level");
	$(menu).addClass("nav-third-level");
	
});

/**
 * ajax执行异步加载菜单信息
 * 
 * 需要获取到当前父级编号为给定参数的权限
 * 
 * @param id
 * 		用户编号
 */
function getGridMenu( id , doc ){
	if( $(doc).next("ul").length == 0 ){
		$.ajax({
			type:"post",
			url:"/VoteManage/getResByParent.action",
			data:{"parent":id},
			async:false,
			dataType:"json",
			success:function(msg){
				if( msg != "error" && msg != "" ){
					var html = "<ul class='nav nav-second-level'>";
	
					for ( var i = 0; i < msg.length; i++) {
						html += "<li><a href='" + msg[i].address+ "?resId="+msg[i].id+"'>" + msg[i].name + "</li>";
					}
					html += "</ul>";
					$(doc).next("ul").remove();
					$(doc).after(html);
				}
			}
		});
		$.getScript("/VoteManage/pagefile/js/sb-admin-2.js");
	}
}