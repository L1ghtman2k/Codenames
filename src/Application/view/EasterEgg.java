package Application.view; 

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EasterEgg {
	
	@FXML
	Button closeButton;
	@FXML
	Button returnButton;
	
	
//	@Override
//	public void start(Stage arg0) throws Exception {
//		// TODO Auto-generated method stub
//		mainStage = arg0;
//		mainStage.setTitle("Easter Egg Found!");
//		closeButton = new Button("Close Window");
//		
//		BorderPane newBox = new BorderPane(closeButton);
//		newBox.getChildren().add(closeButton);
//		Scene scene1 = new Scene(newBox, 300, 250);
//		mainStage.setScene(scene1);
//		
//		Text mainText = new Text("That was a fair game, good job!");
//		VBox secondBox = new VBox(mainText);
//		Scene scene2 = new Scene(secondBox, 300, 250);
//		mainStage.setScene(scene2);
//		
//		
//		mainStage.getIcons().add(new Image("Desktop/Easter_Egg_pic.jpeg"));
//		mainStage.show();
//	
//	}
	
	public void handleCloseButton() {
		System.exit(0);
	}
	
	@FXML
	public void startNewGame() throws IOException {
		((Stage)closeButton.getScene().getWindow()).close();
		Stage mainStage = new Stage();
		mainStage.setTitle("Board");
		mainStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WinWindowsController.class.getResource("GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		mainStage.setScene(scene);
		mainStage.setResizable(false);
		mainStage.show();
		
	}
	
	
}
