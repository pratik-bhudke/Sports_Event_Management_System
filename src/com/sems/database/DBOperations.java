package com.sems.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.sems.model.Event;
import com.sems.model.User;
import com.sems.util.SemsConstants;

public class DBOperations {
	
	public static ResultSet executeSelect(String query) {
		try {
			return getConnection().createStatement().executeQuery(query);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}		
		return null;
	}
	
	public static boolean insertUser(User user) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getInsertUserQuery());
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getUserType());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getPassword());
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean insertEvent(Event event) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getInsertEventQuery());
			ps.setString(1, event.getName());
			ps.setString(2, event.getDescription());
			ps.setString(3, event.getCanRegister().toString());
			ps.setString(4, event.getCreatedBy());
			ps.setString(5, event.getEventGender());
			ps.setString(6, event.getWinner1());
			ps.setString(7, event.getWinner2());
			ps.setString(8, event.getWinner3());
			ps.setString(9, new SimpleDateFormat(SemsConstants.TIMESTAMP_FORMAT).format(Calendar.getInstance().getTime()));
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean updateEvent(Event event) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getUpdateEventQuery());
			ps.setString(1, event.getName());
			ps.setString(2, event.getDescription());
			ps.setString(3, event.getCanRegister().toString());
			ps.setString(4, event.getCreatedBy());
			ps.setString(5, event.getEventGender());
			ps.setString(6, event.getWinner1());
			ps.setString(7, event.getWinner2());
			ps.setString(8, event.getWinner3());
			ps.setString(9, event.getId());
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean registerForEvent(String eventId, String userId, String notes) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getRegisterForEventQuery());
			ps.setString(1, eventId);
			ps.setString(2, userId);
			ps.setString(3, notes);
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean cancelRegistration(String eventId, String userId) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getCancelRegistrationQuery());
			ps.setString(1, eventId);
			ps.setString(2, userId);
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean closeRegistration(String eventId) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getCloseRegistrationQuery());
			ps.setString(1, eventId);
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean openRegistration(String eventId) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(getOpenRegistrationQuery());
			ps.setString(1, eventId);
			return ps.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static boolean deleteEvent(String eventId) {
		try {
			PreparedStatement ps1 = getConnection().prepareStatement(getDeleteRegistrationQuery());
			ps1.setString(1, eventId);
			ps1.execute();
			PreparedStatement ps2 = getConnection().prepareStatement(getDeleteEventQuery());
			ps2.setString(1, eventId);
			return ps2.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static Event getEventFromResultSet(ResultSet rs) {
		try{
			if(rs.next()) {
				Event event = new Event();
				event.setId(rs.getString(SemsConstants.ID));
				event.setName(rs.getString(SemsConstants.NAME));
				event.setDescription(rs.getString(SemsConstants.DESCRIPTION));
				event.setCanRegister(Boolean.parseBoolean(rs.getString(SemsConstants.CAN_REGISTER)));
				event.setCreatedBy(rs.getString(SemsConstants.CREATED_BY));
				event.setEventGender(rs.getString(SemsConstants.EVENT_GENDER));
				event.setWinner1(rs.getString(SemsConstants.WINNER_1));
				event.setWinner2(rs.getString(SemsConstants.WINNER_2));
				event.setWinner3(rs.getString(SemsConstants.WINNER_3));
				return event;
			} else {
				return null;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<Event> getAllEventsFromResultSet(ResultSet rs) {
		try {
			ArrayList<Event> allEvents = new ArrayList<>();
			while(rs.next()) {
				Event event = new Event();
				event.setId(rs.getString(SemsConstants.ID));
				event.setName(rs.getString(SemsConstants.NAME));
				event.setDescription(rs.getString(SemsConstants.DESCRIPTION));
				event.setCanRegister(Boolean.parseBoolean(rs.getString(SemsConstants.CAN_REGISTER)));
				event.setCreatedBy(rs.getString(SemsConstants.CREATED_BY));
				event.setEventGender(rs.getString(SemsConstants.EVENT_GENDER));
				event.setWinner1(rs.getString(SemsConstants.WINNER_1));
				event.setWinner2(rs.getString(SemsConstants.WINNER_2));
				event.setWinner3(rs.getString(SemsConstants.WINNER_3));
				allEvents.add(event);
			}
			return allEvents;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static User getUserFromResultSet(ResultSet rs) {
		try {
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString(SemsConstants.USER_ID));
				user.setName(rs.getString(SemsConstants.NAME));
				user.setUserType(rs.getString(SemsConstants.USER_TYPE));
				user.setGender(rs.getString(SemsConstants.GENDER));
				user.setPassword(rs.getString(SemsConstants.PASSWORD));
				return user;
			} else {
				return null;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<String> getAllRegisteredEventsFromResultSet(ResultSet rs) {
		try {
			ArrayList<String> registeredEvents = new ArrayList<>();
			while(rs.next()) {
				registeredEvents.add(rs.getString(SemsConstants.ID));
			}
			return registeredEvents;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static ArrayList<User> getAllRegisteredUsersFromResultSet(ResultSet rs) {
		try {
			ArrayList<User> registeredUsers = new ArrayList<>();
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getString(SemsConstants.USER_ID));
				user.setName(rs.getString(SemsConstants.NAME));
				user.setGender(rs.getString(SemsConstants.GENDER));
				user.setNotes(rs.getString(SemsConstants.NOTES));
				registeredUsers.add(user);
			}
			return registeredUsers;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private static Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con = DriverManager.getConnection(SemsConstants.DATABASE_URL);
			return con;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	private static String getInsertUserQuery() {
		return	"INSERT INTO `user`(`userId`, `name`, `userType`, `gender`, `password`) " +
				"VALUES (?,?,?,?,?)";
	}
	
	private static String getInsertEventQuery() {
		return	"INSERT INTO `event`(`name`, `description`, `canRegister`, `createdBy`, `eventGender`, `winner1`, `winner2`, `winner3`, `timestamp`) " +
				"VALUES (?,?,?,?,?,?,?,?,?)";
	}
	
	public static String getSelectEventQuery(String eventId) {
		return	"SELECT * FROM `event` WHERE `id` = '" + eventId + "'";
	}
	
	public static String getSelectAllEventsQuery() {
		return "SELECT * FROM `event` ORDER BY `timestamp` DESC";
	}
	
	public static String getSelectAllRegisteredEventsQuery(String userId) {
		return "SELECT `id` FROM `registrations` WHERE `userId`='" + userId + "'";
	}
	
	public static String getSelectAllRegisteredUsersQuery(String eventId) {
		return	"SELECT `user`.`userId`, `user`.`name`, `user`.`gender`, `registrations`.`notes` " +
				"FROM `registrations` " +
				"LEFT JOIN `user` ON `user`.`userId` = `registrations`.`userId` " +
				"WHERE `registrations`.`id` = '" + eventId + "'";
		
	}
	
	private static String getUpdateEventQuery() {
		return	"UPDATE `event` " +
				"SET `name`=?,`description`=?,`canRegister`=?,`createdBy`=?,`eventGender`=?,`winner1`=?,`winner2`=?,`winner3`=? " +
				"WHERE `id`=?";
	}
	
	private static String getRegisterForEventQuery() {
		return "INSERT INTO `registrations`(`id`, `userId`, `notes`) VALUES (?,?,?)";
	}
	
	private static String getCancelRegistrationQuery() {
		return "DELETE FROM `registrations` WHERE `id`=? AND `userId`=?";
	}
	
	private static String getCloseRegistrationQuery() {
		return "UPDATE `event` SET `canRegister`='false' WHERE `id`=?";
	}
	
	private static String getOpenRegistrationQuery() {
		return "UPDATE `event` SET `canRegister`='true' WHERE `id`=?";
	}
	
	private static String getDeleteRegistrationQuery() {
		return "DELETE FROM `registrations` WHERE `id`=?";
	}
	
	private static String getDeleteEventQuery() {
		return "DELETE FROM `event` WHERE `id`=?";
	}
	
	public static String getUserQuery(String userId) {
		return "SELECT * FROM `user` WHERE `userId` = '" + userId + "'";
	}
	

}
