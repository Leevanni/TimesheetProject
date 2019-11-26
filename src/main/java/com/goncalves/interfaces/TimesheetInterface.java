package com.goncalves.interfaces;

import java.util.LinkedList;

import com.goncalves.classes.Timesheet;

public interface TimesheetInterface {

	Timesheet saveTimesheet(Timesheet timesheet);
	LinkedList<Timesheet> findTimesheets(int userId);
	void updateTimesheet(Timesheet timesheet);
	void deleteTimesheet(int timesheetId);
}
