package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Code.Board;
import Code.Launcher;
import Code.Location;

public class Class_Launcher_Method_StartTheGame {
	
	@Test
	public void TwoTeamNamesPassed_ReturnsBoardWith25LocationInstances() {
		Launcher lounch = new Launcher();
		int LocationNullCounter = 0;
		Board board = lounch.StartTheGame("Buffalo", "Knuckles");
		Location[][] grid = board.getGrid();
		LocationNullCounter = LocationCounter(grid);
		
		assertEquals(LocationNullCounter, 0);
		assertEquals(grid.length, 5);
		assertEquals(grid[0].length, 5);
		assertEquals(board.getRedTeam().getTeamName(), "Buffalo");
		assertEquals(board.getBlueTeam().getTeamName(), "Knuckles");
	}
	
	@Test
	public void TwoTeamNamesPassedAndCostumeParameters_ReturnsBoardWith100LocationInstances() {
		Launcher lounch = new Launcher();
		int LocationNullCounter = 0;
		Board board = lounch.StartTheGame(10, 20, 10, 5, "Buffalo", "Knuckles");
		Location[][] grid = board.getGrid();
		LocationNullCounter = LocationCounter(grid);
		
		assertEquals(LocationNullCounter, 0);
		assertEquals(grid.length, 10);
		assertEquals(grid[0].length, 10);
		assertEquals(board.getRedTeam().getTeamName(), "Buffalo");
		assertEquals(board.getBlueTeam().getTeamName(), "Knuckles");
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
