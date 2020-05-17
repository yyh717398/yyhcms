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
<meta name="description" content="${article.summary}" />
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
				<p>
					作者:${article.user.username }发布时间:${article.createdString }
					<%-- <fmt:formatDate value=""
						pattern="yyyy-MM-dd HH-mm-ss"></fmt:formatDate> --%>
					<c:if test="${article.wx!=''}">
						来源:${article.wx }
					</c:if>
				</p>
				<p>${article.content }</p>

				<!-- 发布评论  如果登录用户 则有发布框-->
				<c:if test="${sessionScope.user!=null }">

					<div>
						<hr>
						评论:<br>
						<textarea rows="6" cols="110" name="content"></textarea>
						<button class="btn btn-info" type="button"
							onclick="addComment(${article.id})">评论</button>
					</div>
				</c:if>
				<!-- 显示评论 -->
				<div>
					<hr>
					<h5>共${article.comments }条评论</h5>
					<c:forEach items="${info.list }" var="comment">
						<h5>${comment.user.username }</h5>
						<fmt:formatDate value="${comment.created }"
							pattern="yyyy-MM-dd HH-mm-ss" />
						<p>${comment.content }</p>
						<hr>
					</c:forEach>
					<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card" style="width: 18rem;">
					<div class="card-header">
						<h5 align="center">
							评论排行榜
							</h3>
					</div>
					<div class="card-body">
						<ul class="list-unstyled">
							<c:forEach items="${info2.list }" var="article" varStatus="count">
								<li class="media">
									<div class="media-body">
										<p class="ex">
										
											<a target="_blank"
												href="/articleDetail?id=${article.id }">
												${count.count }.
												${article.title }</a>
										</p>

									</div></li>
								<hr>
							</c:forEach>
						</ul>

					</div>

				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function addComment(articleId){
		var content = $("[name='content']").val();
		$.post("/addComments",{articleId:articleId,content:content},function(flag){
			if(flag){
				alert("评论成功");
				location.reload();//刷新当前页面
			}else{
				
			}
		})
	}
	function goPage(pageNum){
		var articleId = '${article.id}';
		location.href = "/articleDetail?pageNum="+pageNum+"&id="+articleId;
	}
</script>
</html>