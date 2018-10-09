<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/easyui.jspf"%>
<title>My JSP</title>
</head>
<body>
	<form id="ff" method="post">
		<div>
			<label for="resourceId">资源编号:</label> <input type="text" name="resourceId" readonly="readonly"/>
		</div>
		<div>
			<label for="resourceName">资源名称:</label> <input type="text" name="resourceName" />
		</div>
		<div>
			<label for="resourceNumber">下载次数:</label> <input type="text" name="resourceNumber" />
		</div>
		<div>
			<label for="resourceCreateTime">创建时间:</label> <input type="text" name="resourceCreateTime" readonly="readonly" />
		</div>
		<div>
			<label for="resourceIntroduce">资源介绍:</label>
			<textarea name="resourceIntroduce"  cols="36" rows="8" id="content" style="border: 1 solid #888888;LINE-HEIGHT:18px;padding: 3px;resize: none"></textarea>
		</div>			
		<div>
			<label for="resourceUrl">下载:</label>
			<textarea name="resourceUrl"></textarea>
		</div>
		<div>
			<label for="ordeBy">排序序号:</label> <input type="text" name="ordeBy" />
		</div>
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='资源管理']").get(0).contentWindow;//返回ifram页面窗体对象（window)
			var row = win.$('#dg').datagrid("getSelected");
			
			/* alert(row.resourceId); */
			
			$('#ff').form('load','${proPath}/resource/selectId/'+row.resourceId);
			
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
					alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/resource/update.action',
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

				}

			});

		});
	</script>
</body>
</html>
