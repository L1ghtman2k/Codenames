package Tests3Teams;

import static org.junit.Assert.*;

import org.junit.Test;

import Code3Teams.Board;
import Code3Teams.Launcher;
import Code3Teams.Location;
import Code3Teams.Roles;

import org.junit.Before;

public class Class_Board_Method_TestTeamThatWonWhenAssassinRevealed {
	Launcher lounch;
	Board board;
	Location[][] grid;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red","Green");
		grid =  board.getGrid();
		board.LocationAssignerAndRedMove("GameWords1.txt");
	}
		
	@Test
	public void RevealedAssassin_returnTrue() {
		scoroller(Roles.Assassin);
		assertEquals(2, board.isAssassinRevealed());
	}
	
	@Test
	public void NoOneRevealedAssassin_returnFalse() {
		assertEquals(0,board.isAssassinRevealed());
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
