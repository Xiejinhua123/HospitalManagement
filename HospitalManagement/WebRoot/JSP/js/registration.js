var doctorId = '';	// 全局变量，存储点击的医生编号
var reg = ''; // 挂号类型
var price = ''; // 挂号金额
var num = 0;//获取该医生的挂号人次
var regid = 0; // 存储当前用户挂号的编号
var timer; // 定时器
var doid; // 生成的处方表的编号

//医生盒子点击事件
function docClick(docId){
	doctorId = docId;
	$.ajax({
		type:"post",
		url:"/HospitalManagement/doctor?opr=getById",
		data:{"docId":docId},
		dataType:"json",
		success:function(data){
			if(data=="noUrl"){
				$("#error").html("<p>访问出错</p>");
			}else if(data=="nothing"){
				alert("错了");
			}else{
				$(".docName").html(data.trueName);
				$(".docDuty").html(data.duty);
				$(".docSex").html(data.docSex);
				$(".docBir").html(data.docBirthday);
				$(".docSchool").html(data.schoolRecord);
				$(".docPhone").html(data.telePhone);
				$(".docEmail").html(data.email);
				$(".docRegNum").html(num);
			}
			$("#myModal").addClass("in").attr("aria-hidden","false").css({"display":"block"});
		}
	});
}

/**
 * 该方法用来执行ajax轮循
 * 
 * 查询该挂号信息有没有处方生成
 * 
 * 参数id 是挂号生成的编号
 */
function msg(){
	$.ajax({
		type:"post",
		data:{"regid":regid},
		dataType:"json",
		url:"/HospitalManagement/DoctorOffer?opr=getByRegId",
		success:function(data){
			if(data != null){
				clearInterval(timer);
				alert("就诊结束，您的处方已经生成，请查看");
				$("#abc").css("display","none");
				doid = data.dOId;
				var html = "";
				$.ajax({
					type:"post",
					url:"/HospitalManagement/Prescription?opr=getDrugByDoId",
					data:{"doid":doid},
					dataType:"json",
					success:function(data){
						var price = 0;
						$.each(data,function(index,d){
							price += d.drugNum*d.drugPrice;
							html+="<tr>" +
										"<td>"+d.drugName+"</td>" +
										"<td>"+d.drugNum+"</td>" +
										"<td>"+d.drugPrice+"</td>" +
									"</tr>";
						});
						html +="<tr><td></td><td style='font-size:20px; text-aline:center;'>总价:"
								+price+"</td><td><BUTTON onclick='fukuanclick()'>" +
									"确定付款</BUTTON></td></tr>";
						$("#chufangyaopin").html(html);
						$("#chufangxinxi").css("display","block");
					}
				});
				
			}
		}
	});
}

function fukuanclick(){
	$("#output").html("<p>http://localhost:8080/HospitalManagement/Prescription?opr=getDrugByDoIda&doid="+doid+"</p>");
	$("#output").qrcode("http://localhost:8080/HospitalManagement/Prescription?opr=getDrugByDoIda&doid="+doid);
	$("#chufangxinxi").css("display","none");
	$("#erweima").css("display","block");
}

