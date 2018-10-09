<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/easyui.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>itresource控制台</title>
       
	 <script type="text/javascript">
		$(function(){
			$("a[title]").click(function() {
			var text = this.href;
			/* alert(text); */
			//判断是否存在
			if($('#tt').tabs("exists",this.title)){
			//存在则选中
				/* alert("存在了"); */
				$('#tt').tabs("select",this.title);			
			}else{
				$('#tt').tabs('add', {
					title:this.title,
					//面板有关闭按键
				    closable:true, 
				    //href对远程页面js的支持不好 
					//href: text			
					//可以加载内容填充到选项卡，页面有Js时，也可加载
					content:"<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px' ></iframe>"
					});					
				}
				return false;
			
			});		
		});
	</script>
  </head>
  
  <body class="easyui-layout">   
    <div data-options="region:'north',title:'it资源控制台'" style="height:100px;">
    	${users.loginId }
    </div>      
    <div data-options="region:'west',title:'导航栏',split:true" style="width:200px;">
    	<ul class="easyui-tree">   
		    <li>   
		        <span>软件资源管理</span>
		        <ul>
		        	<li>
		        		<a href="${proPath}/base/adminurl/resource/resourcelist" title="资源管理"
						style="text-decoration: none;display: block;font-weight:bold;">
						资源列表
						</a>
					</li>
		        </ul>		         
		    </li>   
		</ul> 
		<ul  class="easyui-tree">   
		    <li>   
		        <span>项目资源管理</span>
		        <ul>
		        	<li>
			        	<a href="${proPath}/base/adminurl/myresource/myresourcelist" title="站长资源"
							style="text-decoration: none;display: block;font-weight:bold;">
							资源列表
						</a>
					</li>
		        </ul>
		    </li>    
		</ul>
		<ul class="easyui-tree">   
		    <li>   
		        <span>问答管理</span>
		        <ul>
		        	<li>
		        		<a href="${proPath}/base/adminurl/message/messagelist" title="问答列表"
							style="text-decoration: none;display: block;font-weight:bold;">
		        		问答列表
		        		</a>
		        	</li>
		        </ul>
		    </li>    
		</ul>
		<ul class="easyui-tree">   
		    <li>   
		        <span>博客管理</span>
		        <ul>
		        	<li>
		        		<a href="${proPath}/base/adminurl/blog/bloglist" title="博客列表"
							style="text-decoration: none;display: block;font-weight:bold;">
		        		博客列表
		        		</a>
		        	</li>
		        </ul>
		    </li>    
		</ul> 
		<ul class="easyui-tree">   
		    <li>   
		        <span>视频资源管理</span>
		        <ul>
		        	<li>
		        		<a href="${proPath}/base/adminurl/video/videolist" title="视频列表"
							style="text-decoration: none;display: block;font-weight:bold;">
		        		视频列表
		        		</a>
		        	</li>
		        </ul>
		    </li>    
		</ul> 
    </div>   
    <div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
    	<div id="tt" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="欢迎页面" style="padding:20px;" >   
		        	<p>这里是管理员控制台，非法登陆操作将追究法律责任<p>
		        	
		        	管理权限说明：
		        		<ol>
		        			<li>普通管理员：只能进行资源的添加</li>
		        			<li>金牌管理员：可以进行资源的增删改查</li>
		        			<li>超级管理员：可以进行资源的增删改查及其他管理员的权限修改</li>
		        		</ol>
		    </div>
		</div>
		<div id="win"></div> 
    </div>   
</body> 
</html>
