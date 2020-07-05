package com.sems.registration;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ViewRegistration
 */
@WebServlet("/viewRegistration")
public class ViewRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event eventToView = null;		
		HttpSession session = request.getSession();
		ArrayList<Event> allEvents = (ArrayList<Event>) session.getAttribute(SemsConstants.ALL_EVENTS);
		for(Event event : allEvents) {
			if(event.getId().equalsIgnoreCase(request.getParameter(SemsConstants.ID))) {
				eventToView = event;
				break;
			}
		}
		ArrayList<User> registeredUsers = DBOperations.getAllRegisteredUsersFromResultSet(
												DBOperations.executeSelect(
													DBOperations.getSelectAllRegisteredUsersQuery(request.getParameter(SemsConstants.ID))));
		
		session.setAttribute(SemsConstants.EVENT_TO_VIEW, eventToView);
		session.setAttribute(SemsConstants.REGISTERED_USERS, registeredUsers);
		request.getRequestDispatcher(SemsConstants.VIEW_REGISTRATION_JSP_PATH).forward(request, response);
	}
}
