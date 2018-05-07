$(function(){
	timer=setInterval(getReg(),5000);
});

function getRegs(){
	
	var h = "";
	
}

function getReg(){//处方信息
	var h="";
	var regId=$("#id").val();
	var sum=0;
	$.ajax({
		 type : "post",
		 url :"../../../Hospital/servlet/prescription?opr=getPreByReg",
		 data :{"regid":regId},
		 dateType:"json",
		 success:function(m){
			console.log(m);
			
			if( m == null ){
				console.log("null");
			}else{
				var da = eval("("+m+")");
				console.log(da);
				$.each(da.drugJson,function(i,n){
					 console.log(m);
					 var price=n.number*n.price;
					 sum+=price;
				h+="<tr> <td width='141' height='42'>"+n.name+"</td>  <td width='97'>"+n.number+"</td> " ;
				h+="<td width='88'>"+n.unit+"</td> <td width='88'>"+n.standard+"</td> <td width='156'>"+n.number*n.price+"</td></tr>";
				})
				
				h+="<tr>总价"+sum+"</tr>";
				$("#tr") .append(h);
				
			}
			
			 	
		 }
	})
	
	
}

//console.log(m);
//$.each(m,function(i,n){
//	 console.log(m);
//	 var price=n.number*n.price;
//	 sum+=price;
//h+="<tr> <td width='141' height='42'>"+n.name+"</td>  <td width='97'>"+n.number+"</td> " ;
//h+="<td width='88'>"+n.unit+"</td> <td width='88'>"+n.stannard+"</td> <td width='156'>"+n.number*n.price+"</td></tr>";
//})
//h+="<tr>总价"+sum+"</tr>";
//$("#tr") .append(h);