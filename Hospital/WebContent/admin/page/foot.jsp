<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
String basePathfoot = request.getScheme() + 
				"://" + request.getServerName() + 
				":" + request.getServerPort() + request.getContextPath() + "/";
%>
		<footer>
			<p class="pull-left">&copy; <a href="http://usman.it" target="_blank">XXXX医院</a> 2017</p>
			<p class="pull-right">技术支持: <a href="http://usman.it/free-responsive-admin-template">XXXX公司</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

	<script>
		$(function(){
			//关闭
			$(".closeModal").click(function(){
				$(this).parent().parent().removeClass("in");
				$(this).parent().parent().css("display","none");
			});

			//表头
			$(".headertitle").click(function(){
				$(this).parent().find(".box-content").toggle(500);
				$(this).parent().find(".box-content").css({"overflow":"inherit"});
			});
		});
	</script>
	<!-- 菜单的加载 -->
	<script src="<%=basePathfoot %>admin/adminJS/menu.js"></script>
	
	<script src="<%=basePathfoot %>admin/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="<%=basePathfoot %>admin/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="<%=basePathfoot %>admin/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='<%=basePathfoot %>admin/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=basePathfoot %>admin/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="<%=basePathfoot %>admin/js/excanvas.js"></script>
	<script src="<%=basePathfoot %>admin/js/jquery.flot.min.js"></script>
	<script src="<%=basePathfoot %>admin/js/jquery.flot.pie.min.js"></script>
	<script src="<%=basePathfoot %>admin/js/jquery.flot.stack.js"></script>
	<script src="<%=basePathfoot %>admin/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="<%=basePathfoot %>admin/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="<%=basePathfoot %>admin/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="<%=basePathfoot %>admin/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="<%=basePathfoot %>admin/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="<%=basePathfoot %>admin/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="<%=basePathfoot %>admin/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=basePathfoot %>admin/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=basePathfoot %>admin/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=basePathfoot %>admin/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=basePathfoot %>admin/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=basePathfoot %>admin/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=basePathfoot %>admin/js/charisma.js"></script>
</body>
</html>
