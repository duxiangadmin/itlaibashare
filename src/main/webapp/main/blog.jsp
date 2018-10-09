<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>博客列表</title>
<%@include file="/common/common.jspf" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="${proPath}/editor/plugins/code/prettify.css"/>  
<script type="text/javascript" src="${proPath}/editor/plugins/code/prettify.js"></script>  
<script>prettyPrint();</script>  
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
<script type="text/javascript">
	/* $(function(){		
		$("#search").click(function(){
			var keyword = $("#keyword").val();			
				window.location = "${proPath}/blog/select?keyword="+keyword.trim();				
		});	
	}); */
</script>
<div class="projects" id="projects">
	<div class="container">
	<span class="about-top-w3"><a  name="publicresource"> </a></span>
		<div class="row" >
	        <div class="col-xs-8 ">
				<h4 class="title-w3ls">
				博客列表		
				</h4>
			</div>	
			
			<!-- <div class="input-group">
		      <input type="text" id="keyword" class="form-control" placeholder="Search for...">
		      <span class="input-group-btn">
		        <button id="search" class="btn btn-default" type="button">Go!</button>
		      </span>
		    </div> -->
    	</div>
		<div class="news-bottom">
				<div class="news-one-wthree-agile">	
					<c:forEach items="${blogEssays }" var="essay">				
						<div class="col-md-12" style="border-bottom: 1px solid green;margin-top:10px"> 
						<a href="${proPath}/blog/${essay.blogId}.html" target="_banck"><h4>文章名：${essay.blogTitle }</h4></a>
							<div style="height: 100px;overflow: hidden;text-overflow:ellipsis;" name="blogContent">${essay.blogContent }</div>	
							<a href="${proPath}/blog/${essay.blogId}.html" target="_banck" style="float: right;color: green">查看详细</a>
						</div>
					</c:forEach>
				</div>						
			</div>	
	</div>
</div>
<script type="text/javascript">
	$(function(){		
		var con = $("div[name='blogContent']");
		$.each(con,function(n){
			var subCon = $(con[n]).text().substring(0,300);
			$(con[n]).html(subCon.trim()+"...");
		});
	});
</script>
<div style="text-align:center">
		<a title="总页数">&nbsp;<b>共${page.pc }/${page.tp }页</b></a>
		<a href="${page.url}&start=0">首  页</a>	
		
		<c:choose>
			<c:when test="${page.start eq 0 }">
				<a>上一页</a>
			</c:when>
			<c:otherwise>
				<a href="${page.url}&start=${page.start-page.count}">上一页</a>
			</c:otherwise>
		</c:choose>
		
		
		
		<%--我们需要计算页码列表的开始和结束位置，即两个变量begin和end
			计算它们需要通过当前页码！
			1. 总页数不足6页--> begin=1, end=最大页
			2. 通过公式设置begin和end，begin=当前页-1，end=当前页+3
			3. 如果begin<1，那么让begin=1，end=6
			4. 如果end>tp, 让begin=tp-5, end=tp
			 --%>
			 <c:choose>
			 	<c:when test="${page.tp <= 6 }">
			 		<c:set var="begin" value="1"/>
			 		<c:set var="end" value="${page.tp }"/>
			 	</c:when>
			 	<c:otherwise>
			 		<c:set var="begin" value="${page.start-2 }"/>
			 		<c:set var="end" value="${page.start + 3}"/>
			 		<c:if test="${begin < 1 }">
			 		  <c:set var="begin" value="1"/>
			 		  <c:set var="end" value="6"/>
			 		</c:if>
			 		<c:if test="${end > page.tp }">
			 		  <c:set var="begin" value="${page.tp-5 }"/>
			 		  <c:set var="end" value="${page.tp }"/>
			 		</c:if> 		
			 	</c:otherwise>
			 </c:choose>
			 
			 <c:forEach begin="${begin }" end="${end }" var="i">
			   <c:choose>
			   	  <c:when test="${i eq page.start }">
			   	    <span class="spanBtnSelect">${i }</span>
			   	  </c:when>
			   	  <c:otherwise>   	  	
			   	  	<%-- <a href="<c:url value='?start=${i }'"/> ${i }</a>  --%> 
			   	  	<a href="${page.url}&start=${(i-1)*page.count }" >${i }</a>  	    
			   	  </c:otherwise>
			   </c:choose>
			</c:forEach>
		<%-- 显示点点点 --%>
	    <c:if test="${end < page.tp }">
	      <span class="spanApostrophe">...</span>
	    </c:if>
		
				
		<c:choose>	
			<c:when test="${(page.count+page.start >= page.rows)}">
				<a>下一页</a>
			</c:when>
			<c:otherwise>			
				<a href="${page.url}&start=${page.start+page.count}">下一页</a>
			</c:otherwise>
		</c:choose>
		
		<%-- <a href="?start=${page.start+page.count}">下一页</a> --%>
		<a href="${page.url}&start=${page.last}">末  页</a>
	</div>
<!-- //about -->
<%@include file="/common/buttom.jspf" %>
</body>
</html>