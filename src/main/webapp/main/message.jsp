<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>it留言</title>
<%@include file="/common/common.jspf"%>
<style type="text/css">
</style>
<%-- 
<c:if test="${empty messags }">
	<script type="text/javascript">
		window.location="${proPath}/message/selectpage"
	</script>
</c:if> --%>
</head>

<body>
	<!-- about -->
	<%@include file="/common/topdh.jspf"%>

	<div class="projects" id="projects">
		<div class="container">
			<span class="about-top-w3"><a name="problem">留言</a></span>
			<h4 class="title-w3ls">留言列表</h4>
			<div class="news-bottom">
				<div class="news-one-wthree-agile" style="float: left;">
					<!--PC和WAP自适应版-->
					<div id="SOHUCS"></div>
					<script type="text/javascript">
						(function() {
							var appid = 'cytFhuOVE';
							var conf = 'prod_8c68dc02f1b563a325adf3bae5f215c3';
							var width = window.innerWidth || document.documentElement.clientWidth;
							if (width < 960) {
								window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>');
							} else {
								var loadJs = function(d, a) {
									var c = document.getElementsByTagName("head")[0] || document.head || document.documentElement;
									var b = document.createElement("script");
									b.setAttribute("type", "text/javascript");b.setAttribute("charset", "UTF-8");b.setAttribute("src", d);
									if (typeof a === "function") {
										if (window.attachEvent) {
											b.onreadystatechange = function() {
												var e = b.readyState;
												if (e === "loaded" || e === "complete") {
													b.onreadystatechange = null;a()
												}
											}
										} else {
											b.onload = a
										}
									}
									c.appendChild(b)
								};
								loadJs("https://changyan.sohu.com/upload/changyan.js", function() {
									window.changyan.api.config({
										appid : appid,
										conf : conf
									})
								});
							}
						})();
					</script>
					
				</div>
			</div>
		</div>
	</div>
	

	<!-- contact -->
	<%@include file="/common/buttom.jspf"%>
	<!-- //footer -->
	<script src="${proPath }/main/js/bars.js"></script>

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
	
			$().UItoTop({
				easingType : 'easeOutQuart'
			});
	
		});
	</script>
	<!-- //here ends scrolling icon -->
</body>
</html>