<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>手机</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/front/css/detail_style.css" />
		<style>
			
			.surper_big ul {
				/*演示过程使用*/
				/*border : 1px solid red;*/
				width : 780px;
				/*上下20 左右居中*/
				margin : 20px auto;
				/*去掉前面的符号（点）*/
				list-style-type: none;
			}
			.surper_big li {
				/*灰色颜色值三个数相同*/
				padding: 10px;
				margin: 10px;
				float: left;
				/*将li的背景色设置为白色*/
				background-color: #FFF;
			}
			.surper_big img {
				width :218px;
			}
			.surper_big p{
				text-align: center;
				width: 218px;
			}
			
		</style>
	</head>

	<body>
		<!--top-->
		<div class="top_big">
			<div class="top_center">
				<div class="left">
					欢迎来到靓淘网！
				</div>
				<div class="right">
					<ul>
						<li>
							<a class="login" href="login.html" target="_blank">请登录</a>
						</li>
						<li>
							<a href="register.html" target="_blank">快速注册</a>
						</li>
						<li>
							<a class="collect" href="">我的收藏</a>
						</li>
						<li>
							<a class="indent" href="">我的订单</a>
						</li>
						<li>
							<a class="phone" href="">手机靓淘</a>
						</li>
						<li>
							<a href="">我的积分</a>
						</li>
						<li>
							<a href="">我的评价</a>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!---------------logo-------------------->
		<div class="logo_center">
			<div class="left">
				<img src="img/LOGO.png" />
			</div>
			<div class="center">
				<input class="logo_search" type="text" />
				<input class="logo_btn" type="button" value="搜索" />
				<ul class="logo_ad">
					<li>
						<a href="">值得买 |</a>
					</li>
					<li>
						<a href="">小米6 |</a>
					</li>
					<li>
						<a href="">金立 |</a>
					</li>
					<li>
						<a href="">华为畅享 7P |</a>
					</li>
					<li>
						<a href="">苹果7 |</a>
					</li>
					<li>
						<a href="">1元800M |</a>
					</li>
				</ul>
			</div>
			<div class="right">
				<a style="color: #666666;" href="">去购物车结算</a>
				<div class="logo_nav">

				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="menu">
			<div class="menu_center">
				<ul class="menu_ul">
					<li>
						<a class="all_a" href="">全部商品分类</a>
					</li>
					<li>
						<a href="index.html" target="_blank">商城首页</a>
					</li>
					<li>
						<a href="">手机首页</a>
					</li>
					<li>
						<a href="">新机首发</a>
					</li>
					<li>
						<a href="">手机社区</a>
					</li>
					<li>
						<a href="">企业采购</a>
					</li>
					<li>
						<a href="">精选店铺</a>
					</li>
				</ul>
				<div class="clearfix"></div>
			</div>

		</div>
		<!------------------------------------------------------------------>
		
		<div class="surper_big">
			
			<ul>
				<c:forEach items="${list}" var="product">
					<li>
						<a href="${ctx}/product/detail.shtml?id=${product.id}"><img src="${product.fullUrl}" /></a>
						<a href="${ctx}/product/detail.shtml?id=${product.id}"><p>${product.name}开发</p></a>
					</li>
				</c:forEach>
			</ul>
			<div class="clearfix"></div>
		</div>
		
		<div class="sp">
			<div class="sp1">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp2">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp3">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="sp4">
				<p style="color: rgb(51,51,51);">品质保障</p>
				<p style="font-size: 12px; color: #808080;margin-top: 5px;">品质护航 购物无忧</p>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="more">
			<div class="mb1">
				<ul>
					<li>
						购物指南
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;免费注册
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;开通支付宝
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;支付宝充值
						</a>
					</li>
				</ul>
			</div>
			<div class="mb2">
				<ul>
					<li>
						品质保障
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;发票保障
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;售后规则
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;缺货赔付
						</a>
					</li>
				</ul>
			</div>
			<div class="mb3">
				<ul>
					<li>
						支付方式
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;快捷支付
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;信用卡
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;货到付款
						</a>
					</li>
				</ul>
			</div>
			<div class="mb4">
				<ul>
					<li>
						商家服务
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;商家入驻
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;商家中心
						</a>
					</li>
					<li>
						<a href="">
							&nbsp;&nbsp;运营服务
						</a>
					</li>
				</ul>
			</div>
			<div class="mb5">
				<ul>
					<li>
						手机靓淘
					</li>
					<li>
						<img src="img/98.png" />
					</li>
				</ul>
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