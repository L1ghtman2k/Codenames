package Code;

public class Launcher {
	private Board board;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board StartTheGame(int n, int Reds, int Blues, int Assassins, String RedName, String BlueName) {
		Location[][] grid = new Location[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = new Location();
			}
		}
		board = new BoardCostume(grid, Reds, Blues, Assassins, RedName, BlueName);	
		return board;
		
	}
	
	public Board StartTheGame(String RedName, String BlueName) {
		int n=5;
		Location[][] grid = new Location[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = new Location();
			}
		}
		board = new BoardDefault(grid, RedName, BlueName);	
		return board;
	}
}
