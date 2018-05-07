$(function(){
	zt();
	sex();
	bm();
	zj();
	zw();
})

function sex(){
	var a=$(".sex").text();
	$.ajax({
		type:'post',
		dataType:'json',
		url:"../../../Hospital/servlet/dic?ac=getDic",
		async:false,
		data:{"typename":"性别"},
		success:function(m){
			if( m!=null ){
				$(".sex").html("");
				var h = "";
				$.each(m,function(i,n){
					h += '<label class="radio" style="margin-left: 13px;"><div class="radio"><span><input type="radio" name="sex" id="optionsRadios'+i+'" value="'+n.typeCode+'"></span></div>'+n.typeValus+'</label>';
				})
				$(".sex").html(h);
				
				var s = $(".hisex").val();
				var ss = $("[name='sex']");	
				
				for (var i = 0; i < ss.length; i++) {
					var ssi = ss[i];
					if( $(ssi).val() == s ){
						ss[i].checked = true;
					}
					
				}
				
			}
		}
});
		
	
}

function zt(){
	var a=$(".ss").text();
	var h="";
	$.ajax({
		type:'post',
		dataType:'json',
		url:"../../../Hospital/servlet/dic?ac=getDic",
		data:{"typename":"在职状态"},
		success:function(m){
			$.each(m,function(i,n){
				console.log(m);
				if(n.typeCode==a)h="<option value="+n.typeCode+">"+n.typeValus+"</option>"+h;
				else h+="<option value="+n.typeCode+">"+n.typeValus+"</option>";
			})
			$(".zt").append(h);
		}
	})
	
}
function bm(){
	var a=$(".bm").text();
	var h="";
	$.ajax({
		type:'post',
		dataType:'json',
		url:"../../../Hospital/servlet/dic?ac=getDic",
		async:false,
		data:{"typename":"科室"},
		success:function(m){
			$.each(m,function(i,n){
				if(n.typeCode==a)h="<option value="+n.typeCode+">"+n.typeValus+"</option>"+h;
				else	h+="<option value="+n.typeCode+">"+n.typeValus+"</option>";
			})
			$(".selbm").append(h);
		}
	})
	
}
function zj(){
	var a=$(".zj").text();
	var h="";
	$.ajax({
		type:'post',
		dataType:'json',
		url:"../../../Hospital/servlet/dic?ac=getDic",
		async:false,
		data:{"typename":"挂号类别"},
		success:function(m){
			$.each(m,function(i,n){
				if(n.typeCode==a)h="<option  value="+n.typeCode+">"+n.typeValus+"</option>"+h;
				else	h+="<option value="+n.typeCode+">"+n.typeValus+"</option>";
			})
			$(".selzj").append(h);
		}
	})
	
}
function zw(){
	var a=$(".zw").text();
	var h="";
	$.ajax({
		type:'post',
		dataType:'json',
		url:"../../../Hospital/servlet/dic?ac=getDic",
		async:false,
		data:{"typename":"职务"},
		success:function(m){
			$.each(m,function(i,n){
				if(n.typeCode==a)h="<option  value="+n.typeCode+">"+n.typeValus+"</option>"+h;
				else	h+="<option value="+n.typeCode+">"+n.typeValus+"</option>";
			})
			$(".selzw").append(h);
		}
	})
	
}
