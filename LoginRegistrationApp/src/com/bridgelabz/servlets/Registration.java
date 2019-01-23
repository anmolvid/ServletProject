package com.bridgelabz.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setFirstname(request.getParameter("firstname"));
		System.out.println(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		System.out.println(request.getParameter("contactno"));
		user.setContactno(Long.parseLong(request.getParameter("contactno")));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

	}
}
