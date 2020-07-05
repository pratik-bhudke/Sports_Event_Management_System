<%@page import="com.sems.util.SemsConstants"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<script type="text/javascript" src="js\custom.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title>SEMS</title>

</head>
<body>

<div class="section">
	<div class="container">
	
		<div class="row">
		
			<div class="col-md-12 text-center">
				<a href="#" class="h2">
					<%=SemsConstants.SYSTEM_TITLE %>
				</a>
			</div>
		
			<div id="tabbedForm" class="col-md-8 col-md-offset-2">
				<ul  class="nav nav-pills">
					<li class="active">
		        		<a  href="#loginTab" data-toggle="tab"><%=SemsConstants.LOGIN %></a>
					</li>
					<li>
						<a href="#registerTab" data-toggle="tab"><%=SemsConstants.REGISTER %></a>
					</li>
				</ul>
				
				<div class="tab-content clearfix">
					<div class="tab-pane active" id="loginTab">
			        	<form class="form-horizontal" method="POST" action="<%=SemsConstants.LOGIN_SERVLET %>">
			        		
			        		<br>
			        		
			        		<div class="form-group">
								<label for="loginId" class="col-md-3 control-label"><%=SemsConstants.FORM_LOGIN_ID %></label>
								<div class="col-md-8">
									<input type="text" id="loginId" name="<%=SemsConstants.LOGIN_ID %>" class="form-control" required />
								</div>
							</div>
							
							<div class="form-group">
								<label for="loginPassword" class="col-md-3 control-label"><%=SemsConstants.FORM_PASSWORD %></label>
								<div class="col-md-8">
									<input type="password" id="loginPassword" name="<%=SemsConstants.LOGIN_PASSWORD %>" class="form-control" required />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 col-md-offset-5">
									<button type="submit" class="btn btn-success btn-block"><%=SemsConstants.FORM_SUBMIT %></button>
								</div>
							</div>
			        		
			        	</form>
					</div>
					<div class="tab-pane" id="registerTab">
			        	<form class="form-horizontal" method="POST" action="<%=SemsConstants.REGISTER_USER_SERVLET %>">
			        		
			        		<br>
			        		
			        		<div class="form-group">
								<label for="studentId" class="col-md-3 control-label"><%=SemsConstants.FORM_STUDENT_ID %></label>
								<div class="col-md-8">
									<input type="text" id="studentId" name="<%=SemsConstants.STUDENT_ID %>" class="form-control" required />
								</div>
							</div>
							
							<div class="form-group">
								<label for="studentName" class="col-md-3 control-label"><%=SemsConstants.FORM_STUDENT_NAME %></label>
								<div class="col-md-8">
									<input type="text" id="studentName" name="<%=SemsConstants.STUDENT_NAME %>" class="form-control" required />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 col-xs-3 control-label"><%=SemsConstants.FORM_GENDER %></label>
								<div class="col-md-2 xs-hide"></div>
								<div class="col-md-2 col-xs-3">
									<label class="checkbox-inline">
										<input type="radio" id="male" name="<%=SemsConstants.GENDER %>" class="form-control" value="Male" required />Male
									</label>
								</div>
								<div class="col-md-2 col-xs-3">
									<label class="checkbox-inline">
										<input type="radio" id="female" name="<%=SemsConstants.GENDER %>" class="form-control" value="Female" required />Female
									</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="password" class="col-md-3 control-label"><%=SemsConstants.FORM_PASSWORD %></label>
								<div class="col-md-8">
									<input type="password" id="password" name="<%=SemsConstants.PASSWORD %>" class="form-control" onchange="validatePassword();" required />
								</div>
							</div>
							
							<div class="form-group">
								<label for="confirmPassword" class="col-md-3 control-label"><%=SemsConstants.FORM_CONFIRM_PASSWORD %></label>
								<div class="col-md-8">
									<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" onchange="validatePassword();" required />
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 col-md-offset-5">
									<button type="submit" class="btn btn-success btn-block"><%=SemsConstants.FORM_SUBMIT %></button>
								</div>
							</div>
			        		
			        	</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>