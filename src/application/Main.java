package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("application/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			// Setting Stage display details
			Image icon = new Image("application/assets/images/rr-icon.png");
			primaryStage.setTitle("Readers Republic Inventory System");
			primaryStage.getIcons().add(icon);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
