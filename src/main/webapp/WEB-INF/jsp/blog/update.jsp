<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<%@ include file="/common/ueditor.jspf" %> 
<title>资源修改</title>
<style type="text/css">	
</style>

<script type="text/javascript">  
	var ue = UE.getEditor('editor');
            function getFileUrl(sourceId) {  
                var url;  
                if (navigator.userAgent.indexOf("MSIE")>=1) { // IE  
                    url = document.getElementById(sourceId).value;  
                } else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox  
                    url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));  
                } else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome  
                    url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));  
                }  
                return url;  
            }  
            function preImg(sourceId, targetId) { 
                var url = getFileUrl(sourceId);   
                var imgPre = document.getElementById(targetId);   
                imgPre.src = url;   
            }  
</script>

</head>
<body>
	<form id="ff" method="post" enctype="multipart/form-data">
		<input type="text" value="${blogEssay.blogId }" id="blogId" name="blogId" />
		<input type="text" value="${blogEssay.blogRedNum }" id="blogRedNum" name="blogRedNum" />
		<input type="text" value="${blogEssay.blogCreateTime }" id="blogCreateTime" name="blogCreateTime" />
		<input type="text" value="${blogEssay.orderBy }" id="orderBy" name="orderBy" />
		<div>
			<label for="blogTitle">资源名称:</label> <input type="text" value="${blogEssay.blogTitle }" id="blogTitle" name="blogTitle" />
		</div>
		<div>
			<label for="blogImg">资源简介图:</label>
			<input type="file" id="file" name="file" onchange="preImg(this.id,'photo');">	
			 <img id="photo"  class="img-thumbnail" <c:if test="${!empty blogEssay.blogImg }"> src="${proPath }${blogEssay.blogImg }" </c:if>>	
			 <input type="text" name="blogImg" value="${blogEssay.blogImg }">
		</div>	
		<div>
			<label for="blogContent">内容:</label>
			<script id="editor" name="blogContent" type="text/plain" style="width:1024px;height:500px;">${blogEssay.blogContent }</script>
			<!-- <textarea name="myresourceContent"  cols="36" rows="8" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;resize: none"></textarea> -->
		</div>			
		<div>
			<label for="blogClassify">类别:</label>			
			<input name="blogClassify" type="text" value="${blogEssay.blogClassify }" style="width: 80%"></input>  
		</div>
		
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>	

	<script type="text/javascript">		
	
		$(function() {		
			var win = parent.$("iframe[title='博客列表']").get(0).contentWindow;//返回ifram页面窗体对象（window)	
			var row = win.$('#dg').datagrid("getSelected");
			/* alert(row.myresourceId); */					
			/* $('#ff').form('load','${proPath}/myresource/selectByKey/'+row.myresourceId); */
			if(${empty blogEssay}){						
				window.location ='${proPath}/blog/selectById/'+row.blogId;		
			}
			$("#btn").click(function() {								 
					$('#ff').form('submit', {
						url : '${proPath}/blog/update',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
								if(count>0){
									alert("修改成功！");									
								}else{
									alert("修改失败！");
								}
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});
			});
		});
	</script>
</body>
</html>
