package Code;

public class GameLogic {
	Team Red;
	Team Blue;
	Board board;
	
	public GameLogic(Team Red, Team Blue, Board board) {
		this.Red = Red;
		this.Blue = Blue;
		this.board = board;
	}
	
	public void RedTeamMove() {
	
		BlueSpyMasterMove();
	}
	
	public void BlueTeamMove() {
		
		RedSpyMasterMove();
	}
	
	public void RedSpyMasterMove() {
		
		RedTeamMove();
	}
	
	public void BlueSpyMasterMove() {
		BlueTeamMove();
	}
}
