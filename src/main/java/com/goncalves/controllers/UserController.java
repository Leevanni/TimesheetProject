package com.goncalves.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goncalves.service.UserService;

public class UserController {
	UserService userService = new UserService();
	
	
	// GET /chinook/api/artist?id=1
	public void putArtist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("username") != null && req.getParameter("password") != null) {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(userService.validateLogin(req.getParameter("name"), req.getParameter("password"))));
		} else {
			resp.sendRedirect("/timeSheet/api/user");
		}
	}

}
