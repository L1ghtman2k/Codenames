package Tests;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;

public class Class_Board_Method_isBoardInWinningState {
	
	Launcher lounch;
	Board board;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
	}
	
	@Test
	public void TeamBlueRevealedAllAgents_returnsTrue() {
		
	}
}
