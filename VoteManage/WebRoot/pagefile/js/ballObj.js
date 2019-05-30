var ballObj = function(){
	this.id;
	this.name;
	this.number;
	this.url;
};

/**
 * 获取龙珠的html代码
 * @returns {String}
 * 		返回的是当前的html代码，可以直接嵌入页面
 */
ballObj.prototype.createHTML = function() {
	
	var html = '<div class="col-lg-3 col-xs-4 ball">';
	html += '<p>' + this.name + '</p>';
	html += '<p>' + this.number + '个</p>';
	html += '<p><img height="50px" width="50px" alt="' + this.name + '" src=" ' + this.url + '"></p>';
	html += '</div>';
	return html;
	
};