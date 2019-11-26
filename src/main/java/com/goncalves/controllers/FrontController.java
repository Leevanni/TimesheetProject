package com.goncalves.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goncalves.controllers.TimesheetController;
import com.goncalves.controllers.UserController;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TimesheetController timesheetController = new TimesheetController();
	private UserController userController = new UserController();
       
    protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		switch (uri) {
		case "/timeSheet/api/timesheet":
			if (req.getMethod().equals("POST")) {
				timesheetController.postTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				timesheetController.putTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timesheetController.getTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				timesheetController.deleteTimesheet(req, resp);
				return;
			}
			
		case "/timeSheet/api/user":
			if (req.getMethod().equals("PUT")) {
				timesheetController.putTimesheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timesheetController.getTimesheet(req, resp);
				return;
			}

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Front Controller Initialized!");
	}

}
