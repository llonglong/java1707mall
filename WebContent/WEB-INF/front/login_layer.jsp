<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>靓淘网-登录</title>
		<link rel="stylesheet" href="${ctx}/resources/front/css/login_style.css" />
		<script type="text/javascript">
		function submitForm() {
			var options = {
					url:"${ctx}/login/loginIndex.shtml",
					type:"post",
					dataType:"json",
					data:$("#login_form").serialize(),
					success:function(data){
						if(data.status == 0) {
							layer.msg(data.message);
							var index = parent.layer.getFrameIndex(window.name); 
							setTimeout(function(){
								//parent.layer.close(index);
								window.parent.location.reload();	
							},1000);
						} else {
							layer.msg(data.message);
						} 
					}
			};
			$.ajax(options);
		}
		</script>
	</head>
	<body>
		<div class="login">
			<form id="login_form">
				<ul>
					<li class="login_title_1">
						<a href="">密码登录</a>
					</li>
					<li class="login_title_2">
						<a href="">扫码登录</a>
					</li>
					<li>
						<input class="login_user" type="text" name="username" placeholder="会员名/邮箱/手机号" />
						<input class="login_password" type="password" name="password" placeholder="密码" />
						<input class="login_btn" type="button" onclick="submitForm()" value="登录" />
					</li>
				</ul>
			</form>
		</div>
	</body>
</html>
