package Tests3Teams;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Code3Teams.Board;
import Code3Teams.Launcher;
import Code3Teams.Location;

public class Class_Launcher_Method_StartTheGame {
	
	@Test
	public void TwoTeamNamesPassed_ReturnsBoardWith25LocationInstances() {
		Launcher lounch = new Launcher();
		int LocationNullCounter = 0;
		Board board = lounch.StartTheGame("Buffalo", "Knuckles", "A-2");
		Location[][] grid = board.getGrid();
		LocationNullCounter = LocationCounter(grid);
		
		assertEquals(LocationNullCounter, 0);
		assertEquals(grid.length, 5);
		assertEquals(grid[0].length, 5);
		assertEquals(board.getRedTeam().getTeamName(), "Buffalo");
		assertEquals(board.getBlueTeam().getTeamName(), "Knuckles");
		assertEquals(board.getGreenTeam().getTeamName(), "A-2");
	}
	
	@Test
	public void TwoTeamNamesPassedAndCostumeParameters_ReturnsBoardWith100LocationInstances() {
		Launcher lounch = new Launcher();
		int LocationNullCounter = 0;
		Board board = lounch.StartTheGame(10, 20, 10, 30, 5, "Buffalo", "Knuckles", "A-2");
		Location[][] grid = board.getGrid();
		LocationNullCounter = LocationCounter(grid);
		
		assertEquals(LocationNullCounter, 0);
		assertEquals(grid.length, 10);
		assertEquals(grid[0].length, 10);
		assertEquals(board.getRedTeam().getTeamName(), "Buffalo");
		assertEquals(board.getBlueTeam().getTeamName(), "Knuckles");
		assertEquals(board.getGreenTeam().getTeamName(), "A-2");
	}
	
	/**
	 * This method Counts how many locations in grid are null
	 * @param grid is an object which contains elements to be counterr
	 * @return amount of nulls in grid
	 */
	public int LocationCounter(Location [][] grid){
		int LocationNullCounter = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==null) {
					LocationNullCounter++;
				}
			}
		}
		return LocationNullCounter;
	}
}
