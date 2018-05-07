// JavaScript Document
		window.onload = function()
        {
            $(".body").css("visibility"," hidden");
        }
		$(function(){
			$(".btn").click(function(){
				var text=$(".text").val();
				$(".body").css("visibility"," hidden");
				if(text==undefined||text=="")
				{
				}
				else
				{
					$(".body").css("visibility", "visible");
					
				}
			})
			
			$("#tijiao").click(function(){
				$("#myModal").addClass("in");
				$("#myModal").css("display","block");
				$(".body").css("visibility"," hidden");
				$(".text").val("");
			});
			
		})
