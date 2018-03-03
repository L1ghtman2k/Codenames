package Code;

/**
 * The GameLogic class calls the turns of the
 * game by using the different move methods.
  */
public class GameLogic {
	Team Red;
	Team Blue;
	Board board;
	/**
	 * Instantiates the GameLogic class.
	 * @param Red - Team Red.
	 * @param Blue - Team Blue.
	 * @param board - current board used.
	 */
	public GameLogic(Team Red, Team Blue, Board board) {
		this.Red = Red;
		this.Blue = Blue;
		this.board = board;
	}
	
	// These have not been implemented yet.
	public void RedTeamMove() {
	

		 //BlueSpyMasterMove();
	}
	
	public void BlueTeamMove() {
		
		//RedSpyMasterMove();
	}
	
	public void RedSpyMasterMove() {
		
		//RedTeamMove();
	}
	
	public void BlueSpyMasterMove() {
		//BlueTeamMove();
	}
}
