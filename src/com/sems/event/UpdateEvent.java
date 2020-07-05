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
 * Servlet implementation class UpdateEvent
 */
@WebServlet("/updateEvent")
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Event eventToEdit = (Event) request.getSession().getAttribute(SemsConstants.EVENT_TO_EDIT);
		eventToEdit.setName(request.getParameter(SemsConstants.NAME));
		eventToEdit.setDescription(request.getParameter(SemsConstants.DESCRIPTION));
		eventToEdit.setEventGender(request.getParameter(SemsConstants.GENDER));
		eventToEdit.setCanRegister(true);
		eventToEdit.setWinner1(request.getParameter(SemsConstants.WINNER_1));
		eventToEdit.setWinner2(request.getParameter(SemsConstants.WINNER_2));
		eventToEdit.setWinner3(request.getParameter(SemsConstants.WINNER_3));

		DBOperations.updateEvent(eventToEdit);
		
		response.sendRedirect(SemsConstants.LOGIN_SERVLET);
	}
}
