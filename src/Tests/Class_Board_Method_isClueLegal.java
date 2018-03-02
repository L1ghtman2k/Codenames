package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Code.Board;
import Code.Launcher;
import Code.Location;
public class Class_Board_Method_isClueLegal {
	Launcher lounch;
	Board board;
	Location[][] grid;
	@Before
	  public void setUp() {
		lounch = new Launcher();
		board = lounch.StartTheGame("Blue", "Red");
		grid =  board.getGrid();
		board.LocationAssignerAndRedMove("src/GameWords1.txt");
	}
	
	
	@Test
	public void ClueLegal_returnsTrue(){
		String clue = "SDAdsajfsadiopfjapsodi";
		assertTrue(board.isClueLegal(clue));
	}
	
	
	@Test
	public void ClueIllegal_returnsFalse(){
		String clue = grid[0][0].getCodename();
		assertFalse(board.isClueLegal(clue));
	}

}
