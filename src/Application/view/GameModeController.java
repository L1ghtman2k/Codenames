package Application.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameModeController {
	@FXML
	Button DefaultStart;
	
	@FXML
	Button CostumeStart;
	
	OptionController controller;
	
	public void ChooseParametrsDefault() throws IOException {
		ChooseParametrsCostume();
		controller.DefaultOption();
	}
	
	
	public void ChooseParametrsCostume() throws IOException{
		((Stage)DefaultStart.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Option Window");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("Option.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		controller = (OptionController)loader.getController();
		controller.CostumeOption();
	}

}
