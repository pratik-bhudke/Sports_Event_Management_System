package com.sems.model;

public class Event {
	private String	id;
	private String	name;
	private String	description;
	private Boolean	canRegister;
	private String	createdBy;
	private String	eventGender;
	private String	winner1;
	private String	winner2;
	private String	winner3;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the canRegister
	 */
	public Boolean getCanRegister() {
		return canRegister;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @return the winner1
	 */
	public String getWinner1() {
		return winner1;
	}
	/**
	 * @return the winner2
	 */
	public String getWinner2() {
		return winner2;
	}
	/**
	 * @return the winner3
	 */
	public String getWinner3() {
		return winner3;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param canRegister the canRegister to set
	 */
	public void setCanRegister(Boolean canRegister) {
		this.canRegister = canRegister;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @param winner1 the winner1 to set
	 */
	public void setWinner1(String winner1) {
		this.winner1 = winner1;
	}
	/**
	 * @param winner2 the winner2 to set
	 */
	public void setWinner2(String winner2) {
		this.winner2 = winner2;
	}
	/**
	 * @param winner3 the winner3 to set
	 */
	public void setWinner3(String winner3) {
		this.winner3 = winner3;
	}
	/**
	 * @return the eventGender
	 */
	public String getEventGender() {
		return eventGender;
	}
	/**
	 * @param eventGender the eventGender to set
	 */
	public void setEventGender(String eventGender) {
		this.eventGender = eventGender;
	}
}
