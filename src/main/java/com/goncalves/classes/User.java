package com.goncalves.classes;

import java.util.LinkedList;

public class User {
	private int userId;					// Id of the user
	private String userFirstName;		// User's first name
	private String userLastName;		// User's last name
	private String username;			// User's username
	private String userPassword;		// User's password
	private String jobTitle;			// User's job title
	LinkedList<Timesheet> timesheets;	// Each user's timesheets
	
	public User() {
		super();
	}
	
	public User(int userID, String firstname, String lastname, String username, String password, String jobtitle) {
		this.userId = userID;
		this.userFirstName = firstname;
		this.userLastName = lastname;
		this.username = username;
		this.userPassword = password;
		this.jobTitle = jobtitle;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.userPassword = password;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setJobTitle(String jobtitle) {
		this.jobTitle = jobtitle;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", username=" + username + ", userPassword=" + userPassword + "]";
	}
}