$(function(){
	
	//$("#").css("display","none");
	
	timer = setInterval(msg,1000);
	
	//挂号类型选择事件，点击事件
	$("[name='regType']").change(function(){
		
		var value = $(this).val();
		reg = value;
		if(reg=="401")price=5.0;
		else if(reg=="402")price=2.5;
		var html = "";
		$.ajax({
			   type: "POST",
			   url: "/HospitalManagement/Department?opr=getByReg",
			   data:{"regType":value},
			   dataType:"json",
			   success:function(m){
				   if(m == ""){
					   $("[name='dep']").html("<option>请选择</option>");
					   $(".doc-box").html("");
					   alert("今天没有专家就诊，请选择普通号进行就医");
				   }else{
					   
					   html += "<option>请选择</option>";
					   $.each(m,function(index,p){
						html += "<option name='depItem' value=" + p.depId + ">" + p.depName + "</option>";
					   });
				   }
				   $("[name='dep']").html(html);
			   }
			});	
	});
	
	//科室下拉框选择事件
	$("[name='dep']").change(function(){
		var depId = $(this).val();
		var html = "";
		$.ajax({
			type:"post",
			url:"/HospitalManagement/doctor?opr=getPage&pagesize=1",
			data:{"depId":depId},
			dataType:"json",
			success:function(data){
				var a=0;
				if(data!=""){
					$.each(data,function(index,p){

							html += "<div class='col-md-3 col-sm-3 col-xs-6' onclick='docClick("+p.docId+")'>" +
							"<a title='6 new members.' class='well top-block' href='#'>" +
							"<i class='glyphicon glyphicon-user blue'></i>" +
							"<div>姓名："+ p.trueName +"</div>" +
							"<div>学历："+ p.schoolRecord +"</div>" +
							"<div>工号："+ p.docId +"</div>" +
							"</a></div>";				
						
					});
					$(".doc-box").html(html);
					
				}else{
					$(".doc-box").html("");
					alert("今天该科室无人值班");					
				}
			}			
		});
	});
	
	//点击部门下拉框
	$("[name='dep']").click(function(){
		$(".select span").remove();		
		if( !$("[name='regType']").is(":checked") ){
			$(this).parent("td").append("<span style='color:red; font-size:16px;'>(请先选择挂号类型)</span>");
		}		
	});
	
	//取消按钮
	$("#callNo").click(function(){
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
	});
	
	//确定按钮
	$("#callYes").click(function(){
		
		$("#regsuccess").css("display","block");
		
		$("#reg_dep").html($("[name='dep'] option:selected").text());
		
		$("#reg_doc").html($(".docName").html());
		$("#reg_price").html(price);
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
		
		
	});
	
	//提交按钮
	$(".btn_submit").click(function(){
		var d = doctorId; // 医生编号
		var rt = reg; // 科室编号
		var dep = $("[name='dep']").val(); // 挂号类型
		
		var data = '{"depId":"'+dep+'","docId":"'+d+'","regType":"'+rt+'}"'; // 获取json
		
		$.ajax({
			type:"post",
			url:"/HospitalManagement/registered?opr=add",
			data:{"depId":dep,"docId":d,"regType":rt},
			dataType:"json",
			success:function(data){
				if(data=="noPatient"){
					$("#error").html("<p>您还没有登录</p>");
				}else if(data=="noUrl"){
					$("#error").html("<p>路径访问出错</p>");
				}else if(data=="noDoc"){
					$("#error").html("<p>没有选择医生</p>");
				}else if(data=="noDep"){
					$("#error").html("<p>没有选择科室</p>");
				}else if(data=="noType"){
					$("#error").html("<p>没有选择挂号类型</p>");
				}else if(data=="nothing"){
					$("#error").html("<p>挂号失败，稍后重试，有可能服务器正在维护</p>");
				}else{ // 挂号成功，直接操作页面上的元素，显示成功挂号后的盒子信息					
					alert("挂号成功");
					regid = data;
					$("#gua").css("display","none");
					$("#regsuccess").css("display","none");
					
					$.ajax({
						type:"post",
						url:"/HospitalManagement/Department?opr=getById",
						data:{"depId":dep},
						dataType:"json",
						success:function(data){
							$(".a").html("<p>"+ data.depName +"</p>");
							$(".c").html("<p>"+ data.depAddress +"</p>");
						}
					});
					
					$.ajax({
						type:"post",
						url:"/HospitalManagement/doctor?opr=getById",
						data:{"docId":doctorId},
						dataType:"json",
						success:function(data){
							$(".b").html("<p>"+ data.trueName +"</p>");
						}
					});
					$("#abc").css("display","block");
				} 
			}
		});
	});
	
	//关闭按钮
	$("#close").click(function(){
		$("#myModal").removeClass("in").attr("aria-hidden","true").css({"display":"none"});
	});
});