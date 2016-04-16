<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<title>没俩 &mdash; 卤味网 </title>
		<%-- 	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		if (session.getAttribute("COMPANY_SESSION") == null) {
			response.sendRedirect(path+"/login.jsp");
			return;
		}
	%> --%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="天下没俩,卤味网" />
	<meta name="keywords" content="没俩,天下没俩,卤味,卤菜,卤味网,卤菜网" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<!-- Google Webfonts -->
	<link href='http://fonts.useso.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Salvattore -->
	<link rel="stylesheet" href="css/salvattore.css">
	<!-- Theme Style -->
	<link rel="stylesheet" href="css/style.css">
	
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
	
	</head>
	<body>
	<!-- <header id="fh5co-header" role="banner">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<a href="#" class="fh5co-menu-btn js-fh5co-menu-btn">菜单 <i class="icon-menu"></i></a>
					<a href="#" class="fh5co-menu-btn js-fh5co-menu-btn">登录 <i class="icon-menu"></i></a>
					<a class="navbar-brand" href="index.html">没俩&mdash;卤菜网</a>		
				</div>
			</div>
		</div>
	</header> -->
	<!-- <div class="btn-group open">
	  <a class="btn btn-primary" href="#"><i class="fa fa-user fa-fw"></i> User</a>
	  <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
	  <span class="fa fa-caret-down"></span></a>
	  <ul class="dropdown-menu">
	    <li><a href="#"><i class="fa fa-pencil fa-fw"></i> Edit</a></li>
	    <li><a href="#"><i class="fa fa-trash-o fa-fw"></i> Delete</a></li>
	    <li><a href="#"><i class="fa fa-ban fa-fw"></i> Ban</a></li>
	    <li class="divider"></li>
	    <li><a href="#"><i class="i"></i> Make admin</a></li>
	  </ul>
	</div> -->
	<!-- 我的没俩  右边目录 -->
	<%@include file="menu.jsp"%>
	
	<!-- 头部 -->
	<%@include file="header.jsp"%>
	
	<!-- 产品展示 -->
	<%@include file="main.jsp"%>

	<!-- 右边工具栏 -->
	<%@include file="jdcart.jsp"%>

	<!-- 底部 -->
	<%@include file="footer.jsp"%>
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Salvattore -->
	<script src="js/salvattore.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>
	</body>
</html>
