package com.sems.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sems.database.DBOperations;
import com.sems.util.SemsConstants;

/**
 * Servlet implementation class ManageRegistration
 */
@WebServlet("/manageRegistration")
public class ManageRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter(SemsConstants.STATE).equalsIgnoreCase(SemsConstants.OPEN)) {
			DBOperations.openRegistration(request.getParameter(SemsConstants.ID));
		} else if(request.getParameter(SemsConstants.STATE).equalsIgnoreCase(SemsConstants.CLOSE)) {
			DBOperations.closeRegistration(request.getParameter(SemsConstants.ID));
		}
		response.sendRedirect(SemsConstants.LOGIN_SERVLET);
	}
}
