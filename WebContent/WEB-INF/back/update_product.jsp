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
    
    <form action="${pageContext.request.contextPath}/product/update.action?id=${product.id}" method="post">
    
 
      分类id：<input type="text" name="categoryId" value="${product.categoryId}"/></br>
     商品名称：<input type="text" name="name" value="${product.name }"/></br>
     商品副标题：<input type="text" name="subtitle" value="${product.subtitle }"/></br>
     价格：<input type="text" name="price" value="${product.price }"/></br>   
    库存数量：<input type="text" name="stock" value="${product.stock }"/></br>
    商品状态：<input type="text" name="status" value="${product.status }"/></br>
  <%--   更新时间：<input type="text" name="updateTime" value="${product.update_time }"/></br>   --%>
	<input type="submit" value="修改"/> 

    </form>
</body>
</html>