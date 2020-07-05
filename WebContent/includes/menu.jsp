<div class="row">
	<div class="col-md-10">
		<a href="#" class="h2">
			<%=SemsConstants.SYSTEM_TITLE %>
		</a>
	</div>
	<div class="col-md-2">
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=loggedInUser.getName() %>  <span class="fa fa-user pull-right"></span>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="<%=SemsConstants.LOGIN_SERVLET %>">All Events <span class="badge pull-right"><%=allEvents.size() %></span></a>
					</li>
					<li class="divider"></li>
					<%if(loggedInUser.getUserType().equalsIgnoreCase(SemsConstants.ADMIN)) { %>
					<li>
						<a href="<%=SemsConstants.ADD_EVENT_JSP_PATH %>"><%=SemsConstants.ADD_EVENT %><span class="fa fa-plus pull-right"></span></a>
					</li>
					<li class="divider"></li>
					<%} %>
					<li><a href="<%=SemsConstants.ROOT_PATH %>"><%=SemsConstants.SIGN_OUT %><span class="fa fa-sign-out pull-right"></span></a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<hr style="border: 1px solid #337cbb;">