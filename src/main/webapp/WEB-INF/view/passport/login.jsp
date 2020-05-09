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
<link href="/resource/css/jquery/screen.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>

</head>

<body>

	<div class="container">
		<form id="login">
			<span id="msg" class="bg-danger">${msg }</span>
			<div class="form-group">
				<label for="username">用户名</label> <input type="text"
					class="form-control" name="username" id="username">
			</div>
			<div class="form-group">
				<label for="password">密码</label> <input type="password"
					class="form-control" name="password" id="password">
			</div>
			
			
			<div class="form-group">
				<button class="btn btn-info" type="submit">登录</button>
				<button class="btn btn-warning" type="reset">重置</button>
			</div>
		</form>
	</div>

</body>
<script type="text/javascript">
	//表单校验
	$(function(){
		$("#login").validate({
			//1表单校验规则
			rules:{
				username:{
					required:true,//用户名不能为空
					
				},
				password:{
					required:true,//密码不能为空
					
				},
				
			},
			// 不满足规则消息提示
			messages:{
				username:{
					required:"用户名不能为空",
				},
				password:{
					required:"密码不能为空",
				},
				
			},
			submitHandler:function(){
				
	            $.post("/passport/login",$("#login").serialize(),function(result){
	            	
	            	if(result.code==200){
	            		
	            		location.href="/";
	            	}else{
	            		//登录失败
	            		$("#msg").text(result.msg);
	            	}
	            })
	        },    
			
		})
	})
	
	
</script>
</html>