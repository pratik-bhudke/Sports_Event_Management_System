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
	Event eventToEdit = (Event) session.getAttribute("eventToEdit");
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="js\jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js\bootstrap.min.js"></script>
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/custom.css" rel="stylesheet" type="text/css">
	
	<title><%=loggedInUser.getName() %> | Edit Event</title>
</head>

<body>

<div class="section">
	<div class="container">
	
		<%@ include file="./includes/menu.jsp" %>
		
		<div class="row">
			<div class="col-md-10">
				
				<div class="panel panel-primary">
					<div class="panel-heading"><%=SemsConstants.EDIT_SPORT_EVENT %></div>
					<div class="panel-body">
						<form class="form-horizontal" method="POST" action="<%=SemsConstants.UPDATE_EVENT_SERVLET %>">
						
							<div class="form-group">
								<label for="name" class="col-md-3 control-label"><%=SemsConstants.EVENT_NAME %></label>
								<div class="col-md-8">
									<input type="text" id="name" name="<%=SemsConstants.NAME %>" class="form-control" value="<%=eventToEdit.getName() %>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="description" class="col-md-3 control-label"><%=SemsConstants.EVENT_DESCRIPTION %></label>
								<div class="col-md-8">
									<textarea id="description" name="<%=SemsConstants.DESCRIPTION %>" class="form-control" rows="3" style="resize: none;"><%=eventToEdit.getDescription() %></textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label"><%=SemsConstants.EVENT_FOR %></label>
								<div class="col-md-1"></div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="male" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_MALE %>" required <%if(eventToEdit.getEventGender().equalsIgnoreCase("MALE")) { %>checked="checked" <%} %> /><%=SemsConstants.GENDER_MALE %>
									</label>
								</div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="male" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_FEMALE %>" required <%if(eventToEdit.getEventGender().equalsIgnoreCase("FEMALE")) { %>checked="checked" <%} %> /><%=SemsConstants.GENDER_FEMALE %>
									</label>
								</div>
								<div class="col-md-2">
									<label class="checkbox-inline">
										<input type="radio" id="male" name="<%=SemsConstants.GENDER %>" class="form-control" value="<%=SemsConstants.GENDER_BOTH %>" required <%if(eventToEdit.getEventGender().equalsIgnoreCase("BOTH")) { %>checked="checked" <%} %> /><%=SemsConstants.GENDER_BOTH %>
									</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner1" class="col-md-3 control-label"><%=SemsConstants.FIRST_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner1" name="<%=SemsConstants.WINNER_1 %>" class="form-control" placeholder="Name of Player/Team" value="<%if(eventToEdit.getWinner1() != null && !eventToEdit.getWinner1().isEmpty()) { %><%=eventToEdit.getWinner1()%><%} %>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner2" class="col-md-3 control-label"><%=SemsConstants.SECOND_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner2" name="<%=SemsConstants.WINNER_2 %>" class="form-control" placeholder="Name of Player/Team" value="<%if(eventToEdit.getWinner2() != null && !eventToEdit.getWinner2().isEmpty()) { %><%=eventToEdit.getWinner2()%><%} %>">
								</div>
							</div>
							
							<div class="form-group">
								<label for="winner3" class="col-md-3 control-label"><%=SemsConstants.THIRD_WINNER %></label>
								<div class="col-md-8">
									<input type="text" id="winner3" name="<%=SemsConstants.WINNER_3 %>" class="form-control" placeholder="Name of Player/Team" value="<%if(eventToEdit.getWinner3() != null && !eventToEdit.getWinner3().isEmpty()) { %><%=eventToEdit.getWinner3()%><%} %>">
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