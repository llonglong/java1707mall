<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.situ.mall.pojo.*"%>
<%@page import="java.util.*"%>
<%@include file="../common/header.jsp" %>
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
	<div class="ibox-content">				
		<form action="${pageContext.request.contextPath}/product/deleteAll.action" method="post" id="mainForm">
			<input type="submit" value="批量删除" onclick="deleteAll"/>
				<!-- <input type="submit" value="批量上架" onclick="updateAll"/> -->
				<table class="table table-striped table-bordered table-hover dataTables-example">
					<tr class="gradeX">
						<td><input type="checkbox" id="selectAll" onclick="selectAlls()"/></td>
						<td>商品id</td>
						<td>分类id</td>
						<td>商品名称</td>
						<td>商品主图</td>
						<!-- <td>商品副标题</td> -->
						<td>价格</td>
						<td>库存数量</td>
						<td>商品状态</td>
						<!-- <td>创建时间</td> -->
						<td>更新时间</td>
						<td>删除</td>
						<td>修改</td>
						<td>上架</td>
					</tr>
				<c:forEach items="${list}" var="product">
						<tr class="gradeX">
							<td><input type="checkbox" name="selectIds" value="${product.id}"/></td>
							<td>${product.id}</td>
							<td>${product.categoryId}</td>
							<c:if test="${fn:length(product.name)>12}">  
								<td>${fn:substring(product.name,0,12)}...</td>
							</c:if>
							<c:if test="${fn:length(product.name)<=12}">  
								<td>${product.name}</td>
							</c:if>
							<td><img alt="" src="/pic/${product.mainImage}" width="80" height="50"></td>
							<%-- <td>${product.subtitle}</td> --%>
							<td>${product.price}</td>
							<td>${product.stock}</td>
							<td>${product.status}</td>
							<%-- <td>${product.createTime}</td> --%>
							<td><fmt:formatDate value="${product.updateTime}" pattern="yyyy-MM-dd"/></td>
							<td><a
								href="${ctx}/product/deleteById.action?id=${product.id}">删除</a></td>
							<td><a
								href="${ctx}/product/findById.action?id=${product.id}">修改</a></td>
							<td><a
								href="${ctx}/product/show.action?id=${product.id}">上架</a></td>
							</tr>
						</c:forEach>
					</table>
			</form>		
	</div>


</body>
</html>