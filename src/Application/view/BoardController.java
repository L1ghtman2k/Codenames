package Application.view;
import java.io.IOException;
import Code.Board;
import Code.Roles;
import Code.Team;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.util.Pair;
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
		SpyMasterWindowInitializer(Term.RedSpyMaster, "Red SpyMaster");
	}

	public void BlueSpyMasterTerm() throws IOException {
		SpyMasterWindowInitializer(Term.BlueSpyMaster, "Blue SpyMaster");
	}
	
	public void RedTeamTerm() {
		TeamWindowInitializer(Term.RedTeam, "Red Team");
	}
	public void BlueTeamTerm() {
		TeamWindowInitializer(Term.BlueTeam, "Blue Team");
	}
	public void SpyMasterWindowInitializer(Term term, String move) throws IOException {
		this.term = term;
		((Stage)ContinueButton.getScene().getWindow()).hide();
		alertInitializer(move);
		Grid.setDisable(false);
		Clue.setVisible(false);
		Count.setVisible(false);
		separator.setVisible(false);
		ContinueButton.setVisible(false);
		addButtonsSpyMaster();
		initializeSpyMastersDialog();
		((Stage)ContinueButton.getScene().getWindow()).show();
	}
	
	public void TeamWindowInitializer(Term term, String move) {
		this.term = term;
		((Stage)ContinueButton.getScene().getWindow()).hide();
		alertInitializer(move);
		Grid.setDisable(false);
		Clue.setVisible(true);
		Count.setVisible(true);
		separator.setVisible(true);
		ContinueButton.setVisible(true);
		addButtonsTeam();
		((Stage)ContinueButton.getScene().getWindow()).show();
	}
	
	public void alertInitializer(String move) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Term Change Warning");
		alert.setHeaderText("Warning");
		alert.setContentText("It is now "+move+"'s Move");
		alert.showAndWait();
	}
	

	public void setBoard(Board board) {
		this.board = board;
		board.LocationAssignerAndRedMove("GameWords1.txt");
	}
	public void addButtonsSpyMaster(){
		int x = board.getGrid().length;
		removeRowsAndColumns();
		for (int i = 0; i < x ; i++) {
			for (int j = 0; j <  x; j++) {	
				boolean revealed = board.getGrid()[i][j].isRevealed();
				String str = "";
				if(!revealed) {
					str+=board.getGrid()[i][j].getCodename() +"\n";
				}
				str+=board.getGrid()[i][j].getPerson().getRole().toString();
				Button button = new Button(str);
				if(revealed && board.getGrid()[i][j].getPerson().getRole() == Roles.Red) {
					button.setText(button.getText()+"\n"+"Revealed");
					button.setStyle("-fx-font-size: 15pt; -fx-text-fill: red");
				}
				else if(revealed && board.getGrid()[i][j].getPerson().getRole() == Roles.Blue) {
					button.setText(button.getText()+"\n"+"Revealed");
					button.setStyle("-fx-font-size: 15pt; -fx-text-fill: Blue");
				}
				else if(revealed) {
					button.setText(button.getText()+"\n"+"Revealed");
					button.setStyle("-fx-font-size: 15pt; -fx-text-fill: Green");
				}
				else {
					button.setStyle("-fx-font-size: 15pt;");
				}
				button.setPrefSize(400, 200);
				button.textAlignmentProperty().set(TextAlignment.CENTER);
				Grid.add(button, j, i);
			}
		}

	}
	public void addButtonsTeam(){
		int x = board.getGrid().length;
		removeRowsAndColumns();
		for (int i = 0; i < x ; i++) {
			for (int j = 0; j <  x; j++) {	
				String str = "";
				str+=board.getGrid()[i][j].getCodename() /* +"\n"*/;
				if(board.getGrid()[i][j].isRevealed())
					str=board.getGrid()[i][j].getPerson().getRole().toString();
					//str+=board.getGrid()[i][j].getPerson().getRole().toString();
				Button button = new Button(str);
				button.setStyle("-fx-font-size: 15pt;");
				button.setPrefSize(400, 200);
				button.textAlignmentProperty().set(TextAlignment.CENTER);
				Pair<Integer,Integer> pair = new Pair<>(i,j);
				button.setUserData(pair);
				if(board.getGrid()[i][j].isRevealed()) {
					button.setDisable(true);
				}
				else {
					handlerAssigner(button);
				}
				Grid.add(button, j, i);
			}
		}
	}
	public void handlerAssigner(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Button internalButton = (Button)e.getSource();
				Pair<Integer,Integer> internalpair= (Pair<Integer, Integer>)(((Button)e.getSource()).getUserData());
				int internalI = internalpair.getKey();
				int internalJ = internalpair.getValue();
				Team curentTeam = null;
				if(term == Term.RedTeam)
					curentTeam = board.getRedTeam();
				if(term == Term.BlueTeam)
					curentTeam = board.getBlueTeam();
				boolean bool = board.LocationStatusUpdater(board.getGrid()[internalI][internalJ].getCodename(), curentTeam);
				internalButton.setText(/*board.getGrid()[internalI][internalJ].getCodename() +"\n" + */board.getGrid()[internalI][internalJ].getPerson().getRole().toString());

				if(bool == true) {
					String str = Integer.toString(Integer.parseInt(Count.getText())-1);
					Count.setText(str);
					if(str.equals("-1")) {
						Grid.setDisable(true);
						Count.setVisible(false);
					}
					internalButton.setDisable(true);
				}
				else{
					Grid.setDisable(true);
					Count.setVisible(false);
				}

			}
		});
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
		primaryStage.setResizable(false);
		primaryStage.setAlwaysOnTop(true);
	}

	public void initializeWinningState(Team team) throws IOException {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("You Win!");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("WinWindow.fxml"));



		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);

		((WinWindowsController)loader.getController()).setTeam(team);

		((Stage)ContinueButton.getScene().getWindow()).close();
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public void nextTerm() throws IOException {
		boolean winningState = board.isBoardInWinningState();
		if(winningState) {
			if(board.isAssassinRevealed()) {
				if(term == Term.RedTeam) {
					initializeWinningState(board.getBlueTeam());
				}
				else {
					initializeWinningState(board.getRedTeam());
				}
			}
			else if(term == Term.RedTeam) {
				initializeWinningState(board.getRedTeam());
			}
			else {
				initializeWinningState(board.getBlueTeam());
			}
		}

		else {
			if(term == Term.RedTeam) {
				BlueSpyMasterTerm();
			}
			else if(term == Term.BlueTeam) {
				RedSpyMasterTerm();
			}
		}
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
