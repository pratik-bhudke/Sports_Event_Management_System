package com.sems.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sems.database.DBOperations;
import com.sems.model.Event;
import com.sems.util.SemsConstants;

/**
 * Servlet implementation class EditEvent
 */
@WebServlet("/editEvent")
public class EditEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event eventToEdit = DBOperations.getEventFromResultSet(DBOperations.executeSelect(DBOperations.getSelectEventQuery(request.getParameter("id"))));
		request.getSession().setAttribute(SemsConstants.EVENT_TO_EDIT, eventToEdit);
		request.getRequestDispatcher(SemsConstants.EDIT_EVENT_JSP_PATH).forward(request, response);
	}
}
