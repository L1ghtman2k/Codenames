package Code;

public class Launcher {
	private Board board;
 
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * This method returns Costume version of Board that contains n x n grid, with selected amount of Reds
	 * selected amount of Blues selected amount Assassin and fills up the rest with Bystander,
	 * and also assigns name to each Team
	 * 
	 * @param int n controls the dimensions of the grid(grid[n][n])
	 * @param int Reds is the amount of Red Agents on the grid
	 * @param int Blues is the amount of Blue Agents on the grid
	 * @param int Assassins is the amount of Assassins on the grid
	 * @param String RedName is the name of the Red Team
	 * @param String BlueName is the name of the Blue Team
	 * @return Returns a customized board
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
	 * @param String RedName - name of Red team	
	 * @param String BlueName - name of Blue team
	 * @return Default board
	 */
	public Board StartTheGame(String RedName, String BlueName) {
		board = StartTheGame(5, 9, 8, 1, RedName, BlueName);	
		return board;
	}
}
