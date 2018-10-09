<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/easyui.jspf" %>
<html>
  <head>
    
    <title>My JSP 'resourcelist.jsp' starting page</title>    
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
			    url:'${proPath}/blog/selectList',  
			    rownumbers:true,
			    pagination:true, 
			    checkOnSelect:true,
			    idField:"blogId",
			    pageSize:10, 
			    pageList:[5,10,20,30],
			    columns:[[    
			    	{checkbox:true},
			        {field:'blogId',title:'博文编号'},    
			        {field:'blogTitle',title:'博文名称'},
			        {field:'blogImg',title:'博文图片路径'},    
			        {field:'blogCreateTime',title:'博文创建',align:'right'},
			        {field:'blogClassify',title:'博文类型',align:'right'},
			        {field:'blogRedNum',title:'博文阅读次数',align:'right'}
			    ]],
			    toolbar: [{
					iconCls: 'icon-add',
					text:"添加博文",
					handler: function(){
						parent.$("#win").window({
							title:"添加文章",
							width:'800',    
						    height:'600',    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/blog/insert' width=100% height=100% frameborder=0/>"   
						});
					}
				},'-',{
					iconCls: 'icon-edit',
					text:"修改文章",
					handler: function(){						
						var array = $('#dg').datagrid("getSelected");
						if(array!=null){
							parent.$("#win").window({
							title:"修改文章",
							width:800,    
						    height:600,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/adminurl/blog/update' width=100% height=100% frameborder=0/>"   
							});	
						}else{
							alert("请选择一行数据进行修改");
						}						
					}
				},'-',{
					iconCls: 'icon-remove',
					text:"删除资源",
					handler: function(){
						var array = $('#dg').datagrid("getSelections");
						if(array != null){
							var ids = new Array();
							var imgs = new Array();
							var times = new Array();							
							for(i=0;i<array.length;i++){
								ids[i]=array[i].blogId;
								imgs[i]=array[i].blogImg;
								times[i]=array[i].blogCreateTime;
							}				
							parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
								if (r) {
								$.ajax({
								  url: "${proPath}/blog/deleteList",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{id:ids,imgs:imgs},
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
