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
    	<form action="${ctx}/product/update.action?id=${product.id}" enctype="multipart/form-data" method="post" class="form_border"
		 id="form-add">
			<div class="form-group">
				<label> 分类id</label> 
				<input type="text" name="categoryId" class="form-control" value="${product.categoryId}"/><br />
			</div>
			<div class="form-group">
				<label> 商品名称</label> 
				<input type="text" name="name" class="form-control" value="${product.name}"/><br />
			</div>
			<div class="form-group">
				<label>商品副标题</label> 
				<input type="text" name="subtitle" class="form-control" value="${product.subtitle}"/><br />
			</div>
			<div class="form-group">
				<label>价格</label> 
				<input type="text" name="price" class="form-control" value="${product.price}"/><br />
			</div>
			<div class="form-group">
				<label>商品主图</label> 
				<img alt="" src="/pic/${product.mainImage}" width="80" height="50"><br />
			</div>
			<div class="form-group">
				<label>库存数量</label> 
				<input type="text" name="stock" class="form-control" value="${product.stock}"/><br />
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