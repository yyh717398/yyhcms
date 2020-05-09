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
<title></title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/popper.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<!-- 头 -->
		<div class="row">
			<div class="col md-12" style="background-color: #563D7C">
				<a href="/"><img alt="" src="/resource/images/logo-my.png" height="50"
					width="50"></a> <font color="white">个人中心</font>
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
		<!-- 第二行 -->
		<div class="row mt-1">
			<!-- 左侧 -->
			<div class="col-md-2  bg-light" style="height: 550px">
				<div class="list-group">
					<a href="#" data="/my/articles" class="list-group-item list-group-item-action active">
						我的文章 </a> <a href="#" data="/my/publish" class="list-group-item list-group-item-action">发布文章</a>
					<a href="#" class="list-group-item list-group-item-action">我的收藏</a>
					<a href="#" class="list-group-item list-group-item-action">我的评论</a>
					<a href="#" class="list-group-item list-group-item-action disabled"
						tabindex="-1" aria-disabled="true">我的设置</a>
				</div>

			</div>
			
			<!-- 中间内容显示 -->
			<div class="col-md-10" id="center">
				<!-- 提前引入kindeditor -->
				<div style="display: none">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				</div>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	//文档就绪函数
	$(function(){
		//0 默认显示我的文章
		$("#center").load("/my/articles");
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