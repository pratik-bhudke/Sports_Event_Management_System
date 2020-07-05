<%boolean winner = false; %>
<%if(event.getWinner1() != null && !event.getWinner1().isEmpty()) { %>
	<div class="form-group">
		<label for="winner1" class="col-md-3 control-label"><%=SemsConstants.FIRST_WINNER %></label>
		<div class="col-md-8">
			<input type="text" id="winner1" class="form-control" value="<%=event.getWinner1() %>" disabled="disabled">
		</div>
	</div>
<% winner = true;
  } 
%>
<%if(event.getWinner2() != null && !event.getWinner2().isEmpty()) { %>
	<div class="form-group">
		<label for="winner1" class="col-md-3 control-label"><%=SemsConstants.SECOND_WINNER %></label>
		<div class="col-md-8">
			<input type="text" id="winner2" class="form-control" value="<%=event.getWinner2() %>" disabled="disabled">
		</div>
	</div>
<% winner = true;
  } %>
<%if(event.getWinner3() != null && !event.getWinner3().isEmpty()) { %>
	<div class="form-group">
		<label for="winner1" class="col-md-3 control-label"><%=SemsConstants.THIRD_WINNER %></label>
		<div class="col-md-8">
			<input type="text" id="winner3" class="form-control" value="<%=event.getWinner3() %>" disabled="disabled">
		</div>
	</div>
<% winner = true;
  } %>
<hr>