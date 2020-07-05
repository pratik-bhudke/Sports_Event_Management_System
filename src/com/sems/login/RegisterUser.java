package com.sems.login;

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
 * Servlet implementation class RegisterUser
 */
@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userToRegister = new User();
		userToRegister.setUserId(request.getParameter(SemsConstants.STUDENT_ID));
		userToRegister.setName(request.getParameter(SemsConstants.STUDENT_NAME));
		userToRegister.setUserType(SemsConstants.STUDENT);
		userToRegister.setGender(request.getParameter(SemsConstants.GENDER));
		userToRegister.setPassword(request.getParameter(SemsConstants.PASSWORD));
		
		DBOperations.insertUser(userToRegister);
		response.sendRedirect(SemsConstants.ROOT_PATH);
	}

}
