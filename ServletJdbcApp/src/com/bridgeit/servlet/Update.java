package com.bridgeit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgeit.dbutli.MysqlDBUtli;
import com.bridgeit.model.User;

public class Update extends HttpServlet{
   
    private static final long serialVersionUID = 1L;
   
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        int updatedUser = 0;
        HttpSession session=request.getSession(false);
        RequestDispatcher requestDispatcher=null;
        user =(User)session.getAttribute("name");
        user = getUser(request, user);
       
        try {
            updatedUser=MysqlDBUtli.edit(user);
            if(updatedUser>0) {
            requestDispatcher=request.getRequestDispatcher("/Profile.jsp");
            requestDispatcher.forward(request, response);
            }else {
                requestDispatcher=request.getRequestDispatcher("/edit.jsp");
                requestDispatcher.include(request, response);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
   
    }

    private User getUser(HttpServletRequest request, User user) {
        user.setFirstname(request.getParameter("firstName"));
        user.setLastname(request.getParameter("lastName"));
        user.setContactno(Long.parseLong(request.getParameter("contact")));
        user.setEmail(user.getEmail());
        return user;
    }

}


