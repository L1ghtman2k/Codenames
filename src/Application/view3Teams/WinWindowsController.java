package Application.view3Teams;

import java.io.IOException;

import Code3Teams.Team;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WinWindowsController {
	@FXML
	Label CongratulationsLabel;
	@FXML
	Button StartNewGameButton;
	@FXML
	Button CloseButton;
	/**
	 * This method is responsible for setting Congratulations Label with appropriate team
	 * @param team whose name is showed in a label
	 */
	public void setTeam(Team team)
	{
		CongratulationsLabel.setText("Congratulation "+team.getTeamName()+"!!");	
	}
	/**
	 * This method is responsible for starting a new game by initializing new GameMode window
	 * @throws IOException if loader fails to load
	 */
	public void Start_New_Game() throws IOException {
		// TO BE OPTIMIZED
		((Stage)CloseButton.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Mode");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WinWindowsController.class.getResource("../TeamChooser.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	/**
	 * This method closes everything when called
	 */
	public void close() {
		System.exit(0);
	}

}
