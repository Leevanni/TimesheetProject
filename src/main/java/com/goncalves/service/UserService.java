package com.goncalves.service;

import com.goncalves.classes.UserDOA;
import com.goncalves.classes.User;

public class UserService {
	UserDOA userDOA = new UserDOA();
	
	// Login logic
	public User validateLogin(String username, String password) {
		if(userDOA.getUsernameAndPassword(username, password) == null) {
			return null;
		}
		else {
			return userDOA.getUserInfo(username);
		}
	}
	
	
	public User getUserInformation(String username) {
		return userDOA.getUserInfo(username);
	}
	

}
