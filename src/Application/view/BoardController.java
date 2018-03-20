package Application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuItem;
public class BoardController {
	
	@FXML
    BorderPane MainBorderPane;
	@FXML
    Label Clue;
	@FXML
    Label Count;
	@FXML
    Button ContinueButton;
	@FXML
    AnchorPane MainAnchor;
	@FXML
	MenuBar MainMenuBar;
	@FXML
	MenuItem StartNewGameItem;
	@FXML
	MenuItem CloseItem;
	@FXML
	GridPane Grid;
	

}
