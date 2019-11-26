package com.goncalves.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goncalves.classes.Timesheet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goncalves.service.TimesheetService;

public class TimesheetController {
	TimesheetService timesheetservice = new TimesheetService();
	
	public void postTimesheet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				timesheetservice.save(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class))));
		// headers
		resp.setStatus(201);
	}
	
	public void getTimesheet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("id") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetservice.findAll(Integer.parseInt(req.getParameter("id")))));
		}
		else {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetservice.findAll(Integer.parseInt(req.getParameter("id")))));
		}
		resp.setStatus(201);
	}
	
	public void putTimesheet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetservice.update(new ObjectMapper().readValue(req.getInputStream(), Timesheet.class));
		resp.setStatus(204);
		
		
	}
	
	public void deleteTimesheet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		timesheetservice.delete(Integer.parseInt(req.getParameter("id")));
		resp.setStatus(204);
		
	}
	
	

}
