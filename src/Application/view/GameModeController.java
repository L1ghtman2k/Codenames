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
	Stage MainStage;
	
	/**
	 * This method is responsible for setting next window as Default Game Option Window
	 * @throws IOException
	 */
	public void ChooseParametrsDefault() throws IOException {
		ChooseParametrs();
		controller.DefaultOption();
		MainStage.show();
	}
	
	/**
	 * This method is responsible for setting next window as  Custom Game Option Window
	 * @throws IOException if ChooseParametrs fails to load
	 */
	public void ChooseParametrsCostume() throws IOException {
		ChooseParametrs();
		MainStage.show();
	}
	
	/**
	 * This method is responsible for creating a new Board window that later on will be
	 * costumized by ChooseParametrsCostume or ChooseParametrsDefault
	 * @throws IOException if loader is not avialiable
	 */
	public void ChooseParametrs() throws IOException{
		((Stage)DefaultStart.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		MainStage = primaryStage;
		primaryStage.setTitle("Option Window");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("Option.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		
		primaryStage.setResizable(false);
		controller = (OptionController)loader.getController();
		controller.CostumeOption();
	}

}
