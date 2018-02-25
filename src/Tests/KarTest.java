package Tests;

import org.junit.Test;

import Code.Board;
import Code.BoardExtension;
import Code.Location;

public class KarTest {

	@Test
	public void retRandomCodenames() {
		
		Location[][] grid = new Location[5][5];
		int Reds = 9;
		int Blues = 8;
		int Assasins = 1;
		String redName = "Red";
		String blueName = "Blue";
		Board boardTest = new Board(grid, Reds, Blues, Assasins, redName, blueName, new BoardExtension());
		
//		assertNotNull(boardTest.retRandomCodenames(wordStrorage))
		
		//fail("Not yet implemented");
	}

}
