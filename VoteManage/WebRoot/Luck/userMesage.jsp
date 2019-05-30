<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userMesage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<Script src="<%=basePath%>/pagefile/js/jquery-1.8.3.min.js"></Script>
	<script>
		$.ajax({
				type:"post",
				url:"VoteManage/getMyMesage.action",
				dataType:"json",
				success:function(m){
					$("#d1 p").eq(0).html("<img src="+m.imgUrl+">");
					$("#d1 p").eq(1).html(m.id);
					$("#d1 p").eq(2).html(m.name);
					$("#d1 p").eq(3).html(m.birthday);
					$("#d1 p").eq(4).html(m.telephone);
					$("#d1 p").eq(5).html(m.loveNumber);
					$("#d1 p").eq(6).html(m.totalVotes);
					$("#d1 p").eq(7).html(m.boxNumber);
					$("#d1 p").eq(9).html(m.oneball);
					$("#d1 p").eq(10).html(m.twoball);
					$("#d1 p").eq(11).html(m.threeball);
					$("#d1 p").eq(12).html(m.fourball);
					$("#d1 p").eq(13).html(m.fiveball);
					$("#d1 p").eq(14).html(m.sixball);
					$("#d1 p").eq(15).html(m.sevenball);
					var h="";
					for(var i=0;i<m.labelList.length;i++)
					{
					h+=m.labelList[i].lableName+"\t";
					}
					$("#d1 p").eq(15).html(h);
				}
		});
		
		
		function updateMes(){
			var id="1500973534347";
			var born="";
			var tel="13838838438";
			$.ajax({
				type:"post",
				data:{"users.id":id,"users.birthday":born,"users.telephone":tel},
				url:"VoteManage/updateUser.action",
				dataType:"json",
				success:function(m){
					alert(m);
				}
			});
		}
		
	//	function updateUserImg()
	//	{
	//	$.ajax({
	//			type:"post",
	//			data:{"file":file},
	//			url:"VoteManage/updateUserImg.action",
	//			dataType:"json",
	//			success:function(m){
	//				alert(m);
	//			}
	//		});
	//	}
	</script>
  </head>
  
  <body>
   <div id="d1" style="width:200px; overflow:hidden; margin:0px auto">
   		头像<p></p>
   		<input type="file" name="file">修改头像<br/>
   		<input type="button" value="保存头像"><br/>
   		编号<p></p>	
   		姓名<p></p>
   		生日<p>无</p>
   		电话<p>无</p>
   		<input type="button" value="保存个人信息" onclick="updateMes()"/><br/>
                        爱心数  <p></p>
   		得票数<p></p>
   		宝箱数<p></p>
   		一星龙珠<p></p>
     	二星龙珠<p></p>
     	三星龙珠<p></p>
     	四星龙珠<p></p>
     	五星龙珠<p></p>
     	六星龙珠<p></p>
     	七星龙珠<p></p>
     	标签<p></p>
   </div>
  </body>
</html>
