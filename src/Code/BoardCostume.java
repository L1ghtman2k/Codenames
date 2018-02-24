package Code;
import java.util.List;
import java.util.Random;

public class BoardCostume implements Board {
	private Location[][] grid;
	private List<String> allNames;
	private String[] allCodenames;
	private Team Red;
	private Team Blue;
	private GameLogic gameLogic;
	int Reds, Blues, Assassins;
	
	public BoardCostume(Location[][] grid, int Reds, int Blues, int Assassins, String RedName, String BlueName) {
		
		this.grid=grid;
		Red = new Team(RedName);
		Blue = new Team(BlueName);
		gameLogic = new GameLogic(Red, Blue, this);
		this.Reds = Reds;
		this.Blues = Blues;
		this.Assassins = Assassins;
	
	}
	

	/**
	 * This method returns 25 random words from ArrayList of String 
	 * wordStorage and stores them in ArrayList of String
	 * 
	 * @param wordStrorage the ArrayList of String which will provide all words to a method
	 * @return the ArrayList of string containing 25 random words
	 */
	
	public List<String> retRandomCodenames(List<String> wordStrorage){
		
		Random r = new Random();
		r.nextInt(wordStrorage.size());
		List<String> newList = wordStrorage;
		return newList;
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
