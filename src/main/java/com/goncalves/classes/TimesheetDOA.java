package com.goncalves.classes;

import java.util.LinkedList;
import com.goncalves.classes.Timesheet;

import com.goncalves.interfaces.TimesheetInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimesheetDOA implements TimesheetInterface {
	
	
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
	
	/*
	 * Tested and ran successfully.
	 */
	@Override
	public Timesheet saveTimesheet(Timesheet timesheet) {
		Connection conn = getConnection();
		
		try{
			String sql = "insert into timesheet_database.timesheet_table(user_id, m_hours, t_hours, w_hours, th_hours, f_hours,timesheet_date)"
					+ " values(?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, timesheet.getUser_id());
			stmt.setInt(2, timesheet.getMondayHours());
			stmt.setInt(3, timesheet.getTuesdayHours());
			stmt.setInt(4, timesheet.getWednesdayHours());
			stmt.setInt(5, timesheet.getThursdayHours());
			stmt.setInt(6, timesheet.getFridayHours());
			stmt.setString(7, timesheet.getDate());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Number of rows affected: " + rowsUpdated);
			ResultSet keys = stmt.getGeneratedKeys();
			while(keys.next()) {
				int timesheetId = keys.getInt(1);
				timesheet.setTimesheetId(timesheetId);
			}
			
		}
		catch(SQLException e) {
			throw new RuntimeException();
		}finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		
		return timesheet;
	}

	/*
	 * Tested and ran successfully.
	 */
	@Override
	public LinkedList<Timesheet> findTimesheets(int userId) {
		Connection conn = getConnection();
		LinkedList<Timesheet> results = new LinkedList<>();
		try {
			String sql = "select * from timesheet_database.timesheet_table where user_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Timesheet t = new Timesheet(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),
				rs.getInt(5), rs.getInt(6),rs.getInt(7), rs.getInt(8),rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12));
				results.add(t);
			}
		}catch(SQLException e) {
			throw new RuntimeException();
		}finally {
			try {
				conn.close();
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
		return results;
	}

	@Override
	public void updateTimesheet(Timesheet timesheet) {
		Connection conn = getConnection();
		try {
			String sql = "update timesheet_database.timesheet_table set m_hours=?, t_hours=?, w_hours=?, "
					+ "th_hours=?, f_hours=?, s_hours=?, su_hours=? where (timesheet_id=?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, timesheet.getMondayHours());
			stmt.setInt(2, timesheet.getTuesdayHours());
			stmt.setInt(3, timesheet.getWednesdayHours());
			stmt.setInt(4, timesheet.getThursdayHours());
			stmt.setInt(5, timesheet.getFridayHours());
			stmt.setInt(6, timesheet.getSaturdayHours());
			stmt.setInt(7, timesheet.getSundayHours());
			stmt.setInt(8, timesheet.getTimesheetId());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println(rowsUpdated);
			
		}catch(SQLException e) {
			System.out.println(e);
			throw new RuntimeException();
		}finally{
			try {
				conn.close();
			}catch(SQLException e) {
				throw new RuntimeException();
			}
		}
	}

	/*
	 * Tested and ran successfully
	 */
	@Override
	public void deleteTimesheet(int timesheetId) {
		Connection conn = getConnection();
		try {
			String sql = "delete from timesheet_database.timesheet_table where timesheet_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, timesheetId);
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Number of rows affected: " + rowsUpdated);
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
