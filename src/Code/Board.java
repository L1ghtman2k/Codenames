package Code;

import java.util.ArrayList;

public class Board {
	private Location[][] grid;
	private ArrayList<String> allNames;
	private String[] randomCodenames;
	private ArrayList<String> allRoles = new ArrayList<String>() {{
		////////////////////////8 Blue Agents//////////////////////////////////////
	    add("Blue Agent"); add("Blue Agent"); add("Blue Agent"); add("Blue Agent");
	    add("Blue Agent"); add("Blue Agent"); add("Blue Agent"); add("Blue Agent");
	    ///////////////////////9 Red agents////////////////////////////////////////
	    add("Red Agent"); add("Red Agent"); add("Red Agent"); add("Red Agent"); add("Red Agent");
	    add("Red Agent"); add("Red Agent"); add("Red Agent"); add("Red Agent");
	    ///////////////////////7 Bystanders////////////////////////////////////////
	    add("Bystander"); add("Bystander"); add("Bystander");
	    add("Bystander"); add("Bystander"); add("Bystander"); add("Bystander");
	    //////////////////////1 Assassin///////////////////////////////////////////
	    add("Assassin");
	}};
	
	
	public ArrayList<String> retAllCodenames(String filename){
		
		return null;
	}
	
	public ArrayList<String> ret25RandomCodenames(ArrayList<String> wordStrorage){
		
		return null;
	}
	
	public Location[][] assignLocationToGrid(){
		
		
		return grid;
	}
	
}
