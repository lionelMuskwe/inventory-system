package application;

import java.io.IOException;
import java.sql.Connection;
//import application.SceneController;
import java.sql.DriverManager;
import application.StaticStrings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import application.DashboardController;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	private Text errorMessage;
	
	@FXML 
	public void login(ActionEvent event) {
		try {
			System.out.println("Trying to login!!!!!!!!");
			System.out.println(event.toString());
			
//			String username = loginUsername.getText();
//			String password = loginPassword.getText();
			
			String username = "root";
			String password = "";
			
			System.out.println(String.format("Details are: %s  and %s ", username, password));
			if (establishDatabaseConnection(username, password) != null) {				
				System.out.println("Switching to Dashboard !");
				switchSceneToDashboard(event, username);
			} else {
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				System.out.println(StaticStrings.checkInternetConnection);
				errorMessage.setText(StaticStrings.checkInternetConnection);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void switchSceneToDashboard(ActionEvent event, String username) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
		Parent root = (Parent) loader.load();
		
		DashboardController dashBoardController = loader.getController();
		dashBoardController.setLoggedInUsername(username);
		
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public Connection establishDatabaseConnection(String username, String password) {
		
		DatabaseConnection.setUsername(username);
		DatabaseConnection.setPassword(password);
		return DatabaseConnection.getInstance();
	}
}
