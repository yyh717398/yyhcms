<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<a href="javascript:goPage(1)">首页</a> <a
		href="javascript:goPage(${pageInfo.number+1-1>1?pageInfo.number+1-1:1})">上一页</a>
		<a
		href="javascript:goPage(${pageInfo.number+1+1>pageInfo.totalPages?pageInfo.totalPages:pageInfo.number+1+1})">下一页</a>
		<a href="javascript:goPage(${pageInfo.totalPages})">尾页</a>
