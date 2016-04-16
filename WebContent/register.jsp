<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<title>用户注册</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<div class="container">
		<div class="col-md-12">	
			<h1 class="text-center margin-bottom-15">用户注册</h1>		
			<form class="form-horizontal templatemo-contact-form-2 templatemo-container" role="form" action="user?action=register" method="post">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">				          		          	
				           	<div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-user"></i>
				            		<input type="text" class="form-control" id="name" name="name" placeholder="用户名">
				            	</div>		            		            		            
				          	</div>              
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-key fa-fw"></i>
				            		<input type="password" class="form-control" id="password1" name="password1" placeholder="密码">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-key fa-fw"></i>
				            		<input type="password" class="form-control" id="password2" name="password2" placeholder="确认密码">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-envelope"></i>
				            		<input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
				            	</div>
				          	</div>
				        </div>
				        <div class="form-group">
				            <div class="col-sm-12">
				            	<div class="templatemo-input-icon-container">
				            		<i class="fa fa-phone"></i>
				            		<input type="text" class="form-control" id="phone" name="phone" placeholder="联系电话">
				            	</div>
				          	</div>
				        </div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
				          <div class="col-md-12">
				            <div class="templatemo-input-icon-container">
				            	<i class="fa fa-pencil-square-o"></i>
				            	<textarea rows="10" cols="50" class="form-control" id="message" name="message" placeholder="其他信息"></textarea>
				            </div>
				          </div>
				        </div>
					</div>					
				</div>	        
		        <div class="form-group">
		          <div class="col-md-12">
		            <div class="checkbox pull-left">
		                <label>
		                  <input type="checkbox"> 发送一份到我的电子邮件？
		                </label>
		            </div>
		            <input type="submit" value="注册" class="btn btn-warning pull-right">		            
		          </div>
		        </div>		    	
		      </form>	
              
              <div class="row">
              	<div class="col-md-8 col-xs-offset-1">
                	<br>
                	<p>Contact form two is brought to youCollect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> that can be used for your websites.</p>
                </div>
              </div>	 
              
		</div>
	</div>
</body>
</html>