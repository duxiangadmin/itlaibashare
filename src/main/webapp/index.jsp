<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html lang="en">

<head>

<title>it资源共享</title>

<%@include file="/common/common.jspf" %>
<script type="text/javascript">
$(function(){
		$.ajax({
			url:"${proPath}/resource/selectblob",
			type:"post",
			dataType:"JSON",
			success:function(data){
				var str = "";
				$.each(data,function(i){
					str+="<a><h4>"+data[i]['resourceName']+"</h4></a>";
					str+="<p class='para-w3-agile'>"+data[i]['resourceIntroduce']+"</p>";
					str+="<a href='"+data[i]['resourceUrl']+"' style='float: right;color: green'>资源下载</a><hr>";
					$("#blobresource").append(str);					
					str="";
				});
				$("#blobresource").trigger("create");
			}
		});
		
		$.ajax({
			url:"${proPath}/resource/selectmyresource",
			type:"post",
			dataType:"JSON",
			success:function(data){
				var str = "";
				$.each(data,function(i){
					str+="<div class='news-one-wthree-agile'  style='overflow: hidden;'><div class='col-md-6 news-left'><div class='biseller-column'><a class='lightbox'>";
					str+="<img  src='${proPath}/img/"+data[i]['myresourceImg'] +"'/></a>";					
					str+="<div class='lightbox-target' id='one'><img src='${proPath }/main/images/scm.png' />";
					str+="<p class='pop'>"+data[i]['myresourceContent']+"</p>"; 
					str+="<a class='lightbox-close' href='#'> </a><div class='clearfix'> </div></div></div></div><div class='col-md-6 news-right'> ";
					str+="<a href='#one'><h4>"+data[i]['myresourceTitle']+"</h4></a>";		   
					str+="<span class='para-w3-agile' style='font-size: 10px'>"+data[i]['myresourceContent']+"</span><br>";
					str+="<a href='"+data[i]['myresourceUrl']+"' style='float: left;color: green'>源码下载</a>";
					str+="<a href='"+data[i]['myresourceSayurl']+"' style='float: right;color: green' target='_blank'>项目预览</a></div><div class='clearfix'></div></div>";
					$("#myresource").append(str);					
					str="";
				});
				$("#myresource").trigger("create");
			}
		});
	});
	

</script>
</head>

	

<body>

	<%-- <DIV id="toubiao">
	<table width="86%" style="margin:0 auto;" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td width="4%" height="30" align="center"><img src="images/kids.gif" width="15" height="14"></td>
	    <td width="82%">本站长期出售各类教学视频，包含java、php、pythone、c等等，价格低廉，需要请联系QQ：937220832</td>
	  </tr>
	</table>
	</DIV>--%>
<!-- about -->

<%@include file="/common/topdh.jspf" %>

<!-- 预留广告位 -->


<!-- 个人简历 -->
<%@include file="/common/jianli.jspf" %>
<!-- 广告 -->
<%@include file="/common/guanggao.jspf" %>
<!-- projects -->

<div class="projects" id="projects">

	<div class="container">

	<span class="about-top-w3"><a name="stationmaster">资源下载</a> </span>

		<h4 class="title-w3ls">个人项目

			<%-- <span style="float: right;font-size: 0.8em"><a href="${proPath }/base/gourl/main/myresources">更多</a></span> --%>

		</h4>

		<div class="news-bottom" id="myresource">		

	</div>
</div>
</div>
<!---->
<div class="projects" id="projects">
	<div class="container">
	<span class="about-top-w3"><a  name="publicresource">资源下载 </a></span>
		<h4 class="title-w3ls">资源下载
			<span style="float: right;font-size: 0.6em"><a href="${proPath }/resource/3.html" target='_blank'>更多资源</a></span>
		</h4>
		<div class="news-bottom">
				<div class="news-one-wthree-agile" >				

					<%-- <c:forEach items="${blobs }" var="resource">	 --%>			

						<div class="col-md-12 news-left" id="blobresource"> 

						<%-- <a><h4>${resource.resourceName }</h4></a>

							<p class="para-w3-agile">${resource.resourceIntroduce }</p>	

							<a href="${resource.resourceUrl }" style="float: right;color: green">资源下载</a> --%>

						</div>

					<%-- </c:forEach>  --%>

				</div>						

			</div>	

	</div>

</div>
<!-- //projects -->
<!-- contact -->

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