<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<title>My JSP</title>
    <style type="text/css">
        #videoSummary
        {
            color: #990099;
            background-color:#FFFFE0;
            border: solid 2px black;
            width: 470px;
            height: 180px;
            overflow: scroll;
            scrollbar-face-color: #ffc0cb;
            scrollbar-shadow-color: #ffb6c1;
            scrollbar-highlight-color: #98fb98;
            scrollbar-3dlight-color: #ffb6c1; 
            scrollbar-darkshadow-color: #90ee90; 
            scrollbar-track-color: #ffdead; 
            scrollbar-arrow-color: #f5deb3;
          }
    </style>
</head>
<body>
	<form id="ff"  method="post" enctype="multipart/form-data">
		<div>
			<label for="videoName">视频资源名称:</label>
			 <input type="text" id="videoName" name="videoName" />
		</div>
		<div>
			<label for="videoSummary">视频资源简介:</label>
			    <textarea  id="videoSummary" name="videoSummary">
   				 </textarea>
		</div>
		<div>
			<label for="videoContent">资源内容:</label>			
			<!-- <textarea id="editor_id" name="blogContent" style="width:700px;height:300px;"></textarea> -->
			<div id="editor" name="videoContent" type="text/plain" style="width:1024px;height:500px;"></div>
		</div>
		<div>
			<label for="videoUrl">视频资源下载地址:</label>
			 <input type="text" id="videoUrl" name="videoUrl" />
		</div>		
		<div>
			<label for="videoIfy">是否收费</label>
			<select name="videoIfy">
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
		</div>
		<div>
			<label for="videoMoney">价格:</label>
			 <input type="text" id="videoMoney" name="videoMoney" />
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
			var win = parent.$("iframe[title='视频列表']").get(0).contentWindow;//返回ifram页面窗体对象（window)		
			$("[name='videoName']").validatebox({
				required : true,
				missingMessage : '请填写资源名！'
			});
			$("[name='videoSummary']").validatebox({
				required : true,
				missingMessage : '请填写资源介绍！'
			});
			$("[name='videoUrl']").validatebox({
				required : true,
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
						url : '${proPath}/sdy/insert',
						onSubmit : function() {						
							return true;
						},
						success : function(count) {					
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
