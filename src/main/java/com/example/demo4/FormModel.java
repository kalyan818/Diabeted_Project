package com.example.demo4;

import java.sql.Time;

public class FormModel {
	
	private String UserName;
	private String Date;
	private String TimeBefore;
	private String BloodLevelBefore;
	private String TimeAfter;
	private String BloodLevelAfter;
	private String Breakfast;
	private String Lunch;
	private String Dinner;
	
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
	@Override
	public String toString() {
		return "FormModel [UserName=" + UserName + ", Date=" + Date + ", TimeBefore=" + TimeBefore
				+ ", BloodLevelBefore=" + BloodLevelBefore + ", TimeAfter=" + TimeAfter + ", BloodLevelAfter="
				+ BloodLevelAfter + ", Breakfast=" + Breakfast + ", Lunch=" + Lunch + ", Dinner=" + Dinner + "]";
	}
	
	
	
	

}
