package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
	
		String password = request.getParameter("password");
	
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    if(username.equals("anmol")&&(password.equals("vid01"))){  
	    	HttpSession session=request.getSession(true);
	    	session.setAttribute("name", username);
	        RequestDispatcher rd=request.getRequestDispatcher("/Logout.html");  
	        rd.forward(request, response);  
	    }  
	    else{  
//	        System.out.println(" Error!");  
	        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);  
	                      
	        }   
	}
}
