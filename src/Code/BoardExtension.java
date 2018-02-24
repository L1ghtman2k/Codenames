package Code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class BoardExtension {
	
	/**
	 * This method returns ArrayList of String 
	 * that would contain all words from a specified text file.
	 * 
	 * @param filename the text file that contains words
	 * @return List that contains all words from filename
	 */

	public static List<String> retAllCodenames(String filename) {
		List<String> list = null;
		try {
			list = Files.readAllLines(new File(filename).toPath(), 
					Charset.defaultCharset() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  list;

	}
	
	/**
	 * This method checks weather or not the clue is legal or illegal
	 * @param clue String that will be checked 
	 * @return true if clue is not equal Codename unless it is revealed, false otherwise
	 */
	public boolean isClueIsLegal(String clue){

		return false;
	}

	/**
	 * This method decrements the count of guesses, 
	 * updates Location Revealed Status,
	 * returns if the Location Contained Team's agent.
	 * @param codename String that reveals content of Location, if associated
	 * @param team Team that chose the codename
	 * @return true if Location contained Team's agent, false otherwise
	 */
	public boolean LocationStatusUpdater(String codename, Team team) {

		return false;
	}

	/**
	 * This method returns weather or not one of the teams is at winning state
	 * @return true if one of the teams won, false otherwise
	 */
	public boolean isBoardInWinningState() {

		return false;
	}
	/**
	 * This method returns a team that won when assassin was revealed
	 * @return A team that did not select the assassin.
	 */
	public Team TeamThatWonWhenAssassinRevealed() {

		return null;
	}
}
