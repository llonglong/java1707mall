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
<script type="text/javascript">
	/* function goPage(pageIndex) {
		$('#pageIndex').val(pageIndex);
		$('#searchForm').submit();
	}
	(function() {
		$("#gender option[value='${searchCondition.gender}']").prop("selected",
				true);
	}); */
	function selectAlls() {
		$("input[name=selectIds]").prop("checked",
				$("#selectAll").is(":checked"));
	}
	function deleteAll() {
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			$("#mainForm")
					.attr("action",
							"${pageContext.request.contextPath}/product/deleteAll.action");
			$("#mainForm").submit();
		}
	}
</script>
</head>
<body>

	<%@include file="../common/header.jsp" %>
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
	<!-- /.container-fluid --> 
	</nav>
	<!-- 导航条结束 -->
	
	<div class="container">

		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="list-group">
						<a
							href="${ctx}/category/findParentCategory.action"
							class="list-group-item active">商品列表</a> <a
							href="${ctx}/product/getTurn.action"
							class="list-group-item">添加商品</a>
					</div>
				</div>
				<div class="col-md-10">
					<ul class="nav nav-tabs">
						<li class="active"><a
							href="${ctx}/category/findParentCategory.action">分类列表</a>
						</li>
						<li><a
							href="${ctx}/product/getTurn.action">添加商品</a>
						</li>

					</ul>
					
				<form action="${pageContext.request.contextPath}/product/deleteAll.action" method="post" id="mainForm">
					<input type="submit" value="批量删除" onclick="deleteAll"/>
					<!-- <input type="submit" value="批量上架" onclick="updateAll"/> -->
					<table class="table container">
						<tr>
							<td><input type="checkbox" id="selectAll" onclick="selectAlls()"/></td>
							<td>id</td>
							<!-- <td>用户id</td>							
							<td>商品id</td> -->
							<td>商品名称</td>
							<td>商品主图</td>
							<td>商品单价</td>
							<td>商品数量</td>
							<td>商品总价</td>
						</tr>
						<c:forEach items="${orderItemList}" var="orderItem">
							<tr>
								<td><input type="checkbox" name="selectIds" value=""/></td>
								<td>${orderItem.id}</td>
								<%-- <td>${orderItem.userId}</td>
								<td>${orderItem.productId}</td> --%>
								<td>${orderItem.productName}</td>
								<%-- <td>${orderItem.productImage}</td> --%>
								<td><img alt="" src="${orderItem.productImage}" width="80" height="60"></td>
								<td>${orderItem.currentUnitPrice}</td>
								<td>${orderItem.quantity}</td>
								<td>${orderItem.totalPrice}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
				</div>
				<!-- 分页开始 -->
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<!-- 上一页开始 -->
					<c:if test="${pageBean.pageIndex==1}">
						<li class="disabled"><a href="javascript:void(0);"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.pageIndex!=1}">
						<li><a
							href="${ctx}/student/findPageBeanList.action?pageIndex=${pageBean.pageIndex-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="1" end="${pageBean.totalPage}" var="page">
						<c:if test="${pageBean.pageIndex!=page}">
							<li><a
								href="${ctx}/student/findPageBeanList.action?pageIndex=${page}">${page}</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex==page}">
							<li class="active">
							<li class="active"><a
								href="${ctx}/student/findPageBeanList.action?pageIndex=${page}">${page}</a></li>
							</li>
						</c:if>
					</c:forEach>
					<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
						<li><a
							href="${ctx}/student/findPageBeanList.action?pageIndex=${pageBean.pageIndex+1}"
							aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>