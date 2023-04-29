package com.example.demo4;

import java.sql.Time;

public class FormModel {

	private String UserName; // variable for storing the name of the user who has submitted the form
	private String Date; // variable for storing the date when the form is submitted
	private String TimeBefore; // variable for storing the time when the user took blood sugar level before
								// eating
	private String BloodLevelBefore; // variable for storing the blood sugar level of the user before eating
	private String TimeAfter; // variable for storing the time when the user took blood sugar level after
								// eating
	private String BloodLevelAfter; // variable for storing the blood sugar level of the user after eating
	private String Breakfast; // variable for storing the breakfast details of the user
	private String Lunch; // variable for storing the lunch details of the user
	private String Dinner; // variable for storing the dinner details of the user

	// getter and setter methods for the variables
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getBloodLevelBefore() {
		return BloodLevelBefore;
	}

	public void setBloodLevelBefore(String bloodLevelBefore) {
		BloodLevelBefore = bloodLevelBefore;
	}

	public String getTimeBefore() {
		return TimeBefore;
	}

	public void setTimeBefore(String timeBefore) {
		TimeBefore = timeBefore;
	}

	public String getTimeAfter() {
		return TimeAfter;
	}

	public void setTimeAfter(String timeAfter) {
		TimeAfter = timeAfter;
	}

	public String getBloodLevelAfter() {
		return BloodLevelAfter;
	}

	public void setBloodLevelAfter(String bloodLevelAfter) {
		BloodLevelAfter = bloodLevelAfter;
	}

	public String getBreakfast() {
		return Breakfast;
	}

	public void setBreakfast(String breakfast) {
		Breakfast = breakfast;
	}

	public String getLunch() {
		return Lunch;
	}

	public void setLunch(String lunch) {
		Lunch = lunch;
	}

	public String getDinner() {
		return Dinner;
	}

	public void setDinner(String dinner) {
		Dinner = dinner;
	}

	// toString method to get the string representation of the object
	@Override
	public String toString() {
		return "FormModel [UserName=" + UserName + ", Date=" + Date + ", TimeBefore=" + TimeBefore
				+ ", BloodLevelBefore=" + BloodLevelBefore + ", TimeAfter=" + TimeAfter + ", BloodLevelAfter="
				+ BloodLevelAfter + ", Breakfast=" + Breakfast + ", Lunch=" + Lunch + ", Dinner=" + Dinner + "]";
	}

}
