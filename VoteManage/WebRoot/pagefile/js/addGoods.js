$(function() {

	$(".tan").hide();

	$(".addImg").click(function() {
		addImgDiv();
	});
	
	$(".submit").click(function() {
		var name = $(".Goodsname").val();
		if (name == null || name == "") {
			$(".checkName").html("商品名称不能为空");
			return false;
		}
		var ai = $(".Goodsai").val();
		if (ai == null || ai == "") {
			$(".checkName").html("");
			$(".chenckAi").html("兑换爱心数不能为空");
			return false;
		}
		if (ai.length > 11) {
			$(".checkName").html("");
			$(".chenckAi").html("请输入正确的爱心数量");
			return false;
		}
		var a = judgeSign(ai);
		if (a == "不是数字" || a == "是负数") {
			$(".checkName").html("");
			$(".chenckAi").html("爱心数输入错误,必须为正整数");
			return false;
		}
		var file = $("[name=file]").val();
		if (file == null || file == "") {
			$(".chenckAi").html("");
			$(".chenckImg").html("至少选择一张图片");
			return false;
		}
		$(".chenckImg").html("");
		$("from").submit();
	});

	$(".tan").hidden;
	var re = $(".ret").val();
	if (re == "success") {
		$(".context").html("添加成功");
		$(".tan").click();
	} else if (re == "error") {
		$(".context").html("添加失败");
		$(".tan").click();
	}
	$(".closeTan").click(function() {
		window.location.href = "/VoteManage/pagefile/pages/addGoods.jsp?resId=8";
	});
});

/**
 * 添加更多按钮点击事件
 */
function addImgDiv() {

	var length = $(".img .imgDiv").length;
	length = length + 1;

	var html = "<div class='imgDiv'> " + "<input type='file' id='a" + length
			+ "' name='file' onchange=javascript:setImagePreviews('a" + length
			+ "','b" + length + "','150px','180px') />" + "<div id='b" + length
			+ "' class='imgView'></div></div>";

	$(".img").append(html);

	$.getScript("/VoteManage/pagefile/js/ImgPreview.js");
}
//检测是否为正数
function judgeSign(num) {
	if (Number(num)) {
		var absVal = Math.abs(num);
		return num == absVal ? '是正数' : '是负数';
	} else {
		return '不是数字';
	}
}