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


	public ArrayList<String> retAllCodenames(String filename){

		return null;
	}

	public ArrayList<String> ret25RandomCodenames(ArrayList<String> wordStrorage){

		return null;
	}

	public void RandomizeRoles(){
		
	}

	
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
