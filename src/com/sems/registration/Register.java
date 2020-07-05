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
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event eventToRegister = null;
		HttpSession session = request.getSession();
		ArrayList<Event> allEvents = (ArrayList<Event>) session.getAttribute(SemsConstants.ALL_EVENTS);
		
		for(Event event : allEvents) {
			if(event.getId().equalsIgnoreCase(request.getParameter(SemsConstants.ID))) {
				eventToRegister = event;
				break;
			}
		}
		session.setAttribute(SemsConstants.EVENT_TO_REGISTER, eventToRegister);
		request.getRequestDispatcher(SemsConstants.REGISTER_JSP_PATH).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBOperations.registerForEvent(	((Event) (session.getAttribute(SemsConstants.EVENT_TO_REGISTER))).getId(), 
										((User) (session.getAttribute(SemsConstants.LOGGED_IN_USER))).getUserId() , 
										request.getParameter(SemsConstants.NOTES));
		response.sendRedirect(SemsConstants.LOGIN_SERVLET);
	}

}
