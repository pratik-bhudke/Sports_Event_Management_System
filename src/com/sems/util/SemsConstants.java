package com.sems.util;

public class SemsConstants {
	
	/**
	 * Headings
	 */
	public static final String SYSTEM_TITLE 								= "Sports Event Management System (SEMS)";
	public static final String LOGIN 										= "Login";
	public static final String REGISTER 									= "Register";
	public static final String ADD_SPORT_EVENT								= "Add Sport Event";
	public static final String EDIT_SPORT_EVENT								= "Edit Sport Event";
	
	/**
	 * Database
	 */
	//Connection
	private static final String JDBC_MYSQL_PROTOCOL 						= "jdbc:mysql://";
	private static final String HOST 										= "localhost";
	private static final String DB 											= "sems";
	private static final String DB_USERNAME 								= "root";
	private static final String DB_PASSWORD 								= "";
	//Query
	private static final String USER_EQUALS 								= "user=";
	private static final String PASSWORD_EQUALS 							= "password=";
	private static final String SLASH 										= "/";
	public static final String QUESTION 									= "?";
	private static final String AND 										= "&";
	public static final String EQUAL 										= "=";
	//URL
	public static final String DATABASE_URL 								= 	JDBC_MYSQL_PROTOCOL + HOST + SLASH + DB + 
																				QUESTION + USER_EQUALS + DB_USERNAME + 
																				AND + PASSWORD_EQUALS + DB_PASSWORD;
	
	/**
	 * Database Fields
	 */
	//User Table
	public static final String USER_ID 										= "userId";
	public static final String NAME 										= "name";
	public static final String USER_TYPE 									= "usertype";
	public static final String GENDER 										= "gender";
	public static final String PASSWORD 									= "password";
	//Event Table
	public static final String ID 											= "id";
	public static final String DESCRIPTION 									= "description";
	public static final String CAN_REGISTER 								= "canRegister";
	public static final String CREATED_BY 									= "createdBy";
	public static final String EVENT_GENDER 								= "eventGender";
	public static final String WINNER_1 									= "winner1";
	public static final String WINNER_2 									= "winner2";
	public static final String WINNER_3 									= "winner3";
	public static final String TIMESTAMP 									= "timestamp";
	//Registrations Table
	public static final String NOTES 										= "notes";
	
	/**
	 * Form Fields
	 */
	//index.jsp: Login Form
	public static final String FORM_LOGIN_ID 								= "Login Id";
	public static final String FORM_PASSWORD 								= "Password";
	public static final String FORM_SUBMIT 									= "Submit";
	//index.jsp: Register Form
	public static final String FORM_STUDENT_ID 								= "Student Id";
	public static final String FORM_STUDENT_NAME 							= "Student Name";
	public static final String FORM_GENDER 									= "Gender";
	public static final String FORM_CONFIRM_PASSWORD 						= "Confirm Password";
	//student.jsp Form
	public static final String EVENT_DESCRIPTION 							= "Event Description";
	public static final String EVENT_FOR 									= "Event for";
	public static final String POST_CREATOR 								= "Post Creator";
	//displayWinner.jsp
	public static final String FIRST_WINNER 								= "1st Winner";
	public static final String SECOND_WINNER 								= "2nd Winner";
	public static final String THIRD_WINNER 								= "3rd Winner";
	//menu.jsp
	public static final String FORM_ALL_EVENTS 								= "All Events";
	public static final String ADD_EVENT 									= "Add Event";
	public static final String SIGN_OUT 									= "Sign Out";
	//addEvent.jsp
	public static final String EVENT_NAME 									= "Event Name";
	public static final String GENDER_MALE 									= "Male";
	public static final String GENDER_FEMALE								= "Female";
	public static final String GENDER_BOTH 									= "Both";
	//register.jsp
	public static final String FORM_NOTES 									= "Notes";
	//viewRegistration.jsp
	public static final String FORM_SR_NO 									= "Sr. No.";
	
	/**
	 * Buttons
	 */
	public static final String CANCEL_REGISTRATION_BUTTON 					= "Cancel Registration";
	public static final String REGISTRATIONS_CLOSED_BUTTON 					= "Registrations Closed";
	public static final String CANNOT_APPLY_BUTTON 							= "Cannot Apply";
	public static final String VIEW_REGISTRATIONS_BUTTON 					= "View Registrations";
	public static final String EDIT_EVENT_BUTTON 							= "Edit Event";
	public static final String CLOSE_REGISTRATIONS_BUTTON 					= "Close Registrations";
	public static final String OPEN_REGISTRATIONS_BUTTON 					= "Open Registrations";
	public static final String DELETE_EVENT_BUTTON 							= "Delete Event";
	
	/**
	 * Servlet Constants
	 */
	//Login Servlet
	public static final String ADMIN 										= "admin";
	public static final String LOGGED_IN_USER 								= "loggedInUser";
	public static final String EVENTS_REGISTERED 							= "eventsRegistered";
	public static final String LOGIN_ID 									= "loginId";
	public static final String LOGIN_PASSWORD 								= "loginPassword";
	public static final String ALL_EVENTS 									= "allEvents";
	//Register Servlet
	public static final String EVENT_TO_REGISTER 							= "eventToRegister";
	//ViewRegistration Servlet
	public static final String EVENT_TO_VIEW 								= "eventToView";
	public static final String REGISTERED_USERS 							= "registeredUsers";
	//ManageRegistration Servlet
	public static final String OPEN 										= "OPEN";
	public static final String CLOSE 										= "CLOSE";
	public static final String STATE 										= "state";
	//EditEvent Servlet
	public static final String EVENT_TO_EDIT 								= "eventToEdit";
	//RegisterUser Servlet
	public static final String STUDENT_ID 									= "studentId";
	public static final String STUDENT_NAME									= "studentName";
	public static final String STUDENT 										= "student";
	
	/**
	 * Class Constants
	 */
	public static final String TIMESTAMP_FORMAT 							= "yyyyMMddhhmmss";
	
	/**
	 * JSP URLs
	 */
	public static final String ROOT_PATH 									= "./";
	public static final String ADMIN_JSP_PATH 								= "./admin.jsp";
	public static final String STUDENT_JSP_PATH 							= "./student.jsp";
	public static final String REGISTER_JSP_PATH 							= "./register.jsp";
	public static final String VIEW_REGISTRATION_JSP_PATH 					= "./viewRegistration.jsp";
	public static final String EDIT_EVENT_JSP_PATH 							= "./editEvent.jsp";
	public static final String ADD_EVENT_JSP_PATH 							= "./addEvent.jsp";
	
	/**
	 * Servlet URLs
	 */
	public static final String LOGIN_SERVLET 								= "./login";
	public static final String REGISTER_SERVLET 							= "./register";
	public static final String VIEW_REGISTRATION_SERVLET 					= "./viewRegistration";
	public static final String MANAGE_REGISTRATION_SERVLET 					= "./manageRegistration";
	public static final String DELETE_EVENT_SERVLET							= "./deleteEvent";
	public static final String ADD_EVENT_SERVLET							= "./addEvent";
	public static final String UPDATE_EVENT_SERVLET							= "./updateEvent";
	public static final String REGISTER_USER_SERVLET 						= "./registerUser";
}
