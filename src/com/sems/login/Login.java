package com.sems.login;

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
 * Servlet implementation class Login
 */
@WebServlet(description = "Checks login credentials of user", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(SemsConstants.LOGGED_IN_USER);
		if(user.getUserType().equalsIgnoreCase(SemsConstants.ADMIN)) {
			path = SemsConstants.ADMIN_JSP_PATH;
		} else {
			ArrayList<String> eventsRegistered = DBOperations.getAllRegisteredEventsFromResultSet(DBOperations.executeSelect(DBOperations.getSelectAllRegisteredEventsQuery(user.getUserId())));
			session.setAttribute(SemsConstants.EVENTS_REGISTERED, eventsRegistered);
			path = SemsConstants.STUDENT_JSP_PATH;
		}
		ArrayList<Event> allEvents = DBOperations.getAllEventsFromResultSet(DBOperations.executeSelect(DBOperations.getSelectAllEventsQuery()));
		session.setAttribute(SemsConstants.ALL_EVENTS, allEvents);
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		HttpSession session = request.getSession();
		
		User loggedInUser = new User();
		loggedInUser.setUserId(request.getParameter(SemsConstants.LOGIN_ID));
		loggedInUser.setPassword(request.getParameter(SemsConstants.LOGIN_PASSWORD));
		
		User user = DBOperations.getUserFromResultSet(DBOperations.executeSelect(DBOperations.getUserQuery(loggedInUser.getUserId())));
		if(user != null && loggedInUser.getPassword().equalsIgnoreCase(user.getPassword())) {
			if(user.getUserType().equalsIgnoreCase(SemsConstants.ADMIN)) {
				path = SemsConstants.ADMIN_JSP_PATH;
			} else {
				path = SemsConstants.STUDENT_JSP_PATH;
				ArrayList<String> eventsRegistered = DBOperations.getAllRegisteredEventsFromResultSet(DBOperations.executeSelect(DBOperations.getSelectAllRegisteredEventsQuery(loggedInUser.getUserId())));
				session.setAttribute(SemsConstants.EVENTS_REGISTERED, eventsRegistered);
			}
			ArrayList<Event> allEvents = DBOperations.getAllEventsFromResultSet(DBOperations.executeSelect(DBOperations.getSelectAllEventsQuery()));
			session.setAttribute(SemsConstants.ALL_EVENTS, allEvents);
			session.setAttribute(SemsConstants.LOGGED_IN_USER, user);
		} else {
			path = SemsConstants.ROOT_PATH;
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
