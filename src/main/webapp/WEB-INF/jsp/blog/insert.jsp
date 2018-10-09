<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<title>My JSP</title>
<style type="text/css">	
</style>

<script type="text/javascript">  
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
            
            $(function(){
            	$.ajax({
            		url:"${proPath}/blogify/selectify",
            		type:"post",
            		dataType:"json",
            		success:function(data){
            			var str="";
            			$.each(data,function(i){
            				str+="<option value="+data[i]['blogId']+">"+data[i]['classIfy'];
            				str+="</option>";
            				$("#blogClassify").append(str);	
            				str="";
            			});
            			$("#blogClassify").trigger("create");            			
            		}
            	});
            });  
</script>

</head>
<body>
	<form id="ff"  method="post" enctype="multipart/form-data">
		<div>
			<label for="blogTitle">文章名称:</label>
			 <input type="text" id="blogTitle" name="blogTitle" />
		</div>
		<div>
			<label for="blogImg">资源简介图:</label>
			<input type="file" id="file" name="file" onchange="preImg(this.id,'photo');">
			<br><img id="photo"  class="img-thumbnail"><!-- 
			 <img id="photo" width="50px" height="50px" style="display: block;width: 50px;height: 50px" /> -->
		</div>	
		<div>
			<label for="blogContent">资源介绍:</label>			
			<!-- <textarea id="editor_id" name="blogContent" style="width:700px;height:300px;"></textarea> -->
			<div id="editor" name="blogContent" type="text/plain" style="width:1024px;height:500px;"></div>
		</div>			
		<div>
			<label for="blogClassify">分类:</label>			 
			<!-- <input name="blogClassify" type="text" style="width: 80%"></input> -->
			<select name="blogClassify" id="blogClassify">
					
			</select>  
		</div>
		
		<div>
			<input id="btn" type="button" value="提交" />
		</div>		
	</form>	
   <%@ include file="/common/ueditor.jspf" %> 
	<script type="text/javascript">	
		var ue = UE.getEditor('editor');
		$(function() {	
			$.post();			
			var win = parent.$("iframe[title='博客列表']").get(0).contentWindow;//返回ifram页面窗体对象（window)		
			$("[name='blogTitle']").validatebox({
				required : true,
				missingMessage : '请填写资源名！'
			}); 
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					/* alert("------------"); */
					$('#ff').form('submit', {						
						url : '${proPath}/blog/insert',
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

<%-- <%@ include file="/common/editor.jspf" %> --%>

</html>
