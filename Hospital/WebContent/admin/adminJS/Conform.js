//JavaScript Document
$(document).ready(function(e) {
		popTipShow.confirm('系统提示','是否继续登录，取消将退出。',['确 定','取 消'],
			function(e){
			  //callback 处理按钮事件
			  var button = $(e.target).attr('class');
			  if(button == 'ok'){
				//按下确定按钮执行的操作 
				//todo ....				
				this.hide();
				setTimeout(function() {
					webToast("操作成功","top", 2000);
				},300,window.location="../servet/user?ac=Writeoff")
			  }

			  if(button == 'cancel') {
				//按下取消按钮执行的操作
				//todo ....
				this.hide();
				setTimeout(function() {
					webToast("您选择“取消”了","bottom", 2000);
				}, 300,function(){
					window.close();
					});
			  }
			}
		);    
});