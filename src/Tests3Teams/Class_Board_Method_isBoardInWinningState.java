package Tests3Teams;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Code3Teams.Board;
import Code3Teams.Launcher;
import Code3Teams.Location;
import Code3Teams.Roles;

public class Class_Board_Method_isBoardInWinningState {
	
	Launcher lounch;
	Board board;
	Location[][] grid;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red", "Greens");
		grid =  board.getGrid();
		board.LocationAssignerAndRedMove("GameWords1.txt");
	}
	
	@Test
	public void TeamBlueRevealedAllAgents_returnsTrue() {
		scoroller(Roles.Blue);
		assertTrue(board.isBoardInWinningState());
	}
	@Test
	public void TeamRedRevealedAllAgents_returnsTrue() {
		scoroller(Roles.Red);
		assertTrue(board.isBoardInWinningState());
	}
	
	@Test
	public void TeamGreenRevealedAllAgents_returnsTrue() {
		scoroller(Roles.Green);
		assertTrue(board.isBoardInWinningState());
	}
	
	@Test
	public void AssassinRevealedAllAgents_returnsTrue() {
		scoroller(Roles.Assassin);
		assertTrue(board.isBoardInWinningState());
	}
	
	@Test
	public void NoOneIsRevealed_returnsFalse() {
		assertFalse(board.isBoardInWinningState());
	}
	
	
	
	/**
	 * Scrolls thru grid and assigns Revealed to specified role
	 * @param role that is being revealed
	 */
	public void scoroller(Roles role) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++)
			{
				if(grid[i][j].getPerson().getRole()==role){
					grid[i][j].setRevealed(true);
				}
				
			}
		}
	}
	
}
