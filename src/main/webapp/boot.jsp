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
</head>

<body>
<!-- container 两边留白
	container-fluid两边不留白
-->
	<!-- 容器 -->
	<div class="container-fluid">
		<!-- 行 -->
		<div class="row">
		<!-- 列 -->
		<div class="col-md-4"  style="background-color: red">我占4格</div>
		<div class="col-md-8"  style="background-color: green">我占8格</div>
		</div>
		
		<!-- 行 -->
		<div class="row">
		<!-- 列 -->
		<div class="col-md-2"  style="background-color: blue">我占2格</div>
		<div class="col-md-4"  style="background-color: yellow">我占4格</div>
		<div class="col-md-6"  style="background-color: pink">我占5格</div>
		</div>
		
		
	</div>

</body>

</html>