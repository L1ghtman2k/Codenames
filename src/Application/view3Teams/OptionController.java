package Application.view3Teams;


import java.io.IOException;

import Code3Teams.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class OptionController {
	@FXML
	TextField GridSize;
	@FXML
	TextField RedTeamMembers;
	@FXML
	TextField BlueTeamMembers;
	@FXML
	TextField GreenTeamMembers;
	@FXML
	TextField Assassins;
	
	@FXML
	TextField RedTeamName;
	@FXML
	TextField BlueTeamName;
	@FXML
	TextField GreenTeamName;

	@FXML
	Label GridSizeWarning;
	@FXML
	Label RedTeamMembersWarning;
	@FXML
	Label BlueTeamMembersWarning;
	@FXML
	Label GreenTeamMembersWarning;
	
	@FXML
	Label AssassinsWarning;
	@FXML
	Label RedTeamNameWarning;
	@FXML
	Label BlueTeamNameWarning;
	@FXML
	Label GreenTeamNameWarning;

	@FXML
	Label AdditionalWarning;

	@FXML
	Button Start;
	
	boolean[] checker = new boolean[8];
	/**
	 * This method is responsible for setting appropriate parameters for a default game,
	 * 5 by 5 Grid
	 * 9 Reds, 8 blues, 1 assassin, and 7 bystanders
	 */
	public void DefaultOption() {
		GridSize.setDisable(true);
		GridSize.setText("5");
		lebel_accepted(GridSizeWarning);
		checker[0] = true;
		
		RedTeamMembers.setDisable(true);
		RedTeamMembers.setText("6");
		lebel_accepted(RedTeamMembersWarning);
		checker[1] = true;
		
		BlueTeamMembers.setDisable(true);
		BlueTeamMembers.setText("5");
		lebel_accepted(BlueTeamMembersWarning);
		checker[2] = true;
		
		GreenTeamMembers.setDisable(true);
		GreenTeamMembers.setText("5");
		lebel_accepted(GreenTeamMembersWarning);
		checker[3] = true;
		
		Assassins.setDisable(true);
		Assassins.setText("2");
		lebel_accepted(AssassinsWarning);
		checker[4] = true;
	}
	
	/**
	 * This method is responsible for setting appropriate parameters for a custome game,
	 * Which is leaving blank spaces for user to enter
	 */
	public void CostumeOption() {
		
		
		RedTeamName.setText("Reds");
		lebel_accepted(RedTeamNameWarning);
		checker[5] = true;
		
		BlueTeamName.setText("Blues");
		lebel_accepted(BlueTeamNameWarning);
		checker[6] = true;
		
		GreenTeamName.setText("Greens");
		lebel_accepted(GreenTeamNameWarning);
		checker[7] = true;
	}
	
	/**
	 * This method is a Collection of all possible checks
	 */
	public void MainFieldCheck() {
		GridFieldInputCheck();
		RedTeamMembersInputCheck();
		BlueTeamMembersInputCheck();
		AssassinsInputCheck();
		RedTeamNameInputCheck();
		BlueTeamNameInputCheck();
		GreenTeamMembersInputCheck();
		GreenTeamNameInputCheck();
	}
	/**
	 * This method checks weather or not gridSize contains an appropriate inputs
	 * which is a number in a range from 3 to 10
	 */
	public void GridFieldInputCheck() {

		if (GridSize.getText().matches("[0-9]+") && GridSize.getText().length()<3 && Integer.parseInt(GridSize.getText())>=3 && Integer.parseInt(GridSize.getText())<=10) {
			lebel_accepted(GridSizeWarning);
			checker[0] = true;
		}
		else {
			GridSizeWarning.setGraphic(null);
			GridSizeWarning.setText("This field must contain a number from 3 to 10");
			checker[0] = false;
		}
	}
	/**
	 * This method checks weather or not Red Team member field contains an appropriate inputs
	 * which has to be a number of a reasonable length more than 0
	 */
	public void RedTeamMembersInputCheck() {

		if (RedTeamMembers.getText().matches("[0-9]+") && RedTeamMembers.getText().length()<4 && Integer.parseInt(RedTeamMembers.getText())>0) {
			lebel_accepted(RedTeamMembersWarning);
			checker[1] = true;
		}
		else {
			RedTeamMembersWarning.setGraphic(null);
			RedTeamMembersWarning.setText("This field must contain a number that is reasonable" );
			checker[1] = false;
		}
		
	}
	/**
	 * This method checks weather or not Blue Team member field contains an appropriate inputs
	 * which has to be a number of a reasonable length more than 0
	 */
	public void BlueTeamMembersInputCheck() {

		if (BlueTeamMembers.getText().matches("[0-9]+") && BlueTeamMembers.getText().length()<4 && Integer.parseInt(BlueTeamMembers.getText())>0) {
			lebel_accepted(BlueTeamMembersWarning);
			checker[2] = true;
		}
		else {
			BlueTeamMembersWarning.setGraphic(null);
			BlueTeamMembersWarning.setText("This field must contain a number that is reasonable");
			checker[2] = false;
		}
		
	}
	
	/**
	 * This method checks weather or not Green Team member field contains an appropriate inputs
	 * which has to be a number of a reasonable length more than 0
	 */
	public void GreenTeamMembersInputCheck() {

		if (GreenTeamMembers.getText().matches("[0-9]+") && GreenTeamMembers.getText().length()<4 && Integer.parseInt(GreenTeamMembers.getText())>0) {
			lebel_accepted(GreenTeamMembersWarning);
			checker[3] = true;
		}
		else {
			GreenTeamMembersWarning.setGraphic(null);
			GreenTeamMembersWarning.setText("This field must contain a number that is reasonable");
			checker[3] = false;
		}
		
	}
	
	/**
	 * This method checks weather or not Assassins Input field contains an appropriate inputs
	 * which has to be a number of a reasonable length more or equal to 0
	 */
	public void AssassinsInputCheck() {

		if (Assassins.getText().matches("[0-9]+") && Assassins.getText().length()<4 && Integer.parseInt(Assassins.getText())>=0) {
			lebel_accepted(AssassinsWarning);
			checker[4] = true;
		}
		else {
			AssassinsWarning.setGraphic(null);
			AssassinsWarning.setText("This field must contain a number that is reasonable");
			checker[4] = false;
		}
	}
	/**
	 * This method checks weather or not Red Team Name field contains an appropriate inputs
	 * which has to be a String of a reasonable length more or equal to 0
	 */
	public void RedTeamNameInputCheck() {

		if (RedTeamName.getText().trim().length()>0 && RedTeamName.getText().length()<=20) {
			lebel_accepted(RedTeamNameWarning);
			checker[5] = true;
		}
		else {
			RedTeamNameWarning.setGraphic(null);
			RedTeamNameWarning.setText("This field must be less than 20 characters");
			checker[5] = false;
		}
	}
	/**
	 * This method checks weather or not Blue Team Name field contains an appropriate inputs
	 * which has to be a String of a reasonable length more or equal to 0
	 */
	public void BlueTeamNameInputCheck() {

		if (BlueTeamName.getText().trim().length()>0 && BlueTeamName.getText().length()<=20) {
			lebel_accepted(BlueTeamNameWarning);
			checker[6] = true;
		}
		else {
			BlueTeamNameWarning.setGraphic(null);
			BlueTeamNameWarning.setText("This field must be less than 20 characters");
			checker[6] = false;
		}
	}
	
	/**
	 * This method checks weather or not Blue Team Name field contains an appropriate inputs
	 * which has to be a String of a reasonable length more or equal to 0
	 */
	public void GreenTeamNameInputCheck() {

		if (GreenTeamName.getText().trim().length()>0 && GreenTeamName.getText().length()<=20) {
			lebel_accepted(GreenTeamNameWarning);
			checker[7] = true;
		}
		else {
			GreenTeamNameWarning.setGraphic(null);
			GreenTeamNameWarning.setText("This field must be less than 20 characters");
			checker[7] = false;
		}
	}
	/**
	 * This method returns an image of a check mark and sets it an appropriate size of 25 by 25 pixels
	 * @return image created
	 */
	public ImageView image_creator() {
		ImageView image = new ImageView(new Image("Media/check-mark.png"));
		image.setFitWidth(25);
		image.setFitHeight(25);
		return image;
	}
	/**
	 * This method sets a label to an image, and deles a warning text
	 * @param label
	 */
	public void lebel_accepted(Label label) {
		label.setText("");
		label.setGraphic(image_creator());
	}
	
	/**
	 * This method is called when continue button is pressed
	 * It creates a new Board if all the requirements are satisfied and there are no
	 * violations of grid size and members relation
	 * @throws IOException if loader of a new board fails
	 */
	public void StartTheGame() throws IOException {
		boolean overall = true;
		
		for(int i = 0; i < checker.length; i++) {
			if(checker[i]==false) {
				overall = false;
				break;
			}
		}
		if(overall==false) {
			AdditionalWarning.setText("Please satisfy all of the requirements above");
		}
		else if((Integer.parseInt(Assassins.getText()) + Integer.parseInt(BlueTeamMembers.getText()) + Integer.parseInt(RedTeamMembers.getText()) + Integer.parseInt(GreenTeamMembers.getText()))> Math.pow(Integer.parseInt(GridSize.getText()),2)){
			AdditionalWarning.setText("You have more roles than your grid can contain.");
		}
		else if(RedTeamName.getText().equals(BlueTeamName.getText()) || RedTeamName.getText().contentEquals(GreenTeamName.getText()) || BlueTeamName.getText().equals(GreenTeamName.getText())) {
			AdditionalWarning.setText("Teams can't have same names");
		}
		else {
			((Stage)Start.getScene().getWindow()).close();
			Stage primaryStage = new Stage();
			primaryStage.setTitle("Board");
			primaryStage.getIcons().add(new Image("Media/logo.png"));
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GameModeController.class.getResource("Board.fxml"));
			BorderPane mainLayout = loader.load();
			Scene scene = new Scene(mainLayout);	
			primaryStage.setScene(scene);
			BoardController controller = (BoardController)loader.getController();
			
			controller.setBoard(new Launcher().StartTheGame(Integer.parseInt(GridSize.getText()), Integer.parseInt(RedTeamMembers.getText()), 
					Integer.parseInt(BlueTeamMembers.getText()),Integer.parseInt(GreenTeamMembers.getText()) ,Integer.parseInt(Assassins.getText()), RedTeamName.getText(), BlueTeamName.getText(),GreenTeamName.getText()));
			controller.RedSpyMasterTerm();
			primaryStage.setOnCloseRequest(e->System.exit(0));
			 
			primaryStage.show();
		}
		
		
	}

}
