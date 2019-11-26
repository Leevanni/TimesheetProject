package com.goncalves.service;

import com.goncalves.classes.TimesheetDOA;

import java.util.List;

import com.goncalves.classes.Timesheet;

public class TimesheetService {
	private TimesheetDOA timesheetDOA = new TimesheetDOA();
	
	public Timesheet save(Timesheet timesheet) {
		return timesheetDOA.saveTimesheet(timesheet);
	}
	
	public List<Timesheet> findAll(int userID){
		return timesheetDOA.findTimesheets(userID);
		
	}
	
	public void update(Timesheet timesheet) {
		timesheetDOA.updateTimesheet(timesheet);
	}

	public void delete(int timesheetID) {
		timesheetDOA.deleteTimesheet(timesheetID);
	}
}
