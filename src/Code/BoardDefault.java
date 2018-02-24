package Code;
import java.util.List;

public class BoardDefault implements Board {
	private Location[][] grid;
	private List<String> allNames;
	private String[] allCodenames;
	private Team Red;
	private Team Blue;
	private GameLogic gameLogic;
	int Reds, Blues, Assassins;
	
	public BoardDefault(Location[][] grid, String Redname, String Bluename) {
		this.grid=grid;
		Red = new Team(Redname);
		Blue = new Team(Bluename);
		gameLogic = new GameLogic(Red, Blue, this);
		Reds = 9;
		Blues = 8;
		Assassins = 1;
	}


	

	/**
	 * This method returns 25 random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStrorage the ArrayList of String which will provide all words to a method
	 * @return the ArrayList of string containing 25 random words
	 */

	public List<String> retRandomCodenames(List<String> wordStrorage){

		return null;
	}


	public List<Person> RandomizeRoles(){

		return null;
	}

	/**
	 * This methods assigns Codenames and Roles to Locations, and sets them as Not Revealed.
	 * After that it let's Red Team to move.
	 */
	public void LocationAssignerAndRedMove() {

		gameLogic.RedTeamMove();
	}
	/**
	 * @return the Location[][] also known as grid
	 */
	public Location[][] getGrid() {
		return grid;	
	}
	/**	 
	 * @return Returns arrayList containing all words from text File 
	 */
	public List<String> getAllNames() {
		return allNames;	
	}

	/**
	 * @return Returns String array containing all codenames
	 */
	public String[] getAllCodenames() {
		return allCodenames;	
	}
}
