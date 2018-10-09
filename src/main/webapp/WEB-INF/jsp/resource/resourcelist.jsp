<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/easyui.jspf" %>
<html>
  <head>
    
    <title>My JSP 'resourcelist.jsp' starting page</title>    
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({    
				method:"get",
			    url:'${proPath}/resource/select.action',  
			    rownumbers:true,
			    pagination:true, 
			    checkOnSelect:true,
			    idField:"resourceId",
			    pageSize:10, 
			    pageList:[5,10,20,30],
			    singleSelect:true,
			    columns:[[    
			    	{checkbox:true},
			        {field:'resourceId',title:'资源编号',width:100},    
			        {field:'resourceName',title:'资源名称',width:100},
			        {field:'resourceNumber',title:'下载次数',width:100},    
			        {field:'resourceCreateTime',title:'创建时间',align:'right'},
			        {field:'resourceIntroduce',title:'简介',align:'right'},
			        {field:'resourceUrl',title:'下载地址',align:'right'},
			        {field:'ordeBy',title:'排序',width:100,align:'right'} 
			    ]],
			    toolbar: [{
					iconCls: 'icon-add',
					text:"添加资源",
					handler: function(){
						parent.$("#win").window({
							title:"添加资源",
							width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/resource/insert' width=100% height=100% frameborder=0/>"   
						});
					}
				},'-',{
					iconCls: 'icon-edit',
					text:"修改资源",
					handler: function(){						
						var array = $('#dg').datagrid("getSelected");
						if(array!=null){
							parent.$("#win").window({
							title:"修改资源",
							width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/resource/update' width=100% height=100% frameborder=0/>"   
							});	
						}else{
							alert("请选择一行数据进行修改");
						}						
					}
				},'-',{
					iconCls: 'icon-remove',
					text:"删除资源",
					handler: function(){
						var array = $('#dg').datagrid("getSelected");
						if(array != null){
							var resourceId = array.resourceId;
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
								if (r) {
								/* alert(r); */
								$.ajax({
								  url: "${proPath}/resource/delete.action",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{resourceId:resourceId},
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
