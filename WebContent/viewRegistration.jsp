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
	Event event = (Event) session.getAttribute("eventToView");
	@SuppressWarnings("unchecked")
	ArrayList<User> registeredUsers = (ArrayList<User>) session.getAttribute("registeredUsers");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title><%=loggedInUser.getName() %> | View Registrations</title>
</head>
<body>

<div class="section">
	<div class="container">
		
		<%@ include file="./includes/menu.jsp" %>
		
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
						</form>
					</div>
					
					<div class="panel-heading">Registrations for <%=event.getName() %></div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-hover table-bordered table-condensed">
								<tr>
									<th><%=SemsConstants.FORM_SR_NO %></th>
									<th><%=SemsConstants.FORM_STUDENT_ID %></th>
									<th><%=SemsConstants.FORM_STUDENT_NAME %></th>
									<th><%=SemsConstants.FORM_GENDER %></th>
									<th><%=SemsConstants.FORM_NOTES %></th>
								</tr>
								
								<%
								int i = 1;
								for (User user : registeredUsers) {
								%>
								
								<tr>
									<td><%=i++ %></td>
									<td><%=user.getUserId() %></td>
									<td><%=user.getName() %></td>
									<td><%=user.getGender() %></td>
									<td><%=user.getNotes() %></td>
								</tr>
								
								<%
								}
								%>
								
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>