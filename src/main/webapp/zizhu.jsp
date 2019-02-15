<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

<title>资助人--感谢各位大大们的资助，让本站能够维持运行</title>
<base target="_blank">
<style type="text/css">
	.list-group-item > .badge {
  float: right;
}
.list-group-item > .badge + .badge {
  margin-right: 5px;
}
</style>
<%@include file="/common/common.jspf" %>
</head>

	

<body>

	

<%@include file="/common/topdh.jspf" %>

<!-- 预留广告位 -->


<!-- 广告 -->
<%@include file="/common/guanggao.jspf" %>

<div class="projects" id="projects">

	<div class="container">

<h1>资助人列表--感谢各位资助人<br><small>请各位资助人在转账的时候备注下资助人姓名（没有备注，会显示转账时显示的昵称）</small></h1>
    <ul class="list-group">
    	<li class="list-group-item">
            <span class="badge">资助金额(元)</span>
            	资助人
        </li>
         <li class="list-group-item">
            <span class="badge">5</span>
            *豆
        </li>
        <li class="list-group-item">
            <span class="badge">19.98</span>
            *嚟
        </li>
        <li class="list-group-item">
            <span class="badge">20</span>
            邹志强 
        </li>
        <li class="list-group-item">
            <span class="badge">10</span>
            李思青
        </li>
        <li class="list-group-item">
            <span class="badge">5</span>
            香菜皮蛋豆腐我最爱
        </li>
        <li class="list-group-item">
            <span class="badge">5</span>
            王莉
        </li>
        <li class="list-group-item">
            <span class="badge">100</span>
            李青
        </li>
        <li class="list-group-item">
            <span class="badge">15</span>
            吴迪
        </li>
    </ul>

</div>
</div>

<%@include file="/common/buttom.jspf" %>
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

								

			$().UItoTop({ easingType: 'easeOutQuart' });

								

			});

	</script>

<!-- //here ends scrolling icon -->

</body>

</html>