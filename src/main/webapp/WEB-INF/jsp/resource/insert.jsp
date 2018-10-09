<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<title>My JSP</title>
</head>
<body>
	<form id="ff" method="post">
		<div>
			<label for="resourceName">资源名称:</label> <input type="text" id="resourceName" name="resourceName" />
		</div>
		<div>
			<label for="resourceIntroduce">资源介绍:</label>
			<textarea name="resourceIntroduce"  cols="36" rows="8" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;resize: none"></textarea>
		</div>			
		<div>
			<label for="resourceUrl">下载:</label>			
			<input name="resourceUrl" type="text" style="width: 80%"></input>  
		</div>
		
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='资源管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
		
			$("[name='resourceName']").validatebox({
				required : true,
				missingMessage : '请填写资源名！'
			}); 
			$("[name='resourceIntroduce']").validatebox({
				required : true,
				missingMessage : '请填写资源介绍！'
			});
			$("[name='resourceUrl']").validatebox({
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
						url : '${proPath}/resource/insert.action',
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
</html>
