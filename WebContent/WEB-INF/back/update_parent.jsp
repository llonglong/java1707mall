<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.situ.mall.pojo.*" %>
<%@page import="java.util.*" %>
<%@include file="../common/header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>  
   	<div class="container">
   		<form action="${ctx}/category/updateParent.action?id=${category.id}" enctype="multipart/form-data" method="post" class="form_border"
		 id="form-add">
		 	<div class="form-group">
				<label> 父类名称</label> 
				<input type="text" name="name" class="form-control" value="${category.name}"/><br />
			</div>
			<div class="form-group">
				<label >商品状态</label>
				  	<select name="status" class="form-control">
				  		<option value="1">上架</option>
				  		<option value="2">下架</option>
				  	</select>
			</div>
			<input type="submit" value="修改"/> 
		 </form>
   	</div>
</body>
</html>