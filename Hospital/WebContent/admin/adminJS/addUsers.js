// JavaScript Document
$(function(){
	
//	var end=$("#selectError1");
//	var enc=$(".chzn-results");
	//id.html("");
	var r = "";
   	$.ajax({
		type:'post',
		data:{},
		dataType:"json",
		url:"../../servet/user?ac=getRole",
		success: function(m){
				if(m=='nothing')
				{
					console.log("null");
				}
				else {
					$.each(m,function(i,d){
						console.log(d.roleName);
						r += "<option value="+d.rolesId+">"+d.roleName+"</option>";
					})
					$(".selectroles").html(r);
				}
			}
		});

	
	
	
})
