package application;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
	private static String username;
	private static String password;
	private static  Connection conn;
			
			
	public static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laravel", username, password);
				System.out.println("Connected to SQL server successfully");
			} catch (Exception ex) {
				System.out.println("Failed to connect !!!");
				System.out.println("Error: " + ex.getMessage());
				return null;
			}
		}
		return conn;
	}
	
	public static void setUsername(String newUsername) {
		username = newUsername;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void setPassword(String newPassword) {
		password = newPassword;
	}
	
	
	
	
}
