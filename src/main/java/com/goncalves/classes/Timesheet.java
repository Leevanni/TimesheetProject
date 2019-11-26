package com.goncalves.classes;

public class Timesheet {
	private int timesheetId;			// Id of the given timesheet
	private int userId;					// The user id of that the timesheet belongs to.
	private int mondayHours;
	private int tuesdayHours;
	private int wednesdayHours;
	private int thursdayHours;
	private int fridayHours;
	private int saturdayHours;
	private int sundayHours;
	private int stateId;				// This will show whether it's "saved" or "not saved"
	private int statusId;				// This will show whether it's been "approved" or "not approved"
	private String timesheetDate;
	
	public Timesheet(int tIid, int userId, int mHours, int tHours, int wHours, int thHours, int fHours,
			int sHours, int suHours, int stateId, int statusId, String date) {
		super();
		this.timesheetId = tIid;
		this.userId = userId;
		this.mondayHours = mHours;
		this.tuesdayHours = tHours;
		this.wednesdayHours = wHours;
		this.thursdayHours = thHours;
		this.fridayHours = fHours;
		this.saturdayHours = sHours;
		this.sundayHours = suHours;
		this.stateId = stateId;
		this.statusId = statusId;
		this.timesheetDate = date;
	}
	
	public Timesheet(int tIid, int mHours, int tHours, int wHours, int thHours, int fHours,
			int sHours, int suHours) {
		super();
		this.timesheetId = tIid;
		this.mondayHours = mHours;
		this.tuesdayHours = tHours;
		this.wednesdayHours = wHours;
		this.thursdayHours = thHours;
		this.fridayHours = fHours;
		this.saturdayHours = sHours;
		this.sundayHours = suHours;
	}
	
	public Timesheet() {
		super();
	}
	
	public int getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}
	

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int userId) {
		this.userId = userId;
	}

	public int getMondayHours() {
		return mondayHours;
	}

	public void setMondayHours(int mondayHours) {
		this.mondayHours = mondayHours;
	}

	public int getTuesdayHours() {
		return tuesdayHours;
	}

	public void setTuesdayHours(int tuesdayHours) {
		this.tuesdayHours = tuesdayHours;
	}

	public int getWednesdayHours() {
		return wednesdayHours;
	}

	public void setWednesdayHours(int wednesdayHours) {
		this.wednesdayHours = wednesdayHours;
	}

	public int getThursdayHours() {
		return thursdayHours;
	}

	public void setThursdayHours(int thursdayHours) {
		this.thursdayHours = thursdayHours;
	}

	public int getFridayHours() {
		return fridayHours;
	}

	public void setFridayHours(int fridayHours) {
		this.fridayHours = fridayHours;
	}

	public int getSaturdayHours() {
		return saturdayHours;
	}

	public void setSaturdayHours(int saturdayHours) {
		this.saturdayHours = saturdayHours;
	}

	public int getSundayHours() {
		return sundayHours;
	}

	public void setSundayHours(int sundayHours) {
		this.sundayHours = sundayHours;
	}
	
	public String getDate() {
		return timesheetDate;
	}

	public void setDate(String date) {
		this.timesheetDate = date;
	}
	
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + timesheetId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timesheet other = (Timesheet) obj;
		if (timesheetId != other.timesheetId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", userId=" + userId + ", mondayHours=" + mondayHours
				+ ", tuesdayHours=" + tuesdayHours + ", wednesdayHours=" + wednesdayHours + ", thursdayHours="
				+ thursdayHours + ", fridayHours=" + fridayHours + ", saturdayHours=" + saturdayHours + ", sundayHours="
				+ sundayHours + ", stateId=" + stateId + ", statusId=" + statusId + ", timesheetDate=" + timesheetDate
				+ "]";
	}
}
