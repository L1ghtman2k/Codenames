package Application.view;

import Code.Roles;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SpyMasterInputController {
	@FXML 
	TextField ClueField;

	@FXML 
	TextField CountField;

	@FXML 
	Label AlertLabel;

	@FXML 
	Button Continuebtn;

	BoardController board;
	public TextField getClueField() {
		return ClueField;
	}

	public TextField CountField() {
		return CountField;
	}

	public void set_BoardController(BoardController board) {
		this.board = board;
	}

	public void EnterAClueAndCount() {
		boolean clue =false;
		boolean count =false;
		if(board.getBoard().isClueLegal(ClueField.getText())) {
			clue = true;
		}
		if(board.getTerm() == Term.RedSpyMaster && CountField.getText().matches("[0-9]+") && CountField.getLength()<5 && board.getBoard().isCountLegal(Integer.parseInt(CountField.getText()), Roles.Red)) {
			count = true;
		}
		else if(board.getTerm() == Term.BlueSpyMaster && CountField.getText().matches("[0-9]+") && CountField.getLength()<5 && board.getBoard().isCountLegal(Integer.parseInt(CountField.getText()), Roles.Blue)) {
			count = true;
		}
		if(count && clue) {
			((Stage)Continuebtn.getScene().getWindow()).hide();
			if(board.getTerm() == Term.RedSpyMaster)
			{
				board.RedTeamTerm();
			}
			else {
				board.RedTeamTerm();
			}
			board.setCount(CountField.getText());
			board.setClue(ClueField.getText());
			((Stage)Continuebtn.getScene().getWindow()).close();

		}
		else if(!clue) {
			AlertLabel.setText("Please enter a proper clue");
		}
		else if(!count) {
			AlertLabel.setText("Please enter a proper count");
		}
	}
}
