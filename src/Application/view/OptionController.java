package Application.view;


import java.io.IOException;

import Code.Launcher;
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
	TextField Assassins;
	@FXML
	TextField RedTeamName;
	@FXML
	TextField BlueTeamName;

	@FXML
	Label GridSizeWarning;
	@FXML
	Label RedTeamMembersWarning;
	@FXML
	Label BlueTeamMembersWarning;
	@FXML
	Label AssassinsWarning;
	@FXML
	Label RedTeamNameWarning;
	@FXML
	Label BlueTeamNameWarning;

	@FXML
	Label AdditionalWarning;

	@FXML
	Button Start;
	
	boolean[] checker = new boolean[6];
	
	public void DefaultOption() {
		GridSize.setDisable(true);
		GridSize.setText("5");
		lebel_accepted(GridSizeWarning);
		checker[0] = true;
		
		RedTeamMembers.setDisable(true);
		RedTeamMembers.setText("9");
		lebel_accepted(RedTeamMembersWarning);
		checker[1] = true;
		
		BlueTeamMembers.setDisable(true);
		BlueTeamMembers.setText("8");
		lebel_accepted(BlueTeamMembersWarning);
		checker[2] = true;
		
		Assassins.setDisable(true);
		Assassins.setText("1");
		lebel_accepted(AssassinsWarning);
		checker[3] = true;
	}
	
	
	public void CostumeOption() {
		
		
		RedTeamName.setText("Reds");
		lebel_accepted(RedTeamNameWarning);
		checker[4] = true;
		
		BlueTeamName.setText("Blues");
		lebel_accepted(BlueTeamNameWarning);
		checker[5] = true;
	}
	
	public void MainFieldCheck() {
		GridFieldInputCheck();
		RedTeamMembersInputCheck();
		BlueTeamMembersInputCheck();
		AssassinsInputCheck();
		RedTeamNameInputCheck();
		BlueTeamNameInputCheck();
	}
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
	
	public void AssassinsInputCheck() {

		if (Assassins.getText().matches("[0-9]+") && Assassins.getText().length()<4 && Integer.parseInt(Assassins.getText())>=0) {
			lebel_accepted(AssassinsWarning);
			checker[3] = true;
		}
		else {
			AssassinsWarning.setGraphic(null);
			AssassinsWarning.setText("This field must contain a number that is reasonable");
			checker[3] = false;
		}
	}
	
	public void RedTeamNameInputCheck() {

		if (RedTeamName.getText().trim().length()>0 && RedTeamName.getText().length()<=20) {
			lebel_accepted(RedTeamNameWarning);
			checker[4] = true;
		}
		else {
			RedTeamNameWarning.setGraphic(null);
			RedTeamNameWarning.setText("This field must be less than 20 characters");
			checker[4] = false;
		}
	}
	
	public void BlueTeamNameInputCheck() {

		if (BlueTeamName.getText().trim().length()>0 && BlueTeamName.getText().length()<=20) {
			lebel_accepted(BlueTeamNameWarning);
			checker[5] = true;
		}
		else {
			BlueTeamNameWarning.setGraphic(null);
			BlueTeamNameWarning.setText("This field must be less than 20 characters");
			checker[5] = false;
		}
	}
	
	public ImageView image_creator() {
		ImageView image = new ImageView(new Image("Media/check-mark.png"));
		image.setFitWidth(25);
		image.setFitHeight(25);
		return image;
	}
	
	public void lebel_accepted(Label label) {
		label.setText("");
		label.setGraphic(image_creator());
	}

	public void StartTheGame() throws IOException {
		boolean overall = true;
		
		for(int i = 0; i < 6; i++) {
			if(checker[i]==false) {
				overall = false;
				break;
			}
		}
		if(overall==false) {
			AdditionalWarning.setText("Please satisfy all of the requirements above");
		}
		else if((Integer.parseInt(Assassins.getText()) + Integer.parseInt(BlueTeamMembers.getText()) + Integer.parseInt(RedTeamMembers.getText()))> Math.pow(Integer.parseInt(GridSize.getText()),2)){
			AdditionalWarning.setText("You have more roles than your grid can contain.");
		}
		else if(RedTeamName.getText().equals(BlueTeamName.getText())) {
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
					Integer.parseInt(BlueTeamMembers.getText()), Integer.parseInt(Assassins.getText()), RedTeamName.getText(), BlueTeamName.getText()));
			
			controller.RedSpyMasterTerm();
			primaryStage.setOnCloseRequest(e->System.exit(0));
			 
			primaryStage.show();
		}
		
		
	}

}
