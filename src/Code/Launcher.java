package Code;

public class Launcher {
	private Board board;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board StartTheGame(int n, int Reds, int Blues, int Assassins, String RedName, String BlueName, Extension extension) {
		Location[][] grid = new Location[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				grid[i][j] = new Location();
			}
		}
		board = new Board(grid, Reds, Blues, Assassins, RedName, BlueName, extension);	
		return board;
		
	}	
	public Board StartTheGame(String RedName, String BlueName, Extension extension) {
		board = StartTheGame(5, 9, 8, 1, RedName, BlueName, extension);	
		return board;
	}
}
