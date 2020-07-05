package com.sems.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sems.database.DBOperations;
import com.sems.model.User;
import com.sems.util.SemsConstants;

/**
 * Servlet implementation class CancelRegistration
 */
@WebServlet("/cancelRegistration")
public class CancelRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBOperations.cancelRegistration(request.getParameter(SemsConstants.ID), 
										((User) (request.getSession().getAttribute(SemsConstants.LOGGED_IN_USER))).getUserId());
		response.sendRedirect(SemsConstants.LOGIN_SERVLET);
	}
}
