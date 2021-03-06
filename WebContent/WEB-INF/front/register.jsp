<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
<title>注册</title>
<%@include file="../common/head.jsp" %>
<link rel="stylesheet" href="${ctx}/resources/front/css/register_style.css" />
</head>

<body>

	<head>
		<meta charset="UTF-8">
		<title>靓淘网-注册</title>
	</head>

	<body>
		<div class="top_center">
			<div class="left">
				<img src="${ctx}/resources/front/img/LOGO.png" />
			</div>
			<div class="right">
				<ul>
					<li class="top_seven">7天无理由退换货</li>
					<li class="top_real">100%正品保证</li>
					<li class="top_back">退货返运费</li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="banner">
			<img class="banner_img" src="${ctx}/resources/front/img/110.png" />
			<div class="banner_center">
				<form>
					<div class="register">
						<ul>
							<li class="register_title_1">
								<span style="font-size: 20px;color: #F41443;font-weight: 900;">
									用户注册
								</span>
								<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已有账号<a style="color: #F41443;" class="here" href="${ctx}/login/toLogin.shtml">在此登录</a></span>
							</li>
							<li>
								<input class="register_user" type="text" placeholder="会员名/邮箱/手机号" />
							</li>
							<li>
								<input class="register_note" placeholder="短信校验码"/>
								<input class="register_note_get" type="button" value="获取短信验证码" />
							</li>
							<li>
								<input class="register_password" type="password" placeholder="密码" />
							</li>
							<li>
								<input class="register_repassword" type="text" placeholder="重置密码" />
							</li>
							<li>
								<input class="register_finish" type="button" value="同意协议并注册" />
							</li>
							<li class="register_bottom">
								<a href=""><span style="color: #F41443;">《靓淘优选用户协议》</span></a>
							</li>
						</ul>

					</div>
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="link">
			<ul>
				<li>
					<a href="">
						关于靓淘
					</a>
				</li>
				<li>
					<a href="">
						帮助中心
					</a>
				</li>
				<li>
					<a href="">
						开放平台
					</a>
				</li>
				<li>
					<a href="">
						诚聘精英
					</a>
				</li>
				<li>
					<a href="">
						联系我们
					</a>
				</li>
				<li>
					<a href="">
						网站合作
					</a>
				</li>
				<li>
					<a href="">
						法律声明及隐私政策
					</a>
				</li>
				<li>
					<a href="">
						知识产权
					</a>
				</li>
				<li>
					<a href="">
						廉政举报
					</a>
				</li>
				<li>
					<a href="">
						规则意见征集
					</a>
				</li>
			</ul>
		</div>
		<div class="copyright">
			COPYRIGHT 2010-2017 北京创锐文化传媒有限公司 JUMEI.COM 保留一切权利. 客服热线：400-123-888888<br /> 京公网安备 110101020011226|京ICP证111033号|食品流通许可证 SP1101051110165515（1-1）|营业执照
		</div>
	</body>
</html>
