<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理员中心</title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/popper.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container-fluid">

		<div class="row bg-dark">
			<div class="col-md-12" style="height: 50px">
			<a href="/">
				<img class="rounded-circle" alt=""
					src="/resource/images/logo-admin.jpg"> </a><font color="white">管理员中心</font>
			
			<div class="float-right">
					<!-- 如果用户登录则显示登录信息 -->
					<c:if test="${sessionScope.user.username!=null }">
					<!-- Default dropleft button -->
					<div class="btn-group dropleft">
						<button type="button" class="btn btn-dark dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							${sessionScope.user.username}</button>
						<div class="dropdown-menu">
							<a href="/" class="dropdown-item" >回到首页</a>
							<a href="" class="dropdown-item">头条产品</a>
							<a href="/passport/logout" class="dropdown-item">注销</a>
						</div>
					</div>
					</c:if>
					
				</div>
			
			</div>
			
		</div>

		<div class="row mt-1">
			<div class="col-md-2">
				<div class="list-group">
					<a href="#" data="/admin/articles" class="list-group-item list-group-item-action active">
						审核文章 </a> <a href="#" data="/admin/users" class="list-group-item list-group-item-action">管理用户</a>
					<a href="#" data="/admin/settings" class="list-group-item list-group-item-action">我的设置</a>

				</div>
			</div>
			<div class="col-md-10" id="center"></div>

		</div>

	</div>

</body>
<script type="text/javascript">
//文档就绪函数
$(function(){
	 //0 默认加载所有文章
	$("#center").load("/admin/articles"); 
	//1为左侧菜单添加点击事件
	$("a").click(function(){
		//2获取a标签data属性
		var url = $(this).attr("data");
		
		//删除a标签的active
		$("a").removeClass("active");
		//为当前点击菜单添加样式
		$(this).addClass("active");
		//在中间区域加载url
		$("#center").load(url);
		}	
	)
	
	
})
</script>
</html>