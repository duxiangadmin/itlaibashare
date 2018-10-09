<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/easyui.jspf" %>
<html>
  <head>
    
    <title>My JSP 'resourcelist.jsp' starting page</title>    
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
				method:"get",
			    url:'${proPath}/message/select',  
			    rownumbers:true,
			    pagination:true, 
			    checkOnSelect:true,
			    idField:"messageId",
			    pageSize:10, 
			    pageList:[5,10,20,30],
			    singleSelect:true,
			    columns:[[    
			    	{checkbox:true},
			        {field:'messageId',title:'留言编号'},    
			        {field:'messageUser',title:'留言人名称'},
			        {field:'messageTitle',title:'留言标题'},    
			        {field:'messageContent',title:'留言内容',width: "300",align:'right'}
			    ]],
			    toolbar: [{
					iconCls: 'icon-remove',
					text:"删除资源",
					handler: function(){
						var array = $('#dg').datagrid("getSelected");
						if(array != null){
							var messageId = array.messageId;
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
								if (r) {
								/* alert(r); */
								$.ajax({
								  url: "${proPath}/message/delete",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{messageId:messageId},
								  success: function(html){
									  if(html>0){
									  	alert("恭喜您 ，删除成功");
									  }else{
									  	alert("对不超 ，删除失败");
									  }
								 	 //重新刷新页面
								    $("#dg").datagrid("reload");
								    //请除所有勾选的行
								    $("#dg").datagrid("clearSelections");
								  },
								  error: function (XMLHttpRequest, textStatus, errorThrown) {
										    $.messager.alert('删除错误','请联系管理员！','error');
										},
									  dataType:'json'
								});
								}							
							});
						}else{
							alert("请选择一条数据进行删除");
						}
					}
				},'-',{
					text:"<input type='text' name='resourceName' id='resourceName'/>"					
				}]
						        
			});
			$('#resourceName').searchbox({ 
				searcher:function(value,name){ 
					alert(value + "," + name) ;
					$('#dg').datagrid('load',{					
						name:'%'+value+'%'		
					});	
				}, 
				menu:'#mm', 
				prompt:'Please Input Value' 
			}); 
		}); 	
	</script>
  </head>
  
  <body>
    <table id="dg"></table>  
  </body>
</html>
