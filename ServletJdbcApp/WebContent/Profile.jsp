<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bridgeit.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ProfileJsp</title>
</head>
<body>
	<%
		User user = new User();
		if (session.getAttribute("user1") == null) {
			response.sendRedirect("index.html");
		} else {
			user = (User) (session.getAttribute("user1"));
		}
		String sessionID = null;
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user1"))
					userName = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("index.html");
	%>
	<h3>
		Hi
		<%=userName%>, Login successful.<br>Your Session ID=<%=sessionID%></h3>
	<br> User Details: First Name:
	<%=user.getFirstname()%><br> Last Name:
	<%=user.getLastname()%><br> Contact:
	<%=user.getContactno()%><br>

	<a href="edit.jsp">Edit--></a>

</body>
</html>


