<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>完整demo</title>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/pagefile/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/pagefile/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath}/pagefile/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/pagefile/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/pagefile/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/pagefile/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/article/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/article/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/article/lang/zh-cn/zh-cn.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="top.jsp" />
		<jsp:include page="menu.jsp" />
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1>文章发布</h1>
					编号:<input type="text" class="id form-control" readonly="readonly"
						style="width: 10%;display: inline; margin:20px" /> 标题:<input
						type="text" class="title form-control" placeholder="请输入标题..."
						style="width: 10%;display: inline; margin:20px" />
					<script id="editor" type="text/plain"
						style="width:1024px;height:500px;"></script>
				</div>
				<div id="btns">
					<div>
						<button onclick="getContent()" class="btn btn-warning"
							style="margin:20px";>修改</button>
					</div>

				</div>
			</div>
		</div>
		<jsp:include page="foot.jsp" />
		<!-- 删除提醒 -->
		<div class="panel-body ">
			<button class="btn btn-primary deltx" data-toggle="modal"
				data-target="#deltx" style="display:none"></button>
			<div class="modal fade" id="deltx">
				<div class="modal-dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title" id="myModalLabel">修改文章</h4>
							</div>
							<div class="modal-body context">
								<div class="row">
									<div class="col-lg-8 col-md-10">
										<div class="form-group">
											<p class="success">修改成功</p>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
		setTimeout(function() {
			UE.getEditor('editor').setContent("${article.content}");
			$(".title").val("${article.title}");
			$(".id").val("${article.id}");
		}, 1000);//延时3秒 
		function isFocus(e) {
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e);
		}
		function setblur(e) {
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e);
		}
		function insertHtml() {
			var value = prompt('插入html代码', '');
			UE.getEditor('editor').execCommand('insertHtml', value);
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml());
		}

		function getContent() {
			var arr = [];
			arr.push(UE.getEditor('editor').getContent());
			var html = arr.join("\n");
			var c = hasContent();
			if (c == "false") {
				$(".success").html("请输入内容");
				$(".deltx").click();
				return;
			}
			var title = $(".title").val();
			if (title == "" || title == null) {
				$(".success").html("请输入标题");
				$(".deltx").click();
				return;
			}
			var id = $(".id").val();
			$.ajax({
				type : "post",
				url : "updateArticle.action",
				dataType : "json",
				data : {
					"article.title" : title,
					"article.content" : html,
					"article.id" : id
				},
				success : function(m) {
					$(".success").html("修改成功");
					$(".deltx").click();
				}
			});
		}
		function getPlainTxt() {
			var arr = [];

			arr.push(UE.getEditor('editor').getPlainTxt());
			return arr.join('\n');
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
			alert(arr.join("\n"));
		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}

		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}

		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt);
		}

		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push(UE.getEditor('editor').hasContents());
			return arr.join("\n");
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for ( var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for ( var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}

		function getLocalData() {
			console.log(UE.getEditor('editor').execCommand("getlocaldata"));

			//alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
		}

		function clearLocalData() {
			UE.getEditor('editor').execCommand("clearlocaldata");
			alert("已清空草稿箱");
		}
	</script>
</body>
</html>