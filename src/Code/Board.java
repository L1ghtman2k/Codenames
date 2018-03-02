package Code;
import java.util.List;

public class Board {
	private Location[][] grid;
	private Team Red;
	private Team Blue;
	private GameLogic gameLogic;
	private IExtension extension;
	private IRandomizer randomizer;
	private int Reds, Blues, Assassins;
	private int totalLocations;


	public Board(Location[][] grid, int Reds, int Blues, int Assassins, String RedName, String BlueName) {
		this.grid=grid;
		this.Red = new Team(RedName);
		this.Blue = new Team(BlueName);
		this.gameLogic = new GameLogic(Red, Blue, this);
		this.Reds = Reds;
		this.Blues = Blues;
		this.Assassins = Assassins;
		totalLocations = grid.length * grid.length;
	}

	/**
	 * This methods assigns Codenames and Roles to Locations, and sets them as Not Revealed.
	 * After that it let's Red Team to move.
	 */
	public void LocationAssignerAndRedMove(String PATH) {

		List<String> RandomCodenames = randomizer.retRandomCodenames(extension.retAllCodenames(PATH));
		List<Person> RandomRoles = randomizer.retRandomizeRoles();

		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++)
			{
				grid[i][j].setCodename(RandomCodenames.get(i*grid.length+j));
				grid[i][j].setPerson(RandomRoles.get(i*grid.length+j));
				grid[i][j].setRevealed(false);
			}
		}
		gameLogic.RedSpyMasterMove();
	}


	/**
	 * This method checks weather or not the clue is legal or illegal
	 * @param clue String that will be checked 
	 * @return true if clue is not equal Codename unless it is revealed, false otherwise
	 */
	public boolean isClueLegal(String clue){
		if(clue.isEmpty() || clue==null ) {
			return false;
		}
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].getCodename().toLowerCase().equals(clue.toLowerCase())) {
					if(grid[i][j].isRevealed()==true) {
						return true;
					}
					return false;
				}
			}
		}
		return true;
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

		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].getCodename().equals(codename)) {				

					if(grid[i][j].getPerson().getRole().equals(team.getAgents())) {
						team.decrementCount();
						grid[i][j].setRevealed(true);
						return true;
					}
					
					grid[i][j].setRevealed(true);
					return false;
				}
			}
		}
		return false;
	}

	/**
	 * This method returns weather or not one of the teams is at winning state
	 * @return true if one of the teams won, false otherwise
	 */
	public boolean isBoardInWinningState() {
		int bluesum =0, redsum=0;

		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {	
				if(grid[i][j].isRevealed() && grid[i][j].getPerson().getRole().equals(Roles.Assassin)) 
					return true;
				
				if(grid[i][j].isRevealed() && grid[i][j].getPerson().getRole().equals(Roles.Blue)) 
					bluesum++;
				
				if(grid[i][j].isRevealed() && grid[i][j].getPerson().getRole().equals(Roles.Red)) 
					redsum++;
			}
		}
		if(bluesum == Blues || redsum == Reds)
			return true;
		return false;
	}

	/**
	 * This method returns a team that won when assassin was revealed
	 * @return A team that did not select the assassin.
	 */
	public Team TeamThatWonWhenAssassinRevealed() {
		if(Red.isRevealedAssassin()) {
			return Blue;
		}
		if(Blue.isRevealedAssassin())
		{
			return Red;
		}
		return null;
	}
	//	GETTER AND SETTERS

	/**
	 * @return the Location[][] also known as grid
	 */
	public Location[][] getGrid() {
		return grid;	
	}
	public void setGrid(Location[][] grid) {
		this.grid = grid;
	}

	public Team getRedTeam() {
		return Red;
	}

	public Team getBlueTeam() {
		return Blue;
	}

	public int getTotalLocations() {
		return totalLocations;
	}

	public IRandomizer getRandomizer() {
		return randomizer;
	}
	public void setRandomizer(IRandomizer randomizer) {
		this.randomizer = randomizer;
	}
	
	public IExtension getExtension() {
		return extension;
	}
	public void setExtension(IExtension extension) {
		this.extension = extension;
	}
	
	public int getAssassins() {
		return Assassins;
	}
	
	public int getRedsCount() {
		return Reds;
	}
	
	public int getBluesCount() {
		return Blues;
	}
	
	public int getAssassinsCount() {
		return Assassins;
	}
	
	public int getBystanders() {
		return (getGrid().length*getGrid().length)-(Reds+Blues+Assassins);
	}
	
}
