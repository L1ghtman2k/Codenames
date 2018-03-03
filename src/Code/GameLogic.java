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
	
	/**
	 * This Method Makes Red Team Move
	 */
	public void RedTeamMove() {
		 //BlueSpyMasterMove();
	}
	
	/**
	 * This Method Makes Blue Team Move
	 */
	public void BlueTeamMove() {
		
		//RedSpyMasterMove();
	}
	
	/**
	 * This Method Makes Red SpyMaster Move
	 */
	public void RedSpyMasterMove() {
		
		//RedTeamMove();
	}
	/**
	 * This Method Makes Blue SpyMaster Move
	 */
	public void BlueSpyMasterMove() {
		//BlueTeamMove();
	}
}
