package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController {
	
	 @FXML
    private Button goToInventoryPage;

    @FXML
    private Button goToSearchPage;

    @FXML
    private Button gotToStockLevelsPage;

    @FXML
    private Text loggedInUsername;
	
	public void setLoggedInUsername(String username) {
		this.loggedInUsername.setText(username);
	}
	
	
	public void openSearchPage(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
		Parent root = (Parent) loader.load();
		
		SearchController searchController = loader.getController();
		searchController.searchBooks();
		
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void openUserManagementPage(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("users.fxml"));
		Parent root = (Parent) loader.load();
		
		UsersController usersController = loader.getController();
		usersController.searchUsers();
		
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
