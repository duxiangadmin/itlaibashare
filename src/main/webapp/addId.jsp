<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/common.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title>资源共享管理员注册</title>
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Validation Signup Form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<link href="${proPath }/login/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- fonts -->
<link href='http://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- //fonts -->
<script type="text/javascript" src="${proPath }/login/js/jquery.min.js"></script>
<script type="text/javascript" src="${proPath }/login/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="${proPath }/login/js/jquery.inputfocus-0.9.min.js"></script>
<%-- <script type="text/javascript" src="${proPath }/login/js/jquery.main.js"></script> --%>
</head>
<body>
	<div class="main">
		<h1>管理员账号注册</h1>
		<div class="content">
			<div id="container">
				<form action="${proPath }/user/insert" method="post">
					<!-- #first_step -->
					<div id="first_step">
						<div class="form">
							<h5>登陆账号</h5>
							<input type="text" name="loginId" id="loginId" value=""  required/>
							<h5>登陆密码</h5>
							<input type="password" name="loginPwd" id="loginPwd" value="" required="required"/>
							<!-- <h5>确认登陆账号</h5>
							<input type="password" name="loginPwd" id="loginPwd" value="" /> -->
							<h5>昵称</h5>
							<input type="text" name="loginName" id="loginName" value=""  required/>							
							<h5>Email Address</h5>
							<input type="text" name="email" id="email" value=""  required/>	
							<div style="color:red">${msg }</div>						
						</div>						
					</div>  
					<input class="submit" type="submit" />
				 </form>
			</div>
		</div>		
	</div>		
</body>
</html>
