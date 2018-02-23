package Code;

import java.util.ArrayList;

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
	
	/**
	 * 
	 * @return the Location[][] also known as grid
	 */
	public Location[][] getGrid() {
		return grid;	
	}
	/**
	 * 
	 * @return Returns arrayList containing all words from text File 
	 */
	public ArrayList<String> getAllNames() {
		return allNames;	
	}
	/**
	 * 
	 * @return Returns String array containing all codenames
	 */
	public String[] getAllCodenames() {
		return allCodenames;	
	}
	

}
