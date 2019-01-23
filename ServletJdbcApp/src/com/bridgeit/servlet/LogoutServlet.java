package com.bridgeit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("You are successfully logged out!");
//		out.close();
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd=request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}
}