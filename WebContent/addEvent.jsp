<%@page import="com.sems.model.Event"%>
<%@page import="com.sems.model.User" %>
<%@page import="com.sems.util.SemsConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>

<%
	User loggedInUser = (User) session.getAttribute(SemsConstants.LOGGED_IN_USER);
	@SuppressWarnings("unchecked")
	ArrayList<Event> allEvents = (ArrayList<Event>) session.getAttribute(SemsConstants.ALL_EVENTS);
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title><%=loggedInUser.getName() %> | Add Event</title>
</head>

<body>

<div class="section">
	<div class="container">
	
		<%@ include file="./includes/menu.jsp" %>
		
		<div class="row">
			<div class="col-md-10">
				
				<div class="panel panel-primary">
					<div class="panel-heading"><%=SemsConstants.ADD_SPORT_EVENT %></div>
					<div class="panel-body">
						<form class="form-horizontal" method="POST" action="<%=SemsConstants.ADD_EVENT_SERVLET %>">
						
							<div class="form-group">
								<label for="name" class="col-md-3 control-label"><%=SemsConstants.EVENT_NAME %></label>
								<div class="col-md-8">
									<input type="text" id="name" name="<%=SemsConstants.NAME %>" class="form-control" placeholder="Ex. Cricket, Football etc." required>
								</div>
							</div>
							
							<div class="form-group">
								<label for="description" class="col-md-3 control-label"><%=SemsConstants.EVENT_DESCRIPTION %></label>
								<div class="col-md-8">
									<textarea id="description" name="<%=SemsConstants.DESCRIPTION %>" class="form-control" placeholder="Short decription of Event" rows="3" style="resize: none;" required></textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label"><%=SemsConstants.EVENT_FOR %></label>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="male" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_MALE %>" required /><%=SemsConstants.GENDER_MALE %>
									</label>
								</div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="female" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_FEMALE %>" required /><%=SemsConstants.GENDER_FEMALE %>
									</label>
								</div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="both" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_BOTH %>" required /><%=SemsConstants.GENDER_BOTH %>
									</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner1" class="col-md-3 control-label"><%=SemsConstants.FIRST_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner1" class="form-control" placeholder="Name of Player/Team" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner2" class="col-md-3 control-label"><%=SemsConstants.SECOND_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner2" class="form-control" placeholder="Name of Player/Team" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner3" class="col-md-3 control-label"><%=SemsConstants.THIRD_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner3" class="form-control" placeholder="Name of Player/Team" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="creator" class="col-md-3 control-label"><%=SemsConstants.POST_CREATOR %></label>
								<div class="col-md-8">
									<input type="text" id="creator" class="form-control" placeholder="<%=loggedInUser.getName() %>" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 col-md-offset-5">
									<button type="submit" class="btn btn-primary btn-block"><%=SemsConstants.FORM_SUBMIT %></button>
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