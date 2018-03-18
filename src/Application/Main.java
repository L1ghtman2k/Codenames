package Application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Board");
		primaryStage.getIcons().add(new Image("images/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Board.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
