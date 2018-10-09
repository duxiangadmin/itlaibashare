<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/easyui.jspf" %>
<html>
  <head>
    
    <title>My JSP 'resourcelist.jsp' starting page</title>    
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
			    url:'${proPath}/myresource/select',  
			    rownumbers:true,
			    pagination:true, 
			    checkOnSelect:true,
			    idField:"myresourceId",
			    pageSize:10, 
			    pageList:[5,10,20,30],
			    singleSelect:true,
			    columns:[[    
			    	{checkbox:true},
			        {field:'myresourceId',title:'资源编号'},    
			        {field:'myresourceTitle',title:'资源名称'},
			        {field:'myresourceImg',title:'资源图片路径'},    
			        {field:'myresourceUrl',title:'资源下载地址',align:'right'},
			        {field:'myresourceTime',title:'资源创建时间',align:'right'},
			        {field:'myresourceNumber',title:'资源下载次数',align:'right'},
			        {field:'userId',title:'上传人',align:'right'}
			    ]],
			    toolbar: [{
					iconCls: 'icon-add',
					text:"站长添加资源",
					handler: function(){
						parent.$("#win").window({
							title:"添加资源",
							width:'800',    
						    height:'600',    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/myresource/insert' width=100% height=100% frameborder=0/>"   
						});
					}
				},'-',{
					iconCls: 'icon-edit',
					text:"修改资源",
					handler: function(){						
						var array = $('#dg').datagrid("getSelected");
						if(array!=null){
							parent.$("#win").window({
							title:"修改站长资源",
							width:800,    
						    height:600,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/myresource/update' width=100% height=100% frameborder=0/>"   
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
							var myresourceId = array.myresourceId;
							var img = array.myresourceImg;
							var date = array.myresourceTime;							
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
								if (r) {
								$.ajax({
								  url: "${proPath}/myresource/delete",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{myresourceId:myresourceId,img:img,date:date},
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
					text:"<input type='text' name='keyword' id='keyword'/>"					
				}]
						        
			});
			/* $('#keyword').searchbox({ 
				searcher:function(value,name){ 
					alert(value + "," + name) ;
					$('#dg').datagrid('load',{					
						keyword:'%'+value+'%'		
					});	
				}, 
				menu:'#mm', 
				prompt:'Please Input Value' 
			});  */
		}); 	
	</script>
  </head>
  
  <body>
    <table id="dg"></table>  
  </body>
</html>
