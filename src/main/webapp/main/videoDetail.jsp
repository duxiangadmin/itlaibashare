<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${studyvideo.videoName }下载</title>
<%@include file="/common/common.jspf" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="${proPath}/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
<link rel="stylesheet" href="${proPath}/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">
<script type="text/javascript">
    SyntaxHighlighter.all();
</script>
<style type="text/css">	
	pre.prettyprint {     
	    border: 1px solid rgb(204, 204, 204);  
	    background-color:#F8F8F8;  
	    margin-left: 2em;  
	    padding: 0.5em;  
	    font-size: 110%;  
	    display: block;  
	    font-family: "Consolas", "Monaco", "Bitstream Vera Sans Mono", "Courier New", Courier, monospace;  
	    margin: 1em 0px;  
	    white-space: pre-wrap;  
	}  
</style>
</head>
	
<body>
<!-- about -->
<%@include file="/common/topdh.jspf" %>

<div class="projects" id="projects">
	<div class="container">
		<div class="news-bottom">
			<div class="news-one-wthree-agile">									
					<div class="col-md-12" style="margin-top:10px"> 
						<a  style="text-align: center;">
							<h2>${studyvideo.videoName }</h2>
						</a>
						
						<p style="padding-top: 100px">${studyvideo.videoContent }</p>							
					</div>
					<div class="col-md-12" style="margin-top:40px"></div>					
					<div class="col-md-2" style="margin-top:10px">
						
					</div>
					<div class="col-md-8" style="margin-top:10px"></div>
					<div class="col-md-2" style="margin-top:10px"> 
						<p>${studyvideo.videoUrl }</p>
					</div> 
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
<script type="text/javascript" src="${proPath}/editor/plugins/code/prettify.js"></script>  
<script>
	$(function(){
		prettyPrint();
	});	
</script> 
</html>