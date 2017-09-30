<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%@include file="../common/header.jsp"%>
<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery/jquery.form.js"></script>
</head>
<!-- <script type="text/javascript">
	function uploadPic(){
	//定义参数
	var options = {
			url : "${pageContext.request.contextPath}/upload/uploadPic.action",
			dataType : "json",
			type : "post",
			success : function(data) {
				$("#imgId").attr("src", "/pic/" + data.fileName);
				$("#mainImage").val(data.fileName);
			}
	};
	 $("#form-add").ajaxSubmit(options);
 }
	$(function () {
		$.ajax({
			url:"${pageContext.request.contextPath}/category/findParentCategory.action",
			dataType:"json",
			success:function (data,textStatus,ajax) {
				var html = "<option>-- 请选择 --</option>"
				for (var i = 0; i < data.length; i++) {
					html += "<option value='"+data[i].id+"'>" + data[i].name + "</option>";
				}
				$("#ParentCategory").html(html);
			}
		});
	});
	function selectCategory (Obj) {
		var parentId = $(Obj).val();
		$("#Category option:gt(0)").remove();
		$.ajax({
			url:"${pageContext.request.contextPath}/category/findPCategory.action",
			dataTypr:"json",
			data:"parentId="+parentId,
			success:function (data,textStatus,ajax) {
				/*  alert(ajax.responseText); */
				 
				var html = "<option>-- 请选择 --</option>";
				for (var i =0; i < data.length; i++) {
					/* alert(i); */
					html += "<option value='"+data[i].id+"'>" + data[i].name + "</option>";
				}
				$("#Category").html(html);
			}
		});
	}

</script> -->
<body>

	<!-- 顶部导航条 -->
	<nav class="navbar navbar-default">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">商品后台管理系统</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;商品管理 </a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-tag"></span>&nbsp;&nbsp;教务管理</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/ShiXun09/login?method=logout"><span
						class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- 导航条结束 -->

	<div class="container">

		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="list-group">
						<a href="${ctx}/student/findPageBeanList.action"
							class="list-group-item">商品列表</a> <a
							href="${ctx}/product/getTurn.action" class="list-group-item active">添加商品</a>
					</div>
				</div>
				<div class="col-md-10">
					<ul class="nav nav-tabs">
						<li><a
							href="${ctx}/students/findPageBeanList.action">商品列表</a></li>
						<li class="active"><a href="${ctx}/product/getTurn.action">添加商品</a></li>

					</ul>
					<form action="${ctx}/category/addCategory.action"  method="post" class="form_border"
					id="form-add">
				
						<div class="form-group">
							<label>选择父类</label> 
							<select id="" name="parentId" class="form-control">
								<c:forEach items="${list}" var="parentCategory">
									<option value="${parentCategory.id}">${parentCategory.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>子类名称</label>
							<input type="text" name="name" value="" class="form-control" id="name"><br />
						</div>
						<div  class="form-group">
				  			<label >商品状态</label>
				  			<select name="status" class="form-control">
				  				<option value="1">上架</option>
				  				<option value="2">下架</option>
				  				<!-- <option value="3">删除</option> -->
				  			</select>
				  		</div>
						<%-- <div class="form-group">
							<label>创建时间</label> <input type="text" name="createTime"
								value="${student.address }" class="form-control" id="name"><br />
						</div>
						<div class="form-group">
							<label>更新时间</label> <input type="text" name="updateTime"
								value="${student.address }" class="form-control" id="name"><br />
						</div> --%>
						<!-- <div class="form-group">
							<label>产品主图</label> 
							<img alt="" id="imgId" src="" width="100" height="100">
							<input type="hidden" id="mainImage" name="mainImage"/>
							<input type="file" name="pictureFile" onchange="uploadPic();"/>
						</div> -->
						<input class="btn btn-success btn-lg" type="submit" value="添加" />
					</form>
				</div>
				
			</div>
		</div>
	</div>

</body>
</html>