/**
 * 当前类是商品的信息
 * @returns
 */
var goodsObj = function(){
	this.id;
	this.name; 
	this.url;
};

/**
 * 获取商品的html代码
 * @returns {String}
 * 		返回的是当前的html代码，可以直接嵌入页面
 */
goodsObj.prototype.createHTML = function() {
	
	var html = '<div class="col-lg-4 col-md-4 col-sm-4" style="overflow:hidden;">';
	html += '<p style="text-align: center;">' + this.name + '</p>';
	html += '<img height="180px" width="150px" alt="' + this.name + '" src="' + this.url + '">';
	html += "</div>";
	return html;
};