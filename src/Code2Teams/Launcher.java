package Code2Teams;

/**
 * 
 * Instance of this class is Used to create a board class.
 *
 */
public class Launcher {
	private Board board;
	
	/**
	 * Returns the board being used.
	 * @return current board.
	 */
	public Board getBoard() {
		return board;
	}
	/**
	 * Sets the board to be used.
	 * @return new board.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * This method returns Costume version of Board that contains n x n grid, with selected amount of Reds
	 * selected amount of Blues selected amount Assassin and fills up the rest with Bystander,
	 * and also assigns name to each Team.
	 * 
	 * @param n - int that controls the dimensions of the grid(grid[n][n]).
	 * @param Reds - int, amount of Red Agents on the grid.
	 * @param Blues - int, amount of Blue Agents on the grid.
	 * @param Assassins - int, amount of Assassins on the grid.
	 * @param RedName - String, name of the Red Team.
	 * @param BlueName - String, name of the Blue Team.
	 * @return Returns a customized board.
	 */
	public Board StartTheGame(int n, int Reds, int Blues, int Assassins, String RedName, String BlueName) {
		Location[][] grid = new Location[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = new Location();
			}
		}
		board = new Board(grid, Reds, Blues, Assassins, RedName, BlueName);	
		board.setExtension(new LocalFileExtension());
		board.setRandomizer(new ShuffleRandomizer(board));
		return board;
		
	}	
	/**
	 * This method returns Default version of Board that contains 5 x 5 grid, with 9 Reds,
	 * 8 Blues, 1 Assassin, and 1 Bystander, and also assigns name to each Team
	 * 
	 * @param RedName - String, name of Red team.	
	 * @param BlueName - String, name of Blue team.
	 * @return Default board.
	 */
	public Board StartTheGame(String RedName, String BlueName) {
		board = StartTheGame(5, 9, 8, 1, RedName, BlueName);	
		return board;
	}
}
