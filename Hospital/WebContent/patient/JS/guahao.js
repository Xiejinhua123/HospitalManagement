$(function(){
	
	$(".dep").live("click",function(){ // 科室小按钮单击事件
		var depName =$(this).text();
		var depId=$(this).attr("depId");
		$(".Names>span").remove();
		$(".Names span.ui-btn-text").html("科室"+depName);
		getDep(depId);
	});
	
	$("#keshi").click(function(){ // 科室栏单击事件
		getDeps();
	});
	
});

/**
 * 获取所有科室
 */
function getDeps(){
	$("#getDep").html("");
	$.ajax({
		type:"post",
		url:"../../../Hospital/servlet/department?opr=Department",
		dataType:"JSON",
		cache: true, // 是否缓存
		async: true, // 是否同步
		success:function(m)
		{
			var h="<h1>所有的科室</h1>";
			$.each(m,function(i,n){
				h+="<a href='#' data-role='button' data-inline='true' data-icon='home' class='dep' depId="+n.depId+">  "+n.depName+ " </a>" ;
			})
			$(h).appendTo("#getDep");
			$("#getDep").trigger('create');
		}
	})
}

/**
 * 根据科室编号获取该科室当天值班的所有医生
 * @param depId
 * 		科室编号
 */
function getDep(depId){
	$(".depp").html("");
	var type;
	var obj = document.getElementsByName("ck_name");
	for(var i=0; i<obj.length; i ++){
        if(obj[i].checked){
        	type=obj[i].value;
        }
    }
	var h="";
	$.ajax({
		type:"post",
		cache: false,
		url:"../../../Hospital/servet/user?ac=getUserByDep",
		data:{"depId":depId,"type":type},
		dataType:"json",
		success:function(m)
		{
			if (m=="") 	$(".depp").html("<p>该科室没有医生在线</p>");
			else if( m.length != null )
			{
				$.each(m,function(i,n){
					h += "<li><a href='#myPopup' onclick='input("+n.userId+")' data-rel='popup' class='ui-btn' data-transition='flip'><h2 style='font-size: 20px; position: relative; left: 20px;''>姓名:"+n.userName+"</h2><h2 style='font-size: 20px; position: relative; left: 20px;'>职位："+n.isSpecialist+"</h2></a></li>";
				})
				
				$(h).appendTo(".depp");
				$('.depp').listview('refresh');
			}
			$(".Names").click();
		}
	}); // ajax结束
}
function input(a){
	$('#aa').val(a);
}
function subm(){
	$("#regiadd").submit();
}