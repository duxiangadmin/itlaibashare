<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>it站长资源下载</title>
<%@include file="/common/common.jspf" %>
</head>
	
<body>
<%@include file="/common/topdh.jspf" %>
<!---->
<div class="projects" id="projects">
	<div class="container">
	<span class="about-top-w3"><a  name="publicresource">资源下载 </a></span>
		<h4 class="title-w3ls">个人资源</h4>
		<div class="news-bottom">
				<div class="news-one-wthree-agile">					
					<div class="col-md-12 news-left"> 
					<a href="#one"><h4>struts2完整jar包下载</h4></a>
						<p class="para-w3-agile">Struts2是一个基于MVC设计模式的Web应用框架，它本质上相当于一个servlet，在MVC设计模式中，Struts2作为控制器(Controller)来建立模型与视图的数据交互。Struts 2是Struts的下一代产品，是在 struts 1和WebWork的技术基础上进行了合并的全新的Struts 2框架。其全新的Struts 2的体系结构与Struts 1的体系结构差别巨大。Struts 2以WebWork为核心，采用拦截器的机制来处理用户的请求，这样的设计也使得业务逻辑控制器能够与ServletAPI完全脱离开，所以Struts 2可以理解为WebWork的更新产品。虽然从Struts 1到Struts 2有着太大的变化，但是相对于WebWork，Struts 2的变化很小。</p>	
						<a href="javascript('暂未提供')" style="float: right;color: green">资源下载</a>
					</div>
				</div>						
			</div>	
	</div>
</div>



<!-- //projects -->
<!-- contact -->
<div class="contact" id="contact">
	<div class="container">
	<span class="about-top-w3"><a name="problem">如有疑问可提交</a></span>
		<h4 class="title-w3ls"></h4>
		<div class="col-md-5 contact-agileits-w3layouts">
			<form action="javascript:alert('未完成')" method="post">
				<input type="text" name="Your Name" placeholder="提问人" required="" />
				<!-- <input type="email" name="Your Email" placeholder="邮箱" required="" /> -->
				<input type="text" Name="Phone Number" maxlength="20" placeholder="问题标题" required=""/>
				<textarea name="Message" placeholder="问题描述" required=""></textarea>
				<input type="submit" value="提交站长">
			</form>
			<h5 class="sub">有偿域名备案</h5>
			<p><span>微信</span> : aaaaa3202</p>
			<p><span>QQ</span> : 937220832</p>
			<p><span>邮箱</span><a href="mailto:example@mail.com"> :937220832@qq.com</a></p>
		</div>
		<div class="col-md-2"></div>

		<div class="col-md-5 contact-agileits-w3layouts">		
			<h5 class="sub" style="color: #045858">如果本站对您有帮助，请资助本站</h5>
			<p style="float: left;width: 220px;text-align: center;"><span style="font-size: 1.5em">支付宝</span> : </p>
			<p style="text-align: center;"><span  style="font-size: 1.5em">微信</span> :</p><!-- 
			<p><span>Email</span><a href="mailto:example@mail.com"> :</a></p> -->
			<img src="http://www.itlaiba.com/myblog/blankgd/images/wx.jpg" class="img-thumbnail" width="200px" alt="Responsive image" style="float: left;">
			<div style="width: 20px; float: left;"></div>
			<img src="http://www.itlaiba.com/myblog/blankgd/images/wx.jpg" class="img-thumbnail" width="200px" alt="Responsive image">
		</div>
	</div>
</div>
</div>
<!-- //about -->

	<div class="footer">
		<div class="container">
			<p>© 2018 网站所有权归本人所有，如转载请注明出处|  <a href="#">itlaiba.com</a></p>
		</div>
	</div>
<!-- //footer -->
<script src="js/bars.js"></script>

<!-- 处理技能进度条的 -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>
