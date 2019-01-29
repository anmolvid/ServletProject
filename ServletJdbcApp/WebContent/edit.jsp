<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bridgeit.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
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

%>
<form method="post", action="edit">

		<h1>
			<center>Register</center>
		</h1>
		<p>Please fill in this form to create an account.</p>


		<div>
			<label for="firstname"><b>Firstname</b></label>
			 <input type="text"
				placeholder="Enter Firstname" name="firstname">
		</div>

		<label for="lastname"><b>Lastname</b></label> <input type="text"
			placeholder="Enter Lastname" name="lastname">

		<div>

		<label for="contactno"><b>Contact Number</b></label> <input
			type="text" placeholder="Enter Contact Number" name="contactno">

		<div>

			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password">
		</div>

		</div>


		<input type="submit" value="Save"></input>
		<input type="submit" value="Back"></input>

		</div>
	</form>
</body>
</html>