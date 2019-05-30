var ballObject;
var goodsObject;

$(function(){
	
	getAll();
});


function getById(){
	
}

/**
 * 页面加载成功需要显示的兑奖信息
 */
function getAll(){
	
	$.ajax({
		type:"post",
		dataType:"json",
		url:"/VoteManage/getGoodsBall.action",
		success:function(data){
			console.log(data);
			if(data != null && data != "error"){
				var rowHtml = "";
				for ( var i = 0; i < data.rows.length; i++) {
					var html = "<div class='row'><div class='col-lg-5 col-md-6 col-sm-6' style='text-align: center;'><div class='row'>";
					var ball = data.rows[i].gbb; // 这是一个集合
					for ( var j = 0; j < ball.length; j++) {
						
						var ballHtml = createBall( ball[j] );
						html += ballHtml;
					}
					
					html += "</div></div><div class='col-lg-7 col-md-6 col-sm-6' style='text-align: center;'><div class='row goods'>";
					
					var goods = data.rows[i].gbg;
					for ( var j = 0; j < goods.length; j++) {
						var goodsHtml = createGoods(goods[j]);
						html += goodsHtml;
					}
					html += "</div></div></div><hr/>";
					rowHtml += html;
				}
				$(".aa").html( rowHtml );
			}
		},
		error:function(data){
			console.log("网络错误");
		}
	});
}

/**
 * 获取当前的龙珠的html
 */
function createBall(obj){
	this.ballObject = new ballObj();
	ballObject.id = obj.id;
	ballObject.name = obj.name;
	ballObject.number = obj.number;
	ballObject.url = obj.url;
	var html = ballObject.createHTML();
	return html;
}

/**
 * 获取商品的html
 * @param obj
 * 		后台数据json 对象
 * @returns
 * 		返回生成的htMl代码
 */
function createGoods( obj ){
	
	this.goodsObject = new goodsObj();
	goodsObject.id = obj.id;
	goodsObject.name = obj.name;
	goodsObject.url = obj.url;
	
	var html = goodsObject.createHTML();
	return html;
}