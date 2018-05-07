$(function() {
	//表单验证
	$("#zc").click(function() {
		var b = true;
		b = checkName();
		b = checkPwd();
		b = checkQrPwd();
		if (b) {
			var name = $("[name='name']").val();//姓名
			var pwd = $("[name='pwd']").val();//密码
			var card = $("[name='card']").val();//身份证号
			var tel = $("[name='tel']").val();//手机号
			var sex = $("#flip2").val();//性别
			var born = $("[name='date']").val();//出生日期
			var address = $(".address").val();//住址
			var bz = $(".bz").val();//过敏症状
			var bs = $(".bs").val();//病史
			console.log("a");
			$.ajax({
				type : 'post',
				dataType : "JSON",
				data : {
					"name" : name,
					"pwd" : pwd,
					"card" : card,
					"tel" : tel,
					"sex" : sex,
					"born" : born,
					"address" : address,
					"bz" : bz,
					"bs" : bs
				},
				url : "../../../Hospital/servlet/patient?opr=zhuce",
				success : function(m) {
					
					if (m == "noapat" || m == ""){}
						
					else
						$("#successid").click();
				},
				error:function(dat){
					var error = dat.responseText;
					if( error == "name" ){
						$("#errortishi").html("您的姓名已经被注册,可以更改密码，或者更换用户名");
					}else if( error == "phone" ){
						$("#errortishi").html("您的手机号码已经被注册，请更换");
					}else if( error == "card" ){
						$("#errortishi").html("您的身份证号已经被注册，请更换");
					}
					$("#errorid").click();
				}
			})
		} else {
			$("#nologin").click();
		}
	})
	$("[name='name']").blur(function() {
		checkName();
	});
	$("[name='pwd']").blur(function() {
		checkPwd();
	});
	$("[name='qrpwd']").blur(function() {
		checkQrPwd();
	});
	$("[name='card']").blur(function() {
		var idcard = $(this).val();
		if (idcard.length == 0) {
			$(".card").html("");
			return;
		} else {
			var bool = isIdCardNo(idcard);
			if (bool)
				$(".card").html("");
		}

	});
	$("[name='tel']").blur(function() {
		var num = $(this).val();
		if (num.length == 0) {
			$(".phone").html("");
			return;
		} else
			checkedPhone(num);
	});

})
//名称验证
function checkName() {
	var name = $("[name='name']").val();
	if (name == "") {
		$(".checkName").html("姓名不能为空");
		return false;
	} else {
		$(".checkName").html("√");
		return true;
	}
}
//密码验证
function checkPwd() {
	var qrpwd = $("[name='qrpwd']").val();
	var pwd = $("[name='pwd']").val();
	if (pwd.length == "") {
		$(".checkPwd").html("密码不能为空");
		return false;
	} else if (pwd.length < 6) {
		$(".checkPwd").html("密码长度不能小于六位");
		return false;
	} else if (pwd.length > 12) {
		$(".checkPwd").html("密码长度不能大于十二位");
		return false;
	}

	else if (pwd.length >= 6 && pwd.length < 12) {
			$(".checkPwd").html("√	");
			return true;
		}
	}
//确认密码
function checkQrPwd() {
	var qrpwd = $("[name='qrpwd']").val();
	var pwd = $("[name='pwd']").val();
	if (qrpwd == "") {
		$(".qrPwd").html("密码不能为空");
		return false;
	} else if (qrpwd.length < 6) {
		$(".qrPwd").html("密码长度不能小于六位");
		return false;
	} else if (qrpwd.length > 12) {
		$(".qrPwd").html("密码长度不能大于十二位");
		return false;
	} else if (qrpwd.length >= 6 && qrpwd.length < 12) {
		if (pwd == qrpwd) {
			$(".checkPwd").html("√	");
			$(".qrPwd").html("√	");
			return true;
		} else if (pwd != qrpwd) {
			$(".qrPwd").html("两次密码不一致");
			return false;
		}
	}
}

/**
 * 身份证号验证
 * @param num
 * 		身份证号
 * @returns
 * 		boolearn
 */
function isIdCardNo(num) {
	num = num.toUpperCase();
	//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。  
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num))) {

		$(".card").html("输入的长度不正确，15位或者18位");
		return false;
	}
	//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
	//下面分别分析出生日期和校验位
	var len, re;
	len = num.length;
	if (len == 15) {
		re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); // 15位正则

		var arrSplit = num.match(re);
		//检查生日日期是否正确

		var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/'
				+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			$(".card").html("身份证号出生日期不正确");
			return false;
		} else {
			//将15位身份证转成18位
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
					8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4',
					'3', '2');
			var nTemp = 0, i;
			num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6);
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			num += arrCh[nTemp % 11];
			$(".card").html("");
			return true;
		}
	}
	if (len == 18) {
		re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var arrSplit = num.match(re);
		//检查生日日期是否正确
		var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/"
				+ arrSplit[4]);
		var bGoodDay;
		bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2]))
				&& ((dtmBirth.getMonth() + 1) == Number(arrSplit[3]))
				&& (dtmBirth.getDate() == Number(arrSplit[4]));
		if (!bGoodDay) {
			$(".card").html("身份证号出生日期不正确");
			return false;
		} else {
			//检验18位身份证的校验码是否正确。
			//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			var valnum;
			var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
					8, 4, 2);
			var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4',
					'3', '2');
			var nTemp = 0, i;
			for (i = 0; i < 17; i++) {
				nTemp += num.substr(i, 1) * arrInt[i];
			}
			valnum = arrCh[nTemp % 11];
			
			$(".card").html("");
			return true;
		}
	}
	return false;
}
/**
 * 手机号码正则验证
 * @param num
 * 		手机号码
 * @returns
 * 		正确与否
 */
function checkedPhone(num) {

	var reg = /^1[3|4|5|7|8][0-9]{9}$/; //验证规则
	var flag = reg.test(num); //true
	if (flag)
		$(".phone").html("");
	else
		$(".phone").html("输入不正确");
	return flag;
}
