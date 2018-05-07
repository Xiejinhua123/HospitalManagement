$(function(){
	$.ajax({
		type:'post',
		dataType:"JSON",
		data:"",
		async:false,
		url:"/Hospital/servet/user?ac=Authority",
		success: function(m){
			var h = "";
			h = tojson(m);
			$("#menu").html(h);
		}
	});
});

/**
 * 
 * @param m
 * 		json类型的权限信息
 * @returns
 * 		菜单列表的html元素
 */
function tojson(m){
	var h = "";
	for (var i = 0; i < m.length; i++) {
		h += '<li><a class="ajax-link" href="'+m[i].menuUrl+'"><i class="'+m[i].menuPic+'"></i><span class="hidden-tablet">'+m[i].priName+'</span></a></li>';
	}
	return h;
}