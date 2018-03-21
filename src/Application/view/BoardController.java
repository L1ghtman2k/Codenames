package Application.view;

import Code.Board;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
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

	public void RedSpyMasterTerm() {
		Clue.setVisible(false);
		Count.setVisible(false);
		separator.setVisible(false);
		addButtons();

		term = Term.RedSpyMaster;
	}

	public void BlueSpyMasterTerm() {
		term = Term.BlueSpyMaster;
	}
	public void RedTeamTerm() {
		term = Term.RedTeam;
	}
	public void BlueTeamTerm() {
		term = Term.BlueTeam;
	}

	public void setBoard(Board board) {
		this.board = board;
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
	}

	public void addButtons(){
		
		int x = board.getGrid().length;
		removeRowsAndColumns();
		for (int i = 0; i < x ; i++) {
			for (int j = 0; j <  x; j++) {	
				Button button = new Button(board.getGrid()[i][j].getCodename() + "\n" + board.getGrid()[i][j].getPerson().getRole().toString());
				button.setStyle("-fx-font-size: 15pt;-fx-pref-width: 400px;-fx-pref-height: 400px;");
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
}
