package Application.view3Teams;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EasterEggController2 {
	@FXML Button but;
	public void OpenBrowser() throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported()) {
		    Desktop.getDesktop().browse(new URI("https://www.cse.buffalo.edu/~mhertz/courses/cse116/"));
		}
		((Stage)but.getScene().getWindow()).close();
	}
}
