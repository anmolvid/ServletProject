package com.bridgeit.dbutli;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.bridgeit.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlDBUtli {
	
	 public static Connection getMySQLConnection() throws SQLException,
     ClassNotFoundException {
 String hostName = "localhost";

 String dbName = "ServletProject";
 String userName = "root";
 String password = "password";

 return getMySQLConnection(hostName, dbName, userName, password);
}

public static Connection getMySQLConnection(String hostName, String dbName,
     String userName, String password) throws SQLException,
     ClassNotFoundException {
 
 Class.forName("com.mysql.jdbc.Driver");

 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

 Connection conn = DriverManager.getConnection(connectionURL, userName,
         password);
 
 return conn;
}

	public static void registration(User user) throws ClassNotFoundException, SQLException {
		String query="insert into User values(?,?,?,?,?,?)";
		Connection connection = getMySQLConnection();
	   PreparedStatement preparedStatement=connection.prepareStatement(query);
	   preparedStatement.setInt(1, 0);
	   preparedStatement.setString(2, user.getFirstname());
	   preparedStatement.setString(3, user.getLastname());
	   preparedStatement.setLong(4, user.getContactno());
	   preparedStatement.setString(5, user.getEmail());
	   preparedStatement.setString(6, user.getPassword());
	   preparedStatement.execute();
	   connection.close();
	}
		public static boolean login(User user) throws ClassNotFoundException, SQLException {
			String query2="select * from User where email=? and password=?";
			Connection connection=getMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(query2);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			while( resultSet.next()){
				return true;
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
			return false;
				
			
			
		            
		        
			
			
			
			
			
			
			
			
			
			
			
		} 
	}


