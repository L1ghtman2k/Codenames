package Tests;

import static org.junit.Assert.*;

import org.junit.Test; 
import org.junit.Before; 

import Code.Board;
import Code.Launcher;

public class Method_TestTeamThatWonWhenAssassinRevealed {
	Launcher launcher;
	Board board;
	
	@Before
	  public void setUp() {
		launcher = new Launcher();
		board = launcher.StartTheGame("Blue", "Red");
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
