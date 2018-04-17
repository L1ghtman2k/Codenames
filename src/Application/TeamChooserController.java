package Application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TeamChooserController {
	@FXML 
	Button ctn;
	
	public void Team2ChooserController() throws IOException {
		((Stage)ctn.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Mode");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view2Teams/GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public void Team3ChooserController() throws IOException {
		((Stage)ctn.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Mode");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view3Teams/GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
