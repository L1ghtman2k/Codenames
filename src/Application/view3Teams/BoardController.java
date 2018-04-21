package Application.view3Teams;
import java.io.IOException;

import Application.view3Teams.Term;
import Code3Teams.Board;
import Code3Teams.Roles;
import Code3Teams.Team;
import javafx.application.Platform;
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
import javafx.scene.control.ScrollPane;
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
	ScrollPane separator;

	/**
	 * This method calls EasterEgg_Initializers before the game starts, so that running it later
	 * wouldn't cause any troubles
	 * @throws IOException if EasterEgg_Initializer fails
	 */
	@FXML
	public void initialize() throws IOException {
		EasterEgg_Initializer();
	}

	private Board board;

	private Term term;

	private Stage SpyStage;

	private Stage EggStage;

	private FXMLLoader EggLoader;

	/**
	 * calls RedSpyMasterTerm with parameters Term.RedSpyMaster, "Red SpyMaster"
	 * @throws IOException if SpyMasterWindowInitializer fails
	 */
	public void RedSpyMasterTerm() throws IOException {
		if(board.getRedTeam().isRevealedAssassin()) {
			BlueSpyMasterTerm();
		}
		else {SpyMasterWindowInitializer(Term.RedSpyMaster, "Red SpyMaster");}
	}
	/**
	 * calls BlueSpyMasterTerm with parameters Term.BlueSpyMaster, "Blue SpyMaster"
	 * @throws IOException if SpyMasterWindowInitializer fails
	 */
	public void BlueSpyMasterTerm() throws IOException {
		if(board.getBlueTeam().isRevealedAssassin()) {
			GreenSpyMasterTerm();
		}
		else {SpyMasterWindowInitializer(Term.BlueSpyMaster, "Blue SpyMaster");}
	}
	/**
	 * calls GreenSpyMasterTerm with parameters Term.BlueSpyMaster, "Green SpyMaster"
	 * @throws IOException if SpyMasterWindowInitializer fails
	 */
	public void GreenSpyMasterTerm() throws IOException {
		if(board.getGreenTeam().isRevealedAssassin()) {
			RedSpyMasterTerm();
		}
		else {SpyMasterWindowInitializer(Term.GreenSpyMaster, "Green SpyMaster");}
	}
	/**
	 * Calls TeamWindowInitializer with parameters Term.RedTeam and "Red Team"
	 */
	public void RedTeamTerm() {
		TeamWindowInitializer(Term.RedTeam, "Red Team");
	}
	/**
	 * Calls TeamWindowInitializer with parameters Term.BlueTeam and "Blue Team"
	 */
	public void BlueTeamTerm() {
		TeamWindowInitializer(Term.BlueTeam, "Blue Team");
	}

	/**
	 * Calls TeamWindowInitializer with parameters Term.GreenTeam and "Green Team"
	 */
	public void GreenTeamTerm() {
		TeamWindowInitializer(Term.GreenTeam, "Green Team");
	}
	/**
	 * This method sets board for spymaster, creates an allert
	 * Makes Grid interactive, makes clue, count separator, continue button invisible.
	 * calls addButtonsSpyMaster, and initialize spymaster dialogue by calling initializeSpyMasterDialog
	 * 
	 * @param term Enum which represents the term
	 * @param team String that represents the team
	 * @throws IOException if initializeSpyMastersDialog fails
	 */
	public void SpyMasterWindowInitializer(Term term, String team) throws IOException {
		this.term = term;
		((Stage)ContinueButton.getScene().getWindow()).hide();
		alertInitializer(team);
		Grid.setDisable(false);
		Clue.setVisible(false);
		Count.setVisible(false);
		separator.setVisible(false);
		ContinueButton.setVisible(false);
		addButtonsSpyMaster();
		initializeSpyMastersDialog();
		((Stage)ContinueButton.getScene().getWindow()).show();
	}
	/**
	 * Initialized window for the team, calls alertInitializer,
	 * Sets Grid to be disabled, makes clue, count, separator, continue button visible,
	 * calls addButtonsTeam method
	 * @param term Enum which represents the term
	 * @param team String that represents the team
	 */
	public void TeamWindowInitializer(Term term, String team) {
		this.term = term;
		((Stage)ContinueButton.getScene().getWindow()).hide();
		alertInitializer(team);
		Grid.setDisable(false);
		Clue.setVisible(true);
		Count.setVisible(true);
		separator.setVisible(true);
		ContinueButton.setVisible(true);
		addButtonsTeam();
		((Stage)ContinueButton.getScene().getWindow()).show();
	}

	/**
	 * This method is responsible for creating a warning window 
	 * indicating which player's move it is
	 * @param player indicates an upcoming player
	 */
	private void alertInitializer(String player) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Term Change Warning");
		alert.setHeaderText("Warning");
		alert.setContentText("It is now "+player+"'s Move");
		alert.showAndWait();
	}


	/**
	 * This method is responsible for creating SpyMaster's Board
	 * which has buttons that include information on weather or not the button
	 * is revealed, the codename of a button, and for a player on a button
	 */
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
				else if(revealed && board.getGrid()[i][j].getPerson().getRole() == Roles.Green) {
					button.setText(button.getText()+"\n"+"Revealed");
					button.setStyle("-fx-font-size: 15pt; -fx-text-fill: Green");
				}
				else if(revealed) {
					button.setText(button.getText()+"\n"+"Revealed");
					button.setStyle("-fx-font-size: 15pt; -fx-text-fill: Yellow");
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
	/**
	 * This method is responsible for assigning actions to the buttons,
	 * setting proper sizes and styles, putting them into board, 
	 * creating an internal data for the button,
	 * and also responsible for naming them.
	 * 
	 * Adds internal information to the button
	 */
	private void addButtonsTeam(){
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
	/**
	 * This method takes internal parameters of a button and
	 * is responsible for assigning actions if the button is pressed
	 * Assassin case: blends the stage, ends term, creates a new window
	 * Same Team case: blends the button, continues to play if enough clues are left
	 * Different Team case: blends the stage, ends the term, waits for preceding of a term
	 * Bystander case: blends the stage, ends the term, waits for preceding of a term
	 * @param button the button which is being pressed
	 */
	private void handlerAssigner(Button button) {
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
				if(term == Term.GreenTeam)
					curentTeam = board.getGreenTeam();
				boolean bool = board.LocationStatusUpdater(board.getGrid()[internalI][internalJ].getCodename(), curentTeam);
				internalButton.setText(/*board.getGrid()[internalI][internalJ].getCodename() +"\n" + */board.getGrid()[internalI][internalJ].getPerson().getRole().toString());
				
				if(bool == true && !board.isBoardInWinningState()) {
					String str = Integer.toString(Integer.parseInt(Count.getText())-1);
					Count.setText(str);
					if(str.equals("-1") ) {
						Grid.setDisable(true);
						Count.setVisible(false);
					}
					internalButton.setDisable(true);
				}

				else {
					if(board.getGrid()[internalI][internalJ].getPerson().getRole() == Roles.Assassin) {
						asyncServiceMethod();
						curentTeam.setRevealedAssassin(true);
					}

					Grid.setDisable(true);
					Count.setVisible(false);
				}
			}
		});
	}
	/**
	 * This method is responsible for clearing out rows and columns when 
	 * terms shift from spymaster to a team.
	 */
	private void removeRowsAndColumns() {
		Grid.getChildren().clear();
		while(Grid.getRowConstraints().size() > 0){
			Grid.getRowConstraints().remove(0);
		}

		while(Grid.getColumnConstraints().size() > 0){
			Grid.getColumnConstraints().remove(0);
		}
	}
	/**
	 * This Method is responsible for closing an application
	 */
	public void close() {
		System.exit(0);
	}
	/**
	 * This method starts a new game when New Game Button is pressed from a menu
	 * @throws IOException when fails to load a proper layout
	 */
	public void Start_New_Game2() throws IOException {
		// TO BE OPTIMIZED
		((Stage)ContinueButton.getScene().getWindow()).close();
		SpyStage.close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Mode");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("../view2Teams/GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * This method starts a new game when New Game Button is pressed from a menu
	 * @throws IOException when fails to load a proper layout
	 */
	public void Start_New_Game3() throws IOException {
		// TO BE OPTIMIZED
		((Stage)ContinueButton.getScene().getWindow()).close();
		SpyStage.close();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Mode");
		primaryStage.getIcons().add(new Image("Media/logo.png"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GameModeController.class.getResource("GameMode.fxml"));
		BorderPane mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);	
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * Initializes Spy master dialogue window where spymaster can put proper values
	 * for clue and count fields
	 * @throws IOException when fails to load borderpane for the spymaster window
	 */
	public void initializeSpyMastersDialog() throws IOException {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("SpyMaster's Input");
		SpyStage = primaryStage;
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
	/**
	 * Initializes a final Winning window with a name of a parameter team
	 * @param team is a team whose winning state is initialized
	 * @throws IOException when fails to load BorderPane
	 */
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

	/**
	 * This method is responsible for deciding weather or net stage will 
	 * continue the game in a proper flow, or end it. Read Diagram.pdf for more. 
	 * And is called when contue button is pressed
	 * @throws IOException in case any State initializers fail
	 */
	public void nextTerm() throws IOException {
		
		if(board.isBoardInWinningState()) {
			if(board.isAssassinRevealed()==2) {
				if(!board.getBlueTeam().isRevealedAssassin()) {			
					initializeWinningState(board.getBlueTeam());
				}
				else if(!board.getRedTeam().isRevealedAssassin()) {
					initializeWinningState(board.getRedTeam());
				}
				else {
					initializeWinningState(board.getGreenTeam());
				}
			}
			else if(board.Winning_Team().getAgents() == Roles.Red ) {
				initializeWinningState(board.getRedTeam());
			}
			else if(board.Winning_Team().getAgents() == Roles.Blue){
				initializeWinningState(board.getBlueTeam());
			}
			else if(board.Winning_Team().getAgents() == Roles.Green){
				initializeWinningState(board.getGreenTeam());
			}
		}

		else {
			if(term == Term.RedTeam) {
				BlueSpyMasterTerm();
			}
			else if(term == Term.BlueTeam) {
				GreenSpyMasterTerm();
			}
			else if(term == Term.GreenTeam) {
				RedSpyMasterTerm();
			}
		}
	}


	/**
	 * This method asynchronously runs EasterEgg Initializer so that it wouldn't
	 * interfere with updates of fields
	 */
	private void asyncServiceMethod(){ 
		Platform.runLater(() -> {
			((EasterEggController)EggLoader.getController()).slower();
			EggStage.show();
		});
	}
	/**
	 * This method initialized window of Easter Egg
	 * @throws IOException in case EggLoader doesn't provide a proper Anchor Pane.
	 */

	private void EasterEgg_Initializer() throws IOException {
		EggStage = new Stage();
		EggStage.setTitle("Easter Egg");
		EggStage.getIcons().add(new Image("Media/logo.png"));
		EggLoader = new FXMLLoader();
		EggLoader.setLocation(GameModeController.class.getResource("EasterEgg.fxml"));
		AnchorPane mainLayout = EggLoader.load();
		Scene scene = new Scene(mainLayout);	
		EggStage.setScene(scene);
		EggStage.setResizable(false);
		((EasterEggController)EggLoader.getController()).image_activator();

	}

	/**
	 * This method returns main board class
	 * @return board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * This method returns term of a current team
	 * @return current team
	 */
	public Term getTerm() {
		return term;
	}
	/**
	 * This method sets Clue field
	 * @param str is a string to which clue field is equal to
	 */
	public void setClue(String str) {
		Clue.setText("Clue: "+str);
	}

	/**
	 * This method allows to set text of a Count Field
	 * @param str is a value to which Count field is set to
	 */
	public void setCount(String str) {
		Count.setText(str);
	}

	/**
	 * This method is responsible for providing a GameWords1 txt file to location 
	 * assigner method, in addition it sets the board
	 * @param board is a board that is being assigned to a main board
	 */
	public void setBoard(Board board) {
		this.board = board;
		board.LocationAssignerAndRedMove("GameWords1.txt");
	}


}
