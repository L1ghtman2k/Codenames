package Code;
import java.util.List;

/**
 * Instances of this class are used to create a board - a 2D desk where Location Instances reside
 * 
 *
 */
public class Board {
	private Location[][] grid;
	private Team Red;
	private Team Blue;
	private IExtension extension;
	private IRandomizer randomizer;
	private int Reds, Blues, Assassins;
	private int totalLocations;
	
	 //Instantiates the Board class with the roles, teams, and grid

	public Board(Location[][] grid, int Reds, int Blues, int Assassins, String RedName, String BlueName) {
		this.grid=grid;
		this.Red = new Team(RedName);
		this.Red.setAgents(Roles.Red);
		this.Blue = new Team(BlueName);
		this.Blue.setAgents(Roles.Blue);
		this.Reds = Reds;
		this.Blues = Blues;
		this.Assassins = Assassins;
		totalLocations = grid.length * grid.length;
	}
 
	/**
	 * This methods assigns Codenames and Roles to Locations, and sets them as Not Revealed.
	 * This method also starts the game with the Red Spymaster.
	 * @param PATH - String name of file with all the codenames.
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
	}


	/**
	 * This method checks whether or not the clue is legal.
	 * @param clue - String that will be checked .
	 * @return true if clue is not equal to Codename unless it is revealed, false otherwise.
	 */
	public boolean isClueLegal(String clue){
		if(clue==null || clue.isEmpty() || clue.trim().length() == 0) {
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
	 * This method checks whether or not the Count is legal.
	 * @param count - int that will be checked .
	 * @param role - role that this count is related too.
	 * @return true if count is less that the amount of revealed roles
	 */
	public boolean isCountLegal(int count, Roles role){
		int sum = 0;
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].getPerson().getRole() == role && !grid[i][j].isRevealed()) {
					sum++;
				}
			}
		}
		if(count > sum)
			return false;
		if(count<0)
			return false;
		return true;
	}

	/**
	 * This method decrements the count of guesses, updates whether the location is revealed or not,
	 * and returns if the Location contained the team's agent.
	 * @param codename - string that reveals content of Location, if associated.
	 * @param team - team that chose the codename.
	 * @return true if Location contained Team's agent, false otherwise.
	 */
	public boolean LocationStatusUpdater(String codename, Team team) {

		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].getCodename().equals(codename)) {						
					if(grid[i][j].getPerson().getRole() == (team.getAgents())) {
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
	 * This method returns true if all of the team's members are revealed, or if at least one assassin is revealed.
	 * Returns false otherwise.
	 * @return true if one of the teams won, false otherwise.
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
	 * This method returns a team that won when assassin was revealed.
	 * @return A team that did not select the assassin.
	 */
	public boolean isAssassinRevealed() {
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid.length; j++) {	
				if(grid[i][j].isRevealed() && grid[i][j].getPerson().getRole().equals(Roles.Assassin)) 
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns the location grid.
	 * @return Location[][] grid.
	 */
	public Location[][] getGrid() {
		return grid;	
	}
	/**
	 * Sets the location grid.
	 * @param grid - Location grid.
	 */
	public void setGrid(Location[][] grid) {
		this.grid = grid;
	}
	/**
	 * Returns the red team.
	 * @return Team Red.
	 */
	public Team getRedTeam() {
		return Red;
	}
	/**
	 * Returns the blue team.
	 * @return Team Blue.
	 */
	public Team getBlueTeam() {
		return Blue;
	}
	/**
	 * Returns the amount of locations (size of grid).
	 * @return total number of Locations.
	 */
	public int getTotalLocations() {
		return totalLocations;
	}
	/**
	 * Returns the randomizer.
	 * @return IRandomizer randomizer.
	 */
	public IRandomizer getRandomizer() {
		return randomizer;
	}
	/**
	 * Sets the classes randomizer.
	 * @param randomizer - IRandomizer.
	 */
	public void setRandomizer(IRandomizer randomizer) {
		this.randomizer = randomizer;
	}
	/**
	 * Returns the extension.
	 * @return IExtension extension.
	 */
	public IExtension getExtension() {
		return extension;
	}
	/**
	 * Sets the classes extension.
	 * @param extension - IExtension.
	 */
	public void setExtension(IExtension extension) {
		this.extension = extension;
	}
	/**
	 * Returns the number of assassins.
	 * @return number of Assassins.
	 */
	public int getAssassins() {
		return Assassins;
	}
	/**
	 * Returns the number of Red Team members.
	 * @return number of Reds.
	 */
	public int getRedsCount() {
		return Reds;
	}
	/**
	 * Returns the number of Blue Team members.
	 * @return number of Blues.
	 */
	public int getBluesCount() {
		return Blues;
	}
	/**
	 * Returns the number of bystanders.
	 * @return number of bystanders.
	 */
	public int getBystanders() {
		return (getGrid().length*getGrid().length)-(Reds+Blues+Assassins);
	}
	
}
