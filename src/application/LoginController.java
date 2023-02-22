package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;

public class LoginController {
	@FXML
	private TextField loginUsername;
	@FXML
	private TextField loginPassword;
	@FXML
	private ImageView loginLogo;
	@FXML
	private Button loginButton;
	
	@FXML 
	public void login(ActionEvent event) {
		try {
			System.out.println("Trying to login!!!!!!!!");
			System.out.println(event.toString());
			
			String username = loginUsername.getText();
			String password = loginPassword.getText();
			
			System.out.println(String.format("Details are: %s  and %s ", username, password));
			establishDatabaseConnection(username, password);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Connection establishDatabaseConnection(String username, String password) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laravel", username, password);
			System.out.println("Connected to SQL server successfully");
			return conn;
		} catch (Exception ex) {
			System.out.println("Failed to connect !!!");
			System.out.println("Error: " + ex.getMessage());
			return null;
		}
	}
}
