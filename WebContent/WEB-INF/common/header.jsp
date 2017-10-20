<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet"
	href="${ctx}/resources/thirdlib/bootstrap/css/bootstrap.css" />

<script type="text/javascript" src="${ctx}/resources/thirdlib/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx}/resources/thirdlib/layer/layer.js"></script>
<!-- 全局js -->
<script src="${ctx}/resources/back/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/resources/back/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctx}/resources/back/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/resources/back/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctx}/resources/back/js/plugins/layer/layer.min.js"></script>