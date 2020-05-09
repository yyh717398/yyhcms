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
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<!-- head -->
		<div class="row" style="height: 34px">
			<div class="col-md-12 bg-dark">
				<button class="btn btn-link btn-sm">
					<font color="white">下载APP</font>
				</button>
				<button class="btn btn-link btn-sm">
					<font color="white">注册头条号</font>
				</button>
				<div class="float-right">
					<button class="btn btn-link btn-sm">
						<font color="white">侵权投诉</font>
					</button>
					<button class="btn btn-link btn-sm">
						<font color="white">头条产品</font>
					</button>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-7">
				<h1>${article.title }</h1>
				<p>作者:${article.user.username }发布时间:<fmt:formatDate
						value="${article.created }" pattern="yyyy-MM-dd HH-mm-ss"></fmt:formatDate>
				</p>
				<p>
					${article.content }
				</p>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

</body>

</html>