package com.bridgeit.servlet;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.dbutli.MysqlDBUtli;
import com.bridgeit.model.User;

public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
		
			try {
				MysqlDBUtli.registration(user);
			} catch (ClassNotFoundException e) {
		
				e.printStackTrace();
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		

	}
}
