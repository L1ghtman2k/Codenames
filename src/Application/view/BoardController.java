package Application.view;
import java.io.IOException;
import Code.Board;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
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
	@FXML
	Separator separator;

	private Board board;

	private Term term;

	public void RedSpyMasterTerm() throws IOException {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Term Change Warning");
		alert.setHeaderText("Warning");
		alert.setContentText("It is now RedSpyMaster's Move");
		alert.showAndWait();
		
		Clue.setVisible(false);
		Count.setVisible(false);
		separator.setVisible(false);
		ContinueButton.setVisible(false);
		term = Term.RedSpyMaster;
		
		addButtonsSpyMaster();
		initializeSpyMastersDialog();
	}
	
	public void RedTeamTerm() {
		((Stage)ContinueButton.getScene().getWindow()).hide();
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Term Change Warning");
		alert.setHeaderText("Warning");
		alert.setContentText("It is now Red Team's Move");
		alert.showAndWait();
		((Stage)ContinueButton.getScene().getWindow()).show();
		Clue.setVisible(true);
		Count.setVisible(true);
		separator.setVisible(true);
		ContinueButton.setVisible(true);
		term = Term.RedTeam;
		
		
	}
	public void BlueSpyMasterTerm() {
		term = Term.BlueSpyMaster;
	}
	
	public void BlueTeamTerm() {
		term = Term.BlueTeam;
	}

	public void setBoard(Board board) {
		this.board = board;
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
	}
	

	public void addButtonsSpyMaster(){
		
		int x = board.getGrid().length;
		removeRowsAndColumns();
		for (int i = 0; i < x ; i++) {
			for (int j = 0; j <  x; j++) {	
				String str=board.getGrid()[i][j].getPerson().getRole().toString();
				if(!board.getGrid()[i][j].isRevealed()) {
					str+="\n" + board.getGrid()[i][j].getCodename();
				}
				Button button = new Button(str);
				button.setStyle("-fx-font-size: 15pt;");
				button.setPrefSize(400, 200);
				button.textAlignmentProperty().set(TextAlignment.CENTER);
				Grid.add(button, j, i);
			}
		}
		
	}
	public void removeRowsAndColumns() {
		Grid.getChildren().clear();
		while(Grid.getRowConstraints().size() > 0){
			Grid.getRowConstraints().remove(0);

		}

		while(Grid.getColumnConstraints().size() > 0){
			Grid.getColumnConstraints().remove(0);
		}
	}
	
	public void close() {
		System.exit(0);
	}
	
	public void Start_New_Game() throws IOException {
		// TO BE OPTIMIZED
		((Stage)ContinueButton.getScene().getWindow()).close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Board");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void initializeSpyMastersDialog() throws IOException {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("SpyMaster's Input");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("SpyMasterInput.fxml"));
		BorderPane mainLayout = loader.load();
		((SpyMasterInputController)loader.getController()).set_BoardController(this);
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setX(0);
		primaryStage.setY(0);
		primaryStage.setOnCloseRequest(e->close());
		primaryStage.setAlwaysOnTop(true);
	}
	public Board getBoard() {
		return board;
	}
	
	public Term getTerm() {
		return term;
	}
	public void setClue(String str) {
		Clue.setText(str);
	}
	public void setCount(String str) {
		Count.setText(str);
	}
	
}
