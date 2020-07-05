<%@page import="com.sems.model.Event"%>
<%@page import="com.sems.model.User" %>
<%@page import="com.sems.util.SemsConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>

<%
	User loggedInUser = (User) session.getAttribute("loggedInUser");
	@SuppressWarnings("unchecked")
	ArrayList<Event> allEvents = (ArrayList<Event>) session.getAttribute("allEvents");
	@SuppressWarnings("unchecked")
	ArrayList<String> eventsRegistered = (ArrayList<String>) session.getAttribute("eventsRegistered");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title><%=loggedInUser.getName() %> | Logged In</title>
</head>

<body>

<div class="section">
	<div class="container">
	
		<%@ include file="./includes/menu.jsp" %>
		
		<%
			for (Event event : allEvents) {
		%>
		
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary" id="<%=event.getId() %>">
					<div class="panel-heading"><%=event.getName() %></div>
					<div class="panel-body">
						<form class="form-horizontal">
						
							<div class="form-group">
								<label for="description" class="col-md-3 control-label"><%=SemsConstants.EVENT_DESCRIPTION %></label>
								<div class="col-md-8">
									<textarea id="description" name="<%=SemsConstants.DESCRIPTION %>" class="form-control" rows="3" style="resize: none;" disabled="disabled"><%=event.getDescription().trim() %></textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label for="name" class="col-md-3 control-label"><%=SemsConstants.EVENT_FOR %></label>
								<div class="col-md-8">
									<input type="text" id="name" name="<%=SemsConstants.NAME %>" class="form-control" value="<%=event.getEventGender() %>" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="creator" class="col-md-3 control-label"><%=SemsConstants.POST_CREATOR %></label>
								<div class="col-md-8">
									<input type="text" id="creator" class="form-control" placeholder="<%=event.getCreatedBy() %>" disabled="disabled">
								</div>
							</div>
					
							<%@ include file="./includes/displayWinner.jsp" %>
					
							<div class="text-right">
								<%
									if(!winner) {
										if(event.getEventGender().equalsIgnoreCase(loggedInUser.getGender()) || 
											event.getEventGender().equalsIgnoreCase("Both")) {
											if(event.getCanRegister() != null && event.getCanRegister()) {
									%>
									<%
												if(eventsRegistered.contains(event.getId())) {
									%>
									<a href="./cancelRegistration?id=<%=event.getId() %>" class="btn btn-danger"><%=SemsConstants.CANCEL_REGISTRATION_BUTTON %></a>
									<%
												} else {
									%>
									<a href="./register?id=<%=event.getId() %>" class="btn btn-primary"><%=SemsConstants.REGISTER %></a>
									<%
												}
									%>
									
									<%
											} else {
									%>
									<button type="button" class="btn btn-danger" disabled="disabled"><%=SemsConstants.REGISTRATIONS_CLOSED_BUTTON %></button>
									<%
											}
										} else {
									%>
									<button type="button" class="btn btn-danger" disabled="disabled"><%=SemsConstants.CANNOT_APPLY_BUTTON %></button>
									<%
										}
									}
								%>
								<a href="./viewRegistration?id=<%=event.getId() %>" class="btn btn-success"><%=SemsConstants.VIEW_REGISTRATIONS_BUTTON %></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<%	
			}
		%>

	</div>
</div>

</body>
</html>