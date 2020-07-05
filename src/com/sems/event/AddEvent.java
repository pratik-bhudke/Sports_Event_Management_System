package com.sems.event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sems.database.DBOperations;
import com.sems.model.Event;
import com.sems.model.User;
import com.sems.util.SemsConstants;

/**
 * Servlet implementation class AddEvent
 */
@WebServlet(description = "Add submitted event to the list of events.", urlPatterns = { "/addEvent" })
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event submittedEvent = new Event();
		submittedEvent.setName(request.getParameter(SemsConstants.NAME));
		submittedEvent.setDescription(request.getParameter(SemsConstants.DESCRIPTION));
		submittedEvent.setEventGender(request.getParameter(SemsConstants.GENDER));
		submittedEvent.setCanRegister(true);
		
		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute(SemsConstants.LOGGED_IN_USER);
		submittedEvent.setCreatedBy(loggedInUser.getName());
		
		DBOperations.insertEvent(submittedEvent);
		
		response.sendRedirect(SemsConstants.LOGIN_SERVLET);
		
	}

}
