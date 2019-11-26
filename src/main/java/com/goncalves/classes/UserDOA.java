package com.goncalves.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.goncalves.classes.User;

public class UserDOA {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://mysql.coufvtggbhlb.us-east-2.rds.amazonaws.com:3306/timesheet_database";
			String username = "admin";
			String password = "adminadmin";
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	
	public User getUsernameAndPassword(String username,String password) {
		boolean errorThrown = false;
		User user;
		Connection conn = getConnection();
		try {
			String sql = "select username, userpassword from timesheet_database.user_table where username=? and userpassword=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			user = new User(rs.getString(1), rs.getString(2));

			return user;
		}catch(SQLException e) {
			errorThrown = true;
			throw new RuntimeException();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new RuntimeException();
			}
			
			// Return null if the username given was not in the database
			if(errorThrown) {
				return null;
			}
		}
	}
	
	
	/*
	 * Tested and ran successfully
	 */
	public User getUserInfo(String username) {
		Connection conn = getConnection();
		try {
			String sql = "select * from timesheet_database.user_table where username=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			return user;
		}catch(SQLException e) {
			throw new RuntimeException();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		
	}
}
