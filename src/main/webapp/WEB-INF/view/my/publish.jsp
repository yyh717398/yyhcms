<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>KindEditor JSP</title>
<link rel="stylesheet"
	href="/resource/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="/resource/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="/resource/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8"
	src="/resource/kindeditor/plugins/code/prettify.js"></script>
<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>

	<form id="form1">
		<!-- 文章标题 -->
		<div class="form-group">
			<label for="title">标题图片:</label> <input id="title" type="text"
				name="title" class="form-control">
		</div>
		<!-- 文章标题图片 -->
		<div class="form-group">
			<label for="picture">文章标题:</label>
			 <input id="picture" type="file"
				name="file" class="form-control-file">
		</div>

		<!-- 栏目与分类 -->
		<div class="form-group form-inline">
			<label for="channel">栏目</label> <select
				class="form-control" id="channel" name="channelId">				
			</select>
			<label for="category">分类</label> <select
				class="form-control" id="category" name="categoryId">				
			</select>
		</div>
		<textarea name="content1" cols="100" rows="8"
			style="width: 1250px; height: 200px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br /> <input type="button" name="button" class="btn btn-info" value="提交内容" onclick="publish()"/>
	</form>
</body>
<script type="text/javascript">
	
	$(function(){
		//遍历所有栏目 动态追加option
		$.get("/my/channels",function(channels){
			for ( var i in channels) {
				$("#channel").append("<option value='"+channels[i].id+"'>"+channels[i].name+"</option>")
			}
			$("#channel").change();
		});
		//为channel添加内容改变事件
		$("#channel").change(function(){
			var channelId = $(this).val();
			
			$.get("/my/selectCategoryByChannelId",{channelId:channelId},function(category){
				$("#category").empty();//清空原有分类
				for ( var i in category) {
					$("#category").append("<option value='"+category[i].id+"'>"+category[i].name+"</option>")
				}
			})
		})
		
	})
	//发布文章
		function publish(){
		var formData = new FormData($("#form1")[0]);
		 formData.set("content",editor1.html()); 
			
			/* formDate.set("content",editor1.html());  */
			
			$.ajax({
				url:"/my/publish",			
				type : 'POST',
				data:formData,							
				// 告诉jQuery不要去处理发送的数据
				processData : false,
				// 告诉jQuery不要去设置Content-Type请求头
				contentType : false,
				success:function(flag){
					if(flag){
						
						location.href="/my";
					}else{
						alert("发布失败");
					}
				}
				
			})
		}
</script>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>