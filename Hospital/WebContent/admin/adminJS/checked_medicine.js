// JavaScript Document
		window.onload = function()
        {
            $(".body").css("visibility"," hidden");
        }
		$(function(){
			
			$(".btn").click(function(){
				var text=$(".text").val();
				if(text==undefined||text=="")
				{
				}else
				{
					$(".body").css("visibility", "visible");
				}
			});
			$("#tijiao").click(function(){
				$("#myModal").addClass("in");
				$("#myModal").css("display","block");
				$(".body").css("visibility", "hidden");
				$(".text").val("");
			});
		})
$(document).ready(function(e) {
	$.ajax({
		type:'post',
		data:'',
		dataType:"json",
		url:"../../servlet/prescription?opr=getPreByReg",
		success: function(m){
				var title='<tr>';
				title+='<td class="center">'+m.patient.patName+'</td>';
				title+='<td class="center">'+m.patient.patSex+'</td>';
				title+='<td class="center">'+m.regPrice+'</td>';
				title+='<td class="center">'+m.users.trueName+'</td>'
				title+='</tr>';
				$("#title").append(title);
				$.each(m.drugJson,function(i,d){
					var tr='<tr>';
					tr+='<td class="center">'+d.name+'</td>';
					tr+='<td class="center">'+d.number+'</td>';
					tr+='<td class="center">'+d.unit+'</td>';
					tr+='<td class="center">'+d.standard+'</td>';
					tr+='</tr>';
					$("#main").append(tr);
				});
			}
	})
});
