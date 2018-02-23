package Code;

import java.util.ArrayList;

import org.hamcrest.core.Is;
import org.junit.experimental.theories.Theories;

public class Board {
	private Location[][] grid;
	private ArrayList<String> allNames;
	private String[] allCodenames;
	private Team Red;
	private Team Blue;
	private GameLogic gameLogic;
	
	
	
	public Board() {
		grid = new Location[5][5];
		allCodenames = new String[25];
		Red = new Team("Red");
		Blue = new Team("Blue");
		gameLogic = new GameLogic(Red, Blue, this);
	}

	private ArrayList<String> allRoles = new ArrayList<String>() {{
		////////////////////////8 Blue Agents//////////////////////////////////////
		add("Blue Agent"); add("Blue Agent"); add("Blue Agent"); add("Blue Agent");
		add("Blue Agent"); add("Blue Agent"); add("Blue Agent"); add("Blue Agent");
		///////////////////////9 Red agents////////////////////////////////////////
		add("Red Agent"); add("Red Agent"); add("Red Agent"); add("Red Agent"); 
		add("Red Agent"); add("Red Agent"); add("Red Agent"); add("Red Agent");
		add("Red Agent");
		///////////////////////7 Bystanders////////////////////////////////////////
		add("Bystander"); add("Bystander"); add("Bystander");
		add("Bystander"); add("Bystander"); add("Bystander"); 
		add("Bystander");
		//////////////////////1 Assassin///////////////////////////////////////////
		add("Assassin");
	}};

	/**
	 * This method returns ArrayList of String 
	 * that would contain all words from a specified text file.
	 * 
	 * @param filename the text file that contains words
	 * @return ArrayList that contains all words from filename
	 */
	public ArrayList<String> retAllCodenames(String filename) {

		return null;
	}
	
	/**
	 * This method returns 25 random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStrorage the ArrayList of String which will provide all words to a method
	 * @return the ArrayList of string containing 25 random words
	 */
	public ArrayList<String> ret25RandomCodenames(ArrayList<String> wordStrorage){
		
		return null;
	}
	
	/**
	 * This method shuffles all the roles in allRoles ArrayList
	 */
	public void RandomizeRoles(){
		
	}

	/**
	 * This methods assigns Codenames and Roles to Locations, and sets them as Not Revealed.
	 * After that it let's Red Team to move.
	 */
	public void LocationAssignerAndRedMove() {
		
		gameLogic.RedTeamMove();
	}
	
	
	public boolean checkIfClueIsLegal(String clue){
		
		return false;
	}
	
	public boolean LocationStatusUpdater(String codename, Team team) {
		
		return false;
	}
	
	
	public boolean isBoardInWinningState() {
		
		return false;
	}
	
	public Team TeamThatWonWhenAssassinRevealed() {
		
		return null;
	}
	
	
	public Location[][] getGrid() {
		return grid;	
	}
	public ArrayList<String> getAllNames() {
		return allNames;	
	}
	public String[] getAllCodenames() {
		return allCodenames;	
	}
	

}
