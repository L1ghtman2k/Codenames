package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;
import Code.Location;
import Code.Team;

public class Class_Board_Method_LocationStatusUpdater {

	Launcher lounch;
	Board board;
	Location[][] grid;
	@Before
	public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
		grid =  board.getGrid();
	}

	@Test
	public void CodeNameMatchesTeamMember_DecrementsTheCountSetsRevealedTrueReturnsTrue() {
		board.LocationAssignerAndRedMove("src/GameWords1.txt");	
		
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid.length; j++) {
				if(grid[i][j].getPerson().getRole() == board.getRedTeam().getAgents())
				{		
					int a=board.getRedTeam().getCount();
					assertTrue(board.LocationStatusUpdater(grid[i][j].getCodename(), board.getRedTeam()));	
					int b=board.getRedTeam().getCount();
					assertEquals(a,b-1);
					assertTrue(grid[i][j].isRevealed());
				}
				if(grid[i][j].getPerson().getRole() == board.getBlueTeam().getAgents())
				{
					assertTrue(board.LocationStatusUpdater(grid[i][j].getCodename(), board.getBlueTeam()));
					
				}
			}
	}
}
