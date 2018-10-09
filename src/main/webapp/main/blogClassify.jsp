<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>所有图文教程</title>
<%@include file="/common/common.jspf" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"${proPath}/blogify/selectify",
			type:"post",
			dataType:"JSON",
			success:function(data){
				var str="";
				$.each(data,function(i){
					str+="<div class='col-md-3' style='margin-top:10px;'>";
					str+="<a href=${proPath}/blog/select?keyword="+data[i]['classIfy']+">";
					str+="<img width=230px height=250px src=${proPath}/classifyimg/"+data[i]['classifyImg']+">";
					str+="</img>";
					str+="</a>";
					str+="</div>";
					$("#blogclassify").append(str);					
					str="";
				});
				$("#blogclassify").trigger("create");	
			}
		});
	});
</script>
</head>
	
<body>
<!-- about -->
<%@include file="/common/topdh.jspf" %>

<div class="projects" id="projects">
	<div class="container">
		<div class="news-bottom">
			<div class="news-one-wthree-agile" id="blogclassify">									
					
			</div>						
		</div>	
	</div>
</div>
<!-- //about -->
<br><br>
<!--PC和WAP自适应版-->
<div id="SOHUCS" ></div> 
<script type="text/javascript"> 
(function(){ 
var appid = 'cytFhuOVE'; 
var conf = 'prod_8c68dc02f1b563a325adf3bae5f215c3'; 
var width = window.innerWidth || document.documentElement.clientWidth; 
if (width < 960) { 
window.document.write('<script id="changyan_mobile_js" charset="utf-8" type="text/javascript" src="https://changyan.sohu.com/upload/mobile/wap-js/changyan_mobile.js?client_id=' + appid + '&conf=' + conf + '"><\/script>'); } else { var loadJs=function(d,a){var c=document.getElementsByTagName("head")[0]||document.head||document.documentElement;var b=document.createElement("script");b.setAttribute("type","text/javascript");b.setAttribute("charset","UTF-8");b.setAttribute("src",d);if(typeof a==="function"){if(window.attachEvent){b.onreadystatechange=function(){var e=b.readyState;if(e==="loaded"||e==="complete"){b.onreadystatechange=null;a()}}}else{b.onload=a}}c.appendChild(b)};loadJs("https://changyan.sohu.com/upload/changyan.js",function(){window.changyan.api.config({appid:appid,conf:conf})}); } })(); </script>
	<div class="footer">
		<div class="container">
			<p>© 2018 网站所有权归本人所有，如转载请注明出处|  <a href="#">itlaiba.com</a></p>
		</div>
	</div>
</body>
</html>