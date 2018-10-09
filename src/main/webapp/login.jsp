<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>   
    
    <title>登陆页面</title>
	<%@include file="/common/easyui.jspf" %>	
  </head>
  
  <body style="width:100%;height:100%;">
    <div id="win">
    	<form id="ff" method="post" action="${proPath }/user/login">
			<div>
				<label for="loginId">账号:</label>				
				<input type="text" name="loginId" value="${user.loginId }" />
			</div>
			<div>
				<label for="loginPwd">密码:</label>				
				<input type="text" name="loginPwd" value="${user.loginPwd }"/>
			</div>			
		</form>
		<div style="color:red">${requestScope.msg}</div>
    </div>
    <script type="text/javascript">
	    $('#loginId').validatebox({    
		    required: true,   
		    missingMessage:"填写账号"  
		});
		
		$('#loginPwd').validatebox({    
		    required: true,    
		   missingMessage:"填写密码"     
		});     
    	//禁用验证
		$("#ff").form("disableValidation");
    	$('#win').dialog({  
    		title:"登陆窗口",
		  	width : 250,
			height : 150,
			closed : false,
			cache : false,
			//设置关闭按钮可见
			closable : false,
			//模式化窗口.如果为true将锁屏
			modal : true,
		    buttons:[{
		    	text:'注册',
				handler:function(){					
					window.open("${proPath}/addId.jsp","_blank");
				}
		    },{
		    	text:'登陆',
				handler:function(){					
					$("#ff").form("enableValidation");
					//进行验证，通过就提交
					if($("#ff").form("validate")){
					//提交
							$("#ff").submit();
					
					}
				}
		    }]		   
		}); 
    </script>
    <div id="win"></div>
  </body>
</html>
