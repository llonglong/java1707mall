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
<link href="${ctx}/resources/thirdlib/kindeditor/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/thirdlib/kindeditor/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/resources/thirdlib/kindeditor/lang/zh_CN.js"></script>
</head>
<script type="text/javascript">
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
			url:"${pageContext.request.contextPath}/category/parenCategoryList.action",
			dataType:"json",
			success:function (data,textStatus,ajax) {
				/* alert(ajax.responseText); */
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
			url:"${pageContext.request.contextPath}/category/categoryList.action",
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

</script>
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
					<form action="${ctx}/product/add.action" enctype="multipart/form-data" method="post" class="form_border"
					id="form-add">

						<%-- <div class="form-group">
							<label>商品id</label> <input type="text" name="id"
								value="${student.name}" class="form-control" id="name"><span
								id="nameInfo"></span><br />
						</div> --%>
						<div class="input-group input-group-sm">
 						 	<span class="input-group-addon" id="sizing-addon3">分类</span>
 						 	<select id="ParentCategory" onchange="selectCategory(this)">
 						 		<option value="">-- 请选择 --</option>
 						 	</select>
 						 	<select id="Category" name="categoryId">
 						 	<option value="parentId">-- 请选择 --</option>
 						 	</select>
						</div>
						<div class="form-group">
							<label>商品名称</label> <input type="text" name="name"
								value="${student.gender }" class="form-control" id="name"><br />
						</div>
						 <div class="form-group">
							<label>商品副标题</label> <input type="text" name="subtitle"
								value="${student.address }" class="form-control" id="name"><br />
						</div> 
						<div class="form-group">
							<label>商品价格</label> <input type="text" name="price"
								value="${student.address }" class="form-control" id="name"><br />
						</div>
						<div class="form-group">
							<label>库存数量</label> <input type="text" name="stock"
								value="${student.address }" class="form-control" id="name"><br />
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
						<div class="form-group">
							<label>产品主图</label> 
							<img alt="" id="imgId" src="" width="100" height="100">
							<input type="hidden" id="mainImage" name="mainImage"/>
							<input type="file" name="pictureFile" onchange="uploadPic();"/>
						</div>
						<div class="form-group">
				  			<label>商品图片</label>
				  	 		<a href="javascript:void(0)" class="picFileUpload" id="picFileUpload">上传图片</a>
	                 		<input type="hidden" name="subImages" id="subImages"/>
	                 	  	<div id="J_imageView"></div>
	                 	</div>
						<div class="form-group">
				  			<label>商品描述</label>
				  	 		<textarea style="width:900px;height:300px;visibility:hidden;" name="detail"></textarea>
				  		</div>
						<input class="btn btn-success btn-lg" type="submit" value="添加" />
					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	var myKindEditor ;
	KindEditor.ready(function(K) {
		var kingEditorParams = {
			//指定上传文件参数名称
			filePostName  : "pictureFile",
			//指定上传文件请求的url。
			uploadJson : '${ctx}/upload/pic.action',
			//上传类型，分别为image、flash、media、file
			dir : "image"
	}
	var editor = K.editor(kingEditorParams);
	//多图片上传
	K('#picFileUpload').click(function() {
		editor.loadPlugin('multiimage', function() {
			editor.plugin.multiImageDialog({
				clickFn : function(urlList) {
					console.log(urlList);
					var div = K('#J_imageView');
					var imgArray = [];
					div.html('');
					K.each(urlList, function(i, data) {
						imgArray.push(data.url);
						div.append('<img src="' + data.url + '" width="80" height="50">');
					});
					$("#subImages").val(imgArray.join(","));
					editor.hideDialog();
				}
			});
		});
	});
	//富文本编辑器
	myKindEditor = KindEditor.create('#form-add[name=detail]', kingEditorParams);
});
</script>
