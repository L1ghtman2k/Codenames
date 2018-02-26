package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.LocalFileExtension;
import Code.Launcher;
import Code.ShuffleRandomizer;

public class Method_isBoardInWinningState {
	
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
