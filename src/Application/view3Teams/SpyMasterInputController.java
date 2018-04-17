package Application.view3Teams;

import Code3Teams.Roles;
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
	/**
	 * This method returns clueField TextField
	 * @return ClueField
	 */
	public TextField getClueField() {
		return ClueField;
	}
	/**
	 * This method returns CountField TextField
	 * @return CountField
	 */
	public TextField CountField() {
		return CountField;
	}
	/**
	 * This method sets a board parameter Board Controller
	 * @param board that is being set
	 */
	public void set_BoardController(BoardController board) {
		this.board = board;
	}
	/**
	 * This method is called when Continue Button is pressed, it checks if inputs a proper
	 * and Changes labels if count or a clue are not properly entered
	 */
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
				board.BlueTeamTerm();
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
