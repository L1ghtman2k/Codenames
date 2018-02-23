package Code;

public class Launcher {
	private Board board;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void StartTheGame() {
		board = new Board();	
		
	}
}
