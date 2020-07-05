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
	Event event = (Event) session.getAttribute("eventToRegister");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title><%=loggedInUser.getName() %> | Register for Event</title>
</head>

<body>

<div class="section">
	<div class="container">
		
		<%@ include file="./includes/menu.jsp" %>
		
		<div class="row">
			<div class="col-md-10">
				<div class="panel panel-primary" id="<%=event.getId() %>">
					<div class="panel-heading">Register for <%=event.getName() %></div>
					<div class="panel-body">
						<form class="form-horizontal" method="POST" action="./register">
						
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
							
							<hr style="border: 1px solid #337cbb;">
							
							<div class="form-group">
								<label for="studentId" class="col-md-3 control-label"><%=SemsConstants.FORM_STUDENT_ID %></label>
								<div class="col-md-8">
									<input type="text" id="studentId" name="<%=SemsConstants.STUDENT_ID %>" class="form-control" value="<%=loggedInUser.getUserId() %>" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="studentName" class="col-md-3 control-label"><%=SemsConstants.FORM_STUDENT_NAME %></label>
								<div class="col-md-8">
									<input type="text" id="studentName" name="<%=SemsConstants.STUDENT_NAME %>" class="form-control" value="<%=loggedInUser.getName() %>" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="studentGender" class="col-md-3 control-label"><%=SemsConstants.FORM_GENDER %></label>
								<div class="col-md-8">
									<input type="text" id="studentGender" name="studentGender" class="form-control" value="<%=loggedInUser.getGender() %>" disabled="disabled">
								</div>
							</div>
							
							<div class="form-group">
								<label for="notes" class="col-md-3 control-label"><%=SemsConstants.FORM_NOTES %></label>
								<div class="col-md-8">
									<textarea id="notes" name="<%=SemsConstants.NOTES %>" class="form-control" rows="3" style="resize: none;" placeholder="Provide Team Name or any other details here (Optional)"></textarea>
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