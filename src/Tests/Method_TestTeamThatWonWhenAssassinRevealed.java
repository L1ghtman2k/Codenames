package Tests;

import static org.junit.Assert.*;

import org.junit.Test; 
import org.junit.Before; 

import Code.Board;
import Code.BoardExtensionFromLocal;
import Code.Launcher;

public class Method_TestTeamThatWonWhenAssassinRevealed {
	Launcher lounch;
	Board board;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red", new BoardExtensionFromLocal());
	}
		
	@Test
	public void blueTeamRevealedAssassin_returnRed() {
		board.getBlueTeam().setRevealedAssassin(true);
		assertEquals(board.TeamThatWonWhenAssassinRevealed(), board.getRedTeam());
	}
	
	@Test
	public void RedTeamRevealedAssassin_returnBlue() {
		
		board.getRedTeam().setRevealedAssassin(true);
		assertEquals(board.TeamThatWonWhenAssassinRevealed(), board.getBlueTeam());
	}
	
	@Test
	public void NoOneRevealedAssassin_returnNull() {
		assertNull(board.TeamThatWonWhenAssassinRevealed());
	}
	

}
