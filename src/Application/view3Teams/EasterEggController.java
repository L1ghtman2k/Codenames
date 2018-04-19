package Application.view3Teams;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class EasterEggController {
	
	@FXML
	ImageView img;
	
	private MediaPlayer mediaPlayer;
	public EasterEggController() {
		Media hit = new Media(getClass().getResource("oof.mp3").toExternalForm());
		mediaPlayer = new MediaPlayer(hit);
	}
	/**
	 * This method is responsible for setting a dope image of our professor
	 */
	public void image_activator() {
		img.setImage(new Image("Media/Assassin.png"));
	}
	/**
	 * This method is responsible for playing oof.mp3 file
	 */
	public void slower() {
		mediaPlayer.stop();
		mediaPlayer.play();
	}

}
