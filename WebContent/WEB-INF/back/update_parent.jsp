<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.situ.mall.pojo.*" %>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>  
    <form action="${pageContext.request.contextPath}/category/updateParent.action?id=${category.id}" method="post">
     父类名称：<input type="text" name="name" value="${category.name}"/></br>   
    商品状态：<select name="status" class="form-control">
			<option value="1">上架</option>
			<option value="2">下架</option>
		</select>
  <%--   更新时间：<input type="text" name="updateTime" value="${product.update_time }"/></br>   --%>
	<input type="submit" value="修改"/> 

    </form>
</body>
</html>