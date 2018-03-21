package Application.view;

import java.io.IOException;

import Code.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WinWindowsController {
	@FXML
	Label CongratulationsLabel;
	@FXML
	Button StartNewGameButton;
	@FXML
	Button CloseButton;
	public void setTeam(Team team)
	{
		CongratulationsLabel.setText("Congratulations "+team.getTeamName()+"!!");
	}
	
	public void Start_New_Game() throws IOException {
		// TO BE OPTIMIZED
		((Stage)CloseButton.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Board");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WinWindowsController.class.getResource("GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void close() {
		System.exit(0);
	}

}
