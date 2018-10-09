<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<%@ include file="/common/ueditor.jspf" %> 
<title>My JSP</title>
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
            	alert(sourceId); 
                var url = getFileUrl(sourceId);   
                var imgPre = document.getElementById(targetId);   
                imgPre.src = url;   
            }  
</script>

</head>
<body>
	<form id="ff"  method="post" enctype="multipart/form-data">
		<div>
			<label for="myresourceTitle">资源名称:</label>
			 <input type="text" id="myresourceTitle" name="myresourceTitle" />
		</div>
		<div>
			<label for="myresourceImg">资源简介图:</label>
			<input type="file" id="file" name="file" onchange="preImg(this.id,'photo');">
			<img id="photo"  class="img-thumbnail"><!-- 
			 <img id="photo" width="50px" height="50px" style="display: block;width: 50px;height: 50px" /> -->
		</div>	
		<div>
			<label for="myresourceContent">资源介绍:</label>			
			<script id="editor" name="myresourceContent" type="text/plain" style="width:1024px;height:500px;"></script>
			<!-- <textarea name="myresourceContent"  cols="36" rows="8" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;resize: none"></textarea> -->
		</div>			
		<div>
			<label for="myresourceUrl">下载:</label>			
			<input name="myresourceUrl" type="text" style="width: 80%"></input>  
		</div>
		
		<div>
			<input id="btn" type="button" value="提交" />
		</div>		
	</form>	
 
	<script type="text/javascript">	
		$(function() {				
			var win = parent.$("iframe[title='站长资源']").get(0).contentWindow;//返回ifram页面窗体对象（window)		
			$("[name='myresourceTitle']").validatebox({
				required : true,
				missingMessage : '请填写资源名！'
			}); 
			$("[name='myresourceUrl']").validatebox({
				required : true,
				validType:"url",
				missingMessage : '请填写资源下载地址！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					/* alert("------------"); */
					$('#ff').form('submit', {						
						url : '${proPath}/myresource/insert',
						onSubmit : function() {						
							return true;
						},
						success : function(count) {	
							alert(count);						
								//可以定义为对应消息框
								if(count>0){
									alert("添加成功！");									
								}else{
									alert("添加失败！");
								}
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});

				}

			});

		});
	</script>
</body>
</html>
