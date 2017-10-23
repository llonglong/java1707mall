<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@include file="../common/header.jsp"%>
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
	<div class="container">
		<form
			action="${pageContext.request.contextPath}/product/deleteAll.action"
			method="post" id="mainForm">
			<input type="submit" value="批量删除" onclick="deleteAll" />
			<!-- <input type="submit" value="批量上架" onclick="updateAll"/> -->
			<table class="table container">
				<tr>
					<td><input type="checkbox" id="selectAll"
						onclick="selectAlls()" /></td>
					<td>id</td>
					<td>商品名称</td>
					<td>商品状态</td>
					<td>删除</td>
					<td>修改</td>
				</tr>
				<c:forEach items="${list}" var="category">
					<tr>
						<td><input type="checkbox" name="selectIds"
							value="${product.id}" /></td>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.status}</td>
						<%-- <td>${product.createTime}</td> --%>
						<%-- <td><fmt:formatDate value="${category.updateTime}" pattern="yyyy-MM-dd"/></td>  --%>
						<td><a
							href="${ctx}/category/deleteCategoryById.action?id=${category.id}">删除</a></td>
						<td><a
							href="${ctx}/category/findCategoryById.action?id=${category.id}">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>


</body>
</html>