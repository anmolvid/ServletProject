package com.bridgeit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dbutli.MysqlDBUtli;
import com.bridgeit.model.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setEmail(username);
		user.setPassword(password);
		try {
			boolean result = MysqlDBUtli.login(user);
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("name", username);
				RequestDispatcher rd = request.getRequestDispatcher("/Logout.html");
				rd.forward(request, response);
			} else { // System.out.println(" Error!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
